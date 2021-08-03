package top.plgxs.admin.service.impl.vacc;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.plgxs.admin.service.vacc.ChildInfoService;
import top.plgxs.mbg.entity.sys.SysConfig;
import top.plgxs.mbg.entity.vacc.ChildInfo;
import top.plgxs.mbg.mapper.sys.SysConfigMapper;
import top.plgxs.mbg.mapper.vacc.ChildInfoMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Stranger.
 * @version 1.0
 * @since 2021-08-02
 */
@Service
public class ChildInfoServiceImpl extends ServiceImpl<ChildInfoMapper, ChildInfo> implements ChildInfoService {
    @Resource
    private ChildInfoMapper childInfoMapper;
    @Resource
    private SysConfigMapper sysConfigMapper;

    @Override
    public List<ChildInfo> getChildInfoList() {
        return childInfoMapper.selectChildInfoList(null);
    }

    @Override
    @DS("sharding")
    public void insert(ChildInfo childInfo) {
        childInfoMapper.insert(childInfo);
    }

    @Override
    public void selectMaster() {
        SysConfig config = sysConfigMapper.selectById("1409078174394880002");
        System.out.println(config.getConfigValue());
    }

    @Override
    @DS("slave_0")
    public void selectSlave() {
        SysConfig config = sysConfigMapper.selectById("1409078174394880002");
        System.out.println(config.getConfigValue());
    }

    @Override
    @DS("sharding")
    public void insertSharding() {
        for (int i = 0; i < 100; i++) {
            ChildInfo childInfo = new ChildInfo();
            childInfo.setCreateDate("2021-08-03");
            childInfoMapper.insert(childInfo);
        }
    }

    @Override
    @DS("sharding")
    public List<ChildInfo> selectSharding() {
        QueryWrapper<ChildInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("create_date", "2021-08-03");
        return childInfoMapper.selectList(queryWrapper);
    }


}
