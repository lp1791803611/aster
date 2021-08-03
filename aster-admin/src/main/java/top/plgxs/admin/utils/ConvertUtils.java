package top.plgxs.admin.utils;

import cn.hutool.core.collection.CollUtil;
import top.plgxs.common.core.api.menu.MenuInfo;
import top.plgxs.common.core.constants.Constants;
import top.plgxs.mbg.entity.sys.SysMenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Stranger。
 * @version 1.0
 * @since 2021/6/10 14:46
 */
public class ConvertUtils {

    public static List<MenuInfo> convertMenuInfoList(List<SysMenu> menus) {
        List<MenuInfo> list = new ArrayList<>();
        if (CollUtil.isEmpty(menus)) {
            return null;
        }
        List<MenuInfo> menuInfos = new ArrayList<>();
        Map<String, MenuInfo> map = new HashMap<>();
        for (SysMenu menu : menus) {
            MenuInfo menuInfo = convertMenuInfo(menu);
            map.put(menu.getCode(), menuInfo);
            menuInfos.add(menuInfo);
        }

        for (MenuInfo menuInfo : menuInfos) {
            if (Constants.TOP_MENU_CODE.equals(menuInfo.getParentCode())) {
                list.add(menuInfo);
            } else {
                MenuInfo parent = map.get(menuInfo.getParentCode());
                if (parent != null) {
                    parent.getChild().add(menuInfo);
                } else {
                    list.add(menuInfo);
                }
            }
        }
        return list;
    }

    public static MenuInfo convertMenuInfo(SysMenu menu) {
        MenuInfo menuInfo = new MenuInfo();
        menuInfo.setTitle(menu.getMenuName());
        menuInfo.setHref(menu.getMenuUrl());
        menuInfo.setIcon(menu.getMenuIcon());
        menuInfo.setTarget(menu.getMenuTarget());
        menuInfo.setCode(menu.getCode());
        menuInfo.setParentCode(menu.getParentCode());
        menuInfo.setSort(menu.getSort());
        return menuInfo;
    }

}
