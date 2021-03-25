package ajaxAndjquery.servlet;

import ajaxAndjquery.bean.CityBean;
import ajaxAndjquery.dao.CityDao;
import ajaxAndjquery.dao.impl.CityDaoImpl;
import net.sf.json.JSONArray;

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
public class CityServlet02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");

            int pid = Integer.parseInt(req.getParameter("pid"));

            CityDao dao = new CityDaoImpl();
            List<CityBean> list = dao.findCity(pid);

            //把list集合--->json数据
//            JSONObject;--->变成简单的数据
//            JSONArray;---->变成数组
            JSONArray jsonArray = JSONArray.fromObject(list);
            String json = jsonArray.toString();
//            System.out.println(json);
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write(json);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
