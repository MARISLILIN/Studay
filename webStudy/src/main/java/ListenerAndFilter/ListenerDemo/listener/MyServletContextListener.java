package ListenerAndFilter.ListenerDemo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {

	//初始化的时候调用
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("servletContext 初始化了...");
	}

	//销毁的时候调用
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("servletContext 销毁了...");

	}

}
