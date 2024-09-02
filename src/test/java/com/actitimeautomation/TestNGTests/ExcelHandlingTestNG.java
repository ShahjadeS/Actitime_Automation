package com.actitimeautomation.TestNGTests;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelHandlingTestNG {
    @Test
    public void ExcelHandlingTest() throws IOException {

        Workbook workbook = null;

        //Stored the path in the varibale
        String filePath = "C:\\SHAHJADE SHAIKH\\CS (Selenium)\\Files\\Credentials.xlsx";

        //Print the extenstion of the file
        String fileExtension = filePath.substring(filePath.indexOf(".") + 1);
        System.out.println("The file extension is: " + fileExtension);

        //Access the particular file
        FileInputStream fis = new FileInputStream(filePath);

        //Based on the extension of file, access the workbook of Excel file
        if (fileExtension.equals("xlsx")) {
            workbook = new XSSFWorkbook(fis);
        } else if (fileExtension.equals("xls")) {
            workbook = new HSSFWorkbook(fis);
        }
//        workbook = new XSSFWorkbook(fis);

        //Get the control of the sheet using Workbook reference
        Sheet sheet = workbook.getSheet("Credentials_Data");

        //Get the total number of rows from the file using Sheet reference
        int totalRows = sheet.getPhysicalNumberOfRows();

        //Get total columns from 0th row usinf Sheet reference
        int totalColumns = sheet.getRow(0).getPhysicalNumberOfCells();

        for (int i = 1; i <= totalRows - 1; i++) {
            Row row = sheet.getRow(i);

            for (int j = 0; i <= totalColumns - 1; i++) {
                Cell cell = row.getCell(j);

                //Check the type of cell
                CellType cellType = cell.getCellType();

                Object value = null;

                //Get the value from cell based on the type
//                if (cellType.equals(CellType.NUMERIC)) {
//                    value = cell.getStringCellValue();
//                } else if (cellType.equals(CellType.STRING)) {
//                    value = cell.getStringCellValue();
//                } else if (cellType.equals(CellType.BOOLEAN)) {
//                    value = cell.getStringCellValue();
//                } else {
//                    value = " ";
//                }

                switch (cell.getCellType()) {
                    case NUMERIC:
                        value = cell.getNumericCellValue();
                        break;
                    case STRING:
                        value = cell.getStringCellValue();
                        break;
                    case BOOLEAN:
                        value = cell.getBooleanCellValue();
                        break;
                    default:
                        value = " ";
                }
                System.out.print(value + " ");
            }
            System.out.println();
        }
        //Close the Workbook instance
        workbook.close();

        //Close the FileInputStream instance
        fis.close();
    }
}