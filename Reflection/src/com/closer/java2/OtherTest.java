package com.closer.java2;

import com.closer.java1.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

/**
 * <p>OtherTest</p>
 * <p>description</p>
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-02-05 16:57
 */
public class OtherTest {
    /**
     * 构造器
     */
    @Test
    public void test1() {
        Class<Person> clazz = Person.class;
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor c : constructors) {
            System.out.println(c);
        }
        System.out.println();
        Constructor<?>[] constructors1 = clazz.getDeclaredConstructors();
        for (Constructor c : constructors1) {
            System.out.println(c);
        }
    }

    /**
     * 父类和泛型
     */
    @Test
    public void test2() {
        Class<Person> clazz = Person.class;
        Class<? super Person> superclass = clazz.getSuperclass();
        System.out.println(superclass);

        Type superclass1 = clazz.getGenericSuperclass();
        System.out.println(superclass1);

        ParameterizedType paraType = (ParameterizedType) superclass1;
        Type[] actualTypeArguments = paraType.getActualTypeArguments();
        System.out.println(Arrays.toString(actualTypeArguments));
        System.out.println(actualTypeArguments[0].getTypeName());
        Class cls = (Class) actualTypeArguments[0];
        System.out.println(cls.getName());
    }

    /**
     * 接口
     */
    @Test
    public void test3() {
        Class<Person> clazz = Person.class;
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class c : interfaces) {
            System.out.println(c);
        }

        Class<? super Person> superclass = clazz.getSuperclass();
        Class<?>[] interfaces1 = superclass.getInterfaces();
        for (Class c : interfaces1) {
            System.out.println(c);
        }
    }

    /**
     * 包
     */
    @Test
    public void test4() {
        Class<Person> clazz = Person.class;
        Package aPackage = clazz.getPackage();
        System.out.println(aPackage);
    }

    /**
     * 类注解
     */
    @Test
    public void test5() {
        Class<Person> clazz = Person.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation anno : annotations) {
            System.out.println(anno);
        }
    }
}

