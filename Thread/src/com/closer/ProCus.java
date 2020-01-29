package com.closer;

/**
 * <p>ProCus</p>
 * <p>description</p>
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-01-29 11:18
 */
public class ProCus {
    public static void main(String[] args) {
        Clerk c = new Clerk();
        Producer p1 = new Producer(c);
        p1.setName("P1");

        CCustomer cc = new CCustomer(c);
        Thread c1 = new Thread(cc);
        c1.setName("C1");
        p1.start();
        c1.start();

    }
}


class Producer extends Thread{
    private Clerk clerk;

    public Producer(Clerk c) {
        clerk = c;
    }

    @Override
    public void run() {
        System.out.println(getName() + " Procuder");
        while (true) {
            clerk.produceProduct();
        }
    }
}

class CCustomer implements Runnable{
    private Clerk clerk;

    public CCustomer(Clerk c) {
        clerk = c;
    }


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Customer");
        while (true) {
            clerk.consumeProduct();
        }
    }
}

class Clerk {
    private int number = 0;

    public synchronized void produceProduct() {
        if (number < 20) {
            System.out.println(Thread.currentThread().getName() + " 生产 " + ++number);
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consumeProduct() {
        if (number > 0) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 消费 " + number--);
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

