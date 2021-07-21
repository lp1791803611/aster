package top.plgxs.admin.controller.sys;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.plgxs.admin.service.sys.SysMenuService;
import top.plgxs.common.core.annotation.Log;
import top.plgxs.common.core.api.ResultInfo;
import top.plgxs.common.core.api.TreeTable;
import top.plgxs.common.core.api.node.ZTreeNode;
import top.plgxs.common.core.api.page.PageDataInfo;
import top.plgxs.common.core.constants.enums.BusinessType;
import top.plgxs.mbg.entity.sys.SysMenu;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

/**
 * <p>
 * 菜单 前端控制器
 * </p>
 *
 * @author Stranger。
 * @version 1.0
 * @since 2021-02-02
 */
@Controller
@RequestMapping("/sysMenu")
public class SysMenuController {
    @Resource
    private SysMenuService sysMenuService;

    /**
     * 菜单页面
     *
     * @author Stranger。
     * @since 2021-02-02
     */
    @GetMapping("/list")
    public String list() {
        return "sys/menu/list";
    }

    /**
     * 查询列表
     *
     * @param menuName 菜单名称
     * @return
     * @author Stranger。
     * @since 2021-02-02
     */
    @GetMapping("/pageList")
    @ResponseBody
    public PageDataInfo queryPageList(@RequestParam(name = "menuName", required = false) String menuName) {
        QueryWrapper<SysMenu> queryWrapper = new QueryWrapper<>();
        if (StrUtil.isNotBlank(menuName)) {
            queryWrapper.like("menu_name", menuName);
        }
        queryWrapper.orderByAsc("sort", "gmt_create");
        List<TreeTable> menus = sysMenuService.treeTableList(queryWrapper);
        long count = menus == null ? 0L : (long) menus.size();
        return new PageDataInfo<TreeTable>(menus, count);
    }

    /**
     * 添加页面
     *
     * @author Stranger。
     * @since 2021-02-02
     */
    @GetMapping("/add")
    public String add() {
        return "sys/menu/add";
    }

    /**
     * 插入一条数据
     *
     * @param sysMenu
     * @return top.plgxs.common.api.ResultInfo<java.lang.Object>
     * @author Stranger。
     * @since 2021-02-02
     */
    @Log(title = "菜单管理", businessType = BusinessType.INSERT)
    @PostMapping("/insert")
    @ResponseBody
    public ResultInfo<Object> insert(@RequestBody SysMenu sysMenu) {
        int result = sysMenuService.insertMenu(sysMenu);
        if (result > 0) {
            return ResultInfo.success();
        } else {
            return ResultInfo.failed();
        }
    }

    /**
     * 编辑页面
     *
     * @author Strangers。
     * @since 2021/2/2
     */
    @GetMapping("/edit/{code}")
    public String edit(Model model, @PathVariable("code") String code) {
        QueryWrapper<SysMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("code", code);
        SysMenu sysMenu = sysMenuService.getOne(queryWrapper);
        String parentName = sysMenuService.getMenuNameByCode(sysMenu.getParentCode());
        model.addAttribute("sysMenu", sysMenu);
        model.addAttribute("parentName", parentName);
        return "sys/menu/edit";
    }

    /**
     * 更新一条数据
     *
     * @param sysMenu
     * @return top.plgxs.common.api.ResultInfo<java.lang.Object>
     * @author Stranger。
     * @since 2021-02-02
     */
    @Log(title = "菜单管理", businessType = BusinessType.UPDATE)
    @PostMapping("/update/{oldCode}")
    @ResponseBody
    public ResultInfo<Object> update(@PathVariable("oldCode") String oldCode, @RequestBody SysMenu sysMenu) {
        if (sysMenu == null || StringUtils.isBlank(sysMenu.getId())
                || StringUtils.isBlank(sysMenu.getParentCode())) {
            return ResultInfo.validateFailed();
        }
        int result = sysMenuService.updateMenu(oldCode, sysMenu);
        if (result > 0) {
            return ResultInfo.success();
        } else {
            return ResultInfo.failed();
        }
    }

    /**
     * 逻辑删除一条数据
     *
     * @param code 编码
     * @return top.plgxs.common.api.ResultInfo<java.lang.Object>
     * @author Stranger。
     * @since 2021-02-02
     */
    @Log(title = "菜单管理", businessType = BusinessType.DELETE)
    @GetMapping("/delete/{code}")
    @ResponseBody
    public ResultInfo<Object> delete(@PathVariable("code") String code) {
        if (StringUtils.isBlank(code)) {
            return ResultInfo.validateFailed();
        }
        try {
            sysMenuService.deleteMenuContainChildren(code);
            return ResultInfo.success();
        } catch (Exception e) {
            return ResultInfo.failed();
        }
    }

    /**
     * 批量删除
     *
     * @param codes code数组
     * @author Stranger。
     * @since 2021-02-02
     */
    @Log(title = "菜单管理", businessType = BusinessType.DELETE)
    @PostMapping("/batchDelete")
    @ResponseBody
    public ResultInfo<Object> batchDelete(@RequestBody List<String> codes) {
        if (codes == null || codes.size() == 0) {
            return ResultInfo.validateFailed();
        }
        try {
            sysMenuService.batchDelete(codes);
            return ResultInfo.success("删除成功", null);
        } catch (Exception e) {
            return ResultInfo.failed("删除失败");
        }
    }

    /**
     * 切换状态
     *
     * @param code   编码
     * @param status 状态
     * @author Stranger。
     * @since 2021-02-02
     */
    @Log(title = "菜单管理", businessType = BusinessType.SWITCH)
    @PostMapping("/switchStatus")
    @ResponseBody
    public ResultInfo<String> switchStatus(@RequestParam(name = "code") String code, @RequestParam(name = "status") String status) {
        try {
            sysMenuService.switchStatus(code, status);
            return ResultInfo.success("切换成功", null);
        } catch (Exception e) {
            return ResultInfo.failed("切换失败");
        }
    }

    /**
     * 获取菜单列表(选择父级菜单用)
     *
     * @return top.plgxs.common.api.ResultInfo<java.util.List < top.plgxs.common.node.ZTreeNode>>
     * @author Stranger。
     * @since 2021/2/6
     */
    @PostMapping("/selectMenuTreeList")
    @ResponseBody
    public ResultInfo<List<ZTreeNode>> selectMenuTreeList() {
        List<ZTreeNode> list = sysMenuService.menuTreeList();
        list.add(ZTreeNode.createParent());
        return ResultInfo.success(list);
    }

    /**
     * 验证编码是否唯一
     *
     * @param code 编码
     * @author Stranger。
     * @since 2021/2/7 0007
     */
    @GetMapping("/verifyCode")
    @ResponseBody
    public ResultInfo<String> verifyCode(@RequestParam("code") String code) {
        QueryWrapper<SysMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("code", code);
        List<SysMenu> list = sysMenuService.list(queryWrapper);
        if (list != null && list.size() > 0) {
            return ResultInfo.success("该编码已存在，请重新填写", null);
        }
        return ResultInfo.failed();
    }

    /**
     * 菜单树-单选
     * @param treeUrl ztrr请求json的url
     * @param model
     * @return java.lang.String
     * @author Stranger。
     * @since 2021/2/6
     */
    @GetMapping("/menuTree")
    public String commonTree(@RequestParam("treeUrl") String treeUrl, Model model) {
        if (StrUtil.isBlank(treeUrl)) {
//            throw new RequestEmptyException("请求数据不完整！");
        }
        try {
            model.addAttribute("treeUrl", URLDecoder.decode(treeUrl, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
//            throw new RequestEmptyException("请求数据不完整！");
        }
        return "sys/menu/ztree";
    }

    /**
     * 获取菜单树（多选）
     *
     * @param roleId 角色id
     * @return top.plgxs.common.api.ResultInfo<java.util.List < top.plgxs.common.node.ZTreeNode>>
     * @author Stranger
     * 。
     * @since 2021/2/13
     */
    @PostMapping("/getMenuTreeByRoleId")
    @ResponseBody
    public ResultInfo<List<ZTreeNode>> getMenuTreeByRoleId(@RequestParam("roleId") String roleId) {
        List<ZTreeNode> list = sysMenuService.getMenuTreeByRoleId(roleId);
        return ResultInfo.success(list);
    }
}
