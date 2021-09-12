package ListenerAndFilter.ListenerDemo.domain;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Bean01 implements HttpSessionBindingListener {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
    	System.out.println("对象被绑定进来了");
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
		System.out.println("对象被解除绑定了");
	}
}
