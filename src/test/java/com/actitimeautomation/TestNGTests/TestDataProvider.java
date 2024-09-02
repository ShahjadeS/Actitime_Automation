package com.actitimeautomation.TestNGTests;

import org.testng.annotations.DataProvider;

public class TestDataProvider
{
    @DataProvider
    public String[][] getSampleData()
    {
        String[][] obj = new String[][]
                {
                        {"Pune", "Mumbai", "Nagpur"},
                        {"Nashik", "Aurangabad", ""}
                };
        return obj;
    }
}