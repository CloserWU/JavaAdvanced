package com.closer.java2;

import com.closer.java1.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * <p>InvokeTest</p>
 * <p>description</p>
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-02-05 17:17
 */
public class InvokeTest {
    /**
     *
     */
    @Test
    public void testField() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class<Person> clazz = Person.class;
        Person p = clazz.newInstance();
        Field id = clazz.getField("id");
        id.set(p, 1001);
        int pid = (int) id.get(p);
        System.out.println(pid);

        Field age = clazz.getDeclaredField("age");
        age.setAccessible(true);
        age.set(p, 22220);
        int pName = (int) age.get(p);
        System.out.println(pName);
    }

    @Test
    public void testMethod() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<Person> clazz = Person.class;
        Person p = clazz.newInstance();
        Method show = clazz.getDeclaredMethod("show", String.class);
        show.setAccessible(true);
        String returnPara = (String) show.invoke(p, "China");
        System.out.println(returnPara);

        /*
         * static
         */

        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        Object returnPara1 = showDesc.invoke(Person.class);
        System.out.println(returnPara1);

    }

    @Test
    public void test3() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Person> clazz = Person.class;
        Constructor<Person> constructor = clazz.getConstructor(String.class);
        constructor.setAccessible(true);
        Person tom = constructor.newInstance("Tom");
        System.out.println(tom);

    }
}

