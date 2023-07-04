package by.atmm.java.__tasks.__topics.templates.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Logger;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Created by Slesarchuk on 10/19/2020.
 */

public class ExcelReader {

  static Logger log = Logger.getLogger(String.valueOf(ExcelReader.class));

  public static void main(String[] args) throws IOException {
    ExcelReader excelReader = new ExcelReader();
    excelReader.read("d:/test/test.xlsx");

  }

  public void read(String filename) throws IOException {
    Workbook workbook = loadWorkbook(filename);
    Sheet sheet = workbook.getSheetAt(0);
    Iterator<Row> rowIterator = sheet.iterator(); // sheet.rowIterator(); --
                                                  // also works well
    while (rowIterator.hasNext()) {
      Row row = rowIterator.next();
      Iterator<Cell> cellIterator = row.iterator(); // row.cellIterator();--
                                                    // also works well
      while (cellIterator.hasNext()) {
        Cell cell = cellIterator.next();
        log.info(cell.getStringCellValue() + "\t");
      }
      log.info("");
    }
  }

  private Workbook loadWorkbook(String filename) throws IOException {
    String extension = filename.substring(filename.lastIndexOf(".") + 1).toLowerCase();
    FileInputStream file = new FileInputStream(new File(filename));
    switch (extension) {
      case "xls":
        // old format
        return new HSSFWorkbook(file);
      case "xlsx":
        // new format
        return new XSSFWorkbook(file);
      default:
        throw new RuntimeException("Unknown Excel file extension: " + extension);
    }
  }

}
