package top.plgxs.admin.controller.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import top.plgxs.common.core.api.ResultInfo;
import top.plgxs.common.core.api.UploadFileInfo;
import top.plgxs.common.core.config.ServerConfig;
import top.plgxs.common.core.util.FileUtils;

import javax.annotation.Resource;

/**
 * <p>通用请求处理</p>
 *
 * @author Stranger。
 * @version 1.0
 * @since 2021/2/6 20:17
 */
@Controller
public class CommonController {
    @Resource
    private ServerConfig serverConfig;
    @Value("${aster.profile}")
    private String uploadPath;
    @Value("${spring.servlet.multipart.max-file-size}")
    private String maxFileSize;

    @RequestMapping("/common/upload")
    @ResponseBody
    public ResultInfo<UploadFileInfo> uploadFile(@RequestParam("uploadFile") MultipartFile file) throws Exception {
        long maxSize = FileUtils.getFileSize(maxFileSize);
        // 上传并返回新文件名称
        String fileName = FileUtils.uploadFile(uploadPath, file, maxSize);
        String url = serverConfig.getUrl() + fileName;
        UploadFileInfo fileInfo = new UploadFileInfo();
        fileInfo.setUrl(url);
        return ResultInfo.success(fileInfo);
    }

}
