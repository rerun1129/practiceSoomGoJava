package chapter08._1interface;

public interface Implementable1 {
    void needImpl();
    default void needNotImpl(){
        System.out.println ( "nope!" );
    }
    void needImplDiff();
}
