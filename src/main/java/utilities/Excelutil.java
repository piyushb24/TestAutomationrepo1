package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutil {

    private Workbook workbook;
    private Sheet sheet;

    // Constructor loads Excel file and sheet
    public Excelutil(String filePath, String sheetName) {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                throw new RuntimeException("Sheet not found: " + sheetName);
            }

        } catch (IOException e) {
            throw new RuntimeException("Failed to load Excel file: " + e.getMessage(), e);
        }
    }

    // Handles STRING, NUMERIC, DATE, BOOLEAN, FORMULA
    public String getCellData(int row, int col) {
        DataFormatter formatter = new DataFormatter();
        Cell cell = sheet.getRow(row).getCell(col);

        if (cell == null) {
            return "";
        }

        return formatter.formatCellValue(cell);
    }

    // Optional: Close workbook to free resources
    public void closeWorkbook() {
        try {
            if (workbook != null) {
                workbook.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
