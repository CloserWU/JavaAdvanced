package com.closer.exec;

import org.junit.Test;

/**
 * <p>DAOTest</p>
 * <p>description</p>
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-02-04 10:49
 */
public class DAOTest {
    @Test
    public void test1() {
        CustomerDAO dao = new CustomerDAO();
        dao.add(new Customer());
        dao.delete(2);

        StudentDAO dao1 = new StudentDAO();
        dao1.add(new Student());
    }
}

