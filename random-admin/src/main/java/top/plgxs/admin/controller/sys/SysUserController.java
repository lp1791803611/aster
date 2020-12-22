package top.plgxs.admin.controller.sys;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.plgxs.admin.service.sys.SysUserService;
import org.springframework.stereotype.Controller;
import top.plgxs.mbg.entity.sys.SysUser;

import javax.annotation.Resource;
import java.util.List;
/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @Author Stranger
 * @Date 2020-12-22
 * @Version 1.0
 */
@Controller
@RequestMapping("/sysUser")
public class SysUserController {
    @Resource
    private SysUserService sysUserService;

    @GetMapping(value = "/list")
    @ResponseBody
    public List<SysUser> getSysUserList(){
        return sysUserService.getSysUserList();
    }
}
