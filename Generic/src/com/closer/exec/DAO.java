package com.closer.exec;

import java.util.List;

/**
 * <p>DAO</p>
 * <p>description</p>
 *
 * Data Access Object
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-02-04 10:43
 */
public class DAO<T> {

    public void add(T t) {}
    public void delete(int index) {}
    public void update(int index, T t) {}
    public T get(int index) {return null;}
    public List<T> getAll() {return null;}

    // 泛型方法
    public <E> E getValue() {return null;}
}
