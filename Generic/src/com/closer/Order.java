package com.closer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Order</p>
 * <p>description</p>
 *
 * 自定义泛型类
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-02-04 09:35
 */
public class Order<T> {
    private String orderName;
    private Integer orderId;
    private T orderT;

    public Order() {
    }

    public Order(String orderName, Integer orderId, T orderT) {
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }


    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }

    // 静态方法中不能使用泛型
    /*public static void show<T>() {
        System.out.println("");
    }*/

    // 异常类也不行
    /*public void show() {
        try {

        } catch (T e) {

        }
    }*/


    /**
     * 泛型方法 -》 在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系。即泛型方法所属的类是不是泛型类都没关系
     * 泛型方法可以是static的
     * @param arr
     * @param <E>  public <E>...  这个<E>声明了E不是类名，而是一种类型，否则编译器会将E[] arr 的E认为一种类名
     * @return
     */
    public <E> List<E> copyFromArrayToList(E[] arr) {
        List<E> list = new ArrayList<>(Arrays.asList(arr));
        return list;
    }
}

