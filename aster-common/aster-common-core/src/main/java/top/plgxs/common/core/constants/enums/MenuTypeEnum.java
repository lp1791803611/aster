package top.plgxs.common.core.constants.enums;

/**
 * @author Stranger。
 * @version 1.0
 * @since 2021/6/10 18:24
 */
public enum MenuTypeEnum {
    CATALOGUE("0", "目录"),
    MENU("1", "菜单"),
    BUTTON("2", "按钮");

    private String code;
    private String message;

    MenuTypeEnum(String code, String message) {
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
