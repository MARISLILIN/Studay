package stu.servlet;


import stu.bean.Student;
import stu.service.StudentService;
import stu.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 97218
 * 用户处理单个学生的更新
 */
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            //1、接受sid
            int sid = Integer.parseInt(req.getParameter("sid"));

            //2、查询学生数据
            StudentService service = new StudentServiceImpl();
            Student student = service.findStudentById(sid);

            //3、先把数据存储到作用域中
            req.setAttribute("stu", student);

            //4、跳转到列表页
            req.getRequestDispatcher("edit.jsp").forward(req, resp);

        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
