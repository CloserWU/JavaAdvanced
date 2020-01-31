package com.closer;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Properties;

/**
 * <p>OtherClassTest</p>
 * <p>description</p>
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-01-31 18:01
 */
public class OtherClassTest {
    @Test
    public void test1() {
        Properties properties = System.getProperties();
        System.out.println(properties.getProperty("java.version"));
        System.out.println(properties.getProperty("java.home"));
        System.out.println(properties.getProperty("os.name"));
        System.out.println(properties.getProperty("os.version"));
        System.out.println(properties.getProperty("user.name"));
        System.out.println(properties.getProperty("user.home"));
        System.out.println(System.getProperty("user.dir"));
    }

    @Test
    public void test2() {
        BigInteger bi = new BigInteger("152641233115123314323541323214321341213321");
        BigDecimal bd = new BigDecimal("12345.123456");
        BigDecimal bd1 = new BigDecimal("11");
        System.out.println(bi);
        System.out.println(bd.divide(bd1, BigDecimal.ROUND_HALF_UP));  // 四舍五入
        System.out.println(bd.divide(bd1, 15, BigDecimal.ROUND_HALF_UP));
        System.out.println(bd.divide(bd1, 15, BigDecimal.ROUND_DOWN));


    }
}

