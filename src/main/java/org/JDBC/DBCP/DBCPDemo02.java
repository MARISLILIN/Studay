package org.JDBC.DBCP;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

public class DBCPDemo02 {

    @Test
    public void testDBCP() {

//        无法获取
//        dataSource.setConnectionProperties("dbcpconfig.properties");

        Connection conn = null;
        PreparedStatement ps = null;
        try{
            Properties properties = new Properties();
            properties.load(new FileInputStream("src/dbcpconfig.properties"));
            BasicDataSource dataSource = BasicDataSourceFactory.createDataSource(properties);
            conn = dataSource.getConnection();
            String sql = "insert into person_info values(null, ?, ?)";

            ps = conn.prepareStatement(sql);
            ps.setString(1, "abc");
            ps.setInt(2, 88);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
