package com.closer;

import org.junit.Test;

import java.util.List;

/**
 * <p>GenericTest</p>
 * <p>description</p>
 * <p>
 * 泛型类，泛型接口，泛型方法
 * <p>
 * 异常类不能声明为泛型的
 * 静态方法不能是泛型的
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-02-04 09:24
 */
public class GenericTest {

    /**
     * 自定义泛型类，泛型接口
     */
    @Test
    public void test1() {
        // T为Object类
        Order obj = new Order("AA", 1, "CC");
        // T为String类
        Order<String> order = new Order<>("AA", 1, "CC");


        System.out.println(obj.getOrderT() instanceof String);
        System.out.println(order.getOrderT() instanceof String);


        SubOrder sub1 = new SubOrder();
        SubOrder1<String> sub2 = new SubOrder1<>();

    }

    /**
     * 泛型方法，在调用时，指明泛型参数类型
     */
    @Test
    public void test2() {
        Order<String> order = new Order<>("AA", 1, "CC");
        Integer[] arr = new Integer[]{1, 2, 3, 4};
        List<Integer> list = order.copyFromArrayToList(arr);
        System.out.println(list);
    }
}

