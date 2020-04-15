package icu.mianshi.openjdk.compiler;

import java.util.Arrays;
import java.util.List;

public class Enclosings {
    public Object c = null;
    public Enclosings() {
        class ClassInConstructor {};
        c = new ClassInConstructor();
    }

    public Object classAObject() {
        class ClassInMethod1{};
        return new ClassInMethod1();
    }

    public Runnable classWithAnonymousClass() {
        return new Runnable() {
            public void run() {}
        };
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