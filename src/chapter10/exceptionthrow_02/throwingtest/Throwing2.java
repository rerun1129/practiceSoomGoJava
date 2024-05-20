package chapter10.exceptionthrow_02.throwingtest;

import java.io.IOException;

public class Throwing2 {

    void throwExceptionOther() throws IOException {
        Throwing3 throwing3 = new Throwing3 ( );
        throwing3.throwException ();
    }

}
