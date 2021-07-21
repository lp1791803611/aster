package top.plgxs.common.core.constants.enums;

/**
 * 用户会话枚举类
 *
 * @author Stranger。
 * @version 1.0
 * @since 2021/6/9 21:11
 */
public enum OnlineStatus
{
    /** 用户状态 */
    on_line("在线"), off_line("离线");

    private final String info;

    private OnlineStatus(String info)
    {
        this.info = info;
    }

    public String getInfo()
    {
        return info;
    }
}
