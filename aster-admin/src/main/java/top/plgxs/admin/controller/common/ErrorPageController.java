package top.plgxs.admin.controller.common;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 错误页（404）处理
 * @author Stranger。
 * @version 1.0
 * @since 2021/3/15 21:53
 */
@Controller
public class ErrorPageController implements ErrorController {
    private static final String ERROR_PATH = "/error";

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    @RequestMapping(ERROR_PATH)
    public String error(){
        return "error/404";
    }
}
