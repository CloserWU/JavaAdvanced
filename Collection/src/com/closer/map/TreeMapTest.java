package com.closer.map;

import com.closer.Person;
import org.junit.Test;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * <p>TreeMapTest</p>
 * <p>description</p>
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-02-03 19:09
 */
public class TreeMapTest {
    @Test
    public void test1() {
        TreeMap<Person, Integer> map = new TreeMap<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.getPrice().equals(o2.getPrice())) {
                    return o1.getName().compareTo(o2.getName());
                } else {
                    return Double.compare(o1.getPrice(), o2.getPrice());
                }
            }
        });
        map.put(new Person(2.0, "AA"), 98);
        map.put(new Person(-4.0, "FF"), 59);
        map.put(new Person(9.0, "AA"), 105);
        map.put(new Person(9.0, "AA"), 204);
        map.put(new Person(9.0, "DD"), 102);
        map.put(new Person(5.0, "HH"), 95);


        Set<Map.Entry<Person, Integer>> entries = map.entrySet();
        for (Map.Entry<Person, Integer> o : entries) {
            System.out.println(o.getKey() + " " + o.getValue());
        }

    }
}

