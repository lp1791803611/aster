package top.plgxs.common.enums;

/**
 * 通用状态枚举类
 *
 * @author Stranger。
 * @version 1.0
 * @since 2021/2/9 21:06
 */
public enum StatusEnum {
    ENABLE("1", "启用"),
    DISABLE("0", "冻结");

    private String code;
    private String message;

    StatusEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
