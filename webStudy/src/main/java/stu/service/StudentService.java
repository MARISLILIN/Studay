package stu.service;

import stu.bean.PageBean;
import stu.bean.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 97218
 * 这是学生的业务处理规则
 */
public interface StudentService {

    /**
     * 根据页数查询所有学生
     * @return List<Student>
     * */
    PageBean findStudentByPage(int currentPage) throws SQLException;

    List<Student> findAll() throws SQLException;

    /**
     * 通过sid查询学生
     * @return Student
     * */
    Student findStudentById(int sid) throws SQLException;

    /**
     * 模糊查询学生
     * @return Student
     * */
    List<Student> searchStudent(String sname, String sgender) throws SQLException;

    /**
     * 添加学生
     * @param student
     * @throws SQLException
     */
    void insert(Student student) throws SQLException;


    /**
     * 更具id删除学生
     * @param sid
     * @throws SQLException
     */
    void delete(int sid) throws SQLException;


    /**
     * 更新学生
     * @param student
     * @throws SQLException
     */
    void update(Student student) throws SQLException;

}
