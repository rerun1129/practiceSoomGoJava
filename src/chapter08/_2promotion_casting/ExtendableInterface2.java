package chapter08._2promotion_casting;

public interface ExtendableInterface2 {
    static void interfaceImplementableStatic(){
        System.out.println ( "구현 안해도 됨!" );
    }
    default void interfaceImplementableDefault(){
        System.out.println ( "구현 안해도 됨!" );
    }
}
