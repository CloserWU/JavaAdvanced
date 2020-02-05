package com.closer.java;

import org.junit.Test;

import java.util.Random;

/**
 * <p>NewInstance</p>
 * <p>description</p>
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-02-05 15:42
 */
public class NewInstance {
    @Test
    public void test1() throws IllegalAccessException, InstantiationException {
        Class<Person> clazz = Person.class;
        /*
         * newInstance调用此方法，创建相应的运行时类的对象，内部调用了运行时类的空参构造器，
         * 若没有空参构造器，或构造器为private，则报错。即必须有public或protected 的权限，够权限
         *
         * 在javabean中，要求提供public的空参构造器，便于通过反射构造对象，便于子类继承父类时，默认super()有权限
         */
        Person person = clazz.newInstance();
        System.out.println(person);
    }


    @Test
    public void test2() {
        int i = new Random().nextInt(3);
        String className = "";
        switch (i) {
            case 0:
                className = "java.util.Date";
                break;
            case 1:
                className = "com.closer.java.Person";
                break;
            case 2:
                // wrong java.sql.Date没有空参构造器
                className = "java.sql.Date";
                break;
            default:
                break;
        }
        try {
            Object o = getInstance(className);
            System.out.println(o);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public Object getInstance(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> clazz = Class.forName(className);
        return clazz.newInstance();

    }
}

