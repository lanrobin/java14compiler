package icu.mianshi.openjdk.compiler;

public class HelloWorld {
    public static void main(String[] args) {
		MyMath mm = new MyMath();
		int a = 10;
		int b = 2;
        System.out.println("" + a + "+" + b + "=" + mm.add(a, b));
    }
}