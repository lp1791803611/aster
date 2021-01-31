package top.plgxs.admin.service.impl.sys;

import top.plgxs.mbg.entity.sys.SysMenu;
import top.plgxs.mbg.mapper.sys.SysMenuMapper;
import top.plgxs.admin.service.sys.SysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 菜单 服务实现类
 * </p>
 *
 * @author Stranger。
 * @since 2021-01-30
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
}
