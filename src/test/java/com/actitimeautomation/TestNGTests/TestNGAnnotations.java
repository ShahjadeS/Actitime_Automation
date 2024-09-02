package com.actitimeautomation.TestNGTests;

import org.testng.annotations.*;

public class TestNGAnnotations {
    //Non-Static Block
    {
        System.out.println("This is a Non-Static Block");
    }

    //Constructor Block
    public TestNGAnnotations() {
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

    @BeforeTest
    public void beforeTest() {
        System.out.println("This is BeforeTest method");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("This is AfterTest method");
    }

    @Test
    public void test1() {
        System.out.println("This is a test1 method");
    }

    @Test
    public void test2() {
        System.out.println("This is a test1 method");
    }

    @Test
    public void test3() {
        System.out.println("This is a test1 method");
    }

}