package ajaxAndjquery.dao.impl;

import ajaxAndjquery.bean.WordBean;
import ajaxAndjquery.dao.UserDao;
import ajaxAndjquery.dao.WordsDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import stu.util.JDBCUtil02;

import java.sql.SQLException;
import java.util.List;

public class WordsDaoImpl implements WordsDao {

    @Override
    public List<WordBean> findWords(String word) throws SQLException {

        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());

        String sql = "select * from words where words like ? limit ?";

        return  runner.query(sql, new BeanListHandler<WordBean>(WordBean.class), word + "%", 5);

    }
}
