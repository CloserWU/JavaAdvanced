package com.closer;

/**
 * <p>AccountSafe2</p>
 * <p>description</p>
 * <p>
 * 使用同步方法
 * 锁 默认为 this
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-01-28 20:04
 */
public class AccountSafe2 {
    public static void main(String[] args) {

    }
}


class Account2 implements Runnable {
    private int ticket = 100;


    @Override
    public void run() {
        while (true) {
            show();
        }
    }

    public synchronized void show () {
        if (ticket > 0) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + ticket);
            ticket--;
        }
    }
}
