package com.closer;

/**
 * <p>AccountSafe</p>
 * <p>description</p>
 *
 * 买票过程中出现了重票、错票
 * 解决：
 * 1.同步代码块
 *
 * synchronized(同步监视器){  锁🔒 任何一个类的对象 都可以当锁。但多个线程必须公用同一个锁
 *     同步代码
 * }   多线程 =》 单线程 效率较低   不能包多 也不能包少
 *
 * 2.同步方法
 * 可以将一个方法声明为同步的，成为同步方法   AccountSafe2
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-01-28 19:25
 */
public class AccountSafe {
    public static void main(String[] args) {
        Account account = new Account();
        Thread thread = new Thread(account);
        thread.start();
        Thread thread1 = new Thread(account);
        thread1.start();
    }

}


class Account implements Runnable {
    private int ticket = 100;
    // 一个锁
    private final Object o = new Object();
    @Override
    public void run() {
        while (true) {
//            synchronized(this) {
            synchronized (o) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " " + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

