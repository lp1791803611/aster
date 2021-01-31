package top.plgxs.admin.service.impl.sys;

import top.plgxs.mbg.entity.sys.SysDept;
import top.plgxs.mbg.mapper.sys.SysDeptMapper;
import top.plgxs.admin.service.sys.SysDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 部门 服务实现类
 * </p>
 *
 * @author Stranger。
 * @since 2021-01-30
 * @version 1.0
 */
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements SysDeptService {
    @Resource
    private SysDeptMapper sysDeptMapper;

    @Override
    public List<SysDept> getSysDeptList() {
        return sysDeptMapper.selectSysDeptList(null);
    }
}
