package ListenerAndFilter.接口回调;

public class A {
	
	public void print(){
		for (int i = 0; i < 10; i++) {
			System.out.println("我在1988年就开始打印这个语句了。。循环到了--"+i);
			if(i == 5){
				System.out.println("循环到了5了，该通知B 了。");
				B b = new B();
				b.printFive();
			}
		}
	}
}
