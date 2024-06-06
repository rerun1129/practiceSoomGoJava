package chapter10.exceptionthrow_02.customexception;

public class MyCheckedException extends Exception{
    /**
     * 이렇게 예외는 자바에서 제공하는 것을 그대로 쓸 수도 있지만 필요하다면 직접 생성해서 만들 수도 있다.
     * 그 경우에는 체크 예외나 언체크 예외를 상속해서 사용해야 적절하게 동작한다.
     * Exception 을 상속받으면 체크 예외가 된다.
     * RuntimeException 을 상속받으면 언체크 예외가 된다. 이런 규칙은 자바 언어에서 문법으로 정한 것이다.
     * */

    public MyCheckedException ( String message ) {
        /**
         * 예외가 제공하는 여러가지 기본 기능이 있는데, 그 중에 이렇게 오류 메시지를 보관하는 기능도 있다.
         * 예제에서 보는 것 처럼 생성자를 통해서 해당 기능을 그대로 사용하면 편리하다.
         * */
        super ( message );
    }
}
