package ajaxAndjquery.servlet;

import ajaxAndjquery.dao.UserDao;
import ajaxAndjquery.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author 97218
 */
public class CheckUserNameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");

            //检测是否存在
            String name = req.getParameter("name");

            System.out.println("name=" + name);
            UserDao dao = new UserDaoImpl();
            boolean isExist = dao.checkUserName(name);

            //通知页面，到底有没有
            if (isExist) {
                resp.getWriter().println(1); //存在用户名
            } else {
                resp.getWriter().println(2); //不存在用户名
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
