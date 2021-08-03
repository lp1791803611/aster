package top.plgxs.common.core.api.menu;

import lombok.Data;

import java.io.Serializable;

/**
 * logo
 *
 * @author Stranger。
 * @version 1.0
 * @since 2021/6/9 11:39
 */
@Data
public class LogoInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 标题
     */
    private String title;

    /**
     * 图片url
     */
    private String image;

    /**
     * 链接
     */
    private String href;

    public LogoInfo() {
        super();
    }

    public LogoInfo(String title, String image) {
        this.title = title;
        this.image = image;
    }

    public LogoInfo(String title, String image, String href) {
        this.title = title;
        this.image = image;
        this.href = href;
    }
}
