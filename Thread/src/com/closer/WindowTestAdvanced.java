package com.closer;

/**
 * <p>WindowTestAdvanced</p>
 * <p>description</p>
 *
 *
 * Thread 也实现Runnable ， 重写run()
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-01-28 17:26
 */
public class WindowTestAdvanced {
    public static void main(String[] args) {
        RunnableWindow window = new RunnableWindow();
        Thread window1 = new Thread(window);
        window1.start();

        Thread window2 = new Thread(window);
        window2.start();
    }
}

class RunnableWindow implements Runnable {

    private int ticket = 100;
    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + " " + ticket);
                ticket--;
            } else {
                break;
            }
        }
    }
}

