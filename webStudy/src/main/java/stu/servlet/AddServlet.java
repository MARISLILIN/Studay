package stu.servlet;


import stu.bean.Student;
import stu.service.StudentService;
import stu.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author 97218
 * 用户处理学生的添加请求
 */
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        try {
            //1、获取客户端提交上来的数据
            String sname = req.getParameter("sname");
            String gender = req.getParameter("gender");
            String phone = req.getParameter("phone");
            String birthday = req.getParameter("birthday");
//            String hobby = req.getParameter("hobby");
            String[] h = req.getParameterValues("hobby");
            String info = req.getParameter("info");

            String hobby = Arrays.toString(h);
            hobby = hobby.substring(1, hobby.length() - 1);

            //2、添加到数据库
            Date date = new SimpleDateFormat("yyy-MM-dd").parse(birthday);


            Student student = new Student(sname, gender,phone,hobby,info,date);
            StudentService service = new StudentServiceImpl();
            service.insert(student);

            //3、跳转到列表页

//            req.getRequestDispatcher("list.jsp").forward(req, resp);
            req.getRequestDispatcher("StudentListServlet").forward(req, resp);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
