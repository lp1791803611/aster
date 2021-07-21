package top.plgxs.admin.controller.sys;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.plgxs.admin.service.sys.SysDictService;
import top.plgxs.common.core.annotation.Log;
import top.plgxs.common.core.api.ResultInfo;
import top.plgxs.common.core.api.page.PageDataInfo;
import top.plgxs.common.core.constants.enums.BusinessType;
import top.plgxs.mbg.entity.sys.SysDict;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 字典数据 前端控制器
 * </p>
 *
 * @author Stranger。
 * @version 1.0
 * @since 2021-02-23
 */
@Controller
@RequestMapping("/sysDict")
public class SysDictController {
    @Resource
    private SysDictService sysDictService;

    /**
     * 字典数据页面
     *
     * @author Stranger。
     * @since 2021-02-23
     */
    @GetMapping("/list")
    public String list(@RequestParam("dictTypeCode") String dictTypeCode, Model model) {
        model.addAttribute("dictTypeCode", dictTypeCode);
        return "sys/dict/list";
    }

    /**
     * 分页查询列表
     *
     * @param name     查询条件
     * @param pageNo   第几页
     * @param pageSize 每页几条
     * @return
     * @author Stranger。
     * @since 2021-02-23
     */
    @GetMapping("/pageList")
    @ResponseBody
    public ResultInfo<PageDataInfo> queryPageList(@RequestParam("dictTypeCode") String dictTypeCode,
                                                  @RequestParam(name = "name", required = false) String name, @RequestParam(name = "page", defaultValue = "1") Integer pageNo,
                                                  @RequestParam(name = "limit", defaultValue = "10") Integer pageSize) {
        QueryWrapper<SysDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("dict_type_code", dictTypeCode);
        if (StrUtil.isNotBlank(name)) {
            queryWrapper.and(qw -> qw.like("dict_label", name));
        }
        queryWrapper.orderByAsc("sort");
        Page<SysDict> page = new Page<>(pageNo, pageSize);
        IPage<SysDict> pageList = sysDictService.page(page, queryWrapper);
        return ResultInfo.success(new PageDataInfo<SysDict>(pageList.getRecords(), pageList.getTotal()));
    }

    /**
     * 添加页面
     *
     * @author Stranger。
     * @since 2021-02-23
     */
    @GetMapping("/add")
    public String add(@RequestParam("dictTypeCode") String dictTypeCode, Model model) {
        model.addAttribute("dictTypeCode", dictTypeCode);
        return "sys/dict/add";
    }

    /**
     * 插入一条数据
     *
     * @param sysDict
     * @return top.plgxs.common.api.ResultInfo<java.lang.Object>
     * @author Stranger。
     * @since 2021-02-23
     */
    @Log(title = "字典数据管理", businessType = BusinessType.INSERT)
    @PostMapping("/insert")
    @ResponseBody
    public ResultInfo<Object> insert(@RequestBody SysDict sysDict) {
        sysDict.setGmtCreate(LocalDateTime.now());
        boolean result = sysDictService.save(sysDict);
        if (result) {
            return ResultInfo.success();
        } else {
            return ResultInfo.failed();
        }
    }

    /**
     * 编辑页面
     *
     * @author Stranger。
     * @since 2021-02-23
     */
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") String id) {
        SysDict sysDict = sysDictService.getById(id);
        model.addAttribute("sysDict", sysDict);
        return "sys/dict/edit";
    }

    /**
     * 更新一条数据
     *
     * @param sysDict
     * @return top.plgxs.common.api.ResultInfo<java.lang.Object>
     * @author Stranger。
     * @since 2021-02-23
     */
    @Log(title = "字典数据管理", businessType = BusinessType.UPDATE)
    @PostMapping("/update")
    @ResponseBody
    public ResultInfo<Object> update(@RequestBody SysDict sysDict) {
        if (sysDict == null || StringUtils.isBlank(sysDict.getId())) {
            return ResultInfo.validateFailed();
        }
        boolean result = sysDictService.updateById(sysDict);
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
     * @author Stranger。
     * @since 2021-02-23
     */
    @Log(title = "字典数据管理", businessType = BusinessType.DELETE)
    @GetMapping("/delete/{id}")
    @ResponseBody
    public ResultInfo<Object> delete(@PathVariable("id") String id) {
        if (StringUtils.isBlank(id)) {
            return ResultInfo.validateFailed();
        }
        boolean result = sysDictService.removeById(id);
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
     * @author Stranger。
     * @since 2021-02-23
     */
    @Log(title = "字典数据管理", businessType = BusinessType.DELETE)
    @PostMapping("/batchDelete")
    @ResponseBody
    public ResultInfo<Object> batchDelete(@RequestBody List<String> ids) {
        boolean result = sysDictService.removeByIds(ids);
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
     * @author Stranger。
     * @since 2021-02-23
     */
    @Log(title = "字典数据管理", businessType = BusinessType.SWITCH)
    @PostMapping("/switchStatus")
    @ResponseBody
    public ResultInfo<String> switchStatus(@RequestParam(name = "id") String id, @RequestParam(name = "status") String status) {
        SysDict sysDict = new SysDict();
        sysDict.setId(id);
        sysDict.setStatus(status);
        boolean result = sysDictService.updateById(sysDict);
        if (result) {
            return ResultInfo.success("切换成功", null);
        } else {
            return ResultInfo.failed("切换失败");
        }
    }

    /**
     * 根据字典类型编码查询字典数据
     * @param code 字典类型编码
     * @author Stranger。
     * @since 2021/2/5 0005
     */
    @PostMapping("/listDictsByCode")
    @ResponseBody
    public ResultInfo<List<SysDict>> listDictsByCode(@RequestParam(name = "code") String code){
        List<SysDict> dicts = sysDictService.listDictsByCode(code);
        return ResultInfo.success(dicts);
    }
}
