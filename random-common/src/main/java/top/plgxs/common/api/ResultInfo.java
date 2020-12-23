package top.plgxs.common.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>通用返回对象</p>
 *
 * @Author Stranger。
 * @Date 2020/12/23 15:13
 * @Version 1.0
 */
@Data
@ApiModel(value="通用返回对象", description="通用返回对象")
public class ResultInfo<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 成功标志
     */
    @ApiModelProperty(value = "成功标志")
    private boolean success = true;

    /**
     * 返回处理消息
     */
    @ApiModelProperty(value = "返回处理消息")
    private String message = "操作成功！";

    /**
     * 返回代码
     */
    @ApiModelProperty(value = "返回代码")
    private Integer code = 0;

    /**
     * 返回数据对象 data
     */
    @ApiModelProperty(value = "返回数据对象")
    private T data;

    /**
     * 时间戳
     */
    @ApiModelProperty(value = "时间戳")
    private long timestamp = System.currentTimeMillis();

    public ResultInfo() {

    }

    /**
     * 成功返回结果
     * @author Stranger。
     * @date 2020/12/23 16:05
     */
    public static <T> ResultInfo<T> success(){
        return success(ResultCode.SUCCESS.getMessage(),null);
    }

    /**
     * 成功返回结果
     * @param data 返回的数据
     * @author Stranger。
     * @date 2020/12/23 0023 16:06
     */
    public static<T> ResultInfo<T> success(T data) {
        return success(ResultCode.SUCCESS.getMessage(),data);
    }

    /**
     * 成功返回结果
     * @param msg 提示信息
     * @param data 返回的数据
     * @author Stranger。
     * @date 2020/12/23 16:09
     */
    public static<T> ResultInfo<T> success(String msg, T data) {
        ResultInfo<T> r = new ResultInfo<T>();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS.getCode());
        r.setMessage(msg);
        r.setData(data);
        return r;
    }

    /**
     * 失败返回结果
     * @author Stranger。
     * @date 2020/12/23 16:10
     */
    public static <T> ResultInfo<T> failed() {
        return failed(ResultCode.FAILED.getMessage());
    }

    /**
     * 失败返回结果
     * @param message 错误信息
     * @author Stranger。
     * @date 2020/12/23 16:10
     */
    public static<T> ResultInfo<T> failed(String message) {
        return failed(ResultCode.FAILED.getCode(), message);
    }

    /**
     * 失败返回结果
     * @param code 错误码
     * @param message 错误信息
     * @author Stranger。
     * @date 2020/12/23 16:10
     */
    public static<T> ResultInfo<T> failed(int code, String message) {
        ResultInfo<T> r = new ResultInfo<>();
        r.setCode(code);
        r.setMessage(message);
        r.setSuccess(false);
        return r;
    }

    /**
     * 参数验证失败返回结果
     * @author Stranger。
     * @date 2020/12/23 16:12
     */
    public static<T> ResultInfo<T> validateFailed() {
        return validateFailed(ResultCode.VALIDATE_FAILED.getMessage());
    }

    /**
     * 参数验证失败返回结果
     * @param message 错误信息
     * @author Stranger。
     * @date 2020/12/23 16:12
     */
    public static<T> ResultInfo<T> validateFailed(String message) {
        return failed(ResultCode.VALIDATE_FAILED.getCode(),message);
    }
    /**
     * 未登录返回结果
     * @author Stranger。
     * @date 2020/12/23 16:12
     */
    public static <T> ResultInfo<T> unauthorized() {
        return failed(ResultCode.UNAUTHORIZED.getCode(),ResultCode.UNAUTHORIZED.getMessage());
    }

    /**
     * 未授权返回结果
     * @author Stranger。
     * @date 2020/12/23 16:12
     */
    public static <T> ResultInfo<T> forbidden() {
        return failed(ResultCode.FORBIDDEN.getCode(),ResultCode.FORBIDDEN.getMessage());
    }

}
