package stu.servlet;


import stu.bean.PageBean;
import stu.service.StudentService;
import stu.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 97218
 * 负责查询所有的学生信息。然后呈现到list.jsp页面
 */
public class StudentListPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            //1、获取需要显示的页码数
            int currentPage = Integer.parseInt(req.getParameter("currentPage"));

            //2、根据指定的页数，去获取该页的数据
            StudentService service = new StudentServiceImpl();
            PageBean pageBean = service.findStudentByPage(currentPage);

            //3、跳转页面
            req.setAttribute("pageBean", pageBean);
            //3、跳转页面
            req.getRequestDispatcher("list_page.jsp").forward(req, resp);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
