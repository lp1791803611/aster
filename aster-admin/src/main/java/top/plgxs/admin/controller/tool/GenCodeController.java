package top.plgxs.admin.controller.tool;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.plgxs.admin.config.JdbcConfig;
import top.plgxs.admin.service.sys.SysUserService;
import top.plgxs.common.core.api.ResultInfo;
import top.plgxs.common.core.api.page.PageDataInfo;
import top.plgxs.common.core.constants.Constants;
import top.plgxs.mbg.dto.gen.GenInfo;
import top.plgxs.mbg.dto.gen.TableBasic;
import top.plgxs.mbg.dto.gen.TableColumn;
import top.plgxs.mbg.dto.gen.TableOutput;
import top.plgxs.mbg.utils.GenUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 生成代码
 *
 * @author Stranger。
 * @version 1.0
 * @since 2021/7/9 10:19
 */
@Controller
@RequestMapping("/gen")
public class GenCodeController {
    @Resource
    JdbcConfig jdbcConfig;
    @Resource
    private SysUserService sysUserService;

    /**
     * 跳转页面
     *
     * @return java.lang.String
     * @author Stranger。
     * @since 2021/7/9
     */
    @GetMapping("/code")
    public String gen() {
        return "tool/gen/gen";
    }

    /**
     * 获取表名
     *
     * @return top.plgxs.common.core.api.ResultInfo<java.util.List < com.alibaba.fastjson.JSONObject>>
     * @author Stranger。
     * @since 2021/7/9
     */
    @GetMapping("/getTableNames")
    @ResponseBody
    public ResultInfo<List<JSONObject>> getTableNames() {
        List<JSONObject> list = new ArrayList<>();
        List<String> tableNames = sysUserService.getTableNames();
        if (CollUtil.isNotEmpty(tableNames)) {
            for (String tableName : tableNames) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("name", tableName);
                jsonObject.put("value", tableName);
                list.add(jsonObject);
            }
        }
        return ResultInfo.success(list);
    }

    /**
     * 获取表字段信息
     *
     * @param tableName 表名
     * @return top.plgxs.common.core.api.ResultInfo<top.plgxs.common.core.api.page.PageDataInfo>
     * @author Stranger。
     * @since 2021/7/9
     */
    @GetMapping("/getTableColumn")
    @ResponseBody
    public ResultInfo<PageDataInfo> getTableColumn(@RequestParam(name = "tableName") String tableName) {
        List<TableColumn> list = sysUserService.getTableColumn(tableName);
        if (CollUtil.isNotEmpty(list)) {
            for (TableColumn column : list) {
                column.setPropertyName(StrUtil.toCamelCase(column.getColumnName()));
            }
        }
        return ResultInfo.success(new PageDataInfo<TableColumn>(list, (long) list.size()));
    }

    /**
     * 生成代码
     *
     * @param genInfo
     * @return top.plgxs.common.core.api.ResultInfo
     * @author Stranger。
     * @since 2021/7/11
     */
    @PostMapping("/generator")
    @ResponseBody
    public ResultInfo generator(@RequestBody GenInfo genInfo) {
        TableBasic basic = genInfo.getBasic();
        List<TableColumn> columns = genInfo.getColumns();
        TableOutput output = genInfo.getOutput();
        if (StrUtil.isBlank(basic.getDbUrl()) || StrUtil.isBlank(basic.getDbType())
                || StrUtil.isBlank(basic.getDbUsername()) || StrUtil.isBlank(basic.getDbPassword())
                || StrUtil.isBlank(basic.getDbDriver())) {
            basic.setDbType(Constants.DEFAULT_DB_TYPE);
            basic.setDbDriver(Constants.DEFAULT_DB_DRIVER);
            basic.setDbUrl(jdbcConfig.getUrl());
            basic.setDbUsername(jdbcConfig.getUsername());
            basic.setDbPassword(jdbcConfig.getPassword());
        }
        GenUtils.generate(basic, output, columns);
        return ResultInfo.success();
    }
}
