package org.JDBC.C3P0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class C3P0Demo2 {
    @Test
    public void testC3P0() {


        Connection conn = null;
        PreparedStatement ps = null;
        try{
//            ComboPooledDataSource dataSource = new ComboPooledDataSource("Test_c3p0");
            ComboPooledDataSource dataSource = new ComboPooledDataSource();


            conn = dataSource.getConnection();
            String sql = "insert into person_info values(null, ?, ?)";

            ps = conn.prepareStatement(sql);
            ps.setString(1, "wangwu");
            ps.setInt(2, 10086);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
