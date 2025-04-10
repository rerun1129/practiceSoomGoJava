package chapter10._2exceptionthrow.customexception;

public class ExceptionRuntime {
    /**
     * 언체크 예외는 체크하지 않으므로 굳이 던지지 않아도 되지만
     * 만약 해당 기능에서 언체크 예외가 발생할 것이라고 예상된다면
     * 이렇게 언체크 예외를 던지도록 해서 해당 기능을 수정하는 개발자에게
     * 주의를 요하게 할 수도 있다.
     */
    void unchecked() throws NullPointerException {
        System.out.println ( "아무것도 안함" );
    }
}
