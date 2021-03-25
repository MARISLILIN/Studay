package ajaxAndjquery.dao;

import java.sql.SQLException;

public interface UserDao {

    /**
     * 用于检测用户名是否存在
     * @param username
     * @return true false
     */
    boolean checkUserName(String username) throws SQLException;
}
