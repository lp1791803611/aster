package top.plgxs.mbg.dto.export;

import cn.hutool.core.util.StrUtil;
import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import top.plgxs.common.core.constants.enums.IsNotEnum;

import java.util.Date;

/**
 * @author Stranger。
 * @version 1.0
 * @since 2021/7/24 21:32
 */
@Data
public class ConfigExport {
    @ExcelIgnore
    private String id;

    @ExcelProperty(value = "参数名称", index = 0)
    private String configName;

    @ExcelProperty(value = "参数键名", index = 1)
    private String configKey;

    @ExcelProperty(value = "参数键值", index = 2)
    private String configValue;

    @ExcelProperty(value = "系统内置", index = 3)
    private String configType;

    @ExcelProperty(value = "创建时间", index = 4)
    private Date gmtCreate;

    @ExcelProperty(value = "备注信息", index = 5)
    private String remark;

    public String getConfigType() {
        if (StrUtil.isNotBlank(configType)) {
            return IsNotEnum.getMessage(configType);
        }
        return configType;
    }
}
