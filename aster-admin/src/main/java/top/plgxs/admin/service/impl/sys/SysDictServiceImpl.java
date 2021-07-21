package top.plgxs.admin.service.impl.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import top.plgxs.common.core.constants.enums.StatusEnum;
import top.plgxs.mbg.entity.sys.SysDict;
import top.plgxs.mbg.mapper.sys.SysDictMapper;
import top.plgxs.admin.service.sys.SysDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 字典数据 服务实现类
 * </p>
 *
 * @author Stranger。
 * @since 2021-02-23
 * @version 1.0
 */
@Service
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDict> implements SysDictService {
    @Resource
    private SysDictMapper sysDictMapper;

    @Override
    public List<SysDict> getSysDictList() {
        return sysDictMapper.selectSysDictList(null);
    }

    /**
     * 根据字典类型编码查询字典数据
     *
     * @param code 字典类型编码
     * @author Stranger。
     * @since 2021/2/25 0025
     */
    @Override
    public List<SysDict> listDictsByCode(String code) {
        QueryWrapper<SysDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("dict_type_code", code);
        queryWrapper.orderByAsc("sort");
        List<SysDict> dicts = sysDictMapper.selectList(queryWrapper);
        return dicts;
    }

    /**
     * 根据字典类型和字典键值查询字典数据信息
     *
     * @param dictType  字典类型
     * @param dictValue 字典键值
     * @return java.lang.String
     * @author Stranger。
     * @since 2021/7/3
     */
    @Override
    public String selectDictLabel(String dictType, String dictValue) {
        QueryWrapper<SysDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("dict_type_code", dictType);
        queryWrapper.eq("dict_value", dictValue);
        queryWrapper.eq("status", StatusEnum.ENABLE.getCode());
        SysDict dict = sysDictMapper.selectOne(queryWrapper);
        return dict.getDictLabel();
    }

    /**
     * 根据字典类型查询字典数据信息
     * @param dictType 字典类型
     * @return java.util.List<top.plgxs.mbg.entity.sys.SysDict>
     * @author Stranger。
     * @since 2021/7/3
     */
    @Override
    public List<SysDict> selectDictByType(String dictType) {
        QueryWrapper<SysDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("dict_type_code", dictType);
        queryWrapper.eq("status", StatusEnum.ENABLE.getCode());
        return sysDictMapper.selectList(queryWrapper);
    }
}
