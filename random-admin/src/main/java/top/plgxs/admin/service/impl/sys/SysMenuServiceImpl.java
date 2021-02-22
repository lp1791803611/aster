package top.plgxs.admin.service.impl.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import top.plgxs.admin.service.sys.SysMenuService;
import top.plgxs.common.constants.Constants;
import top.plgxs.common.domain.TreeTable;
import top.plgxs.common.node.ZTreeNode;
import top.plgxs.mbg.entity.sys.SysMenu;
import top.plgxs.mbg.mapper.sys.SysMenuMapper;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 菜单 服务实现类
 * </p>
 *
 * @author Stranger。
 * @version 1.0
 * @since 2021-02-02
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {
    @Resource
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<SysMenu> getSysMenuList() {
        return sysMenuMapper.selectSysMenuList(null);
    }

    @Override
    public List<TreeTable> treeTableList(QueryWrapper<SysMenu> queryWrapper) {
        List<TreeTable> treeTables = new ArrayList<>();
        List<SysMenu> menus = sysMenuMapper.selectList(queryWrapper);
        if (menus != null && menus.size() > 0) {
            for (int i = 0, len = menus.size(); i < len; i++) {
                TreeTable table = new TreeTable();
                table.setCode(menus.get(i).getCode());
                table.setParentCode(menus.get(i).getParentCode());
                table.setName(menus.get(i).getMenuName());
                table.setUrl(menus.get(i).getMenuUrl());
                table.setAuth(menus.get(i).getMenuAuth());
                table.setIcon(menus.get(i).getMenuIcon());
                table.setStatus(menus.get(i).getStatus());
                table.setType(menus.get(i).getMenuType());
                table.setSort(menus.get(i).getSort());
                treeTables.add(table);
            }
        }
        return treeTables;
    }

    @Override
    public List<ZTreeNode> menuTreeList() {
        return sysMenuMapper.menuTreeList();
    }

    @Override
    public String getMenuNameByCode(String code) {
        QueryWrapper<SysMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("code", code);
        SysMenu sysMenu = sysMenuMapper.selectOne(queryWrapper);
        return sysMenu == null ? "" : sysMenu.getMenuName();
    }

    @Override
    public int insertMenu(SysMenu sysMenu) {
        // 判断编码是否已存在
        if (StringUtils.isNotBlank(this.getMenuNameByCode(sysMenu.getCode()))) {
            // TODO 统一异常
        }
        // 判断父级编码是否为空
        if (StringUtils.isBlank(sysMenu.getParentCode())) {
            // TODO 统一异常
        }
        // 组装属性，设置祖级列表
        String ancestors = getAncestorsByParentCode(sysMenu.getParentCode());
        sysMenu.setAncestors(ancestors);

        sysMenu.setGmtCreate(LocalDateTime.now());
        return sysMenuMapper.insert(sysMenu);
    }

    /**
     * 组装祖级列表
     *
     * @param parentCode 父菜单编码
     * @author Stranger。
     * @since 2021/2/8 0008
     */
    private String getAncestorsByParentCode(String parentCode) {
        String ancestors;
        // 组装属性，设置祖级列表
        if (StringUtils.isBlank(parentCode) || Constants.TOP_MENU_CODE.equals(parentCode)) {
            ancestors = "["+ Constants.TOP_MENU_CODE +"],";
        } else {
            QueryWrapper<SysMenu> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("code", parentCode);
            SysMenu parentMenu = sysMenuMapper.selectOne(queryWrapper);
            ancestors = parentMenu.getAncestors() + "[" + parentCode + "],";
        }
        return ancestors;
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public int updateMenu(SysMenu sysMenu) {
        // 判断编码是否已存在
        if (StringUtils.isNotBlank(this.getMenuNameByCode(sysMenu.getCode()))) {
            // TODO 统一异常
        }
        // 判断父级编码是否为空,为空则设置父为顶级
        if (StringUtils.isBlank(sysMenu.getParentCode())) {
            sysMenu.setParentCode(Constants.TOP_MENU_CODE);
        }
        // 组装属性，设置祖级列表
        String ancestors = getAncestorsByParentCode(sysMenu.getParentCode());
        sysMenu.setAncestors(ancestors);

        // 查找该节点的子集合,并修改相应的parent_code和ancestors(因为修改菜单后,层级可能变化了)
        updateChildMenuLevels(sysMenu);
        return sysMenuMapper.updateById(sysMenu);
    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public void deleteMenuContainChildren(String code) {
        // 删除当前菜单
        QueryWrapper<SysMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("code", code);
        SysMenu sysMenu = sysMenuMapper.selectOne(queryWrapper);
        deleteMenu(sysMenu.getId());

        // 删除所有子菜单
        List<SysMenu> menus = sysMenuMapper.getChildMenusByCode(code);
        if (menus != null && menus.size() > 0) {
            for (SysMenu menu : menus) {
                deleteMenu(menu.getId());
            }
        }
    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public void batchDelete(List<String> codes) {
        for (String code : codes) {
            this.deleteMenuContainChildren(code);
        }
    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public void switchStatus(String code, String status) {
        // 切换当前菜单状态
        this.updateStatus(code, status);
        // 切换子菜单状态
        /*List<SysMenu> menus = sysMenuMapper.getChildMenusByCode(code);
        if (menus != null && menus.size() > 0) {
            for (SysMenu menu : menus) {
                this.updateStatus(menu.getCode(), status);
            }
        }*/
    }

    /**
     * 根据code更新菜单状态
     * @param code
     * @param status
     * @return int
     * @author Stranger。
     * @since 2021/2/9
     */
    @Transactional(rollbackOn = Exception.class)
    public int updateStatus(String code, String status) {
        QueryWrapper<SysMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("code", code);
        SysMenu menu = new SysMenu();
        menu.setStatus(status);
        return sysMenuMapper.update(menu, queryWrapper);
    }

    @Transactional(rollbackOn = Exception.class)
    public void deleteMenu(String id) {
        // 删除菜单
        sysMenuMapper.deleteById(id);

        // 删除关联的relation
        // TODO 删除菜单角色关系
    }

    /**
     * 更新子菜单的父菜单和祖级列表
     *
     * @param sysMenu 新的menu
     * @author Stranger。
     * @since 2021/2/8 0008
     */
    @Transactional(rollbackOn = Exception.class)
    public void updateChildMenuLevels(SysMenu sysMenu) {
        SysMenu oldMenu = sysMenuMapper.selectById(sysMenu.getId());
        List<SysMenu> menus = sysMenuMapper.getChildMenusByCode(oldMenu.getParentCode());
        if (menus != null && menus.size() > 0) {
            for (SysMenu menu : menus) {
                // 更新parent_code
                if (oldMenu.getCode().equals(menu.getParentCode())) {
                    menu.setParentCode(sysMenu.getCode());
                }
                // 更新ancestors
                String oldAncestorsPrefix = oldMenu.getAncestors() + "[" + oldMenu.getCode() + "],";
                String oldAncestorsSuffix = menu.getAncestors().substring(oldAncestorsPrefix.length());
                String menuAncestors = sysMenu.getAncestors() + "[" + sysMenu.getCode() + "]," + oldAncestorsSuffix;
                menu.setAncestors(menuAncestors);
                sysMenuMapper.updateById(menu);
            }
        }
    }

}
