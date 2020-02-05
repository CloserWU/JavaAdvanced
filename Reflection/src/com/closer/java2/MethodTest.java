package com.closer.java2;

import com.closer.java1.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * <p>MethodTest</p>
 * <p>description</p>
 *
 * 框架 = 注解 + 反射 + 设计模式
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-02-05 16:30
 */
public class MethodTest {
    @Test
    public void test1() {
        Class<Person> clazz = Person.class;
        // 运行时类 及其 父类 中声明为 public 的方法
        Method[] methods1 = clazz.getMethods();
        for (Method m : methods1) {
            System.out.println(m);
        }

        System.out.println();
        // 运行时类自己的全部方法
        Method[] methods2 = clazz.getDeclaredMethods();
        for (Method m : methods2) {
            System.out.println(m);
        }
    }

    @Test
    public void test2() {
        Class<Person> clazz = Person.class;
        Method[] methods2 = clazz.getDeclaredMethods();
        for (Method m : methods2) {
            // 获取注解
            Annotation[] anno = m.getAnnotations();
            for (Annotation a : anno) {
                System.out.println(a);
            }

            // 获取权限修饰符
            int modifiers = m.getModifiers();
            System.out.print(Modifier.toString(modifiers) + " ");


            // 获取返回值类型
            Class<?> type = m.getReturnType();
            System.out.print(type.getName() + " ");


            // 获取方法名
            String name = m.getName();
            System.out.print(name + "(");

            // 获取参数列表
            Class<?>[] parameterTypes = m.getParameterTypes();
            if (!(parameterTypes == null || parameterTypes.length == 0)) {
                for (int i = 0; i < parameterTypes.length; i++) {
                    System.out.print(parameterTypes[i].getName() + " args_" + i );
                    if (i != parameterTypes.length - 1) {
                        System.out.print(", ");
                    }
                }
            }
            System.out.print(") ");

            // 获取异常
            Class<?>[] exceptionTypes = m.getExceptionTypes();
            if (!(exceptionTypes == null || exceptionTypes.length == 0)) {
                System.out.print("throws ");
                for (int i = 0; i < exceptionTypes.length; i++) {
                    System.out.print(exceptionTypes[i].getName());
                    if (i != exceptionTypes.length - 1) {
                        System.out.print(", ");
                    }
                }
            }

            System.out.print(" {...};" + "\n\n");
        }
    }
}

