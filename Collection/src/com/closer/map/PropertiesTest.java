package com.closer.map;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * <p>PropertiesTest</p>
 * <p>description</p>
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-02-03 19:17
 */
public class PropertiesTest {
    @Test
    public void test1() throws IOException {
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream("./Collection/resources/jdbc.properties");
        properties.load(fis);
        String name = properties.getProperty("name");
        String password = properties.getProperty("password");
        System.out.println(name + " " + password);
    }

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream("./Collection/resources/jdbc.properties");
        properties.load(fis);
        String name = properties.getProperty("name");
        String password = properties.getProperty("password");
        System.out.println(name + " " + password);

    }
}

