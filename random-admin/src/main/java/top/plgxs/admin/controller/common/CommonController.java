package top.plgxs.admin.controller.common;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.plgxs.common.redis.util.RedisUtils;

import javax.annotation.Resource;

/**
 * <p>通用请求处理</p>
 * @author Stranger。
 * @version 1.0
 * @since 2021/2/6 20:17
 */
@RequestMapping("/common")
@RestController
public class CommonController {
    @Resource
    private RedisUtils redisUtils;

    @GetMapping("/set")
    public void setKey(String key, String value){
        redisUtils.set(key, value);
    }

    @GetMapping("/get")
    public Object getKey(String key){
        return redisUtils.get(key);
    }

}
