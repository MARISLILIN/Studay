package stu.servlet;


import stu.service.StudentService;
import stu.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 97218
 * 用户处理学生s删除求
 */
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try{
            //1、接受sid
            int sid = Integer.parseInt(req.getParameter("sid"));

            //2、执行删除
            StudentService service = new StudentServiceImpl();
            service.delete(sid);

            //3、跳转到列表页
            req.getRequestDispatcher("StudentListServlet").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
