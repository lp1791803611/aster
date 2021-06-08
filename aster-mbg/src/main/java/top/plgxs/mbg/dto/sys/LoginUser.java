package top.plgxs.mbg.dto.sys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>用户登录信息</p>
 *
 * @author Stranger。
 * @version 1.0
 * @since 2021/3/8 0008 15:34
 */
@ApiModel(value="用户登录信息")
@Data
public class LoginUser {
    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "记住我")
    private Boolean rememberMe;

    public LoginUser(){
        super();
    }

    public LoginUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
