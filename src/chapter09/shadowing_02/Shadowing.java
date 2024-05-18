package chapter09.shadowing_02;

import chapter09.Anonymous_02.Functional;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class Shadowing {
    private void run(){
        int baseNum = 10;

        class LocalClass{
            int baseNum = 11;
            void printBaseNum(){
                /**
                 * 내부 클래스와 외부 클래스에서 동일한 이름의 변수가 사용된다면 자바는 가장 가까운 곳에 위치한 변수를 읽는다.
                 * 위에서 baseNum 은 변수명의 중복이지만 클래스가 다르기 때문에 허용이 된다.
                 * 하지만 소스 파일은 같은 java 파일이기 때문에 어느 변수를 읽을지 컴파일러는 판단해야 된다.
                 * 그래서 한번에 컴파일러가 해석하는 블록 단위를 스코프라고 하는데 이 하나의 스코프 안에서 참조하는 변수명에서 중복이 발생하지 않는다면
                 * 그 값을 가져와서 읽는다.
                 * 그리고 내부 클래스의 안에 선언된 변수는 final일 필요가 없지만 외부에 선언된 변수는 동시성 문제 때문에 유사 파이널일 필요가 있다.
                 * 컴파일러는 사이드 이펙트를 제거하기 위해서 컴파일 시점에 에러를 내게 된다.
                 * (외부 클래스에 있는 baseNum의 변수명을 바꿔서 이 블록에서 값을 변경해보면 확인 가능합니다.)
                 * 이를 쉐도윙이라고 하는데 컴파일러는 변수를 읽을 때 값이 변해도 안전하게 처리할 수 있고 더욱 신뢰도가 높은
                 * 가까운 변수를 먼저 읽게 된다.
                 * */
                System.out.println ( baseNum );
            }
        }

        Consumer <Integer> integerConsumer = new Consumer <> ( ) {
            /**
             * 익명 클래스에서도 쉐도윙의 로직대로 가까운 값 참조가 자동적으로 일어나게 된다.
             * */
            @Override
            public void accept ( Integer baseNum ) {
                System.out.println ( baseNum );
            }
        };

        /**
         * 하지만 동일하게 익명 클래스에서 진화한 람다식의 경우는 스코프 자체를 자신의 내부로 잡는 것이 아닌
         * 메서드 전체를 스코프로 잡기 때문에 위와 같이 변수명 충돌 컴파일 에러가 발생한다.
         * (지금은 run 이라는 메서드 내부에 변수들을 선언하고 있다. 그리고 그 변수의 리턴 값을 다시 변수에 할당한 것이다.)
         * 이러한 변수의 참조 범위에서도 기존의 익명 클래스와 람다식이 차이를 보이게 된다.
         * */
//        IntConsumer functional = ( baseNum ) -> System.out.println ( baseNum );

    }
}
