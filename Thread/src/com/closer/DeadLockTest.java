package com.closer;

import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>DeadLockTest</p>
 * <p>description</p>
 *
 *
 * synchronized 与 Lock 的区别
 * synchronized 在执行完相应的同步代码块后，自动释放同步监视器
 * Lock需要手动启动同步和手动结束同步
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-01-29 09:54
 */
public class DeadLockTest {
    public static void main(String[] args) {
        WindowLock windowLock = new WindowLock();
        Thread t1 = new Thread(windowLock);
        Thread t2 = new Thread(windowLock);
        Thread t3 = new Thread(windowLock);
        t1.start();
        t2.start();
        t3.start();
    }
}

class WindowLock implements Runnable {

    private int ticket = 100;

    // fair : true 公平  或不公平
    private ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            try {
                //
                lock.lock();

                if (ticket > 0) {

                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " " + ticket--);
                    ;
                } else {
                    break;
                }
            } finally {
                //
                lock.unlock();
            }

        }
    }
}

