package ListenerAndFilter.autoLogin.servlet;

import ListenerAndFilter.autoLogin.bean.UserBean;
import ListenerAndFilter.autoLogin.dao.UserDao;
import ListenerAndFilter.autoLogin.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String autoLogin = req.getParameter("auto_login");

			UserBean user = new UserBean();
			user.setName(username);
			user.setPassWord(password);

			UserDao dao = new UserDaoImpl();
			UserBean userBean = dao.login(user);

			if (userBean != null) {
				//页面提交，是否选择自动登录
				if ("on".equals(autoLogin)) {
					//发送cookie给客户端
					Cookie cookie = new Cookie("auto_login", username + "#" + password);

					cookie.setMaxAge(60*60*24*7);//7天有效期
//					cookie.setPath("/AutoLooginDemo");
          			cookie.setPath(req.getContextPath());
					resp.addCookie(cookie);
				}



				req.getSession().setAttribute("userBean", userBean);


				//成功，进入首页
				resp.sendRedirect("index.jsp");
			} else {
				//不成功
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}



	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
