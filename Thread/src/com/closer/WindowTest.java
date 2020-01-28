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
            if (ticket > 0) {
                System.out.println(getName() + "ticket" + ticket);
                ticket--;
            } else {
                break;
            }
        }
    }
}

