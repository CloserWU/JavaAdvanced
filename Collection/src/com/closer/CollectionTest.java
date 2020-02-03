package com.closer;

import org.junit.Test;

import java.util.*;

/**
 * <p>CollectionTest</p>
 * <p>description</p>
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-02-03 19:31
 */
public class CollectionTest {
    @Test
    public void test1() {
        List<Integer> list = new ArrayList<>();
        list.add(123);
        list.add(123);
        list.add(123);
        list.add(454);
        list.add(676);
        list.add(909);
        list.add(7);

        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
        // 无序洗牌
        Collections.shuffle(list);
        System.out.println(list);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });
        System.out.println(list);

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });
        System.out.println(list);

        Collections.swap(list, 1, 2);
        System.out.println(list);

        /*
         * sort(Collection, ...Comparator)
         * max(Collection, ...Comparator)
         * min(Collection, ...Comparator)
         */

        System.out.println(Collections.frequency(list, 123));


        /*
         * copy(dest, source)
         * 需要dest.size() >= source.size()
         */
//        List<Integer> list1 = new ArrayList<>();  Exception
        List<Integer> dest = Arrays.asList(new Integer[list.size()]);
        Collections.copy(dest, list);
        System.out.println(dest);


        /*
         * Collections 提供了许多syncXXX()的方法
         */
        List<Integer> list1 = Collections.synchronizedList(list);
    }
}

