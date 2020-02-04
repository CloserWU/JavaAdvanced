package com.closer;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * <p>Hello</p>
 * <p>description</p>
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-01-15 09:12
 */
public class Hello {
    public static void main(String[] args) {
        printClassInfo("".getClass());
        printClassInfo(Runnable.class);
        printClassInfo(java.time.Month.class);
        printClassInfo(String[].class);
        printClassInfo(int.class);



        Object obj = new Person("Wu Shuai");
        Class clazz = obj.getClass();
        Field name = null;
        Object val = null;
        try {
            name = clazz.getDeclaredField("name");
            name.setAccessible(true);
            val = name.get(obj);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(val);


        Object p = new Person("Xiao Ming");
        Class c = p.getClass();
        Field f = null;
        Object value = null;
        try {
            f = c.getDeclaredField("name");
            f.setAccessible(true);
            value = f.get(p);
            int modifiers = f.getModifiers();
            System.out.println(Modifier.isPrivate(modifiers));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        System.out.println(value);
    }

    private static void printClassInfo(Class cls) {
        System.out.println("-------------");
        System.out.println("Class name: " + cls.getName());
        System.out.println("Simple name: " + cls.getSimpleName());
        if (cls.getPackage() != null) {
            System.out.println("Package name: " + cls.getPackage().getName());
        }
        System.out.println("is interface: " + cls.isInterface());
        System.out.println("is enum: " + cls.isEnum());
        System.out.println("is array: " + cls.isArray());
        System.out.println("is primitive: " + cls.isPrimitive());
        System.out.println("-------------");
    }
}

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }
}

