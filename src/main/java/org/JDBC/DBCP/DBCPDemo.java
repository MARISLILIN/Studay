package org.JDBC.DBCP;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DBCPDemo {

    @Test
    public void testDBCP() {

        try{
            BasicDataSource dataSource = new BasicDataSource();

            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://localhost/student?serverTimezone=UTC");
            dataSource.setUsername("root");
            dataSource.setPassword("root");


            Connection conn = dataSource.getConnection();
            String sql = "insert into person_info values(null, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "admin");
            ps.setInt(2, 100);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
