package com.actitimeautomation.TestNGTests;

import org.testng.annotations.*;

public class TestNGAnnotations1 {
    //Non-Static Block
    {
        System.out.println("This is a Non-Static Block");
    }

    //Constructor Block
    public TestNGAnnotations1() {
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

    //On the basis of Priority attributes
    @Test(priority = 1)
    public void test1() {
        System.out.println("This is a test1 method");
    }

    @Test(priority = 3)
    public void test2() {
        System.out.println("This is a test2 method");
    }

    @Test(priority = 2)
    public void test3() {
        System.out.println("This is a test3 method");
    }

}