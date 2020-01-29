package com.closer;

import org.junit.Test;

/**
 * <p>StringMethod</p>
 * <p>description</p>
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-01-29 21:25
 */
public class StringMethod {

    @Test
    public void test1() {
        String s = "  hEel ";
        System.out.println(s.length());
        System.out.println(s.charAt(5));
        System.out.println(s.isEmpty());
        System.out.println(s.toLowerCase());
        System.out.println(s.toUpperCase());
        System.out.println(s.trim());
        System.out.println(s.trim().equals("heel"));
        System.out.println(s.trim().equalsIgnoreCase("heel"));
        System.out.println(s.substring(3));
        System.out.println(s.substring(3, 5)); // [3, 5)
        System.out.println(s.intern());
        System.out.println(s.concat("123"));
        System.out.println(s.compareTo("  kEel ")); // char[] 依次相减
    }

    @Test
    public void tedt2() {
        String s = "test2test";
        System.out.println(s.endsWith("t2"));
        System.out.println(s.startsWith("Tes"));
        System.out.println(s.startsWith("e", 1));
        System.out.println(s.contains("ess"));
        System.out.println(s.indexOf(1));
        System.out.println(s.indexOf("t"));
        System.out.println(s.lastIndexOf("t"));
        System.out.println(s.indexOf("t", 1));
        System.out.println(s.lastIndexOf("t", 3)); // 从指定的索引反向搜索 从右往左
    }
}

