package top.plgxs.random.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Strangers。
 * @version 1.0.0
 * @date 21:58 2020/12/6
 */
@Controller
public class HomeController {
    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("msg","hello world");
        return "index";
    }
}
