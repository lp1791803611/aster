package top.plgxs.common.core.constants.enums;

/**
 * @author Stranger。
 * @version 1.0
 * @since 2021/6/28 11:17
 */
public enum ConfigTypeEnum {
    YES("0", "是"),
    NO("1", "否");

    private String code;
    private String message;

    ConfigTypeEnum(String code, String message) {
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
