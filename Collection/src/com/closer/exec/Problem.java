package com.closer.exec;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>Problem</p>
 * <p>description</p>
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-02-02 21:15
 */
public class Problem {
    @Test
    public void test1() {

        // 若是自定义类，则需要重写equals和hashCode
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);

        List<Integer> list1 = duplicateList(list);

        for (Integer i: list1) {
            System.out.println(i);
        }
    }

    List<Integer> duplicateList(List<Integer> list) {
        Set<Integer> hashSet = new HashSet<>(list);
        hashSet.addAll(list);
        return new ArrayList<>(hashSet);
    }


    @Test
    public void test2() {

        // set中存对象的索引
        Set<Person> set = new HashSet<>();

        Person p1 = new Person(1001.0, "AA");
        Person p2 = new Person(1002.0, "BB");

        set.add(p1);  // AA 1001
        set.add(p2);  // BB 1002  AA 1001

        p1.setName("CC");  // CC 1001(位置没有变哦)  BB 1002
        set.remove(p1);    // p1现在的hash不再CC 1001 位置上


        // p1的hashCode已经改变，
        // set 会认为 p1已经不再set中，所以remove失败
        System.out.println(set);

        set.add(new Person(1001.0, "CC")); // CC 1001(在AA的位置上)  BB 1002  CC 1001
        System.out.println(set);

        set.add(new Person(1001.0,"AA"));  // hashCode到CC 1001， 但是不equals 所以成功加入
        System.out.println(set);

    }
}

