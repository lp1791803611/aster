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
    private String id;
    private String username;
    private String nickname;
    private String mobile;
    private String email;
    private LocalDateTime gmtCreate;
    private String deptId;
    private String deptName;
}
