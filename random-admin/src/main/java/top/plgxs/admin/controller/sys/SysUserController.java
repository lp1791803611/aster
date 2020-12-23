package top.plgxs.admin.controller.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.plgxs.admin.service.sys.SysUserService;
import top.plgxs.common.api.ResultInfo;
import top.plgxs.mbg.entity.sys.SysUser;

import javax.annotation.Resource;
/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author Stranger
 * @since 2020-12-22
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
     * @author Stranger。
     * @date 2020/12/23 16:41
     */
    @GetMapping(value = "/list")
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
}
