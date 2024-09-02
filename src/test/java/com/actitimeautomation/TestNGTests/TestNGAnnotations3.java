package com.actitimeautomation.TestNGTests;

import org.testng.annotations.*;

public class TestNGAnnotations3 {
    //Non-Static Block
    {
        System.out.println("This is a Non-Static Block");
    }

    //Constructor Block
    public TestNGAnnotations3() {
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

    //On the basis of Priority, DependsOnMethods & enabled attributes
    @Test(priority = 1)
    public void login() {
        System.out.println("This is a login method from TestNGAnnotations class");
    }

    @Test(priority = 1, dependsOnMethods = "login")
    public void verifyTask() throws Exception {
        System.out.println("This is a verifyTask method");
        throw new Exception("This is Exception");
    }

    @Test(priority = 2, dependsOnMethods = "login", enabled = false)
    public void logout() {
        System.out.println("This is a logout method");
    }

}