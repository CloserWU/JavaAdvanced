package com.closer;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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


    @Test
    public void test2() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss GGG");
        Date date = new Date();
        System.out.println(date);
        System.out.println(format.format(date));
        SimpleDateFormat format1 = new SimpleDateFormat();
        System.out.println(format1.parse("20-04-24 上午09:35"));
    }

    /**
     * calender
     * 1月是0
     * 周日是1
     */
    @Test
    public void test3() {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getClass()); // java.util.GregorianCalendar


        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));


        // 设置当前
        calendar.set(Calendar.DAY_OF_MONTH, 2);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        // 向前或向后 增加天数
        calendar.add(Calendar.DAY_OF_MONTH, -3);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.YEAR));

        System.out.println(calendar.getTime());

        Date date = new Date();
        calendar.setTime(date);
        System.out.println(calendar.get(Calendar.MINUTE));
    }
}

