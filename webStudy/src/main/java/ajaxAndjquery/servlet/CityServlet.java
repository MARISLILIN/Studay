package ajaxAndjquery.servlet;

import ajaxAndjquery.bean.CityBean;
import ajaxAndjquery.bean.WordBean;
import ajaxAndjquery.dao.CityDao;
import ajaxAndjquery.dao.WordsDao;
import ajaxAndjquery.dao.impl.CityDaoImpl;
import ajaxAndjquery.dao.impl.WordsDaoImpl;
import com.thoughtworks.xstream.XStream;

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
public class CityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");

            int pid = Integer.parseInt(req.getParameter("pid"));

            CityDao dao = new CityDaoImpl();
            List<CityBean> list = dao.findCity(pid);

            //返回数据, 返回xml 手动拼接---->XStream 转化bean对象成xml
            XStream xStream = new XStream();

            //想把id变成属性
//            xStream.useAttributeFor(CityBean.class, "id");

            //设置别名
            xStream.alias("city", CityBean.class);
            //转化一个对象成xml
            String xml = xStream.toXML(list);
            //把xml转成java Bean对象
//            xStream.fromXML(xml)
            resp.setContentType("text/xml; charset=utf-8");
            resp.getWriter().write(xml);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
