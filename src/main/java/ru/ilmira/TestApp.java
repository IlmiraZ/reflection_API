package ru.ilmira;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;


public class TestApp {

    public static void start(Class<?> tClass) throws Exception {
        Method methodB = null;
        Method methodA = null;
        ArrayList<Method> methods = new ArrayList<>();

        Object obj = null;
        try {
            obj = tClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Method m : tClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                methods.add(m);
            } else if (m.isAnnotationPresent(BeforeSuite.class)) {
                if (methodB == null) {
                    methodB = m;
                    System.out.println("Результат: ");
                } else {
                    throw new RuntimeException("Метод с аннотацией @BeforeSuite должен быть один!");
                }
            }
            if (m.isAnnotationPresent(AfterSuite.class)) {
                if (methodA == null) {
                    methodA = m;
                } else {
                    throw new RuntimeException("Метод с аннотацией @AfterSuite должен быть один!");
                }
            }
        }

        if (methodB != null) {
            methodB.invoke(obj);
        }

        methods.sort(Comparator.comparingInt(o -> o.getAnnotation(Test.class).priority()));
        for (Method m : methods) {
            m.invoke(obj);
        }

        if (methodA != null) {
            methodA.invoke(obj);
        }
    }
}
