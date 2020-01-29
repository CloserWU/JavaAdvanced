package com.closer;

import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>AccountTest</p>
 * <p>description</p>
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-01-29 10:05
 */
public class AccountTest {
    public static void main(String[] args) {
        AccountExec a = new AccountExec(1000.0);
        Customer c1 = new Customer(a);
        Customer c2 = new Customer(a);
        c1.setName("甲");
        c2.setName("乙");
        c1.start();
        c2.start();
    }
}

class AccountExec {
    private Double balance;

    private ReentrantLock lock = new ReentrantLock(true);

    public AccountExec(Double balance) {
        this.balance = balance;
    }

    public void deposit(Double d) {
        lock.lock();
        if (d > 0) {
            balance += d;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 余额为:"  + balance);
        }
        lock.unlock();
    }
}

class Customer extends Thread {
    private AccountExec account;

    public Customer(AccountExec a) {
        this.account = a;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {

            account.deposit(1000.0);

        }
    }
}

