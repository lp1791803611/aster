package top.plgxs.admin.service.sys;

import top.plgxs.mbg.entity.sys.SysPosition;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 职位 服务类
 * </p>
 *
 * @author Stranger。
 * @since 2021-01-30
 * @version 1.0
 */
public interface SysPositionService extends IService<SysPosition> {
    /**
     * 数据查询列表
     * @return
     * @author Stranger。
     * @date 2021-01-30
     */
    List<SysPosition> getSysPositionList();
}
