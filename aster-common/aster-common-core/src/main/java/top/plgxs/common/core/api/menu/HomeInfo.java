package top.plgxs.common.core.api.menu;

import lombok.Data;

import java.io.Serializable;

/**
 * 首页
 * @author Stranger。
 * @version 1.0
 * @since 2021/6/9 11:33
 */
@Data
public class HomeInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 标题
     */
    private String title;

    /**
     * 链接
     */
    private String href;

    public HomeInfo(String title, String href){
        this.title = title;
        this.href = href;
    }
}
