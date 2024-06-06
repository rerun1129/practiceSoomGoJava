package chapter10.exceptionclass_01;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Exceptions {
    /**
     * 예외의 계층 구조
     * - Object : 예외도 클래스이기 때문에 Object 타입을 공통 조상으로 둔다.
     *   - Throwable : 최상위 예외이다. 하위에 Exception 과 Error 가 있다.
     *     - Error : 메모리 부족이나 심각한 시스템 오류와 같이 애플리케이션에서 복구 불가능한 시스템 에러이다.
     *       애플리케이션 개발자는 이 에러를 잡으려고 해서는 안된다.
     *
     *  - 상위 예외를 잡으면 그 하위 예외까지 함께 잡는다. 따라서 애플리케이션 로직에서는 Throwable 예외를 잡으면 안되는데,
     *    앞서 이야기한 Error 예외도 함께 잡을 수 있기 때문이다. 애플리케이션 로직은 이런 이유로 Exception 부터 필요한 예외로 생각하고 잡으면 된다.
     *
     * - Exception : 체크 예외
     *     - 애플리케이션 로직에서 사용할 수 있는 실질적인 최상위 예외이다.
     *     - Exception 과 그 하위 예외는 모두 컴파일러가 체크하는 체크 예외이다. 단 RuntimeException은 예외로 한다.
     *   - RuntimeException : 언체크 예외, 런타임 예외
     *       - 컴파일러가 체크 하지 않는 언체크 예외이다.
     *       - RuntimeException 과 그 자식 예외는 모두 언체크 예외이다.
     *       - RuntimeException 의 이름을 따라서 RuntimeException 과 그 하위 언체크 예외를 런타임 예외라고 많이 부른다.
     *
     */


    /**
     * checked exception 과 unchecked exception
     *
     * 각각 체크 예외와 언체크 예외라고도 한다. 둘의 차이점은 간단하게 컴파일러가 컴파일 타임에 해당 예외를 체크하는지를
     * 따지는 것인데 보통 unchecked exception 을 런타임 예외라고 하고 그 외를 컴파일 예외라고 통칭한다.
     *
     * 대표적인 컴파일 예외로는 IO 예외가 있고 대표적인 런타임 예외로는 NPE가 있다.
     *
     *  체크 예외의 장단점
     *  장점: 개발자가 실수로 예외를 누락하지 않도록 컴파일러를 통해 문제를 잡아주는 훌륭한 안전 장치이다.
     *  단점: - 하지만 실제로는 개발자가 모든 체크 예외를 반드시 잡거나 던지도록 처리해야 하기 때문에, 너무 번거로운 일이 된다.
     *       - 크게 신경쓰고 싶지 않은 예외까지 모두 챙겨야 한다.
     *
     *
     *  언체크 예외의 장단점
     *  장점: - 신경쓰고 싶지 않은 언체크 예외를 무시할 수 있다.
     *       - 체크 예외의 경우 처리할 수 없는 예외를 밖으로 던지려면 항상 throws 예외 를 선언해야 하지만, 언체크 예외는 이 부분을 생략할 수 있다.
     *  단점: 언체크 예외는 개발자가 실수로 예외를 누락할 수 있다. 체크 예외는 컴파일러를 통해 예외 누락을 잡아준다.
     *
     * */

    void file() {
        /**
         * 컴파일 예외
         * */
        File file = new File ( "" );
//        file.createNewFile (); //이렇게 IO Exception 이 처리되지 않으면 빨간색으로 컴파일러가 경고표시를 한다.
    }

    /**
     * 런타임 예외
     * */

    static void nullPointer(String str) {
        str.startsWith ( "" ); //컴파일러는 이 상황에서는 어떤 값이 파라미터로 넘어올지 알 수가 없다.
    }

    static int zeroDivide(int bunja, int bunmo){
        return bunja / bunmo; //실행 시점에 0나누기 오류 여부를 발견할 수 있다.
    }

    public static void main ( String[] args ) {
        nullPointer ( null ); //이렇게 null 값을 넘기게 되면 비로소 nullPointer 에서 NPE가 발생하게 된다.
        zeroDivide ( 10, 2 ); //정상 실행
        zeroDivide ( 5, 0 ); //0나누기 오류 발생
    }
}
