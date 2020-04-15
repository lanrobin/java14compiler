package icu.mianshi.openjdk.compiler;

public class PatternTreeSample {

    public static void main(String[] args) {
        BaseClass bc = new DerivedClass();

        if(bc instanceof DerivedClass dc) {
            dc.sayClass();
        }

        if(bc instanceof GrandChildClass gc) {
            gc.sayClass();
        }else {
            System.out.println("bc is not instanceof" + GrandChildClass.class.getCanonicalName());
        }
    }
    private static class BaseClass {
        public void sayClass() {
            System.out.println("I am：" + this.getClass().getCanonicalName());
        }
    }

    private static class DerivedClass extends BaseClass {
        @Override
        public void sayClass() {
            System.out.println("I am：" + this.getClass().getCanonicalName());
        }
    }

    private static class GrandChildClass extends DerivedClass {
        @Override
        public void sayClass() {
            System.out.println("I am：" + this.getClass().getCanonicalName());
        }
    }
}