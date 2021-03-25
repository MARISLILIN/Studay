package stu.dao.impl;

import stu.bean.Student;
import stu.dao.StudentDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import stu.util.JDBCUtil02;
import stu.util.TextUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 97218
 * 这是StudentDao的实现。针对前面定义的规范，做出具体的实现
 */
public class StudentDaoImpl implements StudentDao {

    @Override
    public List<Student> findStudentByPage(int currentPage) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
        return runner.query("select * from stu limit ? offset ?", new BeanListHandler<Student>(Student.class), PAGE_SIZE, (currentPage - 1) * PAGE_SIZE);
    }

    /**
     * 查询所有学生
     * @return
     */
    @Override
    public List<Student> findAll() throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
        return runner.query("select * from stu ", new BeanListHandler<Student>(Student.class));
    }

    @Override
    public Student findStudentById(int sid) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
        return runner.query("select * from stu where sid=? ", new BeanHandler<Student>(Student.class), sid);

    }

    @Override
    public List<Student> searchStudent(String sname, String sgender) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());

        String sql = "select * from stu where 1=1 ";
        List<String> list = new ArrayList<>();

        if (!TextUtils.isEmpty(sname)) {
            sql += " and sname like ?";
            list.add("%" + sname + "%");
        }
        if (!TextUtils.isEmpty(sgender)) {
            sql += " and gender = ?";
            list.add(sgender);
        }

        return runner.query(sql, new BeanListHandler<Student>(Student.class), list.toArray());

    }

    @Override
    public void insert(Student student) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
        runner.update("insert into stu values(null, ?, ?, ?, ?, ?, ?) ",
                student.getSname(),
                student.getGender(),
                student.getPhone(),
                student.getBirthday(),
                student.getHobby(),
                student.getInfo()
                );
    }

    @Override
    public void delete(int sid) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
        runner.update("delete from stu where sid=?  ",sid);
    }

    @Override
    public void update(Student student) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
        runner.update("update stu set sname=?, gender=?, phone=?, birthday=?, hobby=?, info=? where sid=? ",
                student.getSname(),
                student.getGender(),
                student.getPhone(),
                student.getBirthday(),
                student.getHobby(),
                student.getInfo(),
                student.getSid()
        );
    }

    @Override
    public int findCount() throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
        Long result = (Long) runner.query("select count(*) from stu ", new ScalarHandler());
        return result.intValue();
    }
}
