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
 * 菜单
 * </p>
 *
 * @author Stranger。
 * @since 2021-02-02
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_sys_menu")
@ApiModel(value="SysMenu对象", description="菜单")
public class SysMenu extends Model<SysMenu> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @TableId("id")
    private String id;

    @ApiModelProperty(value = "菜单编码")
    @TableField("code")
    private String code;

    @ApiModelProperty(value = "父菜单编码")
    @TableField("parent_code")
    private String parentCode;

    @ApiModelProperty(value = "菜单名称")
    @TableField("menu_name")
    private String menuName;

    @ApiModelProperty(value = "菜单url")
    @TableField("menu_url")
    private String menuUrl;

    @ApiModelProperty(value = "权限控制")
    @TableField("menu_auth")
    private String menuAuth;

    @ApiModelProperty(value = "链接打开方式")
    @TableField("menu_target")
    private String menuTarget;

    @ApiModelProperty(value = "菜单图标")
    @TableField("menu_icon")
    private String menuIcon;

    @ApiModelProperty(value = "菜单类型")
    @TableField("menu_type")
    private String menuType;

    @ApiModelProperty(value = "祖级列表")
    @TableField("ancestors")
    private String ancestors;

    @ApiModelProperty(value = "菜单排序")
    @TableField("sort")
    private Integer sort;

    @ApiModelProperty(value = "创建时间")
    @TableField("gmt_create")
    private LocalDateTime gmtCreate;

    @ApiModelProperty(value = "更新时间")
    @TableField("gmt_modified")
    private LocalDateTime gmtModified;

    @ApiModelProperty(value = "启用状态")
    @TableField("status")
    private String status;

    @ApiModelProperty(value = "删除状态")
    @TableField("is_deleted")
    @TableLogic
    private String isDeleted;

    @ApiModelProperty(value = "备注信息")
    @TableField("remark")
    private String remark;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
