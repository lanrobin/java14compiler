/**
 * 文件全路径与名字 icu/mianshi/openjdk/compiler/InvalidJavaFile.java
 */
package icu.mianshi.openjdk.compiler;

/**
 * 1. public类名与文件名不一致
 */
public class AnotherInvalidJavaFile {
    public static void main(String[] args) {
        System.out.println("InvalidJavaFile");
    }

    /**
     * 2. 重复的Java方法定义
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("InvalidJavaFile");
    }
}

/**
 * 3. InnerClass与DerivedClass循环引用。
 */
class InnerClass extends  DerivedClass{}

/**
 * 4. 重复的类定义。
 */
class InnerClass{}

class DerivedClass extends InnerClass {

}