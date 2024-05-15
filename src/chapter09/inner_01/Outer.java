package chapter09.inner_01;

public class Outer {
    String outerField = "Outer-field";
    void method() {
        System.out.println ( "Outer-method" );
    }
    class Nested { //외부 비 static 멤버들이 내부에 접근하기 때문에 static 권고를 하지 않음(하지만 여전히 내부 클래스는 static이 더 바람직함)
        String field = "Nested-field";
        void method() {
            System.out.println ( "Nested-method" );
        }
        void print() {
            System.out.println (this.field);
            this.method ();
            System.out.println (Outer.this.outerField);
            Outer.this.method ();
        }
    }
}
