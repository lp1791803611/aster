package top.plgxs.admin.service.sys;

import top.plgxs.mbg.entity.sys.SysDept;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 部门 服务类
 * </p>
 *
 * @author Stranger。
 * @since 2021-01-30
 * @version 1.0
 */
public interface SysDeptService extends IService<SysDept> {
    /**
     * 数据查询列表
     * @return
     * @author Stranger。
     * @date 2021-01-30
     */
    List<SysDept> getSysDeptList();
}
