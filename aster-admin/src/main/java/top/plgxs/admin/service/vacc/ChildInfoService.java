package top.plgxs.admin.service.vacc;

import top.plgxs.mbg.entity.vacc.ChildInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Stranger.
 * @since 2021-08-02
 * @version 1.0
 */
public interface ChildInfoService extends IService<ChildInfo> {
    /**
     * 数据查询列表
     * @return
     * @author Stranger.
     * @date 2021-08-02
     */
    List<ChildInfo> getChildInfoList();

    /**
     * 插入
     * @param childInfo
     * @return void
     * @author Stranger。
     * @since 2021/8/3
     */
    void insert(ChildInfo childInfo);

    void selectMaster();

    void selectSlave();

    void insertSharding();

    List<ChildInfo> selectSharding();
}
