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
 * 角色
 * </p>
 *
 * @author Stranger。
 * @since 2021-01-07
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_sys_role")
@ApiModel(value="SysRole对象", description="角色")
public class SysRole extends Model<SysRole> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键uuid")
    @TableId("id")
    private String id;

    @ApiModelProperty(value = "角色名称")
    @TableField("role_name")
    private String roleName;

    @ApiModelProperty(value = "角色代码")
    @TableField("role_code")
    private String roleCode;

    @ApiModelProperty(value = "优先级")
    @TableField("priority")
    private Integer priority;

    @ApiModelProperty(value = "备注")
    @TableField("remark")
    private String remark;

    @TableField("gmt_create")
    private LocalDateTime gmtCreate;

    @TableField("gmt_modified")
    private LocalDateTime gmtModified;

    @ApiModelProperty(value = "状态，1-删除，0-正常")
    @TableField("is_deleted")
    @TableLogic
    private String isDeleted;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
