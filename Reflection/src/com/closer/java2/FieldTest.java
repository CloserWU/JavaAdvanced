package com.closer.java2;

import com.closer.java1.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * <p>FieldTest</p>
 * <p>description</p>
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-02-05 16:20
 */
public class FieldTest {
    @Test
    public void test1() {
        Class<Person> clazz = Person.class;
        // 运行时类自己的全部属性
        Field[] fields1 = clazz.getDeclaredFields();
        for (Field f : fields1) {
            System.out.println(f);
        }
        System.out.println();
        // 运行时类 及其 父类 中声明为 public 的属性
        Field[] fields2 = clazz.getFields();
        for (Field f : fields2) {
            System.out.println(f);
        }
    }

    @Test
    public void test2() {
        Class<Person> clazz = Person.class;
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            /*
             *  权限修饰符
             * public 1
             * default 0
             * private 2
             */
            int i = f.getModifiers();
            System.out.print(i + " " + Modifier.toString(i) + " \t");

            Class<?> type = f.getType();
            System.out.print(type + "\t");

            String name = f.getName();
            System.out.print(name + "\t");
            System.out.println();
        }
    }
}

