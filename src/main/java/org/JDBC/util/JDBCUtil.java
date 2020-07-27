package org.JDBC.util;


import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {

    static String driverClass = null;
    static String url = null;
    static String username = null;
    static String password = null;

    static {
        try {
            Properties properties = new Properties();
//            InputStream is = new FileInputStream("src/main/jdbc.properties");
            //配置文件需要放在源文件夹路径下
            InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");

            properties.load(is);

            driverClass = properties.getProperty("driverClass");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConn() {
        Connection connection = null;

        try{
            //注册驱动
            //DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
//            Class.forName(driverClass);
            //建立连接   新版jdbc驱动需要设置时区  serverTimezone=UTC
            connection = DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
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
