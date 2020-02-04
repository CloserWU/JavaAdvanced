package com.closer.exec1;

import java.util.*;

/**
 * <p>DAO</p>
 * <p>description</p>
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-02-04 16:49
 */
public class DAO<T> {
    private Map<String, T> map;

    public DAO() {
        map = new HashMap<>();
    }

    public void save(String id, T entity) {
        map.put(id, entity);
    }

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T entity) {
        if (map.containsKey(id)) {
            map.put(id, entity);
        }
    }

    public List<T> list() {
       /*
        wrong 无法强制转型 map中的value就是Collection类型，无法转为其子类List
        Collection<T> values = map.values();
        return (List<T>) values;
       */

        Collection<T> values = map.values();
        return new ArrayList<>(values);
    }

    public void delete(String id) {
        map.remove(id);
    }
}

