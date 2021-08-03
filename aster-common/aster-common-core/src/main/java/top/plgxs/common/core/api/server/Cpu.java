package top.plgxs.common.core.api.server;

import lombok.Data;

import java.io.Serializable;

/**
 * CPU相关信息
 * @author Stranger。
 * @version 1.0
 * @since 2021/7/6 17:14
 */
@Data
public class Cpu implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    /**
     * 核心数
     */
    private int cpuNum;

    /**
     * CPU总的使用率
     */
    private double total;

    /**
     * CPU系统使用率
     */
    private double sys;

    /**
     * CPU用户使用率
     */
    private double used;

    /**
     * CPU当前等待率
     */
    private double wait;

    /**
     * CPU当前空闲率
     */
    private double free;

    /**
     * 资源的使用率
     */
    private double usage;
}
