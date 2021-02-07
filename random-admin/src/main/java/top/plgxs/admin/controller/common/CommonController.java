package top.plgxs.admin.controller.common;

import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * <p>通用请求处理</p>
 * @author Stranger。
 * @version 1.0
 * @since 2021/2/6 20:17
 */
@RequestMapping("/common")
@Controller
public class CommonController {

    /**
     * 通用的树列表选择器
     * @param treeUrl ztrr请求json的url
     * @param model
     * @return java.lang.String
     * @author Stranger。
     * @since 2021/2/6
     */
    @GetMapping("/commonTree")
    public String commonTree(@RequestParam("treeUrl") String treeUrl, Model model) {
        if (StrUtil.isBlank(treeUrl)) {
//            throw new RequestEmptyException("请求数据不完整！");
        }
        try {
            model.addAttribute("treeUrl", URLDecoder.decode(treeUrl, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
//            throw new RequestEmptyException("请求数据不完整！");
        }
        return "common/ztree";
    }
}
