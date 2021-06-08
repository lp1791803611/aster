package top.plgxs.admin.controller.sys;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.plgxs.admin.service.sys.SysUserRoleService;
import top.plgxs.admin.service.sys.SysUserService;
import top.plgxs.common.core.api.ResultInfo;
import top.plgxs.common.core.api.page.PageDataInfo;
import top.plgxs.common.core.constants.Constants;
import top.plgxs.common.core.constants.enums.DeleteEnum;
import top.plgxs.mbg.dto.sys.UserDto;
import top.plgxs.mbg.entity.sys.SysUser;
import top.plgxs.mbg.entity.sys.SysUserRole;
import top.plgxs.mbg.utils.Convert;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author Stranger。
 * @version 1.0
 * @since 2021-02-12
 */
@Api(tags = "用户管理")
@Controller
@RequestMapping("/sysUser")
public class SysUserController {
    @Resource
    private SysUserService sysUserService;
    @Resource
    private SysUserRoleService sysUserRoleService;

    /**
     * 用户页面
     *
     * @author Stranger。
     * @since 2021-02-12
     */
    @GetMapping("/list")
    public String list() {
        return "sys/user/list";
    }

    /**
     * 分页查询列表
     *
     * @param name     查询条件
     * @param deptId   部门id
     * @param pageNo   第几页
     * @param pageSize 每页几条
     * @return
     * @author Stranger。
     * @since 2021-02-12
     */
    @ApiOperation(value = "分页查询用户列表", notes = "条件查询")
    @GetMapping("/pageList")
    @ResponseBody
    public ResultInfo<PageDataInfo> queryPageList(@RequestParam(name = "name", required = false) String name,
                                                  @RequestParam(name = "deptId", required = false) String deptId,
                                                  @RequestParam(name = "page", defaultValue = "1") Integer pageNo,
                                                  @RequestParam(name = "limit", defaultValue = "10") Integer pageSize) {
        QueryWrapper<UserDto> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("u.is_deleted", DeleteEnum.OK.getCode());
        if (StringUtils.isNotBlank(deptId) && !Constants.TOP_DEPT_ID.equals(deptId)) {
            queryWrapper.eq("u.dept_id", deptId);
        }
        if (StringUtils.isNotBlank(name)) {
            queryWrapper.and(qw -> qw.like("u.username", name).or().like("u.nickname", name)
                    .or().like("u.mobile", name)).or().like("u.email", name);
        }
        queryWrapper.orderByDesc("u.gmt_create");
        Page<UserDto> page = new Page<>(pageNo, pageSize);
        IPage<UserDto> pageList = sysUserService.selectUserPage(page, queryWrapper);
        return ResultInfo.success(new PageDataInfo<UserDto>(pageList.getRecords(), pageList.getTotal()));
    }

    /**
     * 添加页面
     *
     * @author Stranger。
     * @since 2021-02-12
     */
    @GetMapping("/add")
    public String add() {
        return "sys/user/add";
    }

    /**
     * 插入一条数据
     *
     * @param user
     * @return top.plgxs.common.api.ResultInfo<java.lang.Object>
     * @author Stranger。
     * @since 2021-02-12
     */
    @PostMapping("/insert")
    @ResponseBody
    public ResultInfo<Object> insert(@RequestBody UserDto user) {
        try {
            //TODO 密码加密
            sysUserService.insertUser(user);
            return ResultInfo.success();
        } catch (Exception e) {
            return ResultInfo.failed();
        }
    }

    /**
     * 编辑页面
     *
     * @author Stranger。
     * @since 2021-02-12
     */
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") String id) {
        SysUser sysUser = sysUserService.getById(id);
        UserDto userDto = Convert.convertUserToDto(sysUser);
        List<String> positionIds = sysUserService.selectPositionsByUserId(id);
        model.addAttribute("user", userDto);
        model.addAttribute("positionIds", positionIds);
        return "sys/user/edit";
    }

    /**
     * 更新一条数据
     *
     * @param userDto
     * @return top.plgxs.common.api.ResultInfo<java.lang.Object>
     * @author Stranger。
     * @since 2021-02-12
     */
    @PostMapping("/update")
    @ResponseBody
    public ResultInfo<Object> update(@RequestBody UserDto userDto) {
        try {
            //TODO 密码加密
            sysUserService.updateUser(userDto);
            return ResultInfo.success();
        } catch (Exception e) {
            return ResultInfo.failed();
        }
    }

    /**
     * 逻辑删除一条数据
     *
     * @param id 主键
     * @return top.plgxs.common.api.ResultInfo<java.lang.Object>
     * @author Stranger。
     * @since 2021-02-12
     */
    @GetMapping("/delete/{id}")
    @ResponseBody
    public ResultInfo<Object> delete(@PathVariable("id") String id) {
        try {
            sysUserService.deleteUser(id);
            return ResultInfo.success("删除成功", null);
        } catch (Exception e) {
            return ResultInfo.failed("删除失败");
        }
    }

    /**
     * 批量删除
     *
     * @param ids id数组
     * @author Stranger。
     * @since 2021-02-12
     */
    @PostMapping("/batchDelete")
    @ResponseBody
    public ResultInfo<Object> batchDelete(@RequestBody List<String> ids) {
        try {
            sysUserService.deleteBatchUser(ids);
            return ResultInfo.success("删除成功", null);
        } catch (Exception e) {
            return ResultInfo.failed("删除失败");
        }
    }

    /**
     * 切换状态
     *
     * @param id     主键
     * @param status 状态
     * @author Stranger。
     * @since 2021-02-12
     */
    @PostMapping("/switchStatus")
    @ResponseBody
    public ResultInfo<String> switchStatus(@RequestParam(name = "id") String id, @RequestParam(name = "status") String status) {
        SysUser sysUser = new SysUser();
        sysUser.setId(id);
        sysUser.setStatus(status);
        boolean result = sysUserService.updateById(sysUser);
        if (result) {
            return ResultInfo.success("切换成功", null);
        } else {
            return ResultInfo.failed("切换失败");
        }
    }

    /**
     * 校验用户名是否唯一
     *
     * @param username
     * @param id
     * @return top.plgxs.common.api.ResultInfo<java.lang.String>
     * @author Stranger。
     * @since 2021/2/13
     */
    @GetMapping("/verifyUserName")
    @ResponseBody
    public ResultInfo<String> verifyUserName(@RequestParam("username") String username,
                                             @RequestParam(name = "id", required = false) String id) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        if (StrUtil.isNotBlank(id)) {
            queryWrapper.ne("id", id);
        }
        List<SysUser> list = sysUserService.list(queryWrapper);
        if (list != null && list.size() > 0) {
            return ResultInfo.success("用户名已存在", null);
        }
        return ResultInfo.failed();
    }

    /**
     * 重置密码
     *
     * @param id
     * @return top.plgxs.common.api.ResultInfo<java.lang.String>
     * @author Stranger。
     * @since 2021/2/13
     */
    @GetMapping("/reset/{id}")
    @ResponseBody
    public ResultInfo<String> reset(@PathVariable("id") String id) {
        SysUser user = new SysUser();
        user.setId(id);
        user.setPassword(sysUserService.encryptPassword(user.getUsername(), Constants.PASSWORD_INITIAL, user.getSalt()));
        user.setGmtModified(LocalDateTime.now());
        boolean result = sysUserService.updateById(user);
        if (result) {
            return ResultInfo.success();
        } else {
            return ResultInfo.failed();
        }
    }

    /**
     * 跳转分配角色界面
     *
     * @param userId
     * @param model
     * @return java.lang.String
     * @author Stranger。
     * @since 2021/2/13
     */
    @GetMapping("/assignRole")
    public String assignRole(@RequestParam("userId") String userId, Model model) {
        model.addAttribute("userId", userId);
        return "sys/user/assignRole";
    }

    /**
     * 保存用户角色关系
     *
     * @param userRole
     * @return top.plgxs.common.api.ResultInfo<java.lang.String>
     * @author Stranger。
     * @since 2021/2/19
     */
    @PostMapping("/saveUserRole")
    @ResponseBody
    public ResultInfo<String> saveUserRole(@RequestBody SysUserRole userRole) {
        if (userRole == null || StrUtil.isBlank(userRole.getUserId()) || StrUtil.isBlank(userRole.getRoleId())) {
            return ResultInfo.validateFailed();
        }
        sysUserRoleService.saveUserRole(userRole);
        return ResultInfo.success();
    }
}
