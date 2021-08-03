package top.plgxs.admin.controller.monitor;

import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import top.plgxs.common.core.util.StringUtils;

/**
 * @author Stranger。
 * @version 1.0
 * @since 2021/7/26 14:33
 */
@Api(tags = "druid监控")
@Controller
@RequestMapping("/data")
public class DruidController {

    @RequiresPermissions("monitor:data:view")
    @GetMapping("/list")
    public String index() {
        String url = "/druid/index.html";
        return StringUtils.format("redirect:{}", url);
    }
}
