package ListenerAndFilter.autoLogin.dao;

import ListenerAndFilter.autoLogin.bean.UserBean;

import java.sql.SQLException;

public interface UserDao {

	/**
	 * 执行登录，并返回用户的所有信息
	 * @param user  执行登录的用户信息
	 * @return
	 */
	UserBean login(UserBean user) throws SQLException;



}
