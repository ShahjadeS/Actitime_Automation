package com.actitimeautomation.TestNGTests;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class SanityTestGroup {
    @BeforeGroups(groups = {"regression", "sanity"})
    public void beforeGroup() {
        System.out.println("SanityBeforeGroup");
    }

    @AfterGroups(groups = {"regression", "sanity"})
    public void afterGroup() {
        System.out.println("SanityAfterGroup");
    }

    @Test(groups = "regression")
    public void test1() {
        System.out.println("SanityTest1");
    }

    @Test(groups = "regression")
    public void test2() {
        System.out.println("SanityTest2");
    }

    @Test(groups = "sanity")
    public void test3() {
        System.out.println("SanityTest3");
    }

    @Test(groups = "sanity")
    public void test4() {
        System.out.println("SanityTest4");
    }

    @Test(groups = {"regression", "sanity"})
    public void test5() {
        System.out.println("SanityTest5");
    }
}