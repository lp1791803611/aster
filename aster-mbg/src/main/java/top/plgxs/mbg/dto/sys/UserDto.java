package top.plgxs.mbg.dto.sys;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * User信息
 * @author Stranger。
 * @version 1.0
 * @since 2021/2/12 20:39
 */
@Data
public class UserDto {
    /* 基础信息 */
    private String id;
    private String username;
    private String password;
    private String nickname;
    private String mobile;
    private String email;
    private String gender;
    private String headUrl;
    private String status;
    private LocalDateTime gmtCreate;
    /* 身份证信息 */
    private String realname;
    private String idNumber;
    /* 部门信息 */
    private String deptId;
    private String deptName;
    /* 职位信息 */
    private String positionId;
    private String positionName;

    private String oldPassword;
}
