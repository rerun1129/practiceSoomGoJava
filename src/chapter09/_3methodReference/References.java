package chapter09._3methodReference;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class References {
    /**
     * 메서드 레퍼런스(참조)
     *
     * 메서드 레퍼런스는 람다식을 특수한 상황에서 메서드의 호출 형식이 아닌 메서드 이름의 메모리 주소를 직접 읽어서
     * 해당 메모리 주소에 있는 메서드 구현부를 직접 읽어와서 실행하는 방식의 함수형 프로그래밍 방법이다.
     *
     * 메서드 레퍼런스의 종류는 다음과 같이 4가지가 있다.
     *
     * 1. 스태틱 메서드 참조 -> 타입명 :: 스태틱 메서드 명
     * 2. 특정 객체의 인스턴스 메서드 참조 -> 인스턴스 명 :: 인스턴스 메서드 명
     * 3. 임의 객체의 인스턴스 메서드 참조 -> 타입명 :: 인스턴스 메서드 명
     * 4. 생성자 참조 -> 타입명 :: new
     *
     * 기본적으로 타입명::메서드명 으로 사용이 가능하다고 생각하면 쉽다.
     * 생성자 참조도 기본적으로 new 가 해당 클래스 생성자의 메서드 이름이기 때문에 우변은 메서드 명이라고 간단하게 기억하고 있으면 된다.
     *
     * */

    public static void main ( String[] args ) {
        //스태틱 메서드 참조
        UnaryOperator<String> hiStaticLambda = greet1 -> Greeting.hi ( greet1 );
        //static 메서드는 인스턴스 생성이 필요가 없기 때문에 바로 참조해서 주소의 값을 가져올 수 있다.
        UnaryOperator<String> hiStaticReference = Greeting::hi;
        //static 메서드는 인스턴스 생성이 필요가 없기 때문에 바로 참조해서 주소의 값을 가져올 수 있다.

        //특정 객체의 인스턴스 메서드 참조
        Greeting greeting = new Greeting(); //특정 인스턴스를 생성하고
        UnaryOperator<String> hiInstanceLambda = greet -> greeting.hello ( greet ); //해당 인스턴스가 가진 메서드 명의 주소를 참조해서 실행한다.
        UnaryOperator<String> hiInstanceReference = greeting::hello; //해당 인스턴스가 가진 메서드 명의 주소를 참조해서 실행한다.



        //임의 객체의 인스턴스 메서드 참조
        String[] names = {"k", "w", "t"};
        Arrays.sort ( names, ( s, str ) -> s.compareToIgnoreCase ( str ) );
        Arrays.sort ( names, String::compareToIgnoreCase );
        System.out.println(Arrays.toString(names));
        /**
         * 위와 같이 파라미터가 둘이면 앞의 변수 s는 사실상 인스턴스 취급이 되며 그 인스턴스와 두번째 파라미터를 변형없이 그대로 메서드에 사용하게 되면
         * 람다식 아래와 같이 묵시적으로 그 변수 타입의 메서드 이름으로 해당 메서드를 참조할 수 있기 때문에 메서드 참조로 메서드를 호출할 수 있게 된다.
         * 메서드 참조는 기본적으로 람다식 내부에서 람다식의 좌변의 파라미터를 변형 없이 하나의 메서드만으로 사용한다는 가정 하에 사용 가능한 문법이다.
         * */


        //생성자 참조
        Supplier<Greeting> greetingNewLambda = ( ) -> new Greeting ( );
        Supplier<Greeting> greetingNewReference = Greeting::new;
        /**
         * 기본적으로 클래스에는 빈 생성자가 자동 생성되므로 받는 파라미터 없이 인스턴스만 돌려줘서 Supplier 타입이다
         * 그렇다면 생성자가 둘 이상이라면 어떠한 생성자를 메서드 참조하게 될까?
         * 직접 Greeting::new 를 해보면 생성 가능한 타입이 최대 8가지이다.
         * 이 중에 Function 은 매개변수를 하나만 가지는 레퍼런스이고 BiFunction은 둘을 가지게 된다.
         * 만약 생성자 파라미터가 복수라면 값이 어떻게 파라미터에 할당되어 만들어지는지 눈으로 확인할 수 없기 때문에
         * 구조를 확실히 아는 것이 아니라면 생성자의 메서드 참조는 자주 사용될 방식은 아니다.
         * 더군다나 생성자의 파라미터가 3개 이상이라면 기존의 BiFunction 으로도 값을 모두 가져올 수 없기 때문에
         * 해당 생성자 전용의 함수형 인터페이스를 만들어줘야 하는 불편함이 있다.
         * */
        Function<String, Greeting> functionalGreeting = Greeting::new;
        BiFunction<String, String, Greeting> biFunctionalGreeting = Greeting::new;
        System.out.println ( greetingNewReference.get ().toString () ); //Supplier은 파라미터를 넘겨줄 수 없기 때문에 초기값이 모두 null이 나올 수 밖에 없다.
        System.out.println ( functionalGreeting.apply ( "안녕하세요" ).toString () ); //이렇게 apply 메서드에 값을 넣어줘야 생성자에 대한 초기화가 완성된다.
        System.out.println ( biFunctionalGreeting.apply ( "안녕하세요", "반갑습니다" ).toString () );

    }
}
