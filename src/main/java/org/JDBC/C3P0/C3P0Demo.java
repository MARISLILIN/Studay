package org.JDBC.C3P0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class C3P0Demo {
    @Test
    public void testC3P0() {


        Connection conn = null;
        PreparedStatement ps = null;
        try{
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost/student?serverTimezone=UTC");
            dataSource.setUser("root");
            dataSource.setPassword("root");

            conn = dataSource.getConnection();
            String sql = "insert into person_info values(null, ?, ?)";

            ps = conn.prepareStatement(sql);
            ps.setString(1, "hhhhhhhhhhhh");
            ps.setInt(2, 10086);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
