package org.JDBC.C3P0;

import org.JDBC.util.JDBCUtil02;

import java.sql.Connection;
import java.sql.SQLException;

public class Test {
  public static void main(String[] args) {
      try {
          Connection conn = JDBCUtil02.getConn();
      } catch (SQLException throwables) {
          throwables.printStackTrace();
      }

  }
}
