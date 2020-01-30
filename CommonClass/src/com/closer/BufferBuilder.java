package com.closer;

import org.junit.Test;

/**
 * <p>BufferBuilder</p>
 * <p>description</p>
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-01-30 10:13
 */
public class BufferBuilder {
    // StringBuffer 线程安全效率偏低
    // StringBuilder 线程不安全

    /**
     * String str = new String(); // char[] value = new char[0]
     * String str = new String("abc); // char[] value = new char[]{'a','b','c'}
     * StringBuffer sb1 = new StringBuffer(); // char[] value = new char[16];
     * sb1.append('a'); // value[0] = 'a'
     * StringBuffer sb2 = new StringBuffer("abc"); // char[] value = new char["abc".length() + 16];
     * sb.length() 返回当前sb有多少个元素
     *
     * 当append超过16时，默认扩容为原来容量的2倍 + 2，并且把原有数组复制到新数组中
     * 建议使用StringBuffer(int capacity)
     */
    @Test
    public void test1() {
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0, 'm');
        System.out.println(sb1);
    }


    @Test
    public void test2() {
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        sb.append(1);
        sb.append(true);
        System.out.println(sb);
        System.out.println(sb.delete(2, 4));
        System.out.println(sb.replace(2, 3, "hello"));
        System.out.println(sb.insert(1, false));
        System.out.println(sb.reverse());
        System.out.println(sb.charAt(2));
    }
}

