package ajaxAndjquery.dao;

import ajaxAndjquery.bean.WordBean;

import java.sql.SQLException;
import java.util.List;

public interface WordsDao {

    List<WordBean> findWords(String word) throws SQLException;
}
