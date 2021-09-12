package ListenerAndFilter.FilterDemo.filter;

import javax.servlet.*;
import java.io.IOException;

public class FilterDemo02 implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("过滤器创建了");
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    	System.out.println("来到过滤器filter02 before");
    	filterChain.doFilter(servletRequest, servletResponse);
		System.out.println("来到过滤器filter02 after");

	}

	@Override
	public void destroy() {
		System.out.println("过滤器销毁了");
	}
}
