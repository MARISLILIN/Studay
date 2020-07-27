package org;

import org.JDBC.util.JDBCUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 使用junit
 */
public class TestDemo {

    @Test
    public void testQuery() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtil.getConn();
            //创建statement
            statement = connection.createStatement();
            //执行查询
            String sql = "SELECT * FROM person_info";
            resultSet = statement.executeQuery(sql);

            //遍历结果集
            while (resultSet.next()) {
                String zjhm = resultSet.getString("zjhm");
                String xm = resultSet.getString("xm");
                String xb = resultSet.getString("xb");

                System.out.println("zjhm" + zjhm + "xm" + xm + "xb" + xb);
            }


        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally{
            JDBCUtil.release(connection, statement, resultSet);
        }
    }

    @Test
    public void testInsert() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = JDBCUtil.getConn();
            //创建statement
            statement = connection.createStatement();

            String sql = "insert into person_info values(null,'wangwu',59)";
            int result = statement.executeUpdate(sql);
            if (result > 0) {
                System.out.println("添加成功");
            } else {
                System.out.println("添加失败");
            }

        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally{
            JDBCUtil.release(connection, statement);
        }
    }

    @Test
    public void testDelete() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = JDBCUtil.getConn();
            //创建statement
            statement = connection.createStatement();

            String sql = "delete from person_info where xm='wangwu'";
            int result = statement.executeUpdate(sql);
            if (result > 0) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }

        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally{
            JDBCUtil.release(connection, statement);
        }
    }

    @Test
    public void testUpdate() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = JDBCUtil.getConn();
            //创建statement
            statement = connection.createStatement();

            String sql = "update person_info set age= 26 where xm='zhangsan'";
            int result = statement.executeUpdate(sql);
            if (result > 0) {
                System.out.println("修改成功");
            } else {
                System.out.println("修改失败");
            }

        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally{
            JDBCUtil.release(connection, statement);
        }
    }


}
