package chapter08.interface_01;

public interface Implementable2 {
    void needImpl();
    default void needNotImpl(){
        System.out.println ( "nope!" );
    }
    void needImplOther();
}
