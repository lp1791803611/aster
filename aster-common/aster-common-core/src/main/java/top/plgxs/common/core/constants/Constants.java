package top.plgxs.common.core.constants;

/**
 * 系统常量
 *
 * @author Stranger。
 * @version 1.0
 * @since 2021/2/9 21:21
 */
public class Constants {
    /**
     * 顶级菜单编码
     */
    public static final String TOP_MENU_CODE = "0";

    /**
     * 顶级部门编号
     */
    public static final String TOP_DEPT_ID = "0";
    /**
     * 顶级部门父编号
     */
    public static final String TOP_DEPT_PARENT_ID = "-1";

    /**
     * 密码私钥
     */
    public static final String PASSWORD_SALT = "stranger@aster";

    /**
     * 初始密码
     */
    public static final String PASSWORD_INITIAL = "123456";

    /**
     * 系统用户授权缓存
     */
    public static final String SYS_AUTH_CACHE = "sys-authCache";

    /**
     * 用户名长度限制
     */
    public static final int USERNAME_MIN_LENGTH = 2;
    public static final int USERNAME_MAX_LENGTH = 20;

    /**
     * 密码长度限制
     */
    public static final int PASSWORD_MIN_LENGTH = 5;
    public static final int PASSWORD_MAX_LENGTH = 20;

    /**
     * 超级管理员id
     */
    public static final String SUPER_ADMIN_ID = "Stranger";

    /** 登录名称是否唯一的返回结果码 */
    public final static String USER_NAME_UNIQUE = "0";
    public final static String USER_NAME_NOT_UNIQUE = "1";

    /**
     * 验证码key
     */
    public static final String CURRENT_CAPTCHA = "captcha";

    /**
     * 验证码开关
     */
    public static final String CURRENT_ENABLED = "captchaEnabled";

    /**
     * 验证码类型
     */
    public static final String CURRENT_TYPE = "captchaType";

    /**
     * 验证码
     */
    public static final String CURRENT_VALIDATECODE = "validateCode";

    /**
     * 验证码错误
     */
    public static final String CAPTCHA_ERROR = "captchaError";

    /**
     * 登录记录缓存
     */
    public static final String LOGINRECORDCACHE = "loginRecordCache";

}
