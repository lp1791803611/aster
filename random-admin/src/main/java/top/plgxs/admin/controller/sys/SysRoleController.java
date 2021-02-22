package top.plgxs.admin.controller.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.plgxs.admin.service.sys.SysRoleService;
import top.plgxs.common.api.ResultInfo;
import top.plgxs.common.node.ZTreeNode;
import top.plgxs.common.page.PageDataInfo;
import top.plgxs.mbg.entity.sys.SysRole;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 角色 前端控制器
 * </p>
 *
 * @author Stranger。
 * @since 2021-02-13
 * @version 1.0
 */
@Controller
@RequestMapping("/sysRole")
public class SysRoleController {
    @Resource
    private SysRoleService sysRoleService;

    /**
     * 角色页面
     * @author Stranger。
     * @since 2021-02-13
     */
    @GetMapping("/list")
    public String list(){
        return "sys/role/list";
    }

    /**
     * 分页查询列表
     * @param searchParams 查询条件
     * @param pageNo 第几页
     * @param pageSize 每页几条
     * @return
     * @author Stranger。
     * @since 2021-02-13
     */
    @GetMapping("/pageList")
    @ResponseBody
    public ResultInfo<PageDataInfo> queryPageList(@RequestParam(name = "searchParams", required = false) String searchParams, @RequestParam(name = "page", defaultValue = "1") Integer pageNo,
                                                    @RequestParam(name = "limit", defaultValue = "10") Integer pageSize){
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        //TODO 查询条件
        queryWrapper.orderByDesc("gmt_create");
        Page<SysRole> page = new Page<>(pageNo, pageSize);
        IPage<SysRole> pageList = sysRoleService.page(page, queryWrapper);
        return ResultInfo.success(new PageDataInfo<SysRole>(pageList.getRecords(),pageList.getTotal()));
    }

    /**
     * 添加页面
     * @author Stranger。
     * @since 2021-02-13
     */
    @GetMapping("/add")
    public String add(){
        return "sys/role/add";
    }

    /**
     * 插入一条数据
     * @param sysRole
     * @return top.plgxs.common.api.ResultInfo<java.lang.Object>
     * @author Stranger。
     * @since 2021-02-13
     */
    @PostMapping("/insert")
    @ResponseBody
    public ResultInfo<Object> insert(@RequestBody SysRole sysRole){
        sysRole.setGmtCreate(LocalDateTime.now());
        boolean result = sysRoleService.save(sysRole);
        if(result){
            return ResultInfo.success();
        }else{
            return ResultInfo.failed();
        }
    }

    /**
     * 编辑页面
     * @author Stranger。
     * @since 2021-02-13
     */
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") String id){
        SysRole sysRole = sysRoleService.getById(id);
        model.addAttribute("sysRole",sysRole);
        return "sys/role/edit";
    }

    /**
     * 更新一条数据
     * @param sysRole
     * @return top.plgxs.common.api.ResultInfo<java.lang.Object>
     * @author Stranger。
     * @since 2021-02-13
     */
    @PostMapping("/update")
    @ResponseBody
    public ResultInfo<Object> update(@RequestBody SysRole sysRole){
        if(sysRole == null || StringUtils.isBlank(sysRole.getId())){
            return ResultInfo.validateFailed();
        }
        boolean result = sysRoleService.updateById(sysRole);
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
     * @since 2021-02-13
     */
    @GetMapping("/delete/{id}")
    @ResponseBody
    public ResultInfo<Object> delete(@PathVariable("id") String id){
        if(StringUtils.isBlank(id)){
            return ResultInfo.validateFailed();
        }
        boolean result = sysRoleService.removeById(id);
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
     * @since 2021-02-13
     */
    @PostMapping("/batchDelete")
    @ResponseBody
    public ResultInfo<Object> batchDelete(@RequestBody List<String> ids){
        boolean result = sysRoleService.removeByIds(ids);
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
     * @since 2021-02-13
     */
    @PostMapping("/switchStatus")
    @ResponseBody
    public ResultInfo<String> switchStatus(@RequestParam(name="id") String id, @RequestParam(name = "status") String status){
        SysRole sysRole = new SysRole();
        sysRole.setId(id);
        sysRole.setStatus(status);
        boolean result = sysRoleService.updateById(sysRole);
        if(result){
            return ResultInfo.success("切换成功",null);
        }else{
            return ResultInfo.failed("切换失败");
        }
    }

    /**
     * 查询role组装成ztree格式
     * @param userId 用户id
     * @return top.plgxs.common.api.ResultInfo<java.util.List<top.plgxs.common.node.ZTreeNode>>
     * @author Stranger。
     * @since 2021/2/13
     */
    @PostMapping("/roleTreeList")
    @ResponseBody
    public ResultInfo<List<ZTreeNode>> roleTreeList(@RequestParam("userId") String userId){
        List<ZTreeNode> list = sysRoleService.roleTreeList(userId);
        return ResultInfo.success(list);
    }
}
