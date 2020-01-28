package com.closer;

/**
 * <p>Test2</p>
 * <p>description</p>
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-01-28 17:20
 */
public class Test2 {
    public static void main(String[] args) {
        RunnableTest runnableTest = new RunnableTest();
        Thread thread = new Thread(runnableTest);
        thread.start();
        Thread thread1 = new Thread(runnableTest);
        thread1.start();
    }
}


class RunnableTest implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }
    }
}

