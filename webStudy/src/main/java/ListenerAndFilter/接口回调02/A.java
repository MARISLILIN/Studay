package ListenerAndFilter.接口回调02;

public class A {

	/**
	 * 这是以前的java基础使用的代码。
	 * 但是假设这个A这个类是早在上个世纪80年 就写好的A类， 这个方法 内部是不能直接new B()
	 * 1. 不能直接new B
	 * 
	 * 2. 页不能传递B的实例进来。
	 * 
	 * 所以在定义这个方法的时候，不管未来写的是B 类， 还是C类，还是D类， 人家为了通用。
	 * 所以定义了一种接口，只要让未来的那些类，实现这个接口。 然后这个方法的参数写 接口类型即可。
	 */

	public void print(PrintListener listener){
		for (int i = 0; i < 10; i++) {
			System.out.println("我在1988年就开始打印这个语句了。。循环到了--"+i);
			if(i == 5){
				System.out.println("循环到了5了，该通知B 了。");
				listener.print();
			}
		}
	}
}
