package com.closer;

/**
 * <p>Test1</p>
 * <p>description</p>
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-01-28 16:32
 */
class ThreadTest1 extends Thread {

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println("thread" + i);
            }
        }
    }
}

public class Test1 {
    public static void main(String[] args) {
        ThreadTest1 test1 = new ThreadTest1();
        test1.start();
//        test1.start();    /// java.lang.IllegalThreadStateException 一个线程对象只能start一次
        new Thread(){
            @Override
            public void run() {
                super.run();
            }
        }.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int[] tmp = {1,2,3,4,5,6,7,8,9};
                for (int i = 0; i < tmp.length; i++) {
                    System.out.println("anonymous" + tmp[i]);
                }
            }
        }).start();
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 1) {
                System.out.println("main" + i);
            }
        }
//        System.out.println("ThreadTest1");
    }
}
