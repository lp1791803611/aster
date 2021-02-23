package top.plgxs.admin.service.impl.sys;

import top.plgxs.mbg.entity.sys.SysDictType;
import top.plgxs.mbg.mapper.sys.SysDictTypeMapper;
import top.plgxs.admin.service.sys.SysDictTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

    @Override
    public List<SysDictType> getSysDictTypeList() {
        return sysDictTypeMapper.selectSysDictTypeList(null);
    }
}
