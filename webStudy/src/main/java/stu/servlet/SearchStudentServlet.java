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
 * 用户处理学生的添加请求
 */
public class SearchStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        try {
            //1、获取客户端提交上来的数据
            String sname = req.getParameter("sname");
            String sgender = req.getParameter("sgender");

            StudentService service = new StudentServiceImpl();
            List<Student> list = service.searchStudent(sname, sgender);
            //2、先把数据存储到作用域中
            req.setAttribute("list", list);
            //3、跳转页面
            req.getRequestDispatcher("list.jsp").forward(req, resp);

        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
