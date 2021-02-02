package top.plgxs.admin.controller.sys;

import javax.annotation.Resource;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.plgxs.admin.service.sys.SysMenuService;
import top.plgxs.common.api.ResultInfo;
import top.plgxs.common.domain.TreeTable;
import top.plgxs.common.page.PageDataInfo;
import top.plgxs.mbg.entity.sys.SysMenu;
import org.springframework.stereotype.Controller;

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
     * @author Stranger。
     * @since 2021-02-02
     */
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") String id){
        SysMenu sysMenu = sysMenuService.getById(id);
        model.addAttribute("sysMenu",sysMenu);
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
     * @param id 主键
     * @return top.plgxs.common.api.ResultInfo<java.lang.Object>
     * @author Stranger。
     * @since 2021-02-02
     */
    @GetMapping("/delete/{id}")
    @ResponseBody
    public ResultInfo<Object> delete(@PathVariable("id") String id){
        if(StringUtils.isBlank(id)){
            return ResultInfo.validateFailed();
        }
        boolean result = sysMenuService.removeById(id);
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
     * @since 2021-02-02
     */
    @PostMapping("/batchDelete")
    @ResponseBody
    public ResultInfo<Object> batchDelete(@RequestBody List<String> ids){
        boolean result = sysMenuService.removeByIds(ids);
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
     * @author Stranger。
     * @since 2021-02-02
     */
    @PostMapping("/switchStatus")
    @ResponseBody
    public ResultInfo<String> switchStatus(@RequestParam(name="id") String id, @RequestParam(name = "status") String status){
        SysMenu sysMenu = new SysMenu();
        sysMenu.setId(id);
        sysMenu.setStatus(status);
        boolean result = sysMenuService.updateById(sysMenu);
        if(result){
            return ResultInfo.success("切换成功",null);
        }else{
            return ResultInfo.failed("切换失败");
        }
    }
}
