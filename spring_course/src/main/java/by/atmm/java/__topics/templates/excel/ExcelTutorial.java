package by.atmm.java.__topics.templates.excel;
import java.io.File;
import java.io.OutputStream;
import java.nio.file.Files;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

/**
 * @author Andrey Slesarchuk
 * @date 2022-09-09
 */

public class ExcelTutorial {

    public static void main(String[] args) throws Exception {
        ExcelTutorial excelTutorial = new ExcelTutorial();
        excelTutorial.createEmployeeSheet();
    }

    private void createEmployeeSheet() throws Exception {
        try (Workbook wb = new HSSFWorkbook()) {
            Sheet sheet = wb.createSheet("Building#1");
            //Create table header
            Row headerRow = sheet.createRow(0); //First row - Heading
            headerRow.createCell(0).setCellValue("Employee No.");
            headerRow.createCell(1).setCellValue("Name");
            headerRow.createCell(2).setCellValue("Department");
            headerRow.createCell(3, CellType.BOOLEAN).setCellValue("Promoted");
            applyStyleForRow(headerRow);
            //Add first employee
            Row firstEmployee = sheet.createRow(1); //Second row
            firstEmployee.createCell(0).setCellValue(1); //Giving numeric value to cell
            firstEmployee.createCell(1).setCellValue("Genuine Coder");
            firstEmployee.createCell(2).setCellValue("IT");
            firstEmployee.createCell(3).setCellValue(false); //Giving a boolean value to the cell
            //Add second employee
            Row secondEmployee = sheet.createRow(2); //Third row
            secondEmployee.createCell(0).setCellValue(2);
            secondEmployee.createCell(1).setCellValue("Anya");
            secondEmployee.createCell(2).setCellValue("IT");
            secondEmployee.createCell(3).setCellValue(true); //Giving a boolean value to the cell

            //Write workbook into file
            try (OutputStream fileOut = Files.newOutputStream(new File("employee_data.xls").toPath())) {
                wb.write(fileOut);
            }
        }
    }

    private void applyStyleForRow(Row row) {
        //Create new style for the row
        CellStyle cellStyle = row.getSheet().getWorkbook().createCellStyle();
        //Configure single solid color fill
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        //Set font color
        cellStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
        //Set background color
        cellStyle.setFillBackgroundColor(IndexedColors.WHITE.getIndex());
        //Apply style for each cell
        row.forEach(cell -> cell.setCellStyle(cellStyle));
    }
}