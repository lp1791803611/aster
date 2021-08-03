package top.plgxs.mbg.dto.gen;

import lombok.Data;

import java.util.List;

/**
 * @author Stranger。
 * @version 1.0
 * @since 2021/7/11 16:26
 */
@Data
public class GenInfo {
    private TableBasic basic;
    private List<TableColumn> columns;
    private TableOutput output;
}
