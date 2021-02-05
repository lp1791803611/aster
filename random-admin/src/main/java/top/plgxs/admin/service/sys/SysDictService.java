package top.plgxs.admin.service.sys;

import top.plgxs.mbg.entity.sys.SysDict;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Stranger。
 * @since 2021-01-29
 * @version 1.0
 */
public interface SysDictService extends IService<SysDict> {
    /**
     * 数据查询列表
     * @return
     * @author Stranger。
     * @date 2021-01-29
     */
    List<SysDict> getSysDictList();

    /**
     * 根据字典类型编码查询字典数据
     * @param code 字典类型编码
     * @author Stranger。
     * @since 2021/2/5 0005
     */
    List<SysDict> listDictsByCode(String code);
}
