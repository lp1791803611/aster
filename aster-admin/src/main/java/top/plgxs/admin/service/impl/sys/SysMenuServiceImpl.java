package top.plgxs.admin.service.impl.sys;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import top.plgxs.admin.service.sys.SysMenuService;
import top.plgxs.common.core.constants.Constants;
import top.plgxs.common.core.api.TreeTable;
import top.plgxs.common.core.api.node.ZTreeNode;
import top.plgxs.common.core.constants.enums.StatusEnum;
import top.plgxs.common.core.exception.BusinessException;
import top.plgxs.mbg.entity.sys.SysMenu;
import top.plgxs.mbg.entity.sys.SysRoleMenu;
import top.plgxs.mbg.mapper.sys.SysMenuMapper;
import top.plgxs.mbg.mapper.sys.SysRoleMenuMapper;
import top.plgxs.mbg.mapper.sys.SysUserRoleMapper;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.*;

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
    @Resource
    private SysUserRoleMapper sysUserRoleMapper;
    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;

    /**
     * 数据查询列表
     * @return
     * @author Stranger。
     * @date 2021-02-02
     */
    @Override
    public List<SysMenu> getSysMenuList() {
        return sysMenuMapper.selectSysMenuList(null);
    }

    /**
     * treetable数据
     * @param queryWrapper
     * @author Stranger。
     * @since 2021/2/2 0002
     */
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

    /**
     * 树形菜单列表
     * @return java.util.List<top.plgxs.common.node.ZTreeNode>
     * @author Stranger。
     * @since 2021/2/6
     */
    @Override
    public List<ZTreeNode> menuTreeList() {
        return sysMenuMapper.menuTreeList();
    }

    /**
     * 根据code查询菜单名称
     * @param code 菜单编码
     * @author Stranger。
     * @since 2021/2/7 0007
     */
    @Override
    public String getMenuNameByCode(String code) {
        QueryWrapper<SysMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("code", code);
        SysMenu sysMenu = sysMenuMapper.selectOne(queryWrapper);
        return sysMenu == null ? "" : sysMenu.getMenuName();
    }

    /**
     * 新增一条菜单
     * @param sysMenu
     * @author Stranger。
     * @since 2021/2/8 0008
     */
    @Override
    public int insertMenu(SysMenu sysMenu) {
        // 判断编码是否已存在
        if (StringUtils.isNotBlank(this.getMenuNameByCode(sysMenu.getCode()))) {
            throw new BusinessException("编码已存在");
        }
        // 判断父级编码是否为空
        if (StringUtils.isBlank(sysMenu.getParentCode())) {
            throw new BusinessException("父级编码为空");
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

    /**
     * 更新一条菜单
     * @param sysMenu
     * @author Stranger。
     * @since 2021/2/8 0008
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public int updateMenu(SysMenu sysMenu) {
        // 判断编码是否已存在
        if (StringUtils.isNotBlank(this.getMenuNameByCode(sysMenu.getCode()))) {
            throw new BusinessException("编码已存在");
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

    /**
     * 逻辑删除一条菜单，包含子菜单
     * @param code 菜单编码
     * @author Stranger。
     * @since 2021/2/8 0008
     */
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

    /**
     * 批量删除
     * @param codes
     * @return void
     * @author Stranger。
     * @since 2021/2/9
     */
    @Transactional(rollbackOn = Exception.class)
    @Override
    public void batchDelete(List<String> codes) {
        for (String code : codes) {
            this.deleteMenuContainChildren(code);
        }
    }

    /**
     * 切换启用状态
     * @param code 菜单编码
     * @param status 状态
     * @return void
     * @author Stranger。
     * @since 2021/2/9
     */
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
     * 根据角色id组装菜单树
     * @param roleId
     * @return java.util.List<top.plgxs.common.node.ZTreeNode>
     * @author Stranger。
     * @since 2021/2/22
     */
    @Override
    public List<ZTreeNode> getMenuTreeByRoleId(String roleId) {
        List<SysMenu> sysMenus = this.getMenuByRoleId(roleId);
        Map<String, SysMenu> map = new HashMap<>();
        if (sysMenus != null && sysMenus.size() > 0) {
            for (SysMenu menu : sysMenus) {
                map.put(menu.getCode(), menu);
            }
        }
        List<ZTreeNode> zTreeNodes = sysMenuMapper.menuTreeList();
        if (zTreeNodes != null && zTreeNodes.size() > 0) {
            for (int i = 0, len = zTreeNodes.size(); i < len; i++) {
                ZTreeNode node = zTreeNodes.get(i);
                if (map.containsKey(node.getId())) {
                    node.setChecked(true);
                }
            }
        }
        zTreeNodes.add(ZTreeNode.createParent("0", "菜单信息", false, true));
        return zTreeNodes;
    }

    /**
     * 当前角色所属的菜单
     * @param roleId
     * @return java.util.List<top.plgxs.mbg.entity.sys.SysMenu>
     * @author Stranger。
     * @since 2021/2/22
     */
    @Override
    public List<SysMenu> getMenuByRoleId(String roleId) {
        return sysMenuMapper.getMenuByRoleId(roleId);
    }

    /**
     * 根据用户id查询权限
     * @param userId 用户id
     * @return java.util.Set<java.lang.String>
     * @author Stranger。
     * @since 2021/3/16
     */
    @Override
    public Set<String> getPermissionByUserId(String userId) {
        Set<String> permissions = new HashSet<>();
        List<String> roleIds = sysUserRoleMapper.getRoleIdByUserId(userId);
        List<String> menuIds = this.getMenuIdByRoleId(roleIds);
        List<SysMenu> menus = sysMenuMapper.selectBatchIds(menuIds);
        if (CollUtil.isNotEmpty(menuIds)) {
            for (SysMenu menu : menus) {
                // 只添加启用状态的权限
                if (StatusEnum.ENABLE.getCode().equals(menu.getStatus())) {
                    permissions.add(menu.getMenuAuth());
                }
            }
        }
        return permissions;
    }

    /**
     * 根据角色id查询菜单id
     * @param roleIds 角色id集合
     * @return java.util.List<java.lang.String>
     * @author Stranger。
     * @since 2021/3/16
     */
    @Override
    public List<String> getMenuIdByRoleId(List<String> roleIds) {
        List<String> menuIds = new ArrayList<>();
        QueryWrapper<SysRoleMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("role_id", roleIds);
        List<SysRoleMenu> list = sysRoleMenuMapper.selectList(queryWrapper);
        if (CollUtil.isNotEmpty(list)) {
            for (SysRoleMenu roleMenu : list) {
                menuIds.add(roleMenu.getMenuId());
            }
        }
        return menuIds;
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
        List<SysMenu> menus = sysMenuMapper.getChildMenusByCode(oldMenu.getCode());
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
