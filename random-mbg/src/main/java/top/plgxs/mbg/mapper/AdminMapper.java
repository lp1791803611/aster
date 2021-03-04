package top.plgxs.mbg.mapper;

import org.springframework.data.repository.query.Param;
import top.plgxs.mbg.entity.sys.SysMenu;

import java.util.List;

/**
 * 权限相关多表查询
 * @author Stranger。
 * @version 1.0
 * @since 2021/3/4 22:22
 */
public interface AdminMapper {

    /**
     * 根据用户Id查询
     * @param userId 用户Id
     * @return java.util.List<top.plgxs.mbg.entity.sys.SysMenu>
     * @author Stranger。
     * @since 2021/3/4
     */
    List<SysMenu> getMenuListByUserId(@Param("userId") String userId);
}
