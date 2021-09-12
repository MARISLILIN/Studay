package ListenerAndFilter.接口回调02;

public class B  implements PrintListener{

	@Override
	public void print() {
		System.out.println("2018年。。。A已经循环到了5， 所以B的这个方法将被调用");
	}
}
