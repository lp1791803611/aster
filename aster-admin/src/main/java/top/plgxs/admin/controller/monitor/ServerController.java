package top.plgxs.admin.controller.monitor;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.plgxs.common.core.api.ResultInfo;
import top.plgxs.common.core.api.server.Disk;
import top.plgxs.common.core.util.ArithUtils;
import top.plgxs.common.core.util.ServerUtils;

import java.util.List;

/**
 * @author Stranger。
 * @version 1.0
 * @since 2021/7/6 16:03
 */
@Controller
@RequestMapping("/server")
public class ServerController {

    /**
     * 跳转页面
     *
     * @return java.lang.String
     * @author Stranger。
     * @since 2021/7/6
     */
    @GetMapping("/list")
    public String list(ModelMap mmap) {
        mmap.put("cpu", ServerUtils.getCpuInfo());
        mmap.put("mem", ServerUtils.getMemInfo());
        mmap.put("jvm", ServerUtils.getJvmInfo());
        mmap.put("sys", ServerUtils.getSysInfo());
        List<Disk> list = ServerUtils.getDiskInfo();
        mmap.put("disk", list);
        double usage = 0;
        if (CollUtil.isNotEmpty(list)) {
            for (Disk disk : list) {
                usage += disk.getUsage();
            }
            usage = ArithUtils.div(usage, list.size(), 2);
        }
        mmap.put("diskUsage", usage);
        return "monitor/server/list";
    }

    /**
     * 服务相关数据
     * @return top.plgxs.common.core.api.ResultInfo<com.alibaba.fastjson.JSONObject>
     * @author Stranger。
     * @since 2021/7/7
     */
    @GetMapping("/data")
    @ResponseBody
    public ResultInfo<JSONObject> data(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cpu", ServerUtils.getCpuInfo());
        jsonObject.put("mem", ServerUtils.getMemInfo());
        jsonObject.put("jvm", ServerUtils.getJvmInfo());
        jsonObject.put("sys", ServerUtils.getSysInfo());
        List<Disk> list = ServerUtils.getDiskInfo();
        double usage = 0;
        if (CollUtil.isNotEmpty(list)) {
            for (Disk disk : list) {
                usage += disk.getUsage();
            }
            usage = ArithUtils.div(usage, list.size(), 2);
        }
        jsonObject.put("diskUsage", usage);
        return ResultInfo.success(jsonObject);
    }
}
