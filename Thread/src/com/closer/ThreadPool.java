package com.closer;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>ThreadPool</p>
 * <p>description</p>
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-01-29 12:05
 */
public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        /*
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) executorService;
        service1.setCorePoolSize(15);
        System.out.println(executorService.getClass());
        */



        executorService.execute(new Pool1()); // execute适合Runnable
        System.out.println();

        try {
            Integer integer = executorService.submit(new NumThread()).get();//submit 适合Callable
            System.out.println(integer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}

class Pool1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }
    }
}






