package icu.mianshi.openjdk.compiler;
import static java.lang.System.out;
public class MyMath {
	public int add(int a, int b) {
		int c = a + b;
		return c;
	}
	
	private interface Mathable {
		void calculate(Number n);
	}
	
	private static class InnerMath implements Mathable {
		@Override
		public void calculate(Number n) {
			out.println("Number:" + n);
		}
	}
}

class NonPublicClass{
	public String hello() {
		return "hello";
	}
	
	public static interface Markable<T> {
		void mark(T t);
	}
}