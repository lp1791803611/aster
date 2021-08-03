package top.plgxs.mbg.dto.export;

import cn.hutool.core.util.StrUtil;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author Stranger。
 * @version 1.0
 * @since 2021/7/23 14:06
 */
@Data
public class UserExport {
    @ExcelProperty(value = "编号", index = 0)
    private Integer id;
    @ExcelProperty(value = "用户名", index = 1)
    private String username;
    @ExcelProperty(value = "部门", index = 2)
    private String deptName;
    @ExcelProperty(value = "昵称", index = 3)
    private String nickname;
    @ExcelProperty(value = "手机", index = 4)
    private String mobile;
    @ExcelProperty(value = "邮箱", index = 5)
    private String email;
    @ExcelProperty(value = "性别", index = 6)
    private String gender;
    @ExcelProperty(value = "姓名", index = 7)
    private String realname;
    @ExcelProperty(value = "身份证号", index = 8)
    private String idNumber;
    @ExcelProperty(value = "状态", index = 9)
    private String status;
    @ExcelProperty(value = "创建时间", index = 10)
    private Date gmtCreate;

    public String getGender() {
        if (StrUtil.isNotBlank(gender)) {
            if ("M".equals(gender)) {
                return "男";
            } else if ("F".equals(gender)) {
                return "女";
            }
        }
        return "";
    }
}
