package top.plgxs.admin.service.sys;

import com.baomidou.mybatisplus.extension.service.IService;
import top.plgxs.mbg.entity.sys.SysDict;

import java.util.List;

/**
 * <p>
 * 字典数据 服务类
 * </p>
 *
 * @author Stranger。
 * @version 1.0
 * @since 2021-02-23
 */
public interface SysDictService extends IService<SysDict> {
    /**
     * 数据查询列表
     *
     * @return
     * @author Stranger。
     * @date 2021-02-23
     */
    List<SysDict> getSysDictList();

    /**
     * 根据字典类型编码查询字典数据
     *
     * @param code 字典类型编码
     * @author Stranger。
     * @since 2021/2/25 0025
     */
    List<SysDict> listDictsByCode(String code);

    /**
     * 根据字典类型和字典键值查询字典数据信息
     *
     * @param dictType  字典类型
     * @param dictValue 字典键值
     * @return java.lang.String
     * @author Stranger。
     * @since 2021/7/3
     */
    String selectDictLabel(String dictType, String dictValue);

    /**
     * 根据字典类型查询字典数据信息
     * @param dictType 字典类型
     * @return java.util.List<top.plgxs.mbg.entity.sys.SysDict>
     * @author Stranger。
     * @since 2021/7/3
     */
    List<SysDict> selectDictByType(String dictType);
}
