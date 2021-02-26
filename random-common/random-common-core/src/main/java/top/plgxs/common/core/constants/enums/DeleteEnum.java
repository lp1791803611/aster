package top.plgxs.common.core.constants.enums;

/**
 * 删除状态枚举类
 *
 * @author Stranger。
 * @version 1.0
 * @since 2021/2/9 21:11
 */
public enum DeleteEnum {
    OK("0", "正常"),
    DELETEED("1", "删除");

    private String code;
    private String message;

    DeleteEnum(String code, String message) {
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
