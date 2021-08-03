package top.plgxs.admin.controller.monitor;

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
import top.plgxs.admin.service.monitor.SysOperLogService;
import top.plgxs.common.core.api.ResultInfo;
import top.plgxs.common.core.api.page.PageDataInfo;
import top.plgxs.common.core.util.TimeUtil;
import top.plgxs.mbg.entity.monitor.SysOperLog;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 操作日志记录 前端控制器
 * </p>
 *
 * @author Stranger。
 * @since 2021-07-02
 * @version 1.0
 */
@Api(tags = "操作日志记录管理")
@Controller
@RequestMapping("/sysOperLog")
public class SysOperLogController {
    @Resource
    private SysOperLogService sysOperLogService;

    /**
     * 操作日志记录页面
     * @author Stranger。
     * @since 2021-07-02
     */
    @GetMapping("/list")
    public String list(){
        return "monitor/sysOperLog/list";
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
    @ApiOperation(value = "分页查询操作日志记录列表", notes = "条件查询")
    @GetMapping("/pageList")
    @ResponseBody
    public ResultInfo<PageDataInfo> queryPageList(@RequestParam(name = "searchParams", required = false) String searchParams,
                                                    @RequestParam(name = "page", defaultValue = "1") Integer pageNo,
                                                    @RequestParam(name = "limit", defaultValue = "10") Integer pageSize){
        QueryWrapper<SysOperLog> queryWrapper = new QueryWrapper<>();
        if (StrUtil.isNotBlank(searchParams)) {
            JSONObject jsonObject = JSONObject.parseObject(searchParams);
            String operName = String.valueOf(jsonObject.get("operName"));
            if (StrUtil.isNotBlank(operName)) {
                queryWrapper.eq("oper_name", operName);
            }
            String businessType = String.valueOf(jsonObject.get("businessType"));
            if (StrUtil.isNotBlank(businessType)) {
                queryWrapper.eq("business_type", businessType);
            }
            String operTime = String.valueOf(jsonObject.get("operTime"));
            if (StrUtil.isNotBlank(operTime)) {
                String startDate = operTime.split("~")[0].trim();
                String endDate = operTime.split("~")[1].trim();
                queryWrapper.ge("oper_time", TimeUtil.strToDate(startDate));
                queryWrapper.le("oper_time", TimeUtil.strToDate(endDate));
            }
        }
        queryWrapper.orderByDesc("oper_time");
        Page<SysOperLog> page = new Page<>(pageNo, pageSize);
        IPage<SysOperLog> pageList = sysOperLogService.page(page, queryWrapper);
        return ResultInfo.success(new PageDataInfo<SysOperLog>(pageList.getRecords(),pageList.getTotal()));
    }

    /**
     * 详细页面
     * @author Stranger。
     * @since 2021-07-02
     */
    @GetMapping("/detail/{id}")
    public String edit(Model model, @PathVariable("id") String id){
        SysOperLog sysOperLog = sysOperLogService.getById(id);
        model.addAttribute("sysOperLog",sysOperLog);
        return "monitor/sysOperLog/detail";
    }

    /**
     * 逻辑删除一条数据
     * @param id 主键
     * @return top.plgxs.common.api.ResultInfo<java.lang.Object>
     * @author Stranger。
     * @since 2021-07-02
     */
    @ApiOperation(value = "删除操作日志记录", notes = "删除单条数据")
    @GetMapping("/delete/{id}")
    @ResponseBody
    public ResultInfo<Object> delete(@PathVariable("id") String id){
        if(StringUtils.isBlank(id)){
            return ResultInfo.validateFailed();
        }
        boolean result = sysOperLogService.removeById(id);
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
    @ApiOperation(value = "批量删除操作日志记录", notes = "批量删除数据")
    @PostMapping("/batchDelete")
    @ResponseBody
    public ResultInfo<Object> batchDelete(@RequestBody List<String> ids){
        boolean result = sysOperLogService.removeByIds(ids);
        if(result){
            return ResultInfo.success("删除成功",null);
        }else{
            return ResultInfo.failed("删除失败");
        }
    }

    /**
     * 清空操作日志
     * @return top.plgxs.common.core.api.ResultInfo
     * @author Stranger。
     * @since 2021/7/3
     */
    @GetMapping("/clear")
    @ResponseBody
    public ResultInfo clear(){
        sysOperLogService.clear();
        return ResultInfo.success();
    }
}
