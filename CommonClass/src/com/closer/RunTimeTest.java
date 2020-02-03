package com.closer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p>RunTimeTest</p>
 * <p>description</p>
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-02-02 09:52
 */
public class RunTimeTest {
    /**
     * main中能找到文件
     * test测试中找不到相对目录文件
     * @param args
     */
    public static void main(String[] args) {
        String userName = "CloserWU";
        String[] args1 = new String[] { "python", "./CommonClass/resources/Spider.py", userName };
        Process proc;
        try {
            // 执行py文件
            proc = Runtime.getRuntime().exec(args1);
            //用输入输出流来截取结果
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

