package com.closer.java;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * <p>ClassLoaderTest</p>
 * <p>description</p>
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-02-04 20:47
 */
public class ClassLoaderTest {
    @Test
    public void test1() {
        // 自定义类，使用系统类加载器加载
        ClassLoader loader = ClassLoaderTest.class.getClassLoader();
        System.out.println(loader);
        // 调用系统类加载器的getParent(),获取扩展类加载器
        ClassLoader parent = loader.getParent();
        System.out.println(parent);
        // 引导类加载器主要负责加载java核心类库，无法加载自定义类
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);
    }


    /**
     * 用properties读取配置文件
     */
    @Test
    public void test2() throws IOException {
        Properties p = new Properties();
        // 默认当前module下 方式1
        FileInputStream fis = new FileInputStream("resources/jdbc.properties");
        p.load(fis);
        // 默认当前moudle的src下 方式二
        /*ClassLoader loader = ClassLoaderTest.class.getClassLoader();
        InputStream fis = loader.getResourceAsStream("../resources/jdbc.properties");
        p.load(fis);*/

        String user = p.getProperty("user");
        String password = p.getProperty("password");
        System.out.println(user + password);

    }
}

