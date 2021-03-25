package org.JDBC.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.JDBC.util.bean.PersonInfo;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class TestDbUtils {

    @Test
    public void insertTest() throws SQLException {

        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        QueryRunner queryRunner = new QueryRunner(dataSource);

//        queryRunner.update("insert into person_info values(null, ?, ?)", "aa", 1000);

//        queryRunner.update("delete from person_info where id = ?", 19);

//        queryRunner.update("update person_info set age = ? where id = ?", 19, 20);
/*
        PersonInfo personInfo = queryRunner.query("select * from person_info where id = ?", new ResultSetHandler<PersonInfo>() {

            @Override
            public PersonInfo handle(ResultSet resultSet) throws SQLException {
                PersonInfo personInfo = new PersonInfo();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String xm = resultSet.getString("xm");
                    int age = resultSet.getInt("age");

                    personInfo.setId(id);
                    personInfo.setAge(age);
                    personInfo.setName(xm);
                }

                return personInfo;
            }
        }, 2);

        System.out.println(personInfo.toString());
        */

/*

        PersonInfo personInfo = queryRunner.query("select * from person_info where id = ?", new BeanHandler< PersonInfo>(PersonInfo.class), 2);
        System.out.println(personInfo.toString());
*/
        List<PersonInfo> list = queryRunner.query("select * from person_info where id = ?", new BeanListHandler<PersonInfo>(PersonInfo.class), 2);

    for (PersonInfo personInfo : list) {
        System.out.println(personInfo.toString());
    }

    }
}
