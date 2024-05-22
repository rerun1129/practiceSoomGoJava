package chapter09.Anonymous_02;

public class Main {
    public static void main ( String[] args ) {
        Parent parent = new Parent ( ) { //이 부분이 익명 클래스로 취급받는다.
            @Override
            public void needToOverride ( ) {
                System.out.println ( "재정의 완료!" );
            }
        };
        Parent parent1 = new Parent ( );
        parent.needToOverride ();
        parent1.needToOverride ();

        /**
         * Version.01 익명 인터페이스인 함수형 인터페이스의 사용
         * */
        Functional functionalAnonymous = new Functional ( ) {
            //이 자체를 구현이 완료된 것으로 보아 인터페이스 임에도 불구하고 new가 가능함
            @Override
            public void func ( String str ) {
                System.out.println ( str );
            }
        };
        /**
         * Version.02 익명 인터페이스에서 람다식으로
         *
         * 자바 8버전의 주요한 변경점 중 하나가 바로 람다식의 도입이다. 람다식은 함수형 인터페이스의 익명 클래스 형태의 구현이
         * 너무나도 불편하고 코드의 양이 많기 때문에 원하는 바인 화살표 함수 등의 간단한 구현 방식에 부합하도록 만들어졌다.
         * 그리고 마치 함수가 변수에 담기는 자바 스크립트와 같은 모양을 띄고 있다.(하지만 내용 자체는 위의 익명 클래스와 동일하다)
         * */
        Functional functionalLambda = /*파라미터 선언부*/( String str ) -> /*구현부*/System.out.println ( str ); //위의 코드와 동일한 코드
        /**
         * 위를 보면 마치 메서드의 파라미터 선언부만 화살표로 이어져서 실제 동작할 메서드 구현부를 가리키는 것과 같다.
         * 이 람다식을 쪼개어 보자면 인터페이스의 추상 메서드가 가지고 있는 파라미터 선언부만 떼어서 좌항에 위치하고 화살표로 우항을 가리켜서
         * 좌항에서는 메서드에서 제공하는 파라미터를 정의하여 우항의 메서드 구현부에서 이를 사용할 수 있도록 하고 있다.
         * 만약 파라미터의 변수가 추론이 불가능하거나 타입 캐스팅을 해야할 상황이 아니라면 파라미터의 타입은 컴파일러가
         * 추론 가능한 영역이기 때문에 생략해도 무방하다.
         * (보통은 생략하고 변수명만 정해서 씀)
         * */

        /**
         * 만약 람다식 내부 구현이 복잡하다면 아래와 같이 화살표 우항에 구현부를 직접 선언해서 메서드 구현하듯이 구현할 수도 있다.
         * */
        Functional functionalLambdaImpl = /*파라미터 선언부*/( String str ) -> /*구현부*/{
            System.out.println ( str );
        }; //위의 코드와 동일한 코드

        /**
         * Version.03 메서드인 람다식을 참조변수처럼 사용할 수 있는 메서드 참조(레퍼런스)
         * 위의 코드를 보면 알겠지만 노란색 경고표시가 들어가 있다.
         * 굳이 메서드를 직접 선언하는 것이 아닌 파라미터를 추가적인 조작없이 그대로 구현부의 메서드가 사용한다면 경우에 따라서
         * 메서드의 참조변수만 가지고 해당 메서드를 호출할 수 있다.
         * */

        Functional functionalReference = System.out::println; //위의 코드와 동일한 코드
        /**
         * 사용 방식은 파라미터와 구현부의 메서드에서 사용하는 파라미터가 동일하다면 컴파일러가 이를 추론하여
         * 바로 메서드의 참조변수를 이용해서 메모리에서 함수의 코드를 직접 실행할 수 있게 된다.
         * 그래서 클래스 타입::메서드명으로 간단하게 람다식을 더욱 줄여서 사용할 수 있게 된다.
         */

    }
}
