package com.closer;

import org.junit.Test;

import java.util.*;

/**
 * <p>CollectionTest1</p>
 * <p>description</p>
 * <p>
 * Collection
 * - List   有序、可重复
 * - Set    无序、不可重复
 * Map        K-V
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-01-31 18:16
 */
public class CollectionTest1 {

    /**
     * add
     * addAll
     * remove
     * removeAll
     * contains
     * containsAll
     * retainAll
     *
     * equals
     * hasCode
     * toArray
     *
     * iterator
     */
    @Test
    public void test1() {
        List<Person> list = new ArrayList<>();
        list.add(new Person(2.0, "123"));
        list.add(new Person(2.0, "123"));
        // 比较时要重写equals方法
        System.out.println(list.contains(new Person(2.0, "123")));

        Collection<Person> coll = Arrays.asList(new Person(2.0, "123"));
        System.out.println(list.containsAll(coll));

        System.out.println(list.containsAll(list));


        System.out.println(list.remove(new Person(2.0, "123")));
        System.out.println(list);
        System.out.println(list.removeAll(coll));
        System.out.println(list);


        list.addAll(coll);

        list.retainAll(coll);  // 交集, 并更新当前集合
        System.out.println(list);

        System.out.println(list.equals(coll)); // 判断两个集合是否相等

        System.out.println(list.hashCode());


        Person[] p = new Person[1];
        p[0] = new Person(1111.0, "sss");
        Person[] people = list.toArray(p);
        System.out.println(Arrays.toString(people));


        List<Person> list1 = Arrays.asList(new Person[]{new Person(1.0, "123"), new Person(1.0, "1")});
        System.out.println(list1);


    }


    @Test
    public void test2() {
        List<Person> list = new ArrayList<>();
        list.add(new Person(2.0, "123"));
        list.add(new Person(2.0, "123"));

        Iterator<Person> iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        for (Person aList : list) {
            System.out.println(aList);
        }
    }
}

