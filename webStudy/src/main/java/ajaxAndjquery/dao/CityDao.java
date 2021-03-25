package ajaxAndjquery.dao;

import ajaxAndjquery.bean.CityBean;
import ajaxAndjquery.bean.WordBean;

import java.sql.SQLException;
import java.util.List;

public interface CityDao {

    List<CityBean> findCity(int pid) throws SQLException;
}
