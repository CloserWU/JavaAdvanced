package com.closer;

/**
 * <p>CommunicationTest</p>
 * <p>description</p>
 *
 * wait notify notifyAll 定义在Object类中
 *
 * wait notify notifyAll 的调用者必须是同步代码块或同步方法中的同步监视器
 * 否者 异常
 *
 * sleep 和 wait的异同
 * sleep可以在任何场景下用，wait只能在同步代码块中
 *
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-01-29 10:23
 */
public class CommunicationTest {
    public static void main(String[] args) {
        Number n = new Number();
        Thread t1 = new Thread(n);
        Thread t2 = new Thread(n);
        t1.start();
        t2.start();
    }

}


class Number implements Runnable {
    private int number = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {   // synchronized (obj) *
                this.notify();  // 唤醒优先级高的wait线程
                // notifyAll() 唤醒全部wait线程
                // obj.notify(); *
                if (number <= 100) {

                    try {
                        // 不释放锁
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " " + number++);
                    try {
                        // 阻塞 释放锁
                        this.wait();
                        // obj.wait() *
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }

            }
        }
    }
}

