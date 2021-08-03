package top.plgxs.mbg.entity.monitor;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * 操作日志记录
 * </p>
 *
 * @author Stranger。
 * @since 2021-07-02
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_sys_oper_log")
@ApiModel(value="SysOperLog对象", description="操作日志记录")
public class SysOperLog extends Model<SysOperLog> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "日志主键")
    @TableId("id")
    private String id;

    @ApiModelProperty(value = "模块标题")
    @TableField("title")
    private String title;

    @ApiModelProperty(value = "业务类型")
    @TableField("business_type")
    private String businessType;

    @ApiModelProperty(value = "方法名称")
    @TableField("method")
    private String method;

    @ApiModelProperty(value = "请求方式")
    @TableField("request_method")
    private String requestMethod;

    @ApiModelProperty(value = "操作类别")
    @TableField("operator_type")
    private String operatorType;

    @ApiModelProperty(value = "操作人员")
    @TableField("oper_name")
    private String operName;

    @ApiModelProperty(value = "请求URL")
    @TableField("oper_url")
    private String operUrl;

    @ApiModelProperty(value = "主机地址")
    @TableField("oper_ip")
    private String operIp;

    @ApiModelProperty(value = "操作地点")
    @TableField("oper_location")
    private String operLocation;

    @ApiModelProperty(value = "请求参数")
    @TableField("oper_param")
    private String operParam;

    @ApiModelProperty(value = "返回参数")
    @TableField("json_result")
    private String jsonResult;

    @ApiModelProperty(value = "操作状态")
    @TableField("status")
    private String status;

    @ApiModelProperty(value = "错误消息")
    @TableField("error_msg")
    private String errorMsg;

    @ApiModelProperty(value = "操作时间")
    @TableField("oper_time")
    private LocalDateTime operTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
