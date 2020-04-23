package icu.mianshi.openjdk.compiler;

import java.util.Arrays;
import java.util.List;
import java.util.Date;
/**
 * This is a complex java file.
 */
public class Enclosings extends AbstractEnclosings implements Runnable{
    public Object c = null;

    public Object classAObject() {
        int index = 10;
        printInt(index);
        for(int i = 0; i < index; i++) {
            index += i;
        }
        class ClassInMethod1{};
        return new ClassInMethod1();
    }
    public Enclosings() {
        class ClassInConstructor {};
        c = new ClassInConstructor();
    }



    public Runnable classWithAnonymousClass() {
        return new Runnable() {
            public void run() {}
        };
    }

    private static void printInt(int i) {
        System.out.println("print:" + i);
    }

    public Object innerClassAObject() {
        class ClassInMethod2{
            public Object classInClass() {
                class ClassC{};
                Object clzc =  new ClassC();
                Class<?> cclz = clzc.getClass();
                System.out.println("5:" + cclz.getName() +", enclosings:" + String.join(",", getEnclosings(cclz)));
                return clzc;
            }
        };
        Object obj = new ClassInMethod2().classInClass();
        System.out.println("6:" + obj.getClass().getName() +", enclosings:" + String.join(",", getEnclosings(obj.getClass())));
        return obj;
    }

    public static void main(String[] args) {

        System.out.println("1:" + Enclosings.class.getName() +", enclosings:" + String.join(",", getEnclosings(Enclosings.class)));

        Enclosings enclosings = new Enclosings();
        Class cls = enclosings.classAObject().getClass();

        System.out.println("2:" + cls.getName() +", enclosings:" + String.join(",", getEnclosings(cls)));

        Class<?> clzCnstr = enclosings.c.getClass();
        System.out.println("3:" + clzCnstr.getName() +", enclosings:" + String.join(",", getEnclosings(clzCnstr)));

        Class<?> runnable = enclosings.classWithAnonymousClass().getClass();
        System.out.println("4:" + runnable.getName() +", enclosings:" + String.join(",", getEnclosings(runnable)));

        Class<?> innerClz = enclosings.innerClassAObject().getClass();
        System.out.println("7:" + innerClz.getName() +", enclosings:" + String.join(",", getEnclosings(innerClz)));
    }

    private static List<String> getEnclosings(Class<?> clz) {
       //return  Arrays.asList(clz.getEnclosingClass().getCanonicalName(), clz.getEnclosingConstructor().getName(), clz.getEnclosingMethod().getName());
        String canonicalName = "canonicalName:" + clz.getCanonicalName();
        String packageName = "packageName:" + clz.getPackageName();
        String enclosingClass = clz.getEnclosingClass() == null ? "Enclosing class: No": "Enclosing class:" + clz.getEnclosingClass().getCanonicalName();
        String enclosingConstructor = "enclosing constructor:" + ( clz.getEnclosingConstructor()== null?"No": clz.getEnclosingConstructor().getName());
        String enclosingMethod = "enclosing method:" + (clz.getEnclosingMethod() == null? "No": clz.getEnclosingMethod().getName());
        return Arrays.asList(canonicalName, packageName, enclosingClass, enclosingConstructor, enclosingMethod);
    }
}

@interface EnclosingTo {
    String targetPackage();
}

interface Enclosible {
    void enclose(Enclosible e);
}

abstract class BaseEnclosingClass implements Enclosible{}

@EnclosingTo(targetPackage="icu.mianshi.openjdk.main")
class DerivedEnclosingClass extends BaseEnclosingClass {
    public void enclose(Enclosible e) {
        System.out.println("I am DerivedEnclosingClass implemented enclose method.");
    }
}

record EnclosingRecord(String name, float age, Date date){}