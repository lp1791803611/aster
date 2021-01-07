package top.plgxs.admin.controller.sys;

import javax.annotation.Resource;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import top.plgxs.admin.service.sys.SysMenuService;
import top.plgxs.common.api.ResultInfo;
import top.plgxs.mbg.entity.sys.SysMenu;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 菜单 前端控制器
 * </p>
 *
 * @author Stranger。
 * @since 2021-01-07
 * @version 1.0
 */
@Controller
@RequestMapping("/sysMenu")
public class SysMenuController {
    @Resource
    private SysMenuService sysMenuService;

    /**
     * 分页查询列表
     * @param query 查询条件
     * @param pageNo 第几页
     * @param pageSize 每页几条
     * @return
     * @author Stranger。
     * @since 2021-01-07
     */
    @GetMapping("/list")
    @ResponseBody
    public ResultInfo<IPage<SysMenu>> queryPageList(@RequestParam("query") String query, @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                    @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize){
        QueryWrapper<SysMenu> queryWrapper = new QueryWrapper<>();
        //TODO 查询条件
        Page<SysMenu> page = new Page<>(pageNo, pageSize);
        IPage<SysMenu> pageList = sysMenuService.page(page, queryWrapper);
        return ResultInfo.success(pageList);
    }

    /**
     * 插入一条数据
     * @param sysMenu
     * @return top.plgxs.common.api.ResultInfo<java.lang.Object>
     * @author Stranger。
     * @since 2021-01-07
     */
    @PostMapping("/insert")
    @ResponseBody
    public ResultInfo<Object> insert(@RequestBody SysMenu sysMenu){
        boolean result = sysMenuService.save(sysMenu);
        if(result){
            return ResultInfo.success();
        }else{
            return ResultInfo.failed();
        }
    }

    /**
     * 更新一条数据
     * @param sysMenu
     * @return top.plgxs.common.api.ResultInfo<java.lang.Object>
     * @author Stranger。
     * @since 2021-01-07
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
     * @since 2021-01-07
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
}
