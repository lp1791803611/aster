package top.plgxs.admin.controller.common;

import org.springframework.web.bind.annotation.RestController;
import top.plgxs.common.redis.util.RedisUtils;

import javax.annotation.Resource;

/**
 * <p>通用请求处理</p>
 * @author Stranger。
 * @version 1.0
 * @since 2021/2/6 20:17
 */
@RestController
public class CommonController {
    @Resource
    private RedisUtils redisUtils;


}
