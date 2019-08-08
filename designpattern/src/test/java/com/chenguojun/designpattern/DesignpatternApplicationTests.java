package com.chenguojun.designpattern;

import com.chenguojun.designpattern.PO.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DesignpatternApplicationTests {
    @Value(value = "#{test}")
    public String test;

    @Test
    public void contextLoads() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> c = Class.forName("com.chenguojun.designpattern.PO.Person");
        Person o = (Person) c.newInstance();
        Method declaredMethod = c.getDeclaredMethod("reflectMethod", String.class);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(o, "lisi");
    }

    @Test
    public void test2() {
        System.out.println(test);
    }
}
