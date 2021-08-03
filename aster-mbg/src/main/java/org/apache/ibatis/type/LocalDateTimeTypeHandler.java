package org.apache.ibatis.type;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.util.StringUtil;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 * 解决因sharding-jdbc orm无法映射LocalDateTime所出现的getObject with type问题
 * @author Stranger。
 * @version 1.0
 * @since 2021/8/3 18:27
 */
public class LocalDateTimeTypeHandler extends BaseTypeHandler<LocalDateTime> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, LocalDateTime parameter, JdbcType jdbcType)
            throws SQLException {
        if (parameter != null) {
            ps.setString(i, DateUtil.format(parameter, DatePattern.NORM_DATETIME_PATTERN));
        }
    }

    @Override
    public LocalDateTime getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String target = rs.getString(columnName);
        if (StringUtil.isEmpty(target)) {
            return null;
        }
        return LocalDateTime.parse(target, DatePattern.NORM_DATETIME_FORMATTER);
    }

    @Override
    public LocalDateTime getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String target = rs.getString(columnIndex);
        if (StringUtil.isEmpty(target)) {
            return null;
        }
        return LocalDateTime.parse(target, DatePattern.NORM_DATETIME_FORMATTER);
    }

    @Override
    public LocalDateTime getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String target = cs.getString(columnIndex);
        if (StringUtil.isEmpty(target)) {
            return null;
        }
        return LocalDateTime.parse(target, DatePattern.NORM_DATETIME_FORMATTER);
    }
}
