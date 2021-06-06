package ListenerAndFilter.ListenerDemo.domain;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;

public class Bean02 implements HttpSessionActivationListener, Serializable {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//钝化
	@Override
	public void sessionWillPassivate(HttpSessionEvent httpSessionEvent) {
		System.out.println("session中的值被钝化了。。。");
	}

	//活化
	@Override
	public void sessionDidActivate(HttpSessionEvent httpSessionEvent) {
		System.out.println("session中的值被活化了。。。");
	}
}
