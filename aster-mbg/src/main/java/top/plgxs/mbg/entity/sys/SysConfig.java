package top.plgxs.mbg.entity.sys;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author Stranger。
 * @since 2021-06-13
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_sys_config")
@ApiModel(value="SysConfig对象", description="")
public class SysConfig extends Model<SysConfig> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId("id")
    private String id;

    @ApiModelProperty(value = "参数名称")
    @TableField("config_name")
    private String configName;

    @ApiModelProperty(value = "参数键名")
    @TableField("config_key")
    private String configKey;

    @ApiModelProperty(value = "参数键值")
    @TableField("config_value")
    private String configValue;

    @ApiModelProperty(value = "系统内置")
    @TableField("config_type")
    private String configType;

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
