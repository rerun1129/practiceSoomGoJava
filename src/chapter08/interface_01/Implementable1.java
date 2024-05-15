package chapter08.interface_01;

public interface Implementable1 {
    void needImpl();
    default void needNotImpl(){
        System.out.println ( "nope!" );
    }
    void needImplDiff();
}
