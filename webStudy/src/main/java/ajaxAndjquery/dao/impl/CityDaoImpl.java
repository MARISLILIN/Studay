package ajaxAndjquery.dao.impl;

import ajaxAndjquery.bean.CityBean;
import ajaxAndjquery.bean.WordBean;
import ajaxAndjquery.dao.CityDao;
import ajaxAndjquery.dao.UserDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import stu.util.JDBCUtil02;

import java.sql.SQLException;
import java.util.List;

public class CityDaoImpl implements CityDao {

    @Override
    public List<CityBean> findCity(int pid) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());

        String sql = "select * from city where pid=? ";

        return  runner.query(sql, new BeanListHandler<CityBean>(CityBean.class), pid);

    }
}
