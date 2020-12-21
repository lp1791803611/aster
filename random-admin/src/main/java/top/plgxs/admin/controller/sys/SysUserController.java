package top.plgxs.admin.controller.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import top.plgxs.admin.service.sys.SysUserService;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Stranger
 * @since 2020-12-21
 */
@Controller
@RequestMapping("/sys-user")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

}
