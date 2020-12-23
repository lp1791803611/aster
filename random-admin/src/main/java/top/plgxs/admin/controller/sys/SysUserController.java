package top.plgxs.admin.controller.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import top.plgxs.admin.service.sys.SysUserService;
import top.plgxs.common.api.ResultInfo;
import top.plgxs.mbg.entity.sys.SysUser;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author Stranger
 * @since 2020-12-23
 * @version 1.0
 */
@Controller
@RequestMapping("/sysUser")
public class SysUserController {
    @Resource
    private SysUserService sysUserService;

    /**
     * 分页查询列表
     * @param query 查询条件
     * @param pageNo 第几页
     * @param pageSize 每页几条
     * @return
     * @author Stranger
     * @since 2020-12-23
     */
    @GetMapping("/list")
    @ResponseBody
    public ResultInfo<IPage<SysUser>> queryPageList(@RequestParam("query") String query, @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                    @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize){
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(query)){
            queryWrapper.like("username",query).or().like("nickname",query)
                    .or().like("realname",query);
        }
        Page<SysUser> page = new Page<>(pageNo, pageSize);
        IPage<SysUser> pageList = sysUserService.page(page, queryWrapper);
        return ResultInfo.success(pageList);
    }

    /**
     * 插入一条数据
     * @param sysUser
     * @return top.plgxs.common.api.ResultInfo<java.lang.Object>
     * @author Stranger
     * @since 2020-12-23
     */
    @PostMapping("/insert")
    @ResponseBody
    public ResultInfo<Object> insert(@RequestBody SysUser sysUser){
        boolean result = sysUserService.save(sysUser);
        if(result){
            return ResultInfo.success();
        }else{
            return ResultInfo.failed();
        }
    }

    /**
     * 更新一条数据
     * @param sysUser
     * @return top.plgxs.common.api.ResultInfo<java.lang.Object>
     * @author Stranger
     * @since 2020-12-23
     */
    @PostMapping("/update")
    @ResponseBody
    public ResultInfo<Object> update(@RequestBody SysUser sysUser){
        if(sysUser == null || StringUtils.isBlank(sysUser.getId())){
            return ResultInfo.validateFailed();
        }
        boolean result = sysUserService.updateById(sysUser);
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
     * @author Stranger
     * @since 2020-12-23
     */
    @GetMapping("/delete/{id}")
    @ResponseBody
    public ResultInfo<Object> delete(@PathVariable("id") String id){
        if(StringUtils.isBlank(id)){
            return ResultInfo.validateFailed();
        }
        boolean result = sysUserService.removeById(id);
        if(result){
            return ResultInfo.success();
        }else{
            return ResultInfo.failed();
        }
    }
}
