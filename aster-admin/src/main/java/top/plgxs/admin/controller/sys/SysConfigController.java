package top.plgxs.admin.controller.sys;

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
import top.plgxs.admin.service.sys.SysConfigService;
import top.plgxs.common.core.annotation.Log;
import top.plgxs.common.core.api.ResultInfo;
import top.plgxs.common.core.api.page.PageDataInfo;
import top.plgxs.common.core.constants.enums.BusinessType;
import top.plgxs.common.core.util.ExcelUtils;
import top.plgxs.mbg.dto.export.ConfigExport;
import top.plgxs.mbg.entity.sys.SysConfig;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Stranger。
 * @version 1.0
 * @since 2021-06-13
 */
@Api(tags = "系统设置")
@Controller
@RequestMapping("/sysConfig")
public class SysConfigController {
    @Resource
    private SysConfigService sysConfigService;

    /**
     * 页面
     *
     * @author Stranger。
     * @since 2021-06-13
     */
    @GetMapping("/list")
    public String list() {
        return "sys/config/list";
    }

    /**
     * 分页查询列表
     *
     * @param searchParams 查询条件
     * @param pageNo       第几页
     * @param pageSize     每页几条
     * @return
     * @author Stranger。
     * @since 2021-06-13
     */
    @ApiOperation(value = "分页查询列表", notes = "条件查询")
    @GetMapping("/pageList")
    @ResponseBody
    public ResultInfo<PageDataInfo> queryPageList(@RequestParam(name = "searchParams", required = false) String searchParams, @RequestParam(name = "page", defaultValue = "1") Integer pageNo,
                                                  @RequestParam(name = "limit", defaultValue = "10") Integer pageSize) {

        Page<SysConfig> page = new Page<>(pageNo, pageSize);
        IPage<SysConfig> pageList = sysConfigService.page(page, getQueryWrapper(searchParams));
        return ResultInfo.success(new PageDataInfo<SysConfig>(pageList.getRecords(), pageList.getTotal()));
    }

    private QueryWrapper<SysConfig> getQueryWrapper(String searchParams) {
        QueryWrapper<SysConfig> queryWrapper = new QueryWrapper<>();
        if (StrUtil.isNotBlank(searchParams)) {
            JSONObject jsonObject = JSONObject.parseObject(searchParams);

            String configName = String.valueOf(jsonObject.get("configName"));
            if (StrUtil.isNotBlank(configName)) {
                queryWrapper.like("config_name", configName);
            }
            String configKey = String.valueOf(jsonObject.get("configKey"));
            if (StrUtil.isNotBlank(configKey)) {
                queryWrapper.like("config_key", configKey);
            }
            String configValue = String.valueOf(jsonObject.get("configValue"));
            if (StrUtil.isNotBlank(configValue)) {
                queryWrapper.like("config_value", configValue);
            }
        }
        queryWrapper.orderByDesc("gmt_create");
        return queryWrapper;
    }

    /**
     * 导出
     * @param searchParams
     * @param response
     * @return void
     * @author Stranger。
     * @since 2021/7/24
     */
    @GetMapping("/export")
    public void export(@RequestParam(name = "searchParams", required = false) String searchParams,
                       HttpServletResponse response) {
        List<ConfigExport> list = sysConfigService.export(getQueryWrapper(searchParams));
        ExcelUtils.exportExcel(response, "配置列表", ConfigExport.class, list);
    }

    /**
     * 添加页面
     *
     * @author Stranger。
     * @since 2021-06-13
     */
    @GetMapping("/add")
    public String add() {
        return "sys/config/add";
    }

    /**
     * 插入一条数据
     *
     * @param sysConfig
     * @return top.plgxs.common.api.ResultInfo<java.lang.Object>
     * @author Stranger。
     * @since 2021-06-13
     */
    @Log(title = "系统配置", businessType = BusinessType.INSERT)
    @PostMapping("/insert")
    @ResponseBody
    public ResultInfo<Object> insert(@RequestBody SysConfig sysConfig) {
        int result = sysConfigService.insertConfig(sysConfig);
        if (result > 0) {
            return ResultInfo.success();
        } else {
            return ResultInfo.failed();
        }
    }

    /**
     * 编辑页面
     *
     * @author Stranger。
     * @since 2021-06-13
     */
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") String id) {
        SysConfig sysConfig = sysConfigService.getById(id);
        model.addAttribute("sysConfig", sysConfig);
        return "sys/config/edit";
    }

    /**
     * 更新一条数据
     *
     * @param sysConfig
     * @return top.plgxs.common.api.ResultInfo<java.lang.Object>
     * @author Stranger。
     * @since 2021-06-13
     */
    @Log(title = "系统配置", businessType = BusinessType.UPDATE)
    @PostMapping("/update")
    @ResponseBody
    public ResultInfo<Object> update(@RequestBody SysConfig sysConfig) {
        if (sysConfig == null || StringUtils.isBlank(sysConfig.getId())) {
            return ResultInfo.validateFailed();
        }
        sysConfigService.updateConfig(sysConfig);
        return ResultInfo.success();
    }

    /**
     * 逻辑删除一条数据
     *
     * @param id 主键
     * @return top.plgxs.common.api.ResultInfo<java.lang.Object>
     * @author Stranger。
     * @since 2021-06-13
     */
    @Log(title = "系统配置", businessType = BusinessType.DELETE)
    @GetMapping("/delete/{id}")
    @ResponseBody
    public ResultInfo<Object> delete(@PathVariable("id") String id) {
        if (StringUtils.isBlank(id)) {
            return ResultInfo.validateFailed();
        }
        boolean result = sysConfigService.removeById(id);
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
     * @since 2021-06-13
     */
    @Log(title = "系统配置", businessType = BusinessType.DELETE)
    @PostMapping("/batchDelete")
    @ResponseBody
    public ResultInfo<Object> batchDelete(@RequestBody List<String> ids) {
        boolean result = sysConfigService.removeByIds(ids);
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
     * @since 2021-06-13
     */
    @Log(title = "系统配置", businessType = BusinessType.SWITCH)
    @PostMapping("/switchStatus")
    @ResponseBody
    public ResultInfo<String> switchStatus(@RequestParam(name = "id") String id, @RequestParam(name = "status") String status) {
        SysConfig sysConfig = new SysConfig();
        sysConfig.setId(id);
        sysConfig.setStatus(status);
        boolean result = sysConfigService.updateById(sysConfig);
        if (result) {
            return ResultInfo.success("切换成功", null);
        } else {
            return ResultInfo.failed("切换失败");
        }
    }

    /**
     * 切换主题
     *
     * @param value 值
     * @return top.plgxs.common.api.ResultInfo<java.lang.Object>
     * @author Stranger。
     * @since 2021-06-13
     */
    @Log(title = "系统配置", businessType = BusinessType.UPDATE)
    @PostMapping("/switchTheme/{value}")
    @ResponseBody
    public ResultInfo<Object> switchTheme(@PathVariable("value") String value) {
        sysConfigService.switchTheme(value);
        return ResultInfo.success("切换主题", null);
    }

    /**
     * 验证key是否已存在
     *
     * @param key
     * @return top.plgxs.common.core.api.ResultInfo
     * @author Stranger。
     * @since 2021/6/28
     */
    @GetMapping("/verifyKey")
    @ResponseBody
    public ResultInfo verifyKey(@RequestParam("key") String key,
                                @RequestParam(name = "id", required = false) String id) {
        QueryWrapper<SysConfig> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("config_key", key);
        if (StrUtil.isNotBlank(id)) {
            queryWrapper.ne("id", id);
        }
        List<SysConfig> list = sysConfigService.list(queryWrapper);
        if (CollUtil.isNotEmpty(list)) {
            return ResultInfo.success("key已存在", null);
        }
        return ResultInfo.failed();
    }
}
