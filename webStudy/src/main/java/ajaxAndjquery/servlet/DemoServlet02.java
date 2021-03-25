package ajaxAndjquery.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 97218
 */
public class DemoServlet02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));


        System.out.println("收到请求" + name + "=" + age);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("给你一份数据");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
