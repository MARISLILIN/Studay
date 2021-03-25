package ajaxAndjquery.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 97218
 */
public class DemoServlet01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");

        String name = req.getParameter("name");
        String age = req.getParameter("age");

        System.out.println("收到了一个请求...." + name + "=" + age);

        resp.getWriter().write("收到了请求。。。。");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("现在来了一个post请求，走get代码");
        doGet(req, resp);
    }
}
