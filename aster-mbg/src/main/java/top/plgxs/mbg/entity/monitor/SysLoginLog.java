package top.plgxs.mbg.entity.monitor;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 系统访问记录
 * </p>
 *
 * @author Stranger。
 * @since 2021-07-02
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_sys_login_log")
@ApiModel(value="SysLoginLog对象", description="系统访问记录")
public class SysLoginLog extends Model<SysLoginLog> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "访问ID")
    @TableId("id")
    private String id;

    @ApiModelProperty(value = "登录账号")
    @TableField("login_name")
    private String loginName;

    @ApiModelProperty(value = "登录IP地址")
    @TableField("ip_address")
    private String ipAddress;

    @ApiModelProperty(value = "登录地点")
    @TableField("login_location")
    private String loginLocation;

    @ApiModelProperty(value = "浏览器类型")
    @TableField("browser")
    private String browser;

    @ApiModelProperty(value = "操作系统")
    @TableField("os")
    private String os;

    @ApiModelProperty(value = "登录状态")
    @TableField("status")
    private String status;

    @ApiModelProperty(value = "提示消息")
    @TableField("msg")
    private String msg;

    @ApiModelProperty(value = "访问时间")
    @TableField("login_time")
    private LocalDateTime loginTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
