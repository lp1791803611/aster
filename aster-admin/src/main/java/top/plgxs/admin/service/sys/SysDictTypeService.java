package top.plgxs.admin.service.sys;

import top.plgxs.mbg.entity.sys.SysDictType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 字典类型 服务类
 * </p>
 *
 * @author Stranger。
 * @since 2021-02-23
 * @version 1.0
 */
public interface SysDictTypeService extends IService<SysDictType> {
    /**
     * 数据查询列表
     * @return
     * @author Stranger。
     * @date 2021-02-23
     */
    List<SysDictType> getSysDictTypeList();
}
