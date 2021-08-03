package top.plgxs.mbg.dto.sys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.plgxs.common.core.constants.enums.OnlineStatus;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 在线用户
 *
 * @author Stranger。
 * @version 1.0
 * @since 2021/7/5 19:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OnlineUserDto implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户会话id
     */
    private String sessionId;

    /**
     * 登录名称
     */
    private String username;

    /**
     * 登录IP地址
     */
    private String ipaddr;

    /**
     * 登录地址
     */
    private String loginLocation;

    /**
     * 浏览器类型
     */
    private String browser;

    /**
     * 操作系统
     */
    private String os;

    /**
     * session创建时间
     */
    private LocalDateTime startTimestamp;

    /**
     * session最后访问时间
     */
    private LocalDateTime lastAccessTime;

    /**
     * 超时时间，单位为分钟
     */
    private Long expireTime;

    /**
     * 在线状态
     */
    private OnlineStatus status = OnlineStatus.on_line;
}
