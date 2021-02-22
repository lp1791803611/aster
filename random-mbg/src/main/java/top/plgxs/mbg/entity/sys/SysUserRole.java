package top.plgxs.mbg.entity.sys;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户角色
 * </p>
 *
 * @author Stranger。
 * @since 2021-02-13
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_sys_user_role")
@ApiModel(value="SysUserRole对象", description="用户角色")
public class SysUserRole extends Model<SysUserRole> {

    private static final long serialVersionUID = 1L;

    @TableId("user_id")
    private String userId;

    @TableField("role_id")
    private String roleId;


    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}
