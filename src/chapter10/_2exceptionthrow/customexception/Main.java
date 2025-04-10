package chapter10._2exceptionthrow.customexception;

public class Main {
    public static void main ( String[] args ) {
        ExceptionRuntime exceptionRuntime = new ExceptionRuntime ( );
        exceptionRuntime.unchecked (); //이 부분에서는 딱히 예외가 발생하지 않는다.
        throw new CustomRuntimeException("언체크 예외"); //빌드는 되지만 throw를 했으므로 예외는 발생한다.
    }
}
