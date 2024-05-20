package chapter10.exceptionthrow_02.throwingtest;

import java.io.IOException;

public class Throwing1 {

    void throwExceptionLast() throws IOException {
        Throwing2 throwing2 = new Throwing2 ( );
        //예외를 처리하는 경우
        /**
         * 체크 예외인 경우에는 반드시 try catch 블록을 통해서 예외를 처리해줘야 함
         * (다른 방법으로 체크 예외를 언체크 예외도 변환하여 try catch 블록을 사용하지 않는 방법도 있으나 이는 여기서 다루지 않음)
         * 하지만 언체크 예외인 경우에는 try catch 블록으로 처리할 수도 있지만 그 문제가 발생한 코드를 직접 예외가 발생하지 않도록
         * 수정하는 것이 가장 좋다.
         * */
        try {
            throwing2.throwExceptionOther ();
        } catch ( ArithmeticException | IOException e ) {

            System.out.println ( "예외를 잘 처리했습니다." );
            System.out.println ( "경고 메세지도 잘 처리했습니다." );
            /**
             * 여기에서 Exception 으로 모든 예외를 잡으면 하위 타입인 IOException 도 잡힌다.
             * 또한, 예외는 위와 같이 여러 예외를 catch 블록에서 여럿을 각각 잡을 수 있다.
             * 예외를 여럿 잡아도 하나의 결과만이 나온다.
             * */

            /**
             * 예외는 최대한 구체적으로 선언하여 잡아야 한다.
             * 위의 catch 문도 단순하게 Exception 으로 잡는다면 간편하지만 그렇게 예외를 잡아버리면
             * 그 예외가 산술 예외인지 입출력 예외인지를 알 수 없고 단순하게 모든 예외의 조상인 Exception 로 잡혀서
             * 디버깅이 어려워질 수도 있다.
             * */
        }
        //예외를 처리하지 못하는 경우
        throwing2.throwExceptionOther ();
    }

}
