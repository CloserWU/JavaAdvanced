package com.closer;

import org.junit.Test;

/**
 * <p>IDEADebug</p>
 * <p>description</p>
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-01-31 09:16
 */
public class IDEADebug {
    @Test
    public void test() {
        String str = null;
        StringBuilder sb = new StringBuilder();
        sb.append(str);

        System.out.println(sb.length());  // 4

        System.out.println(sb); // "null"

        StringBuilder sb2 = new StringBuilder(str);
        System.out.println(sb2);  // 异常NullPointerException
    }
}

