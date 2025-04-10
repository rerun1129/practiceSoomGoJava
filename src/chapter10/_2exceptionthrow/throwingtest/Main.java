package chapter10._2exceptionthrow.throwingtest;

import java.io.IOException;

public class Main {
    public static void main ( String[] args ) throws IOException {
        Throwing1 throwing1 = new Throwing1 ( );
        throwing1.throwExceptionLast ();
        //여기서까지 던지면 예외가 터진다고 표현한다.
    }
}
