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
 * 通知公告
 * </p>
 *
 * @author Stranger.
 * @since 2021-07-16
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_sys_notice")
@ApiModel(value="SysNotice对象", description="通知公告")
public class SysNotice extends Model<SysNotice> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @TableId("id")
    private String id;

    @ApiModelProperty(value = "公告标题")
    @TableField("notice_title")
    private String noticeTitle;

    @ApiModelProperty(value = "公告类型")
    @TableField("notice_type")
    private String noticeType;

    @ApiModelProperty(value = "公告内容")
    @TableField("notice_content")
    private String noticeContent;

    @ApiModelProperty(value = "创建者")
    @TableField("create_by")
    private String createBy;

    @ApiModelProperty(value = "创建时间")
    @TableField("gmt_create")
    private LocalDateTime gmtCreate;

    @ApiModelProperty(value = "更新者")
    @TableField("modified_by")
    private String modifiedBy;

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

    @ApiModelProperty(value = "备注")
    @TableField("remark")
    private String remark;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
