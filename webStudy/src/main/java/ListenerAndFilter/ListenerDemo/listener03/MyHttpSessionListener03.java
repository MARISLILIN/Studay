package ListenerAndFilter.ListenerDemo.listener03;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;

public class MyHttpSessionListener03 implements HttpSessionActivationListener {

	//钝化
	@Override
	public void sessionWillPassivate(HttpSessionEvent httpSessionEvent) {
    	System.out.println("session被钝化了。。。");
	}

	//活化
	@Override
	public void sessionDidActivate(HttpSessionEvent httpSessionEvent) {
		System.out.println("session被活化了。。。");
	}
}
