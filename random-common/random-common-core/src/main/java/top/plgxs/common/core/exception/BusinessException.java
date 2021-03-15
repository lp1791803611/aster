package top.plgxs.common.core.exception;

/**
 * 业务异常
 *
 * @author Stranger。
 * @version 1.0
 * @since 2021/3/15 21:31
 */
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    protected Integer errorCode;
    protected String message;

    public BusinessException() {}

    public BusinessException(String message) {
        this.message = message;
    }

    public BusinessException(Integer errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public BusinessException(String message, Throwable e) {
        super(message, e);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getErrorCode() {
        return errorCode;
    }
}
