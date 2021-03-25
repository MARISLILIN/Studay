package ajaxAndjquery.servlet;

import ajaxAndjquery.bean.WordBean;
import ajaxAndjquery.dao.UserDao;
import ajaxAndjquery.dao.WordsDao;
import ajaxAndjquery.dao.impl.UserDaoImpl;
import ajaxAndjquery.dao.impl.WordsDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 97218
 */
public class FindWordsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");

            String word = req.getParameter("word");
            System.out.println(word);
            WordsDao dao = new WordsDaoImpl();
            List<WordBean> list = dao.findWords(word);

            for (WordBean wordBean : list) {
                System.out.println(wordBean.toString());
            }
            req.setAttribute("list", list);

            //返回数据
            resp.setContentType("text/html;charset=utf-8");
//            resp.getWriter().write("数据是。。。");
            req.getRequestDispatcher("AjaxAndJQuery/list.jsp").forward(req, resp);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
