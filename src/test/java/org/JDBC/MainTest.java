package org;

import org.JDBC.util.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainTest {
  public static void main(String[] args) {

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
}
