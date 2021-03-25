package org.JDBC.commoncrud;

import org.JDBC.util.JDBCUtil02;
import org.JDBC.util.bean.PersonInfo;
import org.apache.commons.dbutils.ResultSetHandler;
import org.junit.Test;

import java.sql.*;

public class CommonCRUDUtil {

    @Test
    public void test() {
    /*String sql = "insert into person_info values(null, ?, ?)";

    update(sql,"aaa", 123,111,112,21);*/

        PersonInfo query = query(
                "select * from person_info where id=?",
                new ResultSetHandler<PersonInfo>() {
                    @Override
                    public PersonInfo handle(ResultSet resultSet) throws SQLException {
                        PersonInfo t = new PersonInfo();
                        if (resultSet.next()) {
                            int id = resultSet.getInt("id");
                            String xm = resultSet.getString("xm");
                            int age = resultSet.getInt("age");

                            t.setId(id);
                            t.setAge(age);
                            t.setXm(xm);
                        }
                        return t;
                    }
                },
                20);

    System.out.println(query);
    }

    public <T> T query(String sql, ResultSetHandler<T> handler, Object ... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = JDBCUtil02.getConn();
            ps = conn.prepareStatement(sql);

            ParameterMetaData metaData = ps.getParameterMetaData();
            int count = metaData.getParameterCount();
            for (int i = 0; i < count; i++) {
                ps.setObject(i + 1, args[i]);
            }

            ResultSet rs = ps.executeQuery();

            T t = handler.handle(rs);

            return t;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            JDBCUtil02.release(conn, ps);
        }
        return null;

    }


    public void update(String sql, Object ... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = JDBCUtil02.getConn();
            ps = conn.prepareStatement(sql);

            /*for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }*/

            ParameterMetaData metaData = ps.getParameterMetaData();
            int count = metaData.getParameterCount();
            for (int i = 0; i < count; i++) {
                ps.setObject(i + 1, args[i]);
            }

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            JDBCUtil02.release(conn, ps);
        }


    }
}

