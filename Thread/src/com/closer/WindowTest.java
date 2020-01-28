package com.closer;

/**
 * <p>WindowTest</p>
 * <p>description</p>
 *
 * 线程安全问题
 * Thread-0ticket100
 * Thread-1ticket100
 * Thread-0ticket99
 * Thread-0ticket97
 * Thread-0ticket96
 * Thread-0ticket95
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-01-28 17:14
 */
public class WindowTest {
    public static void main(String[] args) {
        Window window1 = new Window();
        Window window2 = new Window();

        window1.start();
        window2.start();
    }

}

class Window extends Thread {
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
//            synchronized (Window.class)
            if (ticket > 0) {
                System.out.println(getName() + "ticket" + ticket);
                ticket--;
            } else {
                break;
            }
        }
    }

    /**
     * 同步监视器不是this static中没有this， 是Window.class
     */
    public static synchronized void show () {
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "ticket" + ticket);
            ticket--;
        }
    }
}

