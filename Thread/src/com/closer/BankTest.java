package com.closer;

/**
 * <p>BankTest</p>
 * <p>description</p>
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-01-29 09:26
 */
public class BankTest {
}

class Bank {
    private Bank() {
    }

    private static Bank instance = null;

    public static Bank getInstance() {
        // 效率较高
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }

        // 效率较差
        /*synchronized (Bank.class) {
            if (instance == null) {
                instance = new Bank();
            }
        }*/

        return instance;
    }

}

