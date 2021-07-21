package top.plgxs.admin.service.impl.sys;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.plgxs.admin.service.sys.SysDictTypeService;
import top.plgxs.common.core.constants.enums.StatusEnum;
import top.plgxs.mbg.entity.sys.SysDict;
import top.plgxs.mbg.entity.sys.SysDictType;
import top.plgxs.mbg.mapper.sys.SysDictMapper;
import top.plgxs.mbg.mapper.sys.SysDictTypeMapper;
import top.plgxs.mbg.utils.DictUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 字典类型 服务实现类
 * </p>
 *
 * @author Stranger。
 * @since 2021-02-23
 * @version 1.0
 */
@Service
public class SysDictTypeServiceImpl extends ServiceImpl<SysDictTypeMapper, SysDictType> implements SysDictTypeService {
    @Resource
    private SysDictTypeMapper sysDictTypeMapper;
    @Resource
    private SysDictMapper sysDictMapper;
    @Resource
    private DictUtils dictUtils;

    /**
     * 项目启动时，初始化字典到缓存
     * @return void
     * @author Stranger。
     * @since 2021/3/23
     */
    @PostConstruct
    public void init() {
        List<SysDictType> dictTypes = this.list();
        if (CollUtil.isNotEmpty(dictTypes)) {
            for (SysDictType dictType : dictTypes) {
                QueryWrapper<SysDict> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("dict_type_code", dictType.getDictTypeCode())
                    .eq("status", StatusEnum.ENABLE.getCode());
                List<SysDict> dictList = sysDictMapper.selectList(queryWrapper);
                dictUtils.setDictCache(dictType.getDictTypeCode(), dictList);
            }
        }
    }

    @Override
    public List<SysDictType> getSysDictTypeList() {
        return sysDictTypeMapper.selectSysDictTypeList(null);
    }

    @Override
    public void clearAll() {
        dictUtils.clearDictCache();
    }
}
