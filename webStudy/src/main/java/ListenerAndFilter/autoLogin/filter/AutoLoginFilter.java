package ListenerAndFilter.autoLogin.filter;

import ListenerAndFilter.autoLogin.bean.UserBean;
import ListenerAndFilter.autoLogin.dao.UserDao;
import ListenerAndFilter.autoLogin.dao.impl.UserDaoImpl;
import ListenerAndFilter.autoLogin.util.CookieUtil;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

public class AutoLoginFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		try {
			HttpServletRequest request = (HttpServletRequest) servletRequest;

			//先判断现在session中还有没有那个userBean
			UserBean userBean = (UserBean) request.getSession().getAttribute("userBean");
			//还有，有效
			if (userBean != null) {
				filterChain.doFilter(request, servletResponse);
			} else {
				//代表session失效了，看cookie
				//来请求的时候，先从请求里面取出cookie，但是cookie中有很多key-value
				Cookie[] cookies = request.getCookies();

				//从一堆cookie里面找出以前给浏览器发的那个cookie
				Cookie cookie = CookieUtil.findCookie(cookies, "auto_login");
				//第一次来
				if (cookie == null) {
					filterChain.doFilter(request, servletResponse);
				} else {
					//不是第一次来
					String value = cookie.getValue();
					String username = value.split("#")[0];
					String password = value.split("#")[1];

					//完成登录
					UserBean user = new UserBean();
					user.setName(username);
					user.setPassWord(password);

					UserDao dao = new UserDaoImpl();
					userBean = dao.login(user);

					//存到session中
					request.getSession().setAttribute("userBean", userBean);

					//放行
					filterChain.doFilter(request, servletResponse);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			//放行
			filterChain.doFilter(servletRequest, servletResponse);
		}
	}

	@Override
	public void destroy() {

	}
}
