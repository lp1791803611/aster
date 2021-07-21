package top.plgxs.common.core.api.page;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>分页数据信息</p>
 *
 * @author Stranger。
 * @version 1.0
 * @since 2021/1/28 0028 11:39
 */
@Data
public class PageDataInfo<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private int code;
    private List<T> data;
    private String msg;
    private Long count;

    public PageDataInfo() {
        super();
    }

    /**
     * 分页
     *
     * @param data  列表数据
     * @param count 总记录数
     * @author Stranger。
     * @date 2021/1/28
     */
    public PageDataInfo(List<T> data, Long count) {
        this.code = 0;
        this.data = data;
        this.msg = "";
        this.count = count;
    }
}
