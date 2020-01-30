package com.closer;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

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
    public void test2() {
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

    @Test
    public void test3() {
        String s = "hello worLD ws HEllo";
        System.out.println(s.replace('o', 'j'));
        System.out.println(s.replace("ll", "jj"));
        System.out.println(s.replaceAll("\\s", ""));
        System.out.println(s.replaceFirst("\\s", ""));
        System.out.println(s.matches("hello[a-zA-Z\\s]*"));
        System.out.println(Arrays.asList(s.split("\\s")));
        System.out.println(Arrays.asList(s.split("\\s", 2)));
    }

    @Test
    public void test4() {
        String s = "551201";
        System.out.println(Integer.parseInt(s));
        System.out.println(String.valueOf(Integer.parseInt(s)));
    }

    @Test
    public void test5() {
        String s = "abc123";
        System.out.println(s.toCharArray());
        char[] chars = new char[]{'e', 'g', ' ', 's'};
        System.out.println(new String(chars));
    }

    @Test
    public void test6() throws UnsupportedEncodingException {
        String s = "abc123宇宙🌌";
        System.out.println(Arrays.toString(s.getBytes()));
        System.out.println(Arrays.toString(s.getBytes("gbk")));

        System.out.println(new String(s.getBytes()));
        System.out.println(new String(s.getBytes("gbk")));
        System.out.println(new String(s.getBytes("gbk"), "gbk"));
    }

}

