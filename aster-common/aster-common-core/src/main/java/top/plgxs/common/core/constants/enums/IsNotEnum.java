package top.plgxs.common.core.constants.enums;

/**
 * @author Stranger。
 * @version 1.0
 * @since 2021/7/8 21:24
 */
public enum IsNotEnum {
    /**
     * 0-是
     */
    IS("0", "是"),
    /**
     * 1-否
     */
    NOT("1", "否");

    private String code;
    private String message;

    IsNotEnum(String code, String message){
        this.code = code;
        this.message = message;
    }

    public static String getCode(String value) {
        IsNotEnum[] enums = IsNotEnum.values();
        for (IsNotEnum bEnum : enums) {
            if (bEnum.getMessage().equals(value)) {
                return bEnum.getCode();
            }
        }
        return null;
    }

    public static String getMessage(String code) {
        IsNotEnum[] enums = IsNotEnum.values();
        for (IsNotEnum bEnum : enums) {
            if (bEnum.getCode().equals(code)) {
                return bEnum.getMessage();
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
