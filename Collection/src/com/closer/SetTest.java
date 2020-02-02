package com.closer;

import org.junit.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * <p>SetTest</p>
 * <p>description</p>
 * <p>
 * Set
 * - HashSet 线程不安全 可以存Null值，
 * 无序      根据hash值决定在数据的位置
 * 不可重复   根据hashCode()返回值，为true不存入
 * 拉链法处理冲突，hashCode相同的位置，进行拉链，调用equals方法，来判断最终是否存入链中。
 * jdk8中，拉链中存放成功后，存放到拉链head(第一个)
 * - LinkedHashSet 在HashSet中，对每个节点都有个前后指针，查找快，但建立哈希表慢
 * - TreeSet 红黑树 可排序 按照对象指定属性排序，数据必须是同一个类的对象
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-02-02 11:08
 */
public class SetTest {
    /**
     * Set
     * Set中的方法都是Collection的，没有添加新方法
     */
    @Test
    public void test1() {
        Set<Object> set = new HashSet<>();
        set.add(23);
        // 不会加入set
        set.add(new Integer(23));
        set.add(5421);
        set.add(new Person(2.0, "ws"));
        // Person重写hashCode方法，判断只要是true，则不会重复添加
        set.add(new Person(2.0, "ws"));
        set.add("AVC1");
        System.out.println(set);
    }


    /**
     * TreeSet中的数据必须是同一个类的对象
     */
    @Test
    public void test2() {
        TreeSet<Person> treeSet = new TreeSet<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.getPrice().equals(o2.getPrice())) {
                    return o1.getName().compareTo(o2.getName());
                } else if (o1.getPrice() > o2.getPrice()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        treeSet.add(new Person(2.0, "AA"));
        treeSet.add(new Person(3.0, "AA"));
        treeSet.add(new Person(3.0, "CC"));
        treeSet.add(new Person(4.0, "BB"));
        treeSet.add(new Person(1.0, "DD"));

        System.out.println(treeSet);


    }

    /*
     * 1.集合Collection中存储的如果是自定义类对象，需要自定义重写哪个方法？
     *   equals()
     *   List: equals()
     *   Set: [HashSet, LinkedHashSet] -> equals(), hashCode();
     *        [TreeSet] -> Comparable: compareTo(Object)
     *                     Comparator: compare(Object, Object)
     *
     * 2.ArrayList, LinkedList, Vector(废弃) 三者的不同点
     *   - 底层存储不同
     *   - 查找效率不同
     *   - 删除、插入效率不同
     *   - 安全性
     *
     * 3.List常用方法
     *    23个
     *
     * 4.Set存储特点，及其实现类特点
     *    第层实现  HashSet -> HashMap  LinkedHashSet -> LinkedHashMap   TreeSet -> TreeMap
     */
}

