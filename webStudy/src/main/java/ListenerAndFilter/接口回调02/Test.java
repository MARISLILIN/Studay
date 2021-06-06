package ListenerAndFilter.接口回调02;

public class Test {

	public static void main(String[] args) {
		A a = new A();
		
		//这是多态的体现，
		a.print(new B());
	}
}
