package com.closer;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * <p>ThreadNew</p>
 * <p>description</p>
 *
 * Callable 接口 JDK5.0
 * Callable比Runnable强大
 *
 * call()可以有返回值
 * 能抛出异常
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-01-29 11:42
 */
public class ThreadCallable {
    public static void main(String[] args) {
        NumThread n = new NumThread();
        FutureTask<Integer> task = new FutureTask<>(n);
        new Thread(task).start();
        try {
            // get()返回futureTask构造器参数Callable实现类重写的call()的返回值
            Integer sum = task.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class NumThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}

