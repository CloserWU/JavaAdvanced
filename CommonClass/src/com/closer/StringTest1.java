package com.closer;

import org.junit.Test;

/**
 * <p>StringTest1</p>
 * <p>description</p>
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-01-29 16:13
 */
public class StringTest1 {

    /**
     * String 是final的，
     * String实现了Serializable接口 表示字符串支持序列化
     * 实现了Comparable接口，即可以比较大小
     * 定义了final char[] value存放数据 （value 和 String 类对象不同 value在常量池中）
     * String代表不可变的字符序列
     * <p>
     * <p>
     * String 变量的值定义在 方法区(含字符串常量池)，常量区的内容是唯一的  abc hello
     * String 变量的变量名 在 栈中 s1 s2   s1 -》 abc   s2 -》 abc
     * String 变量的重新赋值 是指 栈中相应的地址改变   s1 -》 hello
     */
    @Test
    public void test() {
        String s1 = "abc";
        String s2 = "abc";
        s1 = "hello";
        System.out.println(s1); // hello
        System.out.println(s2); // abc
        System.out.println(s1 == s2);  // ==比较地址值


        s1 = s1.replace('o', 'p');
        System.out.println(s1); // hellp
    }


    @Test
    public void test1() {
        String s1 = new String("javaee");  // new 出来的在堆空间
        String s2 = new String("javaee"); // new 出来的都是在堆空间新创建的

        String s3 = "javaee";  // 常量池
        String s4 = "javaee";

        System.out.println(s1 == s2); // false 不同对象
        System.out.println(s1 == s3); // false
        System.out.println(s1 == s4); // false
        System.out.println(s3 == s4); // true
    }

    @Test
    public void test2() {
        String s1 = "java";
        String s2 = "c++";

        String s3 = "javac++";
        String s4 = "java" + "c++";
        String s5 = s1 + "c++";  //相当于new出来的  堆 s5指向堆
        String s6 = "java" + s2;

        String s7 = s5.intern(); // intern 返回的的常量池的地址

        System.out.println(s3 == s4); //true
        System.out.println(s3 == s5); //false
        System.out.println(s3 == s6); //false
        System.out.println(s5 == s6); //false
        System.out.println(s7 == s3); // true

    }

    String str = new String("good");
    char[] ch = {'t', 'e', 's', 't'};

    public void exchange(String str, char[] ch) {
        str = "test ok";
        ch[0] = 'b';
    }

    @Test
    public void test3() {
        StringTest1 s = new StringTest1();
        s.exchange(s.str, s.ch);
        System.out.println(s.str); //good
        System.out.println(s.ch); //best
    }
}

