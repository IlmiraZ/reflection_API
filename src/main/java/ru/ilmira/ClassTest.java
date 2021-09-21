package ru.ilmira;

public class ClassTest {

    @BeforeSuite
    public void before() {
        System.out.println("Method before");
    }

//    @BeforeSuite
//    public void before2() {
//        System.out.println("Method before");
//    }

    @Test(priority = 1)
    public void test1() {
        System.out.println("test1");
    }

    @Test(priority = 3)
    public void test2() {
        System.out.println("test2");
    }

    @Test(priority = 2)
    public void test3() {
        System.out.println("test3");
    }

    @Test(priority = 2)
    public void test4() {
        System.out.println("test4");
    }

    @Test(priority = 3)
    public void test5() {
        System.out.println("test5");
    }

    @AfterSuite
    public void after() {
        System.out.println("Method after");
    }

//    @AfterSuite
//    public void after2() {
//        System.out.println("Method after");
//    }
}
