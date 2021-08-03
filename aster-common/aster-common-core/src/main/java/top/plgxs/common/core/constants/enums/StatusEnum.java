package top.plgxs.common.core.constants.enums;

/**
 * 通用状态枚举类
 *
 * @author Stranger。
 * @version 1.0
 * @since 2021/2/9 21:06
 */
public enum StatusEnum {
    ENABLE("0", "启用"),
    DISABLE("1", "冻结");

    private String code;
    private String message;

    StatusEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static String getCode(String value) {
        StatusEnum[] enums = StatusEnum.values();
        for (StatusEnum bEnum : enums) {
            if (bEnum.getMessage().equals(value)) {
                return bEnum.getCode();
            }
        }
        return null;
    }

    public static String getMessage(String code) {
        StatusEnum[] enums = StatusEnum.values();
        for (StatusEnum bEnum : enums) {
            if (bEnum.getCode().equals(code)) {
                return bEnum.getMessage();
            }
        }
        return null;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
