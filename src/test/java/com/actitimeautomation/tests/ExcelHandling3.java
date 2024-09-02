package com.actitimeautomation.tests;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelHandling3
{
    /*
    * Get the access of workbook based on the provided file path
    * @Param : filePath
    * */
    public Workbook getWorkBook(String filePath)
    {
        Workbook workbook = null;
        try
        {
            // Print the extension of the file
            String fileExtension = filePath.substring(filePath.lastIndexOf(".") + 1);
            System.out.println("The file extension is: " + fileExtension);

            // Access the particular file
            FileInputStream fis = new FileInputStream(filePath);

            // Based on the extension of file, access the workbook of Excel file
            if (fileExtension.equals("xlsx")) {
                workbook = new XSSFWorkbook(fis);
            } else if (fileExtension.equals("xls")) {
                workbook = new HSSFWorkbook(fis);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return workbook;
    }

    //Get the access of the sheet with the reference of workbook
    public Object[][] getExcelData(String filePath, String sheetName) throws Exception
    {
        //Get the control of workbook using filePath
        Workbook workbook = getWorkBook(filePath);

        //Get the control of Sheet
        Sheet sheet = workbook.getSheet(sheetName);

        //Get total number of rows
        int totalRows = sheet.getPhysicalNumberOfRows();

        //Get total number of columns from 0th row
        int totalColumns = sheet.getRow(0).getPhysicalNumberOfCells();

        //Implement Two-Dimentional Array
        Object[][] testData = new Object[totalRows][totalColumns];

        for (int i = 1; i < totalRows; i++)
        {
            Row row = sheet.getRow(i);

            for (int j = 0; j < totalColumns; j++)
            {
                Cell cell = row.getCell(j);

                // Check the type of cell and get the value accordingly
                Object value = null;
                switch (cell.getCellType())
                {
                    case NUMERIC:
                        value = cell.getStringCellValue();
                        break;
                    case STRING:
                        value = cell.getStringCellValue();
                        break;
                    case BOOLEAN:
                        value = cell.getStringCellValue();
                        break;
                    default:
                        value = " ";
                }
                testData[i][j] = value;

//                CellType cellType = null;
//                if (cellType.equals(CellType.NUMERIC)) {
//                    value = cell.getStringCellValue();
//                } else if (cellType.equals(CellType.STRING)) {
//                    value = cell.getStringCellValue();
//                } else if (cellType.equals(CellType.BOOLEAN)) {
//                    value = cell.getStringCellValue();
//                } else {
//                    value = " ";
//                }

                System.out.print(value + " ");
            }
            System.out.println();
        }
        System.out.println(testData);
        // Close the Workbook instance
        workbook.close();
        return testData;
    }

    public void writeExcelData(String filePath, String sheetName) throws Exception
    {
        // Sample data to write using 2-Dimensional Array
        String[][] data = {
                {"Shahjade", "Shaikh"},
                {"Masoom", "Shaikh"},
                {"Vikas", "Jain"},
                {"Vipul", "Jain"},
                {"Uday", "Kadam"}
        };
        //Get the control of workbook using filePath
        Workbook workbook = getWorkBook(filePath);

        //Create sheet from workbook reference
        Sheet sheet = workbook.createSheet(sheetName);

        // Iterate over the data array to create rows and cells
        for (int i = 0; i < data.length; i++) {
            Row row = sheet.createRow(i);
            for (int j = 0; j < data[i].length; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(data[i][j]);
            }
        }
        System.out.println("Data is inserted successfully...!");

//        //Create a row using sheet reference
//        Row row = sheet.createRow(0);
//
//        //Create a cell using row reference
//        Cell cell = row.createCell(0);
//
//        //Set the value in the cell
//        cell.setCellValue(10);
//        System.out.println("Data is inserted...!");

        //Create object of FileOutputStream to write or save the file
        FileOutputStream fos = new FileOutputStream(filePath);

        //write or save the data workbook using FileOutputStream reference
        workbook.write(fos);

        //Close the workbook
        workbook.close();

        //Close the FileOutputStream
        fos.close();
    }

    public static void main(String[] args) throws Exception
    {
        ExcelHandling3 excelHandling3 = new ExcelHandling3();
        String filePath = "C:\\SHAHJADE SHAIKH\\CS (Selenium)\\Files\\Credentials.xlsx";
        excelHandling3.writeExcelData(filePath, "Test4");
    }
}