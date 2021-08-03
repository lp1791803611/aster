package top.plgxs.admin.controller.sys;

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
import top.plgxs.admin.service.sys.SysNoticeService;
import top.plgxs.common.core.annotation.Log;
import top.plgxs.common.core.api.ResultInfo;
import top.plgxs.common.core.api.page.PageDataInfo;
import top.plgxs.common.core.constants.enums.BusinessType;
import top.plgxs.mbg.entity.sys.SysNotice;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 通知公告 前端控制器
 * </p>
 *
 * @author Stranger.
 * @since 2021-07-16
 * @version 1.0
 */
@Api(tags = "通知公告管理")
@Controller
@RequestMapping("/sysNotice")
public class SysNoticeController {
    @Resource
    private SysNoticeService sysNoticeService;

    /**
     * 通知公告页面
     * @author Stranger.
     * @since 2021-07-16
     */
    @GetMapping("/list")
    public String list(){
        return "sys/notice/list";
    }

    /**
     * 分页查询列表
     * @param searchParams 查询条件
     * @param pageNo 第几页
     * @param pageSize 每页几条
     * @return
     * @author Stranger.
     * @since 2021-07-16
     */
    @ApiOperation(value = "分页查询通知公告列表", notes = "条件查询")
    @GetMapping("/pageList")
    @ResponseBody
    public ResultInfo<PageDataInfo> queryPageList(@RequestParam(name = "searchParams", required = false) String searchParams,
                                                    @RequestParam(name = "page", defaultValue = "1") Integer pageNo,
                                                    @RequestParam(name = "limit", defaultValue = "10") Integer pageSize){
        QueryWrapper<SysNotice> queryWrapper = new QueryWrapper<>();
        if (StrUtil.isNotBlank(searchParams)) {
            JSONObject jsonObject = JSONObject.parseObject(searchParams);
            String noticeTitle = String.valueOf(jsonObject.get("noticeTitle"));
            if (StrUtil.isNotBlank(noticeTitle)) {
                queryWrapper.like("notice_title", noticeTitle);
            }
            String noticeType = String.valueOf(jsonObject.get("noticeType"));
            if (StrUtil.isNotBlank(noticeType)) {
                queryWrapper.eq("notice_type", noticeType);
            }
        }
        queryWrapper.orderByDesc("gmt_create");
        Page<SysNotice> page = new Page<>(pageNo, pageSize);
        IPage<SysNotice> pageList = sysNoticeService.page(page, queryWrapper);
        return ResultInfo.success(new PageDataInfo<SysNotice>(pageList.getRecords(),pageList.getTotal()));
    }

    /**
     * 添加页面
     * @author Stranger.
     * @since 2021-07-16
     */
    @GetMapping("/add")
    public String add(){
        return "sys/notice/add";
    }

    /**
     * 插入一条数据
     * @param sysNotice
     * @return top.plgxs.common.api.ResultInfo<java.lang.Object>
     * @author Stranger.
     * @since 2021-07-16
     */
    @ApiOperation(value = "插入通知公告", notes = "插入单条数据")
    @Log(title = "通知公告", businessType = BusinessType.INSERT)
    @PostMapping("/insert")
    @ResponseBody
    public ResultInfo<Object> insert(@RequestBody SysNotice sysNotice){
        sysNotice.setGmtCreate(LocalDateTime.now());
        boolean result = sysNoticeService.save(sysNotice);
        if(result){
            return ResultInfo.success();
        }else{
            return ResultInfo.failed();
        }
    }

    /**
     * 编辑页面
     * @author Stranger.
     * @since 2021-07-16
     */
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") String id){
        SysNotice sysNotice = sysNoticeService.getById(id);
        model.addAttribute("sysNotice",sysNotice);
        return "sys/notice/edit";
    }

    /**
     * 更新一条数据
     * @param sysNotice
     * @return top.plgxs.common.api.ResultInfo<java.lang.Object>
     * @author Stranger.
     * @since 2021-07-16
     */
    @ApiOperation(value = "更新通知公告", notes = "更新单条数据")
    @Log(title = "通知公告", businessType = BusinessType.UPDATE)
    @PostMapping("/update")
    @ResponseBody
    public ResultInfo<Object> update(@RequestBody SysNotice sysNotice){
        if(sysNotice == null || StringUtils.isBlank(sysNotice.getId())){
            return ResultInfo.validateFailed();
        }
        sysNotice.setGmtModified(LocalDateTime.now());
        boolean result = sysNoticeService.updateById(sysNotice);
        if(result){
            return ResultInfo.success();
        }else{
            return ResultInfo.failed();
        }
    }

    /**
     * 逻辑删除一条数据
     * @param id 主键
     * @return top.plgxs.common.api.ResultInfo<java.lang.Object>
     * @author Stranger.
     * @since 2021-07-16
     */
    @ApiOperation(value = "删除通知公告", notes = "删除单条数据")
    @Log(title = "通知公告", businessType = BusinessType.DELETE)
    @GetMapping("/delete/{id}")
    @ResponseBody
    public ResultInfo<Object> delete(@PathVariable("id") String id){
        if(StringUtils.isBlank(id)){
            return ResultInfo.validateFailed();
        }
        boolean result = sysNoticeService.removeById(id);
        if(result){
            return ResultInfo.success();
        }else{
            return ResultInfo.failed();
        }
    }

    /**
     * 批量删除
     * @param ids id数组
     * @author Stranger.
     * @since 2021-07-16
     */
    @ApiOperation(value = "批量删除通知公告", notes = "批量删除数据")
    @Log(title = "通知公告", businessType = BusinessType.DELETE)
    @PostMapping("/batchDelete")
    @ResponseBody
    public ResultInfo<Object> batchDelete(@RequestBody List<String> ids){
        boolean result = sysNoticeService.removeByIds(ids);
        if(result){
            return ResultInfo.success("删除成功",null);
        }else{
            return ResultInfo.failed("删除失败");
        }
    }

    /**
     * 切换状态
     * @param id 主键
     * @param status 状态
     * @author Stranger.
     * @since 2021-07-16
     */
    @ApiOperation(value = "切换通知公告状态", notes = "切换状态")
    @Log(title = "通知公告", businessType = BusinessType.SWITCH)
    @PostMapping("/switchStatus")
    @ResponseBody
    public ResultInfo<String> switchStatus(@RequestParam(name="id") String id, @RequestParam(name = "status") String status){
        SysNotice sysNotice = new SysNotice();
        sysNotice.setId(id);
        sysNotice.setStatus(status);
        boolean result = sysNoticeService.updateById(sysNotice);
        if(result){
            return ResultInfo.success("切换成功",null);
        }else{
            return ResultInfo.failed("切换失败");
        }
    }
}
