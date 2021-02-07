package top.plgxs.admin.service.impl.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import top.plgxs.common.domain.TreeTable;
import top.plgxs.common.node.ZTreeNode;
import top.plgxs.mbg.entity.sys.SysMenu;
import top.plgxs.mbg.mapper.sys.SysMenuMapper;
import top.plgxs.admin.service.sys.SysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 菜单 服务实现类
 * </p>
 *
 * @author Stranger。
 * @since 2021-02-02
 * @version 1.0
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
        if(menus != null && menus.size() > 0){
            for(int i = 0, len = menus.size(); i < len; i++) {
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

}
