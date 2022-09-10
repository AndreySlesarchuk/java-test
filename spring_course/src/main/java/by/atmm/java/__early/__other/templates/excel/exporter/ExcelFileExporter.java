package by.atmm.java.__early.__other.templates.excel.exporter;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @author Andrey Slesarchuk
 * @date 2022-09-09
 *
 * Excel File Exporter
 */
public class ExcelFileExporter {

    public void exportExcelFile(List<String[]> lists, String[] headers, String fileName) {
        // create a new Workbook
        Workbook workbook = new XSSFWorkbook();

        // Create a new Sheet named "Contacts"
        Sheet sheet = workbook.createSheet("Contacts");

        // Create header row
        createHeaderRow(workbook, sheet, headers);

        // Create rows
        for (int i = 0; i < lists.size(); i++) {
            // row index equals i + 1 because the first row of Excel file is the header row.
            int rowIndex = i + 1;
            createNewRow(workbook, sheet, rowIndex, lists.get(i));
        }

        // Adjusts 3 columns to set the width to fit the contents.
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        sheet.createFreezePane(0,1);

        // Write to file
        try (OutputStream outputStream = new FileOutputStream(fileName)) {
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Create header row
     *
     * @param workbook the Workbook object
     * @param sheet    the Sheet object
     * @param headers  the headers text
     */
    private void createHeaderRow(Workbook workbook, Sheet sheet, String[] headers) {
        Row headerRow = sheet.createRow(0);
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.index);
        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerCellStyle.setBorderTop(BorderStyle.THIN);
        headerCellStyle.setTopBorderColor(IndexedColors.BLACK.index);
        headerCellStyle.setBorderRight(BorderStyle.THIN);
        headerCellStyle.setRightBorderColor(IndexedColors.BLACK.index);
        headerCellStyle.setBorderBottom(BorderStyle.THIN);
        headerCellStyle.setBottomBorderColor(IndexedColors.BLACK.index);
        headerCellStyle.setBorderLeft(BorderStyle.THIN);
        headerCellStyle.setLeftBorderColor(IndexedColors.BLACK.index);

        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerCellStyle);
        }
    }

    /**
     * Create a new row
     *
     * @param workbook the Workbook object
     * @param sheet    the Sheet object
     * @param rowIndex the index of row to create
     * @param data     the Contact object which represent information to write to row.
     */
    private void createNewRow(Workbook workbook, Sheet sheet, int rowIndex, String[] data) {
        Row row = sheet.createRow(rowIndex);
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setTopBorderColor(IndexedColors.BLACK.index);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setRightBorderColor(IndexedColors.BLACK.index);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBottomBorderColor(IndexedColors.BLACK.index);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setLeftBorderColor(IndexedColors.BLACK.index);

        Cell cell = null;
        for (int i = 0; i < data.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(data[i]);
            cell.setCellStyle(cellStyle);
        }
    }

}