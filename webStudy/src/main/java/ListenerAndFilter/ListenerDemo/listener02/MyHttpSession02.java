package ListenerAndFilter.ListenerDemo.listener02;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSession02 implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
    	System.out.println("属性被添加了");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
		System.out.println("属性被移除了");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
		System.out.println("属性被替换了");
	}
}
