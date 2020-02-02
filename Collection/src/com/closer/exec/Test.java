package com.closer.exec;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * <p>Test</p>
 * <p>description</p>
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-02-02 20:58
 */
public class Test {
    @org.junit.Test
    public void test1() {
        TreeSet<Employee> set = new TreeSet<>(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        Employee e1 = new Employee("刘德华", 55, new MyDate(1986, 10, 4));
        Employee e2 = new Employee("张学友", 56, new MyDate(1956, 5, 14));
        Employee e3 = new Employee("郭富城", 52, new MyDate(1986, 5, 5));
        Employee e4 = new Employee("黎明", 50, new MyDate(2015, 6, 16));
        Employee e5 = new Employee("梁朝伟", 45, new MyDate(1690, 7, 31));
        Employee e6 = new Employee("梁朝伟2", 45, new MyDate(1690, 7, 31));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);
        set.add(e6);

        Iterator<Employee> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }


    @org.junit.Test
    public void test2() {
        TreeSet<Employee> set = new TreeSet<>();
        Employee e1 = new Employee("刘德华", 55, new MyDate(1986, 10, 4));
        Employee e2 = new Employee("张学友", 56, new MyDate(1956, 5, 14));
        Employee e3 = new Employee("郭富城", 52, new MyDate(1986, 5, 5));
        Employee e4 = new Employee("黎明", 50, new MyDate(2015, 6, 16));
        Employee e5 = new Employee("梁朝伟", 45, new MyDate(1690, 7, 31));
        Employee e6 = new Employee("梁朝伟2", 45, new MyDate(1690, 7, 31));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);
        set.add(e6);

        Iterator<Employee> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

