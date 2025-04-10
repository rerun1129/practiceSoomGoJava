package chapter15._2annotation.custom;

public class AnnotationTest {
    public static void main(String[] args) {
        InjectedClass myClass1 = new InjectedClass();
        System.out.println ( myClass1 );
        InjectedClass myClass2 = new InjectedClass("안녕하세요", 30);
        System.out.println ( myClass2 );
    }
}
