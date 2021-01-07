package top.plgxs.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.plgxs.mbg.entity.sys.SysUser;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>登录</p>
 *
 * @author Stranger。
 * @version 1.0
 * @since 2021/1/7 0007 15:44
 */
@Controller
public class LoginController {

    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("key","Hello World!");
        model.addAttribute("content","my name is <b>maliming</b>");

        List<SysUser> list = new ArrayList<>();
        SysUser user = new SysUser();
        user.setUsername("Stranger");
        user.setMobile("17623567587");
        list.add(user);

        SysUser user2 = new SysUser();
        user2.setUsername("Stranger2");
        user2.setMobile("17723567587");
        list.add(user2);

        model.addAttribute("user",user);
        model.addAttribute("list",list);

        String[] arrays = new String[]{"a","b","c"};
        model.addAttribute("arrays",arrays);
        return "index";
    }
}
