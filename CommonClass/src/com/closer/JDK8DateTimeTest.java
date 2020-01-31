package com.closer;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * <p>JDK8DateTimeTest</p>
 * <p>description</p>
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-01-31 10:17
 */
public class JDK8DateTimeTest {
    @Test
    public void test1() {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);


        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 10, 31, 5, 25);
        System.out.println(localDateTime1);

        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getDayOfWeek().getValue());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getMinute());

        LocalDateTime localDateTime2 = localDateTime.withDayOfMonth(10);
        System.out.println(localDateTime2);

        LocalDateTime localDateTime3 = localDateTime.plusDays(2020);
        System.out.println(localDateTime3);

        LocalDateTime localDateTime4 = localDateTime3.minusDays(2019);
        System.out.println(localDateTime4);

    }

    @Test
    public void test2() {
        // 格林威治时间
        Instant instant = Instant.now();
        System.out.println(instant);


        // 东八区时间
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);


        // 1970-01-01 00.00.00 UTC
        System.out.println(instant.toEpochMilli());
    }


    @Test
    public void test3() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        System.out.println(formatter.format(LocalDateTime.now()));

        TemporalAccessor parse = formatter.parse("2020-01-31 10:39:55");
        System.out.println(parse);
    }
}

