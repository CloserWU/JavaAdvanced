package com.closer.map;

import org.junit.Test;

import java.util.*;

/**
 * <p>MapTest1</p>
 * <p>description</p>
 *
 * - Map : K - V 键值对
 *     - HashMap 线程不安全 效率高 可以存null的key和value
 *            - LinkedHashMap 在原有HashMap底层基础上，添加了一对指针，指向一个前一个后，可以顺序遍历
 *     - TreeMap  按添加的 k - v 进行遍历，实现排序 按照K排
 *     - Hashtable 古老实现类 线程安全 效率低 不能存null的key和value
 *            - Properties
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-02-03 09:21
 */
public class MapTest1 {
    @Test
    public void test1() {
        Map<Object, Object> map = new HashMap<>();
        map.put(null, null);
        System.out.println(map);
        Map<Object, Object> map1 = new Hashtable<>();
        map.put(null, null);
        System.out.println(map1);
    }


    /*
     * Key是set 不能重复，且无序
     * value可以重复 用collection存储 可重复 无序
     * Entry 是set 不能重复 且无序
     *
     * HashMap，key要重写equals 和 hashCode;
     * TreeMap，key要实现Comparable接口
     * value要重写equals
     */

    /*
     * HashMap底层：
     *      jdk7： new HashMap后， 创造长为16的entry数组
     *             put(k1，v1) 时，首先计算k1的hashCode，得到在entry中的存放位置(& 15)
     *                             如果此位置为空，则添加进去
     *                             若不为空，则此位置存在一个或多个数据(链表)，然后依次比较hashCode，
     *                                  如果存在hash相同，则调用equals
     *                                        equals相同，使用value替换原来的
     *                                        equals不同，则添加成功， 插入链表
     *                                  若hash都不同，则添加成功 ，插到末尾
     *              添加过程中，扩容时默认扩容为2倍，并将数据复制过来，
     *              当hash表中的数据个数超过临界值时 (threshold = 装填因子 * 数组长),扩容
     *
     *       jdk8： new HashMap时，没有创建长度为16的数组
     *              且底层数组类型为Node，而非entry
     *              首此put()时， 创建长为16的数组
     *              当数组的某一个索引位置上的元素的链表长大于8时，且当前数组长度超过64，
     *              则此索引位置上的所有数据改为红黑树存储
     *
     */


    /*
     * LinkedHashMap底层:
     * static class Entry<K,V> extends HashMap.Node<K,V> {
            Entry<K,V> before, after;  前后指针
            Entry(int hash, K key, V value, Node<K,V> next) {
                super(hash, key, value, next);
            }
        }
     *
     */

    @Test
    public void test2() {
        Map<Object, Object> map = new LinkedHashMap<>();
        map.put(123, "AA");
        map.put(124, "VV");
        map.put(125, "FF");
        System.out.println(map);

        Map<Object, Object> map1 = new HashMap<>();
        map1.put(123, "AA");
        map1.put(124, "VV");
        map1.put(125, "FF");
        System.out.println(map1);
    }

    @Test
    public void test3() {
        Map<Object, Object> map = new HashMap<>();
        map.put("AA", 123);
        map.put(45, 123);
        map.put("BB", 56);
        map.put("AA", 87);
        System.out.println(map);
        System.out.println("-------------------------------");

        Map<Object, Object> map1 = new HashMap<>();
        map1.put("CC", 123);
        map1.put("DD", 213);

        map.putAll(map1);
        System.out.println(map);
        System.out.println("-------------------------------");

        Object o = map.remove("CC");
        System.out.println(o);
        System.out.println(map);


        Object o1 = map.remove("NOT EXIST");
        System.out.println(o1);
        System.out.println("-------------------------------");

        System.out.println(map.get(45));


        System.out.println(map.containsKey("BB"));

        System.out.println(map.containsValue(123));

        System.out.println(map.isEmpty());
        System.out.println("-------------------------------");


        Set<Object> set = map.keySet();
        for (Object aSet : set) {
            System.out.println(aSet);
        }
        System.out.println();

        Collection<Object> values = map.values();
        for (Object aValues: values) {
            System.out.println(aValues);
        }
        System.out.println();


        Set<Map.Entry<Object, Object>> entries = map.entrySet();
        for (Map.Entry<Object, Object> next : entries) {
            System.out.println(next.getKey() + " = " + next.getValue());
        }


        System.out.println("-------------------------------");

        map.clear();
        System.out.println(map.size());
        System.out.println(map);


    }
}

