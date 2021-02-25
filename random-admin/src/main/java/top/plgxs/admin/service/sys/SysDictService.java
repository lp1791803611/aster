package top.plgxs.admin.service.sys;

import top.plgxs.mbg.entity.sys.SysDict;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 字典数据 服务类
 * </p>
 *
 * @author Stranger。
 * @since 2021-02-23
 * @version 1.0
 */
public interface SysDictService extends IService<SysDict> {
    /**
     * 数据查询列表
     * @return
     * @author Stranger。
     * @date 2021-02-23
     */
    List<SysDict> getSysDictList();

    /**
     * 根据字典类型编码查询字典数据
     * @param code 字典类型编码
     * @author Stranger。
     * @since 2021/2/25 0025
     */
    List<SysDict> listDictsByCode(String code);
}
