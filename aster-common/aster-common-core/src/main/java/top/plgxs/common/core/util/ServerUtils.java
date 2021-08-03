package top.plgxs.common.core.util;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.VirtualMemory;
import oshi.software.os.FileSystem;
import oshi.software.os.OSFileStore;
import oshi.software.os.OperatingSystem;
import oshi.util.Util;
import top.plgxs.common.core.api.server.*;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * 服务器相关信息
 *
 * @author Stranger。
 * @version 1.0
 * @since 2021/7/6 16:42
 */
public class ServerUtils {

    /**
     * 获取服务器相关信息
     *
     * @return top.plgxs.common.core.api.server.SysInfo
     * @author Stranger。
     * @since 2021/7/6
     */
    public static Sys getSysInfo() {
        Sys sys = new Sys();
        Properties props = System.getProperties();
        sys.setComputerName(AddressUtils.getHostName());
        sys.setComputerIp(AddressUtils.getHostIp());
        sys.setOsName(props.getProperty("os.name"));
        sys.setOsArch(props.getProperty("os.arch"));
        sys.setUserDir(props.getProperty("user.dir"));
        return sys;
    }

    /**
     * 获取JVM相关信息
     *
     * @return top.plgxs.common.core.api.server.Jvm
     * @author Stranger。
     * @since 2021/7/6
     */
    public static Jvm getJvmInfo() {
        Jvm jvm = new Jvm();
        Properties props = System.getProperties();
        long total = Runtime.getRuntime().totalMemory();
        long max = Runtime.getRuntime().maxMemory();
        long free = Runtime.getRuntime().freeMemory();
        jvm.setName(ManagementFactory.getRuntimeMXBean().getVmName());
        jvm.setTotal(ArithUtils.div(total, (1024 * 1024), 2));
        jvm.setMax(ArithUtils.div(max, (1024 * 1024), 2));
        jvm.setFree(ArithUtils.div(free, (1024 * 1024), 2));
        jvm.setUsed(ArithUtils.div((total - free), (1024 * 1024), 2));
        jvm.setUsage(ArithUtils.mul(ArithUtils.div(total - free, total, 4), 100));
        jvm.setVersion(props.getProperty("java.version"));
        jvm.setHome(props.getProperty("java.home"));
        jvm.setStartTime(new Date(ManagementFactory.getRuntimeMXBean().getStartTime()));
        jvm.setRunTime(TimeUtil.getDatePoor(new Date(), jvm.getStartTime()));
        return jvm;
    }

    /**
     * 获取CPU相关信息
     *
     * @return top.plgxs.common.core.api.server.Cpu
     * @author Stranger。
     * @since 2021/7/6
     */
    public static Cpu getCpuInfo() {
        Cpu cpu = new Cpu();
        SystemInfo si = new SystemInfo();
        // 获取硬件信息
        HardwareAbstractionLayer hal = si.getHardware();
        // 获取处理器信息
        CentralProcessor processor = hal.getProcessor();
        long[] prevTicks = processor.getSystemCpuLoadTicks();
        // 等待1秒...
        Util.sleep(1000);
        long[] ticks = processor.getSystemCpuLoadTicks();
        long nice = ticks[CentralProcessor.TickType.NICE.getIndex()] - prevTicks[CentralProcessor.TickType.NICE.getIndex()];
        long irq = ticks[CentralProcessor.TickType.IRQ.getIndex()] - prevTicks[CentralProcessor.TickType.IRQ.getIndex()];
        long softirq = ticks[CentralProcessor.TickType.SOFTIRQ.getIndex()] - prevTicks[CentralProcessor.TickType.SOFTIRQ.getIndex()];
        long steal = ticks[CentralProcessor.TickType.STEAL.getIndex()] - prevTicks[CentralProcessor.TickType.STEAL.getIndex()];
        long cSys = ticks[CentralProcessor.TickType.SYSTEM.getIndex()] - prevTicks[CentralProcessor.TickType.SYSTEM.getIndex()];
        long user = ticks[CentralProcessor.TickType.USER.getIndex()] - prevTicks[CentralProcessor.TickType.USER.getIndex()];
        long iowait = ticks[CentralProcessor.TickType.IOWAIT.getIndex()] - prevTicks[CentralProcessor.TickType.IOWAIT.getIndex()];
        long idle = ticks[CentralProcessor.TickType.IDLE.getIndex()] - prevTicks[CentralProcessor.TickType.IDLE.getIndex()];
        long totalCpu = user + nice + cSys + idle + iowait + irq + softirq + steal;
        cpu.setName(processor.getProcessorIdentifier().getName());
        cpu.setCpuNum(processor.getLogicalProcessorCount());
        cpu.setTotal(ArithUtils.round(ArithUtils.mul(totalCpu, 100), 2));
        cpu.setSys(ArithUtils.round(ArithUtils.mul(cSys / totalCpu, 100), 2));
        cpu.setUsed(ArithUtils.round(ArithUtils.mul(user / totalCpu, 100), 2));
        cpu.setWait(ArithUtils.round(ArithUtils.mul(iowait / totalCpu, 100), 2));
        cpu.setFree(ArithUtils.round(ArithUtils.mul(idle / totalCpu, 100), 2));
        cpu.setUsage(ArithUtils.mul(ArithUtils.div((user + cSys), totalCpu, 4), 100));
        return cpu;
    }

    /**
     * 获取内存相关信息
     *
     * @return top.plgxs.common.core.api.server.Mem
     * @author Stranger。
     * @since 2021/7/6
     */
    public static Mem getMemInfo() {
        Mem mem = new Mem();
        SystemInfo si = new SystemInfo();
        // 获取硬件信息
        HardwareAbstractionLayer hal = si.getHardware();
        // 获取内存信息
        GlobalMemory memory = hal.getMemory();
        long total = memory.getTotal();
        long free = memory.getAvailable();
        long used = memory.getTotal() - memory.getAvailable();
        mem.setTotal(ArithUtils.div(total, (1024 * 1024 * 1024), 2));
        mem.setFree(ArithUtils.div(free, (1024 * 1024 * 1024), 2));
        mem.setUsed(ArithUtils.div(used, (1024 * 1024 * 1024), 2));
        mem.setUsage(ArithUtils.mul(ArithUtils.div(used, total, 4), 100));
        // 获取虚拟内存
        VirtualMemory virtualMemory = memory.getVirtualMemory();
        long swapTotal = virtualMemory.getSwapTotal();
        long swapUsed = virtualMemory.getSwapUsed();
        mem.setSwapTotal(ArithUtils.div(swapTotal, (1024 * 1024 * 1024), 2));
        mem.setSwapUsed(ArithUtils.div(swapUsed, (1024 * 1024 * 1024), 2));
        mem.setSwapFree(ArithUtils.div((swapTotal - swapUsed), (1024 * 1024 * 1024), 2));
        mem.setSwapUsage(ArithUtils.mul(ArithUtils.div(swapUsed, swapTotal, 4), 100));
        return mem;
    }

    /**
     * 获取磁盘信息
     *
     * @return java.util.List<top.plgxs.common.core.api.server.Disk>
     * @author Stranger。
     * @since 2021/7/6
     */
    public static List<Disk> getDiskInfo() {
        List<Disk> list = new ArrayList<>();
        SystemInfo si = new SystemInfo();
        OperatingSystem os = si.getOperatingSystem();
        FileSystem fileSystem = os.getFileSystem();
        List<OSFileStore> fsArray = fileSystem.getFileStores();
        for (OSFileStore fs : fsArray) {
            long free = fs.getUsableSpace();
            long total = fs.getTotalSpace();
            long used = total - free;
            Disk disk = new Disk();
            disk.setDirName(fs.getMount());
            disk.setSysTypeName(fs.getType());
            disk.setTypeName(fs.getName());
            disk.setTotal(convertFileSize(total));
            disk.setFree(convertFileSize(free));
            disk.setUsed(convertFileSize(used));
            disk.setUsage(ArithUtils.mul(ArithUtils.div(used, total, 4), 100));
            list.add(disk);
        }
        return list;
    }

    /**
     * 字节转换
     *
     * @param size 字节大小
     * @return 转换后值
     */
    public static String convertFileSize(long size) {
        long kb = 1024;
        long mb = kb * 1024;
        long gb = mb * 1024;
        if (size >= gb) {
            return String.format("%.1f GB", (float) size / gb);
        } else if (size >= mb) {
            float f = (float) size / mb;
            return String.format(f > 100 ? "%.0f MB" : "%.1f MB", f);
        } else if (size >= kb) {
            float f = (float) size / kb;
            return String.format(f > 100 ? "%.0f KB" : "%.1f KB", f);
        } else {
            return String.format("%d B", size);
        }
    }
}
