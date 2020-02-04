package com.closer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
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


    /**
     * 通配符的使用
     * 类A是类B的父类，G<A>和G<B>没有关系，二者共同的父类是G<?>
     */
    @Test
    public void test3() {
        List<Object> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<?> list = null;
        list = list1;
        list = list2;
        print(list1);
        print(list2);
//        list1 = list2;  // 不同泛型直接不能赋值



        List<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("BB");


//        list.add("DD"); // 不能直接加， 要用另一个List赋值， 除了null
        list.add(null);

        Object o = list.get(0);

        list = list3;

        print(list);


    }


    public void print(List<?> list) {
        for (Object aList : list) {
            System.out.println(aList);
        }
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    /**
     * 有限制条件的通配符
     * ? extends A
     * ? super B
     */
    @Test
    public void test4() {
        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;

        List<Student> list3 = new ArrayList<>();
        List<Person> list4 = new ArrayList<>();
        List<Object> list5 = new ArrayList<>();

        list1 = list3;
        list1 = list4;
//        list1 = list5;  wrong  只能是Person或是其子类 <= Person

//        list2 = list3;  wrong  >= Person
        list2 = list4;
        list2 = list5;


        System.out.println("-------------read-----------------");

        list1 = list3;
//        Student person = list1.get(0);  wrong
        Person person = list1.get(0);
        list1 = list4;
        Person person1 = list1.get(0);


        list2 = list4;
//        Person o = list2.get(0);  wrong
        Object o = list2.get(0);


        System.out.println("-------------write-----------------");
//        list1.add(new Student());  // 无法添加
        list2.add(new Person());    // 添加时只能加Person及其子类
        list2.add(new Student());


    }

}

