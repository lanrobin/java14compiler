/**
* This package is test for kinds of java language features.
*/
@ReleaseTo(customer = "https://www.mianshi.icu")
package icu.mianshi.openjdk.compiler;

class PackageSharedClass {
	public static void test() {
		System.out.println("package shared class");
	}
}

final class PackageConst {
	public static String CONST = "Hello world";
	
	private PackageConst(){}
}