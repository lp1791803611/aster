package top.plgxs.admin.controller.vacc;

import cn.hutool.core.util.IdUtil;
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
import top.plgxs.admin.service.vacc.ChildInfoService;
import top.plgxs.common.core.annotation.Log;
import top.plgxs.common.core.api.ResultInfo;
import top.plgxs.common.core.api.page.PageDataInfo;
import top.plgxs.common.core.constants.enums.BusinessType;
import top.plgxs.mbg.entity.vacc.ChildInfo;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Stranger.
 * @version 1.0
 * @since 2021-08-02
 */
@Api(tags = "管理")
@Controller
@RequestMapping("/childInfo")
public class ChildInfoController {
    @Resource
    private ChildInfoService childInfoService;

    /**
     * 页面
     *
     * @author Stranger.
     * @since 2021-08-02
     */
    @GetMapping("/list")
    public String list() {
        return "vacc/childInfo/list";
    }

    /**
     * 分页查询列表
     *
     * @param searchParams 查询条件
     * @param pageNo       第几页
     * @param pageSize     每页几条
     * @return
     * @author Stranger.
     * @since 2021-08-02
     */
    @ApiOperation(value = "分页查询列表", notes = "条件查询")
    @GetMapping("/pageList")
    @ResponseBody
    public ResultInfo<PageDataInfo> queryPageList(@RequestParam(name = "searchParams", required = false) String searchParams,
                                                  @RequestParam(name = "page", defaultValue = "1") Integer pageNo,
                                                  @RequestParam(name = "limit", defaultValue = "10") Integer pageSize) {
        QueryWrapper<ChildInfo> queryWrapper = new QueryWrapper<>();
        if (StrUtil.isNotBlank(searchParams)) {
            JSONObject jsonObject = JSONObject.parseObject(searchParams);
        }
        queryWrapper.orderByDesc("gmt_create");
        Page<ChildInfo> page = new Page<>(pageNo, pageSize);
        IPage<ChildInfo> pageList = childInfoService.page(page, queryWrapper);
        return ResultInfo.success(new PageDataInfo<ChildInfo>(pageList.getRecords(), pageList.getTotal()));
    }

    /**
     * 添加页面
     *
     * @author Stranger.
     * @since 2021-08-02
     */
    @GetMapping("/add")
    public String add() {
        for (int i = 0; i < 10; i++) {
            ChildInfo childInfo = new ChildInfo();
            childInfo.setChildId(IdUtil.fastSimpleUUID());
            childInfo.setCreateTime(LocalDateTime.now());
            childInfoService.insert(childInfo);
        }

        return "vacc/childInfo/add";
    }

    /**
     * 插入一条数据
     *
     * @param childInfo
     * @return top.plgxs.common.api.ResultInfo<java.lang.Object>
     * @author Stranger.
     * @since 2021-08-02
     */
    @ApiOperation(value = "插入", notes = "插入单条数据")
    @Log(title = "", businessType = BusinessType.INSERT)
    @PostMapping("/insert")
    @ResponseBody
    public ResultInfo<Object> insert(@RequestBody ChildInfo childInfo) {
        boolean result = childInfoService.save(childInfo);
        if (result) {
            return ResultInfo.success();
        } else {
            return ResultInfo.failed();
        }
    }

    /**
     * 编辑页面
     *
     * @author Stranger.
     * @since 2021-08-02
     */
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") String id) {
        ChildInfo childInfo = childInfoService.getById(id);
        model.addAttribute("childInfo", childInfo);
        return "vacc/childInfo/edit";
    }

    /**
     * 更新一条数据
     *
     * @param childInfo
     * @return top.plgxs.common.api.ResultInfo<java.lang.Object>
     * @author Stranger.
     * @since 2021-08-02
     */
    @ApiOperation(value = "更新", notes = "更新单条数据")
    @Log(title = "", businessType = BusinessType.UPDATE)
    @PostMapping("/update")
    @ResponseBody
    public ResultInfo<Object> update(@RequestBody ChildInfo childInfo) {
        if (childInfo == null || StringUtils.isBlank(childInfo.getChildId())) {
            return ResultInfo.validateFailed();
        }
        boolean result = childInfoService.updateById(childInfo);
        if (result) {
            return ResultInfo.success();
        } else {
            return ResultInfo.failed();
        }
    }

    /**
     * 逻辑删除一条数据
     *
     * @param id 主键
     * @return top.plgxs.common.api.ResultInfo<java.lang.Object>
     * @author Stranger.
     * @since 2021-08-02
     */
    @ApiOperation(value = "删除", notes = "删除单条数据")
    @Log(title = "", businessType = BusinessType.DELETE)
    @GetMapping("/delete/{id}")
    @ResponseBody
    public ResultInfo<Object> delete(@PathVariable("id") String id) {
        if (StringUtils.isBlank(id)) {
            return ResultInfo.validateFailed();
        }
        boolean result = childInfoService.removeById(id);
        if (result) {
            return ResultInfo.success();
        } else {
            return ResultInfo.failed();
        }
    }

    /**
     * 批量删除
     *
     * @param ids id数组
     * @author Stranger.
     * @since 2021-08-02
     */
    @ApiOperation(value = "批量删除", notes = "批量删除数据")
    @Log(title = "", businessType = BusinessType.DELETE)
    @PostMapping("/batchDelete")
    @ResponseBody
    public ResultInfo<Object> batchDelete(@RequestBody List<String> ids) {
        boolean result = childInfoService.removeByIds(ids);
        if (result) {
            return ResultInfo.success("删除成功", null);
        } else {
            return ResultInfo.failed("删除失败");
        }
    }

    /**
     * 切换状态
     *
     * @param id     主键
     * @param status 状态
     * @author Stranger.
     * @since 2021-08-02
     */
    @ApiOperation(value = "切换状态", notes = "切换状态")
    @Log(title = "", businessType = BusinessType.SWITCH)
    @PostMapping("/switchStatus")
    @ResponseBody
    public ResultInfo<String> switchStatus(@RequestParam(name = "id") String id, @RequestParam(name = "status") String status) {
        ChildInfo childInfo = new ChildInfo();
        childInfo.setChildId(id);
        childInfo.setStatus(status);
        boolean result = childInfoService.updateById(childInfo);
        if (result) {
            return ResultInfo.success("切换成功", null);
        } else {
            return ResultInfo.failed("切换失败");
        }
    }
}
