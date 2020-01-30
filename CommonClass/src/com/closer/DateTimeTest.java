package com.closer;

import org.junit.Test;

import java.util.Date;

/**
 * <p>DateTimeTest</p>
 * <p>description</p>
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-01-30 10:43
 */
public class DateTimeTest {
    @Test
    public void test1() {
        // 1970.1.1到现在的毫秒差
        System.out.println(System.currentTimeMillis());

        Date date1 = new Date();
        System.out.println(date1.toString());
        System.out.println(date1.getTime());

        Date date2 = new Date(date1.getTime());
        System.out.println(date2.getTime());

        java.sql.Date date3 = new java.sql.Date(1580352526698L);
        System.out.println(date3.toString());

        Date date4 = new Date();
        java.sql.Date date5 = new java.sql.Date(date4.getTime());
        System.out.println(date5);

    }
}

