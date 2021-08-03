package top.plgxs.common.core.util;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 导出到excel
 *
 * @author Stranger。
 * @version 1.0
 * @filename ExportExcel.java
 * @email lipian1004@163.com
 * @date 2019年4月21日 下午5:19:08
 */
@Slf4j
public class ExcelUtils extends ExcelUtil {

    public static <T> void exportExcel(HttpServletResponse response, String fileName, Class<T> tClass,
                                       List<T> list){
        try {
            fileName = fileName + DateUtil.format(new Date(), DatePattern.PURE_DATETIME_MS_FORMAT);
//            response.setContentType("application/vnd.ms-excel");
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8") + ".xlsx");

            EasyExcel.write(response.getOutputStream(), tClass)
                    .excelType(ExcelTypeEnum.XLSX)
                    .sheet("sheet1")
                    .doWrite(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 导出excel
     *
     * @param headerMap 表头
     * @param writeData 数据
     * @param response
     * @return void
     * @author Stranger。
     * @since 2021/5/27
     */
    public static <T> void exportExcel(Map<String, String> headerMap, List<T> writeData, String title,
                                       HttpServletResponse response) {
        ExcelWriter writer = ExcelUtil.getWriter();
        writer.setHeaderAlias(headerMap);
        writer.write(writeData, true);

        String fileName = title + "_" + DateUtil.format(new Date(), DatePattern.PURE_DATETIME_MS_FORMAT);
        ServletOutputStream out = null;
        try {
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8") + ".xls");
            out = response.getOutputStream();
            writer.flush(out, true);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
        IoUtil.close(out);
    }

    /**
     * 列标题单元格样式
     *
     * @param workbook
     * @return
     * @author lp
     * @date 2017年8月30日 上午11:31:31
     */
    private static HSSFCellStyle getColunmTitleStyle(HSSFWorkbook workbook) {
        // 设置字体
        HSSFFont font = workbook.createFont();
        //设置字体大小
        font.setFontHeightInPoints((short) 11);
        //字体加粗
        font.setBold(true);
        //设置字体名字
        font.setFontName("Courier New");
        //设置样式;
        HSSFCellStyle style = workbook.createCellStyle();
        //设置底边框;
        style.setBorderBottom(BorderStyle.THIN);
        //设置底边框颜色;
        style.setBottomBorderColor((short) 0);
        //设置左边框;
        style.setBorderLeft(BorderStyle.THIN);
        //设置左边框颜色;
        style.setLeftBorderColor((short) 0);
        //设置右边框;
        style.setBorderRight(BorderStyle.THIN);
        //设置右边框颜色;
        style.setRightBorderColor((short) 0);
        //设置顶边框;
        style.setBorderTop(BorderStyle.THIN);
        //设置顶边框颜色;
        style.setTopBorderColor((short) 0);
        //在样式中应用设置的字体;
        style.setFont(font);
        //设置自动换行;
        style.setWrapText(false);
        //设置水平对齐的样式为居中对齐;
        style.setAlignment(HorizontalAlignment.CENTER);
        //设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        return style;
    }

    /**
     * 中英文数据信息单元格样式
     *
     * @param workbook
     * @return
     * @author lp
     * @date 2017年8月30日 上午11:31:19
     */
    public static HSSFCellStyle getDataStyle(HSSFWorkbook workbook) {
        // 设置字体
        HSSFFont font = workbook.createFont();
        //设置字体大小
        //font.setFontHeightInPoints((short)10);
        //字体加粗
        //font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        //设置字体名字
        font.setFontName("Courier New");
        //设置样式;
        HSSFCellStyle style = workbook.createCellStyle();
        //设置底边框;
        style.setBorderBottom(BorderStyle.THIN);
        //设置底边框颜色;
        style.setBottomBorderColor((short) 0);
        //设置左边框;
        style.setBorderLeft(BorderStyle.THIN);
        //设置左边框颜色;
        style.setLeftBorderColor((short) 0);
        //设置右边框;
        style.setBorderRight(BorderStyle.THIN);
        //设置右边框颜色;
        style.setRightBorderColor((short) 0);
        //设置顶边框;
        style.setBorderTop(BorderStyle.THIN);
        //设置顶边框颜色;
        style.setTopBorderColor((short) 0);
        //在样式用应用设置的字体;
        style.setFont(font);
        //设置自动换行;
        style.setWrapText(false);
        //设置水平对齐的样式为左对齐;
        style.setAlignment(HorizontalAlignment.LEFT);
        //设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        return style;
    }

    /**
     * 整数数据信息单元格样式
     *
     * @param workbook
     * @return
     * @author lp
     * @date 2017年9月1日 上午11:16:11
     */
    public static HSSFCellStyle getNumStyle(HSSFWorkbook workbook) {
        // 设置字体
        HSSFFont font = workbook.createFont();
        //设置字体大小
        //font.setFontHeightInPoints((short)10);
        //字体加粗
        //font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        //设置字体名字
        font.setFontName("Courier New");
        //设置样式;
        HSSFCellStyle style = workbook.createCellStyle();
        //设置底边框;
        style.setBorderBottom(BorderStyle.THIN);
        //设置底边框颜色;
        style.setBottomBorderColor((short) 0);
        //设置左边框;
        style.setBorderLeft(BorderStyle.THIN);
        //设置左边框颜色;
        style.setLeftBorderColor((short) 0);
        //设置右边框;
        style.setBorderRight(BorderStyle.THIN);
        //设置右边框颜色;
        style.setRightBorderColor((short) 0);
        //设置顶边框;
        style.setBorderTop(BorderStyle.THIN);
        //设置顶边框颜色;
        style.setTopBorderColor((short) 0);
        //在样式用应用设置的字体;
        style.setFont(font);
        //设置自动换行;
        style.setWrapText(false);
        //设置水平对齐的样式为右对齐;
        style.setAlignment(HorizontalAlignment.RIGHT);
        //设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setDataFormat(HSSFDataFormat.getBuiltinFormat("0"));
        return style;
    }

    /**
     * 日期单元格样式
     *
     * @param workbook
     * @return
     * @author lp
     * @date 2017年9月13日 下午5:12:28
     */
    public static HSSFCellStyle getDateStyle(HSSFWorkbook workbook) {
        // 设置字体
        HSSFFont font = workbook.createFont();
        //设置字体大小
        //font.setFontHeightInPoints((short)10);
        //字体加粗
        //font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        //设置字体名字
        font.setFontName("Courier New");
        //设置样式;
        HSSFCellStyle style = workbook.createCellStyle();
        //设置字体
        style.setFont(font);
        //设置底边框;
        style.setBorderBottom(BorderStyle.THIN);
        //设置底边框颜色;
        style.setBottomBorderColor((short) 0);
        //设置左边框;
        style.setBorderLeft(BorderStyle.THIN);
        //设置左边框颜色;
        style.setLeftBorderColor((short) 0);
        //设置右边框;
        style.setBorderRight(BorderStyle.THIN);
        //设置右边框颜色;
        style.setRightBorderColor((short) 0);
        //设置顶边框;
        style.setBorderTop(BorderStyle.THIN);
        //设置顶边框颜色;
        style.setTopBorderColor((short) 0);

        HSSFDataFormat format = workbook.createDataFormat();
        style.setDataFormat(format.getFormat("yyyy/M/d"));
        return style;
    }

    /**
     * 货币单元格样式——人民币
     *
     * @param workbook
     * @return
     * @author lp
     * @date 2017年9月14日 下午4:56:30
     */
    public static HSSFCellStyle getCurrencyStyle(HSSFWorkbook workbook) {
        // 设置字体
        HSSFFont font = workbook.createFont();
        //设置字体大小
        //font.setFontHeightInPoints((short)10);
        //字体加粗
        //font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        //设置字体名字
        font.setFontName("Courier New");
        //设置样式;
        HSSFCellStyle style = workbook.createCellStyle();
        //设置字体
        style.setFont(font);
        //设置底边框;
        style.setBorderBottom(BorderStyle.THIN);
        //设置底边框颜色;
        style.setBottomBorderColor((short) 0);
        //设置左边框;
        style.setBorderLeft(BorderStyle.THIN);
        //设置左边框颜色;
        style.setLeftBorderColor((short) 0);
        //设置右边框;
        style.setBorderRight(BorderStyle.THIN);
        //设置右边框颜色;
        style.setRightBorderColor((short) 0);
        //设置顶边框;
        style.setBorderTop(BorderStyle.THIN);
        //设置顶边框颜色;
        style.setTopBorderColor((short) 0);
        HSSFDataFormat format = workbook.createDataFormat();
        style.setDataFormat(format.getFormat("¥#,##0.00"));
        return style;
    }

    /**
     * 小数单元格样式
     *
     * @param workbook
     * @return
     * @author lp
     * @date 2017年9月14日 下午4:56:30
     */
    public static HSSFCellStyle getDoubleStyle(HSSFWorkbook workbook) {
        // 设置字体
        HSSFFont font = workbook.createFont();
        //设置字体大小
        //font.setFontHeightInPoints((short)10);
        //字体加粗
        //font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        //设置字体名字
        font.setFontName("Courier New");
        //设置样式;
        HSSFCellStyle style = workbook.createCellStyle();
        //设置字体
        style.setFont(font);
        //设置底边框;
        style.setBorderBottom(BorderStyle.THIN);
        //设置底边框颜色;
        style.setBottomBorderColor((short) 0);
        //设置左边框;
        style.setBorderLeft(BorderStyle.THIN);
        //设置左边框颜色;
        style.setLeftBorderColor((short) 0);
        //设置右边框;
        style.setBorderRight(BorderStyle.THIN);
        //设置右边框颜色;
        style.setRightBorderColor((short) 0);
        //设置顶边框;
        style.setBorderTop(BorderStyle.THIN);
        //设置顶边框颜色;
        style.setTopBorderColor((short) 0);
        style.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
        return style;
    }

    /**
     * 设置文本单元格样式和value
     *
     * @param cell
     * @param cellStyle
     * @param value
     * @author lp
     * @date 2017年8月30日 上午11:30:16
     */
    public static void setCell(HSSFCell cell, HSSFCellStyle cellStyle, String value) {
        cell.setCellStyle(cellStyle);
        cell.setCellValue(value);
    }

    /**
     * 设置货币样式和value
     *
     * @param cell
     * @param cellStyle
     * @param value
     * @author lp
     * @date 2017年9月15日 上午10:12:13
     */
    public static void setCurrencyCell(HSSFCell cell, HSSFCellStyle cellStyle, Double value) {
        cell.setCellType(CellType.NUMERIC);
        cell.setCellStyle(cellStyle);
        cell.setCellValue(value);
    }

    /**
     * 设置日期样式和value
     *
     * @param cell
     * @param cellStyle
     * @param value
     * @throws Exception
     * @author lp
     * @date 2017年9月15日 上午10:12:41
     */
    public static void setDateCell(HSSFCell cell, HSSFCellStyle cellStyle,
                                   Date value) throws Exception {
        if (value != null) {
            value = TimeUtil.datetimeFormat.get()
                    .parse(TimeUtil.datetimeFormat.get().format(value));
            cell.setCellStyle(cellStyle);
            cell.setCellValue(value);
        } else {
            cell.setCellStyle(cellStyle);
            cell.setCellValue("");
        }

    }

    /**
     * 设置整数样式和value
     *
     * @param cell
     * @param cellStyle
     * @param value
     * @throws Exception
     * @author lp
     * @date 2017年10月9日 上午11:57:03
     */
    public static void setNumCell(HSSFCell cell, HSSFCellStyle cellStyle,
                                  Integer value) throws Exception {
        value = value == null ? 0 : value;
        cell.setCellStyle(cellStyle);
        cell.setCellValue(value);
    }

    /**
     * 设置小数样式和value
     *
     * @param cell
     * @param cellStyle
     * @param value
     * @throws Exception
     * @author lp
     * @date 2017年10月9日 上午11:57:03
     */
    public static void setDoubleCell(HSSFCell cell, HSSFCellStyle cellStyle,
                                     Double value) throws Exception {
        cell.setCellStyle(cellStyle);
        cell.setCellValue(value);
    }

    /**
     * 将BigDecimal类型转化为Double，默认值0.00
     *
     * @param cost
     * @return
     * @author lp
     * @date 2017年8月30日 上午11:49:59
     */
    private static Double costFormat(BigDecimal cost) {
        Double result = 0.00;
        if (cost == null || cost.doubleValue() == 0.00) {
            result = 0.00;
        } else {
            result = cost.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        return result;
    }

    /**
     * 格式化日期
     *
     * @param date
     * @return
     * @author lp
     * @date 2017年9月1日 上午11:48:45
     */
    public static String dateOfFormat(Date date) {
        String result = "";
        if (date != null) {
            result = TimeUtil.datetimeFormat.get().format(date);
        }
        return result;
    }

    /**
     * 将字符串日期数组格式化为日期
     *
     * @param str
     * @return
     * @author lp
     * @date 2017年9月1日 上午11:51:31
     */
    public static String strDateFormat(String str) {

        String result;
        try {
            if (str != null && !str.equals("")) {
                String[] strArray = str.split(",");
                result = TimeUtil.datetimeFormat.get()
                        .format(TimeUtil.datetimeFormat.get().parse(strArray[0]));
            } else {
                result = "";
            }

        } catch (ParseException e) {
            result = "";
        }
        return result;
    }

    /**
     * 将字符串日期格式化为日期
     *
     * @param str
     * @return
     * @author lp
     * @date 2017年9月1日 下午12:33:03
     */
    public static Date parseDate(String str) {
        Date result = null;
        try {
            if (str != null && !str.equals("")) {
                result = TimeUtil.datetimeFormat.get().parse(str);
            } else {
                result = null;
            }
        } catch (ParseException e) {
            result = null;
        }
        return result;
    }

    /**
     * 将BigDecimal 转为 Double
     *
     * @param value
     * @return
     * @author lp
     * @date 2017年10月9日 下午12:17:24
     */
    public static Double parseDecimal(BigDecimal value) {
        Double result = null;
        if (value != null) {
            result = value.doubleValue();
        } else {
            result = 0.00;
        }
        return result;
    }

    /**
     * 导出excel
     *
     * @param list      待导出集合
     * @param title     excel标题
     * @param rowName   excel表头
     * @param fieldName 字段名称
     * @param response
     * @throws Exception
     */
    public <T> void exportExcel(List<T> list, String title, String[] rowName, String[] fieldName,
                                HttpServletResponse response) throws Exception {
        HSSFWorkbook workbook = new HSSFWorkbook(); //创建一个工作簿
        int rowTotal = 60000;
        int sheetCount = list.size() / rowTotal + 1;
        for (int s = 0; s < sheetCount; s++) {
            String sheetName = "sheet" + (s + 1);
            HSSFSheet sheet = workbook.createSheet(sheetName); //创建一个工作表
            sheet.setDefaultColumnWidth(15); //设置表格默认列宽度为15个字节

            //创建标题行表格
            HSSFRow rowTitle = sheet.createRow(0); //创建第一行为标题
            HSSFCell cellTitle = rowTitle.createCell(0);

            //设置标题样式
            HSSFCellStyle colunmTitleStyle = getColunmTitleStyle(workbook);
            //设置中英文内容样式
            HSSFCellStyle dataStyle = getDataStyle(workbook);
            //合并单元格
            CellRangeAddress region = new CellRangeAddress(0, 0, 0,
                    (rowName.length - 1));
            sheet.addMergedRegion(region);
            cellTitle.setCellStyle(colunmTitleStyle);
            cellTitle.setCellValue(title);

            //定义所需列数
            int columnNum = rowName.length;
            //在索引2的位置创建行(最顶端的行开始的第二行)
            HSSFRow rowRowName = sheet.createRow(2); //创建excel中的第三行(索引第二行)为列头
            // 将列头设置到sheet的单元格中
            for (int n = 0; n < columnNum; n++) {
                HSSFCell cellRowName = rowRowName.createCell(n); //创建列头对应个数的单元格
                cellRowName.setCellType(CellType.STRING); //设置列头单元格的数据类型
                HSSFRichTextString text = new HSSFRichTextString(rowName[n]);
                cellRowName.setCellValue(text); //设置列头单元格的值
                cellRowName.setCellStyle(colunmTitleStyle); //设置列头单元格样式
            }

            HSSFCell cell = null; //设置单元格的数据类型
            //将查询出的数据设置到sheet对应的单元格中
            int rowCount = s == sheetCount - 1 ? list.size() - s * rowTotal : rowTotal;
            for (int i = 0; i < rowCount; i++) {
                T entity = list.get(i + s * rowTotal);
                HSSFRow row = sheet.createRow(i + 3);
                //第一列为行号
                cell = row.createCell(0, CellType.NUMERIC);
                setCell(cell, dataStyle, Integer.toString(i + s * rowTotal + 1));
                for (int j = 1; j < fieldName.length; j++) {
                    cell = row.createCell(j, CellType.STRING);
                    Method method = entity.getClass() == null ? null
                            : entity.getClass().getMethod("get" + StrUtil.upperFirst(fieldName[j]));
                    Object data = method == null ? null : method.invoke(entity);
                    setCell(cell, dataStyle, data == null ? "" : data.toString());
                }
            }

            //让列宽随着导出的列长自动适应
            for (int colNum = 0; colNum < columnNum; colNum++) {
                int columnWidth = sheet.getColumnWidth(colNum) / 256;
                for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
                    HSSFRow currentRow;
                    //当前行未被使用过
                    if (sheet.getRow(rowNum) == null) {
                        currentRow = sheet.createRow(rowNum);
                    } else {
                        currentRow = sheet.getRow(rowNum);
                    }
                    if (currentRow.getCell(colNum) != null) {
                        HSSFCell currentCell = currentRow.getCell(colNum);
                        if (currentCell.getCellTypeEnum() == CellType.STRING) {
                            int length = currentCell.getStringCellValue().getBytes().length;
                            if (columnWidth < length) {
                                columnWidth = length;
                            }
                        }
                    }
                }
                if (colNum == 0) {
                    sheet.setColumnWidth(colNum, (columnWidth - 2) * 256);
                } else {
                    sheet.setColumnWidth(colNum, (columnWidth + 4) * 256);
                }
            }
        }

        if (workbook != null) {
            OutputStream out = null;
            try {
                Date date = new Date();
                SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
                String filename = title + "_" + df.format(date); //导出excel名
                System.out.println("------excel" + filename + "------开始导出------");
                response.setContentType("application/octet-stream");
                response.setHeader("Content-Disposition",
                        "attachment;filename=" + URLEncoder.encode(filename, "UTF-8")
                                + ".xls");
                out = response.getOutputStream();
                workbook.write(out);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (out != null) {
                    out.flush();
                    out.close();
                }
            }
        }
    }

    /**
     * 导出excel
     *
     * @param list     待导出集合
     * @param title    标题
     * @param rowName  excel表头
     * @param header   表字段的数组，例如id，name等
     * @param response
     * @throws Exception
     */
    public <T> void customExport(List<Map<String, Object>> list, String title, String[] rowName,
                                 String[] header, HttpServletResponse response) throws Exception {
        HSSFWorkbook workbook = new HSSFWorkbook(); //创建一个工作簿
        int rowTotal = 60000;
        int sheetCount = list.size() / rowTotal + 1;
        for (int s = 0; s < sheetCount; s++) {
            String sheetName = "sheet" + (s + 1);
            HSSFSheet sheet = workbook.createSheet(sheetName); //创建一个工作表
            sheet.setDefaultColumnWidth(15); //设置表格默认列宽度为15个字节

            //创建标题行表格
            HSSFRow rowTitle = sheet.createRow(0); //创建第一行为标题
            HSSFCell cellTitle = rowTitle.createCell(0);

            //设置标题样式
            HSSFCellStyle colunmTitleStyle = getColunmTitleStyle(workbook);
            //设置中英文内容样式
            HSSFCellStyle dataStyle = getDataStyle(workbook);
            //合并单元格
            CellRangeAddress region = new CellRangeAddress(0, 0, 0,
                    rowName.length - 1);
            sheet.addMergedRegion(region);
            cellTitle.setCellStyle(colunmTitleStyle);
            cellTitle.setCellValue(title);

            //定义所需列数
            int columnNum = rowName.length;
            //在索引2的位置创建行(最顶端的行开始的第二行)
            HSSFRow rowRowName = sheet.createRow(2); //创建excel中的第三行(索引第二行)为列头
            // 将列头设置到sheet的单元格中
            for (int n = 0; n < columnNum; n++) {
                HSSFCell cellRowName = rowRowName.createCell(n); //创建列头对应个数的单元格
                cellRowName.setCellType(CellType.STRING); //设置列头单元格的数据类型
                HSSFRichTextString text = new HSSFRichTextString(rowName[n]);
                cellRowName.setCellValue(text); //设置列头单元格的值
                cellRowName.setCellStyle(colunmTitleStyle); //设置列头单元格样式
            }

            HSSFCell cell = null; //设置单元格的数据类型
            int rowCount = s == sheetCount - 1 ? list.size() - s * rowTotal : rowTotal;
            for (int i = 0; i < rowCount; i++) {
                Map<String, Object> map = list.get(i + s * rowTotal);
                HSSFRow row = sheet.createRow(i + 3);
                //第一列为行号
                cell = row.createCell(0, CellType.NUMERIC);
                setCell(cell, dataStyle, Integer.toString(i + s * rowTotal + 1));
                for (int j = 1; j < header.length; j++) {

                    cell = row.createCell(j, CellType.STRING);

                    setCell(cell, dataStyle,
                            map.get(header[j]) == null ? "" : map.get(header[j]).toString());
                }
            }

            //让列宽随着导出的列长自动适应
            for (int colNum = 0; colNum < columnNum; colNum++) {
                int columnWidth = sheet.getColumnWidth(colNum) / 256;
                for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
                    HSSFRow currentRow;
                    //当前行未被使用过
                    if (sheet.getRow(rowNum) == null) {
                        currentRow = sheet.createRow(rowNum);
                    } else {
                        currentRow = sheet.getRow(rowNum);
                    }
                    if (currentRow.getCell(colNum) != null) {
                        HSSFCell currentCell = currentRow.getCell(colNum);
                        if (currentCell.getCellTypeEnum() == CellType.STRING) {
                            int length = currentCell.getStringCellValue().getBytes().length;
                            if (columnWidth < length) {
                                columnWidth = length;
                            }
                        }
                    }
                }
                if (colNum == 0) {
                    sheet.setColumnWidth(colNum, (columnWidth - 2) * 256);
                } else {
                    sheet.setColumnWidth(colNum, (columnWidth + 4) * 256);
                }
            }
        }

        if (workbook != null) {
            OutputStream out = null;
            try {
                Date date = new Date();
                SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
                String filename = title + "_" + df.format(date); //导出excel名
                response.setContentType("application/octet-stream");
                response.setHeader("Content-Disposition",
                        "attachment;filename=" + new String(filename.getBytes("UTF-8"), "iso-8859-1")
                                + ".xls");
                out = response.getOutputStream();
                workbook.write(out);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (out != null) {
                    out.flush();
                    out.close();
                }
            }
        }
    }
}
