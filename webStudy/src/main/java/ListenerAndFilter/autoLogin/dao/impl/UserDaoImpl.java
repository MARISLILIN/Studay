package ListenerAndFilter.autoLogin.dao.impl;

import ListenerAndFilter.autoLogin.bean.UserBean;
import ListenerAndFilter.autoLogin.dao.UserDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import stu.util.JDBCUtil02;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
	@Override
	public UserBean login(UserBean user) throws SQLException {

		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		String sql = "select * from user where name = ? and password = ?";

		return runner.query(sql, new BeanHandler<>(UserBean.class), user.getName(), user.getPassWord());
	}
}
