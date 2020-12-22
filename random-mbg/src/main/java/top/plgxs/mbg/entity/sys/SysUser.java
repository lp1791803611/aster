package top.plgxs.mbg.entity.sys;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户
 * </p>
 *
 * @Author Stranger
 * @Date 2020-12-22
 * @Version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_sys_user")
@ApiModel(value="SysUser对象", description="用户")
public class SysUser extends Model<SysUser> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键uuid")
    @TableId("id")
    private String id;

    @ApiModelProperty(value = "用户名")
    @TableField("username")
    private String username;

    @ApiModelProperty(value = "密码md5")
    @TableField("password")
    private String password;

    @ApiModelProperty(value = "手机号")
    @TableField("mobile")
    private String mobile;

    @ApiModelProperty(value = "邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty(value = "昵称")
    @TableField("nickname")
    private String nickname;

    @ApiModelProperty(value = "性别，0-保密，1-男，2-女")
    @TableField("gender")
    private Integer gender;

    @ApiModelProperty(value = "真实姓名")
    @TableField("realname")
    private String realname;

    @ApiModelProperty(value = "身份证号")
    @TableField("id_number")
    private String idNumber;

    @ApiModelProperty(value = "头像url")
    @TableField("head_url")
    private String headUrl;

    @ApiModelProperty(value = "注册时间")
    @TableField("register_time")
    private LocalDateTime registerTime;

    @ApiModelProperty(value = "登录次数")
    @TableField("login_number")
    private Long loginNumber;

    @ApiModelProperty(value = "最后登录时间")
    @TableField("last_login_time")
    private LocalDateTime lastLoginTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "状态，1-冻结，0-正常")
    @TableField("status")
    @TableLogic
    private String status;

    @ApiModelProperty(value = "手机验证码")
    @TableField("mobile_verification_code")
    private String mobileVerificationCode;

    @ApiModelProperty(value = "邮箱验证码")
    @TableField("email_verification_code")
    private String emailVerificationCode;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
