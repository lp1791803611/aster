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
 * 角色菜单
 * </p>
 *
 * @author Stranger。
 * @since 2021-02-13
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_sys_role_menu")
@ApiModel(value="SysRoleMenu对象", description="角色菜单")
public class SysRoleMenu extends Model<SysRoleMenu> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色主键")
    @TableId("role_id")
    private String roleId;

    @ApiModelProperty(value = "菜单主键")
    @TableField("menu_id")
    private String menuId;


    @Override
    protected Serializable pkVal() {
        return this.roleId;
    }

}
