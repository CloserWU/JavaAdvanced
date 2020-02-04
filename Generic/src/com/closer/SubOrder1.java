package com.closer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>SubOrder1</p>
 * <p>description</p>
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-02-04 10:01
 */
public class SubOrder1<T> extends Order<T> {
    /**
     * 泛型方法可以是static的
     */
    public static  <E> List<E> copyFromArrayToList_Sub(E[] arr) {
        List<E> list = new ArrayList<>(Arrays.asList(arr));
        return list;
    }
}

