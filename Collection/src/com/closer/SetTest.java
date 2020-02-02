package com.closer;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>SetTest</p>
 * <p>description</p>
 *
 * Set
 *  - HashSet 线程不安全 可以存Null值，
 *              无序      根据hash值决定在数据的位置
 *              不可重复   根据hashCode()返回值，为true不存入
 *      拉链法处理冲突，hashCode相同的位置，进行拉链，调用equals方法，来判断最终是否存入链中。
 *          jdk8中，拉链中存放成功后，存放到拉链head(第一个)
 *    - LinkedHashSet
 *  - TreeSet 红黑树 可排序
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-02-02 11:08
 */
public class SetTest {
    /** Set
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
}

