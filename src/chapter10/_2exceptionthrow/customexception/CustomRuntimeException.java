package chapter10._2exceptionthrow.customexception;

public class CustomRuntimeException extends RuntimeException{
    /**
     * 언체크 예외는 throw를 하지 않아도 서비스가 빌드가 된다.
     * */
    public CustomRuntimeException ( String message ) {
        super ( message );
    }
}
