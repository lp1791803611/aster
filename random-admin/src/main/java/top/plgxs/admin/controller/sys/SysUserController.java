package top.plgxs.admin.controller.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.plgxs.admin.service.sys.SysUserService;
import top.plgxs.common.api.ResultInfo;
import top.plgxs.common.constants.Constants;
import top.plgxs.common.page.PageDataInfo;
import top.plgxs.mbg.dto.sys.UserDto;
import top.plgxs.mbg.entity.sys.SysUser;

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
@Controller
@RequestMapping("/sysUser")
public class SysUserController {
    @Resource
    private SysUserService sysUserService;

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
    @GetMapping("/pageList")
    @ResponseBody
    public ResultInfo<PageDataInfo> queryPageList(@RequestParam(name = "name", required = false) String name,
                                                  @RequestParam(name = "deptId", required = false) String deptId,
                                                  @RequestParam(name = "page", defaultValue = "1") Integer pageNo,
                                                  @RequestParam(name = "limit", defaultValue = "10") Integer pageSize) {
        QueryWrapper<UserDto> queryWrapper = new QueryWrapper<>();
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
     * @param sysUser
     * @return top.plgxs.common.api.ResultInfo<java.lang.Object>
     * @author Stranger。
     * @since 2021-02-12
     */
    @PostMapping("/insert")
    @ResponseBody
    public ResultInfo<Object> insert(@RequestBody SysUser sysUser) {
        sysUser.setGmtCreate(LocalDateTime.now());
        boolean result = sysUserService.save(sysUser);
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
     * @since 2021-02-12
     */
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") String id) {
        SysUser sysUser = sysUserService.getById(id);
        model.addAttribute("sysUser", sysUser);
        return "sys/user/edit";
    }

    /**
     * 更新一条数据
     *
     * @param sysUser
     * @return top.plgxs.common.api.ResultInfo<java.lang.Object>
     * @author Stranger。
     * @since 2021-02-12
     */
    @PostMapping("/update")
    @ResponseBody
    public ResultInfo<Object> update(@RequestBody SysUser sysUser) {
        if (sysUser == null || StringUtils.isBlank(sysUser.getId())) {
            return ResultInfo.validateFailed();
        }
        boolean result = sysUserService.updateById(sysUser);
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
     * @since 2021-02-12
     */
    @GetMapping("/delete/{id}")
    @ResponseBody
    public ResultInfo<Object> delete(@PathVariable("id") String id) {
        if (StringUtils.isBlank(id)) {
            return ResultInfo.validateFailed();
        }
        boolean result = sysUserService.removeById(id);
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
     * @since 2021-02-12
     */
    @PostMapping("/batchDelete")
    @ResponseBody
    public ResultInfo<Object> batchDelete(@RequestBody List<String> ids) {
        boolean result = sysUserService.removeByIds(ids);
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
}
