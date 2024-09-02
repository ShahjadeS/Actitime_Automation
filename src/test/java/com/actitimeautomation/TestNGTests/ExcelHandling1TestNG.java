package com.actitimeautomation.TestNGTests;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelHandling1TestNG {
    @Test
    public void ExcelHandling1Test() throws Exception {
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