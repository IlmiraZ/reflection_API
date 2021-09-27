package ru.ilmira;

public class MainClass {
    public static void main(String[] args) {
        try {
            TestApp.start(ClassTest.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
