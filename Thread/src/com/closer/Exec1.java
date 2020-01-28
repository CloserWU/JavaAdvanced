package com.closer;

/**
 * <p>Exec1</p>
 * <p>description</p>
 *
 * currentThread() static 返回Thread,返回当前执行的线程
 * getName() 返回当前线程名字
 * setName(String) 设置当前线程名
 * yield() 释放CPU控制权
 * join() 调用的线程执行完毕后，才执行其他线程
 * stop() 强制结束线程 deprecated 已过时
 * sleep(long millis) 线程睡眠x毫秒
 * isAlive() 线程是否存活
 * getPriority();获取线程优先级 1 5 10 Max Norm Min
 * setPriority(int);设置线程优先级
 *
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-01-28 16:44
 */
public class Exec1 {
    public static void main(String[] args) {
        MyThreadExec1 myThreadExec1 = new MyThreadExec1();
        myThreadExec1.start();
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 1) {
                if (i == 51) {
                    System.out.println(Thread.currentThread().getPriority());
                    Thread.currentThread().setName("线程一");
                    try {
                        myThreadExec1.join();  // 等待myThreadExec1执行完毕，在进行main线程
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                };
                System.out.println(Thread.currentThread().getName() + i);
            }
        }
        // false
        System.out.println(myThreadExec1.isAlive());

    }
}

class MyThreadExec1 extends Thread {


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                if (i == 50) {
                    Thread.currentThread().setName("线程二");
                    yield();
                    setPriority(MAX_PRIORITY);
                    try {
                        sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + i);
            }
        }
    }
}
