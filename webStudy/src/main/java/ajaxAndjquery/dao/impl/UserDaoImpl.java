package ajaxAndjquery.dao.impl;

import ajaxAndjquery.dao.UserDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import stu.util.JDBCUtil02;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean checkUserName(String username) throws SQLException {

        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());

        String sql = "select count(*) from user where name = ? ";

        Long result = (Long) runner.query(sql, new ScalarHandler<>(), username);


        return result > 0;
    }
}
