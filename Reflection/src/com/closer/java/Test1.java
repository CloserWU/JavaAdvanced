package com.closer.java;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * <p>Test1</p>
 * <p>description</p>
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-02-04 19:46
 */
public class Test1 {
    @Test
    public void test1() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class clazz = Person.class;
        Constructor con = clazz.getConstructor(String.class, int.class);
        Object o = con.newInstance("Tom", 12);
        Person p = (Person) o;
        System.out.println(p);

        Field name = clazz.getDeclaredField("name");
        Object o2 = name.get(p);
        System.out.println(o2);
        name.setAccessible(true);
        name.set(p, "Bob");
        System.out.println(p);

        Method show = clazz.getMethod("show");
        show.invoke(p);

        Method[] methods = clazz.getDeclaredMethods();


        Constructor con1 = clazz.getDeclaredConstructor(String.class);
        con1.setAccessible(true);
        Object o1 = con1.newInstance("Tony");
        Person p1 = (Person) o1;

        Method nation = clazz.getDeclaredMethod("showNation", String.class);
        String paraReturn = (String) nation.invoke(p1, "China");
        System.out.println(paraReturn);


        /*
         * 类加载过程
         * 程序经过javac.exe命令后，会生成一个或多个字节码文件(.class)，接着我们使用
         * java.exe命令对某个字节码文件进行解释运行。相当于将某个字节码加载到内存中，此过程就成为类的加载。
         * 加载到内存中的类就成为运行时类，此运行时类，就是一个Class实例
         *
         */



    }

    /**
     * Class的三种加载方式 + ClassLoader
     * 加载到内存中的运行时类，会缓存一段时间。在此时间中，我们可以通过不同的方式获取此运行时类。
     * 此运行时类只会被加载一次，在内存中也只有一个
     * @throws ClassNotFoundException
     */
    @Test
    public void test2() throws ClassNotFoundException {
        Class<Person> clazz1 = Person.class;
        Person p1 = new Person();
        Class<? extends Person> clazz2 = p1.getClass();
        // 使用频率最高 ↓
        Class<Person> clazz3 = (Class<Person>) Class.forName("com.closer.java.Person");
        System.out.println(clazz1);
        System.out.println(clazz2);
        System.out.println(clazz3);
        System.out.println(clazz1 == clazz2);
        System.out.println(clazz2 == clazz3);

        ClassLoader loader = Test1.class.getClassLoader();
        Class<?> clazz4 = loader.loadClass("com.closer.java.Person");
        System.out.println(clazz4);
        System.out.println(clazz3 == clazz4);


        /*
         * 哪些类型可以有Class对象？
         *  - 外部类，成员（成员内部类，静态内部类），局部内部类，匿名内部类
         *  - [] 数组
         *  - enum 枚举
         *  - annotation 注解@interface
         *  - primitive type 基本数据类型
         *  - void
         */
    }

}

