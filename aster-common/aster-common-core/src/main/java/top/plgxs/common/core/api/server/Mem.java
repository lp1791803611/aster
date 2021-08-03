package top.plgxs.common.core.api.server;

import lombok.Data;

import java.io.Serializable;

/**
 * 内存相关信息
 * @author Stranger。
 * @version 1.0
 * @since 2021/7/6 17:28
 */
@Data
public class Mem implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 内存总量
     */
    private double total;

    /**
     * 已用内存
     */
    private double used;

    /**
     * 剩余内存
     */
    private double free;

    /**
     * 资源的使用率
     */
    private double usage;

    /**
     * 交换区总量
     */
    private double swapTotal;

    /**
     * 交换区已使用量
     */
    private double swapUsed;

    /**
     * 交换区未使用量
     */
    private double swapFree;

    /**
     * 资源的使用率
     */
    private double swapUsage;
}
