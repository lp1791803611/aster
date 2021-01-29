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
 * 字典数据
 * </p>
 *
 * @author Stranger。
 * @since 2021-01-29
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_sys_dict")
@ApiModel(value="SysDict对象", description="")
public class SysDict extends Model<SysDict> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @TableId("id")
    private String id;

    @ApiModelProperty(value = "字典标签")
    @TableField("dict_label")
    private String dictLabel;

    @ApiModelProperty(value = "字典键值")
    @TableField("dict_value")
    private String dictValue;

    @ApiModelProperty(value = "字典类型编码")
    @TableField("dict_type_code")
    private String dictTypeCode;

    @ApiModelProperty(value = "字典排序")
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
