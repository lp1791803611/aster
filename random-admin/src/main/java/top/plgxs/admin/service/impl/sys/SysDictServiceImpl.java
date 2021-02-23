package top.plgxs.admin.service.impl.sys;

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
}
