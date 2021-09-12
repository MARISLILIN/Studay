package ListenerAndFilter.FilterDemo.filter;

import javax.servlet.*;
import java.io.IOException;

public class FilterDemo implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("过滤器创建了");
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    	System.out.println("来到过滤器了");
    	filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void destroy() {
		System.out.println("过滤器销毁了");
	}
}
