package com.actitimeautomation.TestNGTests;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelHandling5TestNG {
    public Workbook getWorkBook(String filePath) {
        Workbook workbook = null;
        try {
            String fileExtension = filePath.substring(filePath.lastIndexOf(".") + 1);
            System.out.println("The file extension is: " + fileExtension);

            FileInputStream fis = new FileInputStream(filePath);

            if (fileExtension.equals("xlsx")) {
                workbook = new XSSFWorkbook(fis);
            } else if (fileExtension.equals("xls")) {
                workbook = new HSSFWorkbook(fis);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return workbook;
    }

    public void writeExcelData(String filePath, String sheetName, Object[][] data) throws Exception {
        Workbook workbook = getWorkBook(filePath);
        Sheet sheet;

        if (workbook.getSheet(sheetName) != null) {
            sheet = workbook.getSheet(sheetName);
        } else {
            sheet = workbook.createSheet(sheetName);
        }

        int rowCount = sheet.getPhysicalNumberOfRows();
        for (int i = 0; i < data.length; i++) {
            Row row = sheet.createRow(rowCount++);
            for (int j = 0; j < data[i].length; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(data[i][j].toString());
            }
        }

        FileOutputStream fos = new FileOutputStream(filePath);
        workbook.write(fos);
        workbook.close();
        fos.close();
    }

    @Test
    public void ExcelHandling5Test() throws Exception {
        ExcelHandling5TestNG excelHandling5 = new ExcelHandling5TestNG();
        String filePath = "C:\\SHAHJADE SHAIKH\\CS (Selenium)\\Files\\Credentials.xlsx";
        Object[][] data = new Object[][]{
                {"Customer", "Project"},
                {"Customer1", "Project1"},
                {"Customer2", "Project2"}
        };
        excelHandling5.writeExcelData(filePath, "CustomersProjects", data);
    }
}