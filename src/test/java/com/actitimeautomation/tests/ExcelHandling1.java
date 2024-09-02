package com.actitimeautomation.tests;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelHandling1 {
    public static void main(String[] args) throws Exception {
//        String filePath = "C:\\SHAHJADE SHAIKH\\CS (Selenium)\\Files\\Credentials.xlsx";
//        FileInputStream fis = new FileInputStream(filePath);

        File file = new File("C:\\SHAHJADE SHAIKH\\CS (Selenium)\\Files\\Credentials.xlsx");
        FileInputStream fis = new FileInputStream(file);

        Sheet sheet = WorkbookFactory.create(fis).getSheet("Credentials_Data");

        int lastRowIndex = sheet.getLastRowNum();
        int lastCellIndex = sheet.getRow(0).getLastCellNum();

        for(int i = 1; i<=lastRowIndex; i++)
        {
            for(int j = 0; j<=lastCellIndex-1; j++)
            {
                Cell data = sheet.getRow(i).getCell(j);
                System.out.print(data+"  ");
            }
            System.out.println();
        }
    }
}