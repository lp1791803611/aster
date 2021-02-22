package top.plgxs.admin.controller.sys;

import javax.annotation.Resource;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.plgxs.admin.service.sys.SysRoleService;
import top.plgxs.common.api.ResultInfo;
import top.plgxs.common.page.PageDataInfo;
import top.plgxs.mbg.entity.sys.SysRole;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 角色 前端控制器
 * </p>
 *
 * @author Stranger。
 * @since 2021-02-22
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
     * @since 2021-02-22
     */
    @GetMapping("/list")
    public String list(){
        return "sys/role/list";
    }

    /**
     * 分页查询列表
     * @param name 查询条件
     * @param pageNo 第几页
     * @param pageSize 每页几条
     * @return
     * @author Stranger。
     * @since 2021-02-22
     */
    @GetMapping("/pageList")
    @ResponseBody
    public ResultInfo<PageDataInfo> queryPageList(@RequestParam(name = "name", required = false) String name, @RequestParam(name = "page", defaultValue = "1") Integer pageNo,
                                                    @RequestParam(name = "limit", defaultValue = "10") Integer pageSize){
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        if (StrUtil.isNotBlank(name)) {
            queryWrapper.like("role_name", name).or().like("role_code", name);
        }
        queryWrapper.orderByDesc("gmt_create");
        Page<SysRole> page = new Page<>(pageNo, pageSize);
        IPage<SysRole> pageList = sysRoleService.page(page, queryWrapper);
        return ResultInfo.success(new PageDataInfo<SysRole>(pageList.getRecords(),pageList.getTotal()));
    }

    /**
     * 添加页面
     * @author Stranger。
     * @since 2021-02-22
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
     * @since 2021-02-22
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
     * @since 2021-02-22
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
     * @since 2021-02-22
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
     * @since 2021-02-22
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
     * @since 2021-02-22
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
     * @since 2021-02-22
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
     * 校验角色编码是否已存在
     * @param code 角色编码
     * @author Stranger。
     * @since 2021/2/22 0022
     */
    @GetMapping("/verifyCode")
    @ResponseBody
    public ResultInfo<String> verifyCode(@RequestParam("code") String code) {
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_code", code);
        List<SysRole> roles = sysRoleService.list(queryWrapper);
        if (roles != null && roles.size() > 0) {
            return ResultInfo.success("角色编码已存在，请重新填写！", null);
        }
        return ResultInfo.failed();
    }
}
