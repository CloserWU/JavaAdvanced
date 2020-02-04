package com.closer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * <p>Main</p>
 * <p>description</p>
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-01-15 21:41
 */
public class Main {
    public static void main(String[] args) {

        Class clazz = Student.class;
        Class clazz1 = Person1.class;
        try {
            // 获取public方法getScore，参数为String:
            Method getScore = clazz.getMethod("getScore", String.class);
            System.out.println(getScore);
            // 获取继承的public方法getName，无参数:
            Method getGrade = clazz.getDeclaredMethod("getGrade", int.class);
            getGrade.setAccessible(true);
            Student student = new Student();
            System.out.println(getGrade.invoke(student, 20));
            System.out.println(getGrade);
            // 获取private方法getGrade，参数为int:
            Method getName = clazz.getMethod("getName");
            System.out.println(getName);


            Method substring = String.class.getMethod("substring", int.class);
            System.out.println(substring.invoke("Clazz Reflecting", 5));

            Method substring1 = String.class.getMethod("substring", int.class, int.class);
            System.out.println(substring1.invoke("Clazz Reflecting", 2, 15));

            Method parseInt = Integer.class.getMethod("parseInt", String.class);
            System.out.println(parseInt.invoke(null, "01234"));


            // clazz1 是 Person1的反射  由此可得，反射也遵循多态原则
            Method getName1 = clazz1.getMethod("getName");
            System.out.println(getName1.invoke(new Student()));

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}

class Student extends Person1 {
    public int getScore(String type) {
        return 99;
    }
    private int getGrade(int year) {
        return 1;
    }

    @Override
    public String getName() {
        return "Student";
    }
}

class Person1 {
    public String getName() {
        return "Person";
    }
}
