package top.plgxs.admin.aspectj;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.spring.PropertyPreFilters;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import top.plgxs.admin.service.monitor.SysOperLogService;
import top.plgxs.admin.utils.ShiroUtils;
import top.plgxs.common.core.annotation.Log;
import top.plgxs.common.core.constants.enums.StatusEnum;
import top.plgxs.common.core.util.ServletUtils;
import top.plgxs.common.core.util.StringUtils;
import top.plgxs.mbg.dto.sys.LoginUser;
import top.plgxs.mbg.entity.monitor.SysOperLog;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * 操作日志
 * 可以设置order参数，值越小，优先级越高，如果不设置，就是优先级最小。
 * @author Stranger。
 * @version 1.0
 * @since 2021/7/2 17:37
 */
@Aspect
@Component
@Slf4j
@Order(Integer.MIN_VALUE-1)
public class LogAspect {
    @Resource
    private SysOperLogService sysOperLogService;
    @Resource
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    /** 排除敏感属性字段 */
    public static final String[] EXCLUDE_PROPERTIES = { "password", "oldPassword", "newPassword", "confirmPassword" };

    /**
     * 操作切入点，一般情况该方法中再不需要添加其他的代码
     * 使用@Pointcut 来声明切入点表达式
     * 后面的其他通知直接使用方法名直接引用方法名即可
     */
    @Pointcut("@annotation(top.plgxs.common.core.annotation.Log)")
    public void logPointCut() {
        // 该方法无方法体,主要为了让同类中其他方法使用此切入点
    }

    /**
     * 处理完请求后执行
     *
     * @param joinPoint  切点
     * @param jsonResult
     */
    @AfterReturning(pointcut = "logPointCut()", returning = "jsonResult")
    public void doAfterReturning(JoinPoint joinPoint, Object jsonResult) {
        handleLog(joinPoint, null, jsonResult);
    }

    /**
     * 拦截异常操作
     *
     * @param joinPoint 切点
     * @param e         异常
     */
    @AfterThrowing(value = "logPointCut()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Exception e) {
        handleLog(joinPoint, e, null);
    }

    protected void handleLog(final JoinPoint joinPoint, final Exception e, Object jsonResult) {
        try {
            // 获得注解
            Log controllerLog = getAnnotationLog(joinPoint);
            if (controllerLog == null) {
                return;
            }

            // 获取当前的用户
            LoginUser currentUser = ShiroUtils.getLoginUser();

            // *========数据库日志=========*//
            SysOperLog operLog = new SysOperLog();
            operLog.setStatus(StatusEnum.ENABLE.getCode());
            operLog.setOperName(currentUser.getUsername());
            // 请求的地址
            String ip = ShiroUtils.getIp();
            operLog.setOperIp(ip);
            // 返回参数
            operLog.setJsonResult(StringUtils.substring(JSONUtil.toJsonStr(jsonResult), 0, 2000));
            operLog.setOperUrl(ServletUtils.getRequest().getRequestURI());

            if (e != null) {
                operLog.setStatus(StatusEnum.DISABLE.getCode());
                operLog.setErrorMsg(StringUtils.substring(e.getMessage(), 0, 2000));
            }
            // 设置方法名称
            String className = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            operLog.setMethod(className + "." + methodName + "()");
            // 设置请求方式
            operLog.setRequestMethod(ServletUtils.getRequest().getMethod());
            // 处理设置注解上的参数
            getControllerMethodDescription(controllerLog, operLog);
            // 操作时间
            operLog.setOperTime(LocalDateTime.now());
            // 保存数据库
            threadPoolTaskExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    sysOperLogService.save(operLog);
                }
            });
        } catch (Exception exp) {
            // 记录本地异常日志
            log.error("==前置通知异常==");
            log.error("异常信息:{}", exp.getMessage());
            exp.printStackTrace();
        }
    }

    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param log     日志
     * @param operLog 操作日志
     * @throws Exception
     */
    public void getControllerMethodDescription(Log log, SysOperLog operLog) throws Exception {
        // 设置action动作
        operLog.setBusinessType(String.valueOf(log.businessType().ordinal()));
        // 设置标题
        operLog.setTitle(log.title());
        // 设置操作人类别
        operLog.setOperatorType(String.valueOf(log.operatorType().ordinal()));
        // 是否需要保存request，参数和值
        if (log.isSaveRequestData()) {
            // 获取参数的信息，传入到数据库中。
            setRequestValue(operLog);
        }
    }

    /**
     * 获取请求的参数，放到log中
     *
     * @param operLog 操作日志
     * @throws Exception 异常
     */
    private void setRequestValue(SysOperLog operLog) throws Exception {
        Map<String, String[]> map = ServletUtils.getRequest().getParameterMap();
        if (StringUtils.isNotEmpty(map)) {
            PropertyPreFilters.MySimplePropertyPreFilter excludefilter = new PropertyPreFilters().addFilter();
            excludefilter.addExcludes(EXCLUDE_PROPERTIES);
            String params = JSONObject.toJSONString(map, excludefilter);
            operLog.setOperParam(StringUtils.substring(params, 0, 2000));
        }
    }

    /**
     * 是否存在注解，如果存在就获取
     */
    private Log getAnnotationLog(JoinPoint joinPoint) throws Exception {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        if (method != null) {
            return method.getAnnotation(Log.class);
        }
        return null;
    }
}
