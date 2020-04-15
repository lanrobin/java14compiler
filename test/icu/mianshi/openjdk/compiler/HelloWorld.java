package icu.mianshi.openjdk.compiler;
import java.util.List;
import java.util.ArrayList;

/**
This is HelloWorld class for main.
*/
@AnnoHelloWorld
public class HelloWorld {
	// main entry.
    public static void main(String[] args) {
		MyMath mm = new MyMath();
		var a = 10;
		int b = 2;
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
        System.out.println("" + a + "+" + b + "=" + mm.add(a, b));
		System.out.println("list.size()=" + list.size());
    }
	
	@Deprecated
	public int oldMethod(int a, int b) {
		return a + b;
	}
	
	private HelloWorldMemberClass memberEnterTest = new HelloWorldMemberClass();
}