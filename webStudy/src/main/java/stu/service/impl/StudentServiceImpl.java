package stu.service.impl;

import stu.bean.PageBean;
import stu.bean.Student;
import stu.dao.StudentDao;
import stu.dao.impl.StudentDaoImpl;
import stu.service.StudentService;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 97218
 * 这是学生的业务实现
 */
public class StudentServiceImpl implements StudentService {
    @Override
    public PageBean findStudentByPage(int currentPage) throws SQLException {

        StudentDao dao = new StudentDaoImpl();
        //封装分页的该页数据
        PageBean<Student> pageBean = new PageBean<>();
        int pageSize = StudentDao.PAGE_SIZE;
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);
        List<Student> list = dao.findStudentByPage(currentPage);
        pageBean.setList(list);
        int count = dao.findCount();
        pageBean.setTotalSize(count);
        pageBean.setTotalPage(count % pageSize == 0 ? count / pageSize :count / pageSize + 1);

        return pageBean;
    }

    @Override
    public List<Student> findAll() throws SQLException {

        StudentDao dao = new StudentDaoImpl();
        return dao.findAll();
    }

    @Override
    public Student findStudentById(int sid) throws SQLException {

        StudentDao dao = new StudentDaoImpl();
        return dao.findStudentById(sid);
    }

    @Override
    public List<Student> searchStudent(String sname, String sgender) throws SQLException {

        StudentDao dao = new StudentDaoImpl();
        return dao.searchStudent(sname, sgender);
    }

    @Override
    public void insert(Student student) throws SQLException {

        StudentDao dao = new StudentDaoImpl();
        dao.insert(student);
    }

    @Override
    public void delete(int sid) throws SQLException {
        StudentDao dao = new StudentDaoImpl();
        dao.delete(sid);
    }

    @Override
    public void update(Student student) throws SQLException {
        StudentDao dao = new StudentDaoImpl();
        dao.update(student);
    }
}
