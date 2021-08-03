package top.plgxs.common.core.util;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.web.multipart.MultipartFile;
import top.plgxs.common.core.constants.Constants;
import top.plgxs.common.core.exception.BusinessException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件工具类
 *
 * @author Stranger。
 * @version 1.0
 * @since 2021/7/19 14:32
 */
public class FileUtils {
    /**
     * 默认的文件名最大长度 100
     */
    public static final int MAX_FILENAME_LENGTH = 100;

    /**
     * 默认的文件大小 20M
     */
    public static final long MAX_FILE_SIZE = 20 * 1024 * 1024;

    /**
     * 将MultipartFile转为file
     *
     * @param multipartFile
     * @author Stranger。
     * @since 2021/3/17 0017
     */
    public static File multipartFileToFile(MultipartFile multipartFile) {
        File file = null;
        InputStream ins = null;
        try {
            ins = multipartFile.getInputStream();
            String originalFilename = multipartFile.getOriginalFilename();
            if (StrUtil.isBlank(originalFilename)) {
                originalFilename = DateUtil.now();
            }
            file = new File(originalFilename);
            inputStreamToFile(ins, file);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ins != null) {
                    ins.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    /**
     * inputstream to file
     *
     * @param ins  输入流
     * @param file 文件
     * @author Stranger。
     * @since 2021/3/17 0017
     */
    public static void inputStreamToFile(InputStream ins, File file) {
        OutputStream os = null;
        try {
            os = new FileOutputStream(file);
            int bytesRead;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
                if (ins != null) {
                    ins.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取某个目录下所有直接下级文件，不包括目录下的子目录的下的文件，所以不用递归获取
     *
     * @param path 目录路径
     * @return java.util.List<java.lang.String>
     * @author Stranger。
     * @since 2021/5/24
     */
    public static List<String> getFiles(String path) {
        List<String> files = new ArrayList<>();
        File file = new File(path);
        File[] tempList = file.listFiles();
        if (tempList == null || tempList.length == 0) {
            return files;
        }
        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
                files.add(tempList[i].toString());
                //文件名，不包含路径
                //String fileName = tempList[i].getName();
            }
            if (tempList[i].isDirectory()) {
                //这里就不递归了，
            }
        }
        return files;
    }

    /**
     * 将文件移动到文件夹中
     *
     * @param startPath 文件绝对路径
     * @param endPath   目标文件夹绝对路径
     * @author Stranger。
     * @since 2021/5/24
     */
    public static void moveToOtherFolders(String startPath, String endPath) {
        try {
            File startFile = new File(startPath);
            File tmpFile = new File(endPath);   // 获取文件夹路径
            if (!tmpFile.exists()) {              //判断文件夹是否创建，没有创建则创建新文件夹
                tmpFile.mkdirs();
            }
            if (startFile.renameTo(new File(endPath + startFile.getName()))) {
                System.out.println("------ File is moved successful! ------");
            } else {
                System.out.println("------ File is failed to move! ------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 下载文件到浏览器
     *
     * @param request
     * @param response
     * @param filename 要下载的文件名
     * @param file     需要下载的文件对象
     * @throws IOException
     */
    public static void downFile(HttpServletRequest request, HttpServletResponse response, String filename, File file) throws IOException {
        //  文件存在才下载
        if (file.exists()) {
            OutputStream out = null;
            FileInputStream in = null;
            try {
                // 1.读取要下载的内容
                in = new FileInputStream(file);

                // 2. 告诉浏览器下载的方式以及一些设置
                // 解决文件名乱码问题，获取浏览器类型，转换对应文件名编码格式，IE要求文件名必须是utf-8, firefo要求是iso-8859-1编码
                String agent = request.getHeader("user-agent");
                if (agent.contains("FireFox")) {
                    filename = new String(filename.getBytes("UTF-8"), "iso-8859-1");
                } else {
                    filename = URLEncoder.encode(filename, "UTF-8");
                }
                // 设置下载文件的mineType，告诉浏览器下载文件类型
                String mineType = request.getServletContext().getMimeType(filename);
                response.setContentType(mineType);
                // 设置一个响应头，无论是否被浏览器解析，都下载
                response.setHeader("Content-disposition", "attachment; filename=" + filename);
                // 将要下载的文件内容通过输出流写到浏览器
                out = response.getOutputStream();
                int len = 0;
                byte[] buffer = new byte[1024];
                while ((len = in.read(buffer)) > 0) {
                    out.write(buffer, 0, len);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            }
        }
    }

    /**
     * 上传文件
     *
     * @param basePath 上传文件在服务器上的目录
     * @param file     待上传的文件
     * @param maxSize  单文件最大上传大小
     * @return java.lang.String 返回上传成功的文件名
     * @author Stranger。
     * @since 2021/7/19
     */
    public static String uploadFile(String basePath, MultipartFile file, long maxSize) {
        // 文件名长度校验
        String fileName = file.getOriginalFilename();
        verifyFilename(fileName);
        // 文件大小校验
        verifyFileSize(file.getSize(), maxSize);
        // 文件类型校验
        String extension = FileUtil.extName(fileName);
        verifyFileType(extension);
        // 文件存放路径: basepath/2021-07-18/xxxxxx.doc
        fileName = DateUtil.today() + "/" + IdUtil.fastSimpleUUID() + "." + extension;

        File desc = new File(basePath + Constants.RESOURCE_UPLOAD + File.separator + fileName);
        if (!desc.exists()) {
            if (!desc.getParentFile().exists()) {
                desc.getParentFile().mkdirs();
            }
        }
        try {
            file.transferTo(desc);
        } catch (IOException e) {
            e.printStackTrace();
            throw new BusinessException("文件上传失败");
        }
        return Constants.RESOURCE_PREFIX + Constants.RESOURCE_UPLOAD + "/" + fileName;
    }

    /**
     * 校验文件名长度
     *
     * @param fileName 文件名
     * @return void
     * @author Stranger。
     * @since 2021/7/19
     */
    private static void verifyFilename(String fileName) {
        // 文件名校验
        int fileNamelength = fileName.length();
        if (fileNamelength > FileUtils.MAX_FILENAME_LENGTH) {
            throw new BusinessException("待上传文件的文件名超过设定长度" + FileUtils.MAX_FILENAME_LENGTH);
        }
    }

    /**
     * 校验文件大小
     *
     * @param fileSize 文件大小
     * @param maxSize  最大文件大小
     * @return void
     * @author Stranger。
     * @since 2021/7/19
     */
    private static void verifyFileSize(long fileSize, long maxSize) {
        maxSize = maxSize > 0L ? maxSize : FileUtils.MAX_FILE_SIZE;
        if (fileSize > maxSize) {
            throw new BusinessException("待上传文件的大小超过设定大小" + maxSize / 1024 / 1024 + "M");
        }
    }

    /**
     * 校验文件类型
     *
     * @param fileType 文件类型
     * @return void
     * @author Stranger。
     * @since 2021/7/19
     */
    private static void verifyFileType(String fileType) {
        boolean flag = false;
        String[] mimeTypes = Constants.DEFAULT_UPLOAD_EXTENSION;
        for (String mimeType : mimeTypes) {
            if (mimeType.equalsIgnoreCase(fileType)) {
                flag = true;
            }
        }
        if (!flag) {
            throw new BusinessException("待上传文件的类型不符合默认设定的类型");
        }
    }

    /**
     * 转换文件大小
     *
     * @param maxFileSize 100TB,100GB,100MB,100KB,100B
     * @return long
     * @author Stranger。
     * @since 2021/7/19
     */
    public static long getFileSize(String maxFileSize) {
        if (StrUtil.isBlank(maxFileSize)) {
            return 0L;
        }
        try {
            if (StrUtil.indexOfIgnoreCase(maxFileSize, "TB") > -1) {
                return Long.parseLong(StrUtil.removeSuffixIgnoreCase(maxFileSize, "TB")) * 1024 * 1024 * 1024 * 1024;
            }
            if (StrUtil.indexOfIgnoreCase(maxFileSize, "GB") > -1) {
                return Long.parseLong(StrUtil.removeSuffixIgnoreCase(maxFileSize, "GB")) * 1024 * 1024 * 1024;
            }
            if (StrUtil.indexOfIgnoreCase(maxFileSize, "MB") > -1) {
                return Long.parseLong(StrUtil.removeSuffixIgnoreCase(maxFileSize, "MB")) * 1024 * 1024;
            }
            if (StrUtil.indexOfIgnoreCase(maxFileSize, "KB") > -1) {
                return Long.parseLong(StrUtil.removeSuffixIgnoreCase(maxFileSize, "KB")) * 1024;
            }
            if (StrUtil.indexOfIgnoreCase(maxFileSize, "B") > -1) {
                return Long.parseLong(StrUtil.removeSuffixIgnoreCase(maxFileSize, "B"));
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return 0L;
    }
}
