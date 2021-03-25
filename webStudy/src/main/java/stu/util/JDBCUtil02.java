package stu.util;


import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil02 {

    static ComboPooledDataSource dataSource = null;

    static {
        dataSource = new ComboPooledDataSource("Test_c3p0");
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConn() throws SQLException {

        return dataSource.getConnection();
    }




    public static void release(Connection conn, Statement st, ResultSet rs) {
        closeConn(conn);
        closeSt(st);
        closeRs(rs);
    }
    public static void release(Connection conn, Statement st) {
        closeConn(conn);
        closeSt(st);
    }

    private static void closeRs(ResultSet rs) {
        try{
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            rs = null;
        }
    }

    private static void closeSt(Statement st) {
        try{
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            st = null;
        }
    }

    private static void closeConn(Connection conn) {
        try{
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            conn = null;
        }
    }
}
