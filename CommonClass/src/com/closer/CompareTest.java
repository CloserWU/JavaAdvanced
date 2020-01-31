package com.closer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <p>CompareTest</p>
 * <p>description</p>
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-01-31 11:39
 */
public class CompareTest {
    @Test
    public void test1() {
        String[] arr = new String[] {"AA", "BB", "CC", "DD"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2() {
        List<Goods> goods = new ArrayList<>();
        goods.add(new Goods(2.0, "衣服"));
        goods.add(new Goods(3.0, "鞋子"));
        goods.add(new Goods(4.0, "电脑"));
        goods.add(new Goods(4.0, "显卡"));
        goods.add(new Goods(5.0, "CPU"));

        goods.sort(new Comparator<Goods>() {
            @Override
            public int compare(Goods o1, Goods o2) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            }
        });
        System.out.println(goods);

    }


    @Test
    public void test3() {
        Goods[] goods = new Goods[5];
        goods[0] = new Goods(2.0, "衣服");
        goods[1] = new Goods(3.0, "衣服");
        goods[2] = new Goods(4.0, "衣服");
        goods[3] = new Goods(5.0, "衣服");
        goods[4] = new Goods(4.0, "显卡");
        Arrays.sort(goods);
        System.out.println(Arrays.toString(goods));

        Arrays.sort(goods, new Comparator<Goods>() {
            @Override
            public int compare(Goods o1, Goods o2) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            }
        });

        System.out.println(Arrays.toString(goods));
    }
}

