package org.JDBC.dao;

import org.JDBC.dao.impl.PersonDaoImpl;
import org.junit.Test;

public class TestPersonDaoImpl {


    @Test
    public void testFindAll() {
        PersonDao dao = new PersonDaoImpl();
        dao.findAll();
    }

    @Test
    public void testlogin() {
        PersonDao dao = new PersonDaoImpl();
        dao.login("zhangsan","27");
    }
}
