package com.actitimeautomation.TestNGTests;

import org.testng.annotations.*;

public class TestNGAnnotations2 {
    //Non-Static Block
    {
        System.out.println("This is a Non-Static Block");
    }

    //Constructor Block
    public TestNGAnnotations2() {
        System.out.println("This is a constructor of TestNGAnnotations class");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("This is a BeforeClass Annotation");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("This is a AfterClass Annotation");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("This is a BeforeMethod Annotation");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("This is a AfterMethod Annotation");
    }

    @Test
    public void verifyLogin()
    {
        System.out.println("This is verify login method");
    }

    //On the basis of Priority & DependsOnMethods attributes
    @Test(priority = 1)
    public void login() {
        System.out.println("This is a login method");
    }

    @Test(priority = 1, dependsOnMethods = "login")
    public void verify() {
        System.out.println("This is a verify method");
    }

    @Test(priority = 2, dependsOnMethods = "verify")
    public void logout() {
        System.out.println("This is a logout method");
    }

}