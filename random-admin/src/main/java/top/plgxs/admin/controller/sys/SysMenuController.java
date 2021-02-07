package top.plgxs.admin.controller.sys;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.plgxs.admin.service.sys.SysMenuService;
import top.plgxs.common.api.ResultInfo;
import top.plgxs.common.domain.TreeTable;
import top.plgxs.common.node.ZTreeNode;
import top.plgxs.common.page.PageDataInfo;
import top.plgxs.mbg.entity.sys.SysMenu;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 菜单 前端控制器
 * </p>
 *
 * @author Stranger。
 * @since 2021-02-02
 * @version 1.0
 */
@Controller
@RequestMapping("/sysMenu")
public class SysMenuController {
    @Resource
    private SysMenuService sysMenuService;

    /**
     * 菜单页面
     * @author Stranger。
     * @since 2021-02-02
     */
    @GetMapping("/list")
    public String list(){
        return "sys/menu/list";
    }

    /**
     * 查询列表
     * @param menuName 菜单名称
     * @return
     * @author Stranger。
     * @since 2021-02-02
     */
    @GetMapping("/pageList")
    @ResponseBody
    public PageDataInfo queryPageList(@RequestParam(name = "menuName", required = false) String menuName){
        QueryWrapper<SysMenu> queryWrapper = new QueryWrapper<>();
        if(StrUtil.isNotBlank(menuName)){
            queryWrapper.like("menu_name", menuName);
        }
        queryWrapper.orderByAsc("sort", "gmt_create");
        List<TreeTable> menus = sysMenuService.treeTableList(queryWrapper);
        long count = menus == null ? 0L : (long) menus.size();
        return new PageDataInfo<TreeTable>(menus, count);
    }

    /**
     * 添加页面
     * @author Stranger。
     * @since 2021-02-02
     */
    @GetMapping("/add")
    public String add(){
        return "sys/menu/add";
    }

    /**
     * 插入一条数据
     * @param sysMenu
     * @return top.plgxs.common.api.ResultInfo<java.lang.Object>
     * @author Stranger。
     * @since 2021-02-02
     */
    @PostMapping("/insert")
    @ResponseBody
    public ResultInfo<Object> insert(@RequestBody SysMenu sysMenu){
        sysMenu.setGmtCreate(LocalDateTime.now());
        boolean result = sysMenuService.save(sysMenu);
        if(result){
            return ResultInfo.success();
        }else{
            return ResultInfo.failed();
        }
    }

    /**
     * 编辑页面
     * @author Strangers。
     * @since 2021/2/2 
     */
    @GetMapping("/edit/{code}")
    public String edit(Model model, @PathVariable("code") String code){
        QueryWrapper<SysMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("code", code);
        SysMenu sysMenu = sysMenuService.getOne(queryWrapper);
        String parentName = sysMenuService.getMenuNameByCode(sysMenu.getParentCode());
        model.addAttribute("sysMenu",sysMenu);
        model.addAttribute("parentName", parentName);
        return "sys/menu/edit";
    }

    /**
     * 更新一条数据
     * @param sysMenu
     * @return top.plgxs.common.api.ResultInfo<java.lang.Object>
     * @author Stranger。
     * @since 2021-02-02
     */
    @PostMapping("/update")
    @ResponseBody
    public ResultInfo<Object> update(@RequestBody SysMenu sysMenu){
        if(sysMenu == null || StringUtils.isBlank(sysMenu.getId())){
            return ResultInfo.validateFailed();
        }
        boolean result = sysMenuService.updateById(sysMenu);
        if(result){
            return ResultInfo.success();
        }else{
            return ResultInfo.failed();
        }
    }

    /**
     * 逻辑删除一条数据
     * @param code 编码
     * @return top.plgxs.common.api.ResultInfo<java.lang.Object>
     * @author Stranger。
     * @since 2021-02-02
     */
    @GetMapping("/delete/{code}")
    @ResponseBody
    public ResultInfo<Object> delete(@PathVariable("code") String code){
        if(StringUtils.isBlank(code)){
            return ResultInfo.validateFailed();
        }
        QueryWrapper<SysMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("code", code);
        boolean result = sysMenuService.remove(queryWrapper);
        if(result){
            return ResultInfo.success();
        }else{
            return ResultInfo.failed();
        }
    }

    /**
     * 批量删除
     * @param codes code数组
     * @author Stranger。
     * @since 2021-02-02
     */
    @PostMapping("/batchDelete")
    @ResponseBody
    public ResultInfo<Object> batchDelete(@RequestBody List<String> codes){
        QueryWrapper<SysMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("code", codes);
        boolean result = sysMenuService.remove(queryWrapper);
        if(result){
            return ResultInfo.success("删除成功",null);
        }else{
            return ResultInfo.failed("删除失败");
        }
    }

    /**
     * 切换状态
     * @param code 编码
     * @param status 状态
     * @author Stranger。
     * @since 2021-02-02
     */
    @PostMapping("/switchStatus")
    @ResponseBody
    public ResultInfo<String> switchStatus(@RequestParam(name="code") String code, @RequestParam(name = "status") String status){
        SysMenu sysMenu = new SysMenu();
        sysMenu.setStatus(status);
        QueryWrapper<SysMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("code", code);
        boolean result = sysMenuService.update(sysMenu, queryWrapper);
        if(result){
            return ResultInfo.success("切换成功",null);
        }else{
            return ResultInfo.failed("切换失败");
        }
    }

    /**
     * 获取菜单列表(选择父级菜单用)
     * @return top.plgxs.common.api.ResultInfo<java.util.List<top.plgxs.common.node.ZTreeNode>>
     * @author Stranger。
     * @since 2021/2/6
     */
    @PostMapping("/selectMenuTreeList")
    @ResponseBody
    public ResultInfo<List<ZTreeNode>> selectMenuTreeList(){
        List<ZTreeNode> roleTreeList = sysMenuService.menuTreeList();
        roleTreeList.add(ZTreeNode.createParent());
        return ResultInfo.success(roleTreeList);
    }

    /**
     * 验证编码是否唯一
     * @param code 编码
     * @author Stranger。
     * @since 2021/2/7 0007
     */
    @GetMapping("/verifyCode")
    @ResponseBody
    public ResultInfo<String> verifyCode(@RequestParam("code") String code){
        QueryWrapper<SysMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("code", code);
        List<SysMenu> list = sysMenuService.list(queryWrapper);
        if(list != null && list.size() > 0) {
            return ResultInfo.success("该编码已存在，请重新填写", null);
        }
        return ResultInfo.failed();
    }
}
