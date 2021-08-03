package top.plgxs.common.core.api.server;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * JVM相关信息
 *
 * @author Stranger。
 * @version 1.0
 * @since 2021/7/6 17:10
 */
@Data
public class Jvm implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 当前JVM占用的内存总数(M)
     */
    private double total;

    /**
     * JVM最大可用内存总数(M)
     */
    private double max;

    /**
     * JVM空闲内存(M)
     */
    private double free;

    /**
     * JVM已使用内存(M)
     */
    private double used;

    /**
     * JVM使用率
     */
    private double usage;

    /**
     * JDK名称
     */
    private String name;

    /**
     * JDK版本
     */
    private String version;

    /**
     * JDK路径
     */
    private String home;

    /**
     * JDK启动时间
     */
    private Date startTime;

    /**
     * JDK运行时间
     */
    private String runTime;

}
