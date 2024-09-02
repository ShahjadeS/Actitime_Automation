package com.actitimeautomation.TestNGTests;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RegressionTestGroup {
    @BeforeGroups(groups = {"regression", "sanity"})
    public void beforeGroup() {
        System.out.println("RegressionBeforeGroup");
    }

    @AfterGroups(groups = {"regression", "sanity"})
    public void afterGroup() {
        System.out.println("RegressionAfterGroup");
    }

    @Test(groups = "regression")
    public void test1() {
        System.out.println("RegressionTest1");
    }

    @Test(groups = "regression")
    public void test2() {
        System.out.println("RegressionTest2");
    }

    @Test(groups = "sanity")
    public void test3() {
        System.out.println("RegressionTest3");
    }

    @Test(groups = "sanity")
    public void test4() {
        System.out.println("RegressionTest4");
    }

    @Test(groups = {"regression", "sanity"})
    public void test5() {
        System.out.println("RegressionTest5");
    }

    @Parameters({"browser", "username", "password"})
    @Test
    public void regressionTest1(String browser, String username, String password)
    {
        System.out.println(browser);
        System.out.println(username);
        System.out.println(password);
    }
}