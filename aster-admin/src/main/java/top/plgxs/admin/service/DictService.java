package top.plgxs.admin.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import top.plgxs.admin.service.sys.SysDictService;
import top.plgxs.admin.service.sys.SysDictTypeService;
import top.plgxs.common.core.constants.enums.StatusEnum;
import top.plgxs.mbg.entity.sys.SysDict;
import top.plgxs.mbg.entity.sys.SysDictType;

import javax.annotation.Resource;
import java.util.List;

/**
 * 供前端thymeleaf调用
 *
 * @author Stranger。
 * @version 1.0
 * @since 2021/7/3 14:27
 */
@Service("dict")
public class DictService {
    @Resource
    private SysDictService sysDictService;
    @Resource
    private SysDictTypeService sysDictTypeService;

    public List<SysDictType> getDictType(){
        QueryWrapper<SysDictType> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", StatusEnum.ENABLE.getCode());
        return sysDictTypeService.list(queryWrapper);
    }

    /**
     * 根据字典类型查询字典数据信息
     *
     * @param dictType 字典类型
     * @return 参数键值
     */
    public List<SysDict> getDict(String dictType) {
        return sysDictService.selectDictByType(dictType);
    }

    /**
     * 根据字典类型和字典键值查询字典数据信息
     *
     * @param dictType  字典类型
     * @param dictValue 字典键值
     * @return 字典标签
     */
    public String getLabel(String dictType, String dictValue) {
        return sysDictService.selectDictLabel(dictType, dictValue);
    }
}
