package chapter06.methods;

public class Methods {
    public static void main ( String[] args ) {
        CallMethod callMethod = new CallMethod ( );

        /**
         * 아래의 두 멤버는 단지 메서드 호출자인 -> ()에 의해서 그 쓰임이 달라지게 된다.
         * */
        callMethod.greeting = "Hi!"; //멤버 변수 -> callMethod.greeting -> 컴파일러가 변수로써 읽음
        callMethod.greeting("Hi!");//메서드 -> callMethod.greeting( <- 이 시점에서 컴파일러가 변수로서 읽음

        /**
         * 위와 같이 ()을 함수의 호출자라 하며 컴파일러는 위의 코드를 기계어로 번역할 때 이렇게 번역하게 된다.
         * callMethod/.[이 이후는 인스턴스의 멤버임]/greeting/[여기서 끝난다면 이것은 멤버 변수임]([이렇게 괄호가 들어온다면 이는 멤버 메서드임]/파라미터/)/
         *
         * (중요)멤버의 이름은 참조 변수로 취급함. 즉, 멤버 변수도 자신의 메모리 주소를 가지고 있고 멤버 메서드도 자신의 메모리 주소를 가지고 있음.
         * 그래서 자바 스크립트나 코틀린 같은 언어는 메서드의 주소만으로 메서드를 참조해서 사용할 수 있음.
         * 하지만 자바는 멤버 메서드의 이름이 가진 메모리 주소만으로는 메서드를 호출할 수 없고 반드시 호출자를 통해서 호출해야 함(이를 메서드 = 2급 시민이라는 용어로 사용함) 아래의 예시 참고
         * 위의 같은 특징때문에 자바는 메서드를 변수에 할당할 수 없고 자바스크립트와 같은 언어는 함수를 변수에 할당해서 사용할 수 있음(이를 함수 = 1급 시민이라는 용어로 사용함) js 파일 예시 참고
         * */
//        var method = callMethod.greetingOther;//할당이 불가능한 컴파일 에러가 발생함


    }
}
