package stu.servlet;


import stu.bean.Student;
import stu.service.StudentService;
import stu.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 97218
 * 负责查询所有的学生信息。然后呈现到list.jsp页面
 */
public class StudentListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            //1、查询出所有的学生
            StudentService service = new StudentServiceImpl();
            List<Student> list = service.findAll();

            //2、先把数据存储到作用域中
            req.setAttribute("list", list);
            //3、跳转页面
            req.getRequestDispatcher("list.jsp").forward(req, resp);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
