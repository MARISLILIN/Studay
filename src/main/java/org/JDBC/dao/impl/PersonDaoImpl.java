package org.JDBC.dao.impl;

import org.JDBC.dao.PersonDao;
import org.JDBC.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PersonDaoImpl implements PersonDao {
    @Override
    public void findAll() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConn();
            st = conn.createStatement();

            String sql = "select * from person_info";
            rs = st.executeQuery(sql);

          while (rs.next()) {
              String xm = rs.getString("xm");
              int age = rs.getInt("age");

              System.out.println(xm + "---" + age);
          }

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            JDBCUtil.release(conn, st, rs);
        }
    }

    /*@Override
    public void login(String name, String age) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConn();
            st = conn.createStatement();

            String sql = "select * from person_info where xm='" + name +"' and age="+age;
            rs = st.executeQuery(sql);

            if (rs.next()) {
                System.out.println("登录成功");
            } else {
                System.out.println("登录失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            JDBCUtil.release(conn, st, rs);
        }
    }*/

    @Override
    public void login(String name, String age) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConn();
            String sql = "select * from person_info where xm=? and age=?";
            
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,age);

            rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("登录成功");
            } else {
                System.out.println("登录失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            JDBCUtil.release(conn, ps, rs);
        }
    }


}
