package top.plgxs.admin.controller.monitor;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.plgxs.admin.service.monitor.SysLoginLogService;
import top.plgxs.admin.service.sys.SysUserService;
import top.plgxs.common.core.api.ResultInfo;
import top.plgxs.common.core.api.page.PageDataInfo;
import top.plgxs.common.core.util.TimeUtil;
import top.plgxs.mbg.entity.monitor.SysLoginLog;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 系统访问记录 前端控制器
 * </p>
 *
 * @author Stranger。
 * @since 2021-07-02
 * @version 1.0
 */
@Api(tags = "系统访问记录管理")
@Controller
@RequestMapping("/sysLoginLog")
public class SysLoginLogController {
    @Resource
    private SysLoginLogService sysLoginLogService;
    @Resource
    private SysUserService sysUserService;

    /**
     * 系统访问记录页面
     * @author Stranger。
     * @since 2021-07-02
     */
    @GetMapping("/list")
    public String list(){
        return "monitor/sysLoginLog/list";
    }

    /**
     * 分页查询列表
     * @param searchParams 查询条件
     * @param pageNo 第几页
     * @param pageSize 每页几条
     * @return
     * @author Stranger。
     * @since 2021-07-02
     */
    @ApiOperation(value = "分页查询系统访问记录列表", notes = "条件查询")
    @GetMapping("/pageList")
    @ResponseBody
    public ResultInfo<PageDataInfo> queryPageList(@RequestParam(name = "searchParams", required = false) String searchParams,
                                                    @RequestParam(name = "page", defaultValue = "1") Integer pageNo,
                                                    @RequestParam(name = "limit", defaultValue = "10") Integer pageSize){
        QueryWrapper<SysLoginLog> queryWrapper = new QueryWrapper<>();
        if (StrUtil.isNotBlank(searchParams)) {
            JSONObject jsonObject = JSONObject.parseObject(searchParams);
            String operName = String.valueOf(jsonObject.get("loginName"));
            if (StrUtil.isNotBlank(operName)) {
                queryWrapper.eq("login_name", operName);
            }
            String operTime = String.valueOf(jsonObject.get("loginTime"));
            if (StrUtil.isNotBlank(operTime)) {
                String startDate = operTime.split("~")[0].trim();
                String endDate = operTime.split("~")[1].trim();
                queryWrapper.ge("login_time", TimeUtil.strToDate(startDate));
                queryWrapper.le("login_time", TimeUtil.strToDate(endDate));
            }
        }
        queryWrapper.orderByDesc("login_time");
        Page<SysLoginLog> page = new Page<>(pageNo, pageSize);
        IPage<SysLoginLog> pageList = sysLoginLogService.page(page, queryWrapper);
        return ResultInfo.success(new PageDataInfo<SysLoginLog>(pageList.getRecords(),pageList.getTotal()));
    }

    /**
     * 详细页面
     * @author Stranger。
     * @since 2021-07-02
     */
    @GetMapping("/detail/{id}")
    public String edit(Model model, @PathVariable("id") String id){
        SysLoginLog sysLoginLog = sysLoginLogService.getById(id);
        model.addAttribute("sysLoginLog",sysLoginLog);
        return "monitor/sysLoginLog/detail";
    }

    /**
     * 逻辑删除一条数据
     * @param id 主键
     * @return top.plgxs.common.api.ResultInfo<java.lang.Object>
     * @author Stranger。
     * @since 2021-07-02
     */
    @ApiOperation(value = "删除系统访问记录", notes = "删除单条数据")
    @GetMapping("/delete/{id}")
    @ResponseBody
    public ResultInfo<Object> delete(@PathVariable("id") String id){
        if(StringUtils.isBlank(id)){
            return ResultInfo.validateFailed();
        }
        boolean result = sysLoginLogService.removeById(id);
        if(result){
            return ResultInfo.success();
        }else{
            return ResultInfo.failed();
        }
    }

    /**
     * 批量删除
     * @param ids id数组
     * @author Stranger。
     * @since 2021-07-02
     */
    @ApiOperation(value = "批量删除系统访问记录", notes = "批量删除数据")
    @PostMapping("/batchDelete")
    @ResponseBody
    public ResultInfo<Object> batchDelete(@RequestBody List<String> ids){
        boolean result = sysLoginLogService.removeByIds(ids);
        if(result){
            return ResultInfo.success("删除成功",null);
        }else{
            return ResultInfo.failed("删除失败");
        }
    }

    /**
     * 解锁用户
     * @param usernames 用户
     * @return top.plgxs.common.core.api.ResultInfo<java.lang.Object>
     * @author Stranger。
     * @since 2021/7/4
     */
    @PostMapping("/unlock")
    @ResponseBody
    public ResultInfo<Object> unlock(@RequestBody List<String> usernames){
        if (CollUtil.isNotEmpty(usernames)) {
            for (String username : usernames) {
                sysUserService.clearLoginRecordCache(username);
            }
        }
        return ResultInfo.success("解锁成功");
    }
}
