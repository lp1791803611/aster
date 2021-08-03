package top.plgxs.common.core.api.menu;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Stranger。
 * @version 1.0
 * @since 2021/6/9 11:31
 */
@Data
public class MenuInit implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 首页信息
     */
    private HomeInfo homeInfo;

    /**
     * logo信息
     */
    private LogoInfo logoInfo;

    /**
     * 菜单信息
     */
    private List<MenuInfo> menuInfo;
}
