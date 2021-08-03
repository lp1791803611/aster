package top.plgxs.common.core.api.server;

import lombok.Data;

import java.io.Serializable;

/**
 * 系统相关信息
 *
 * @author Stranger。
 * @version 1.0
 * @since 2021/7/6 16:44
 */
@Data
public class Sys implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 服务器名称
     */
    private String computerName;

    /**
     * 服务器Ip
     */
    private String computerIp;

    /**
     * 项目路径
     */
    private String userDir;

    /**
     * 操作系统
     */
    private String osName;

    /**
     * 系统架构
     */
    private String osArch;
}
