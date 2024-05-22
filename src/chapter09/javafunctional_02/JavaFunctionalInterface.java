package chapter09.javafunctional_02;

import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class JavaFunctionalInterface {
    /**
     * 자바에서 기본적으로 제공하는 자주 사용하는 함수형 인터페이스는 대략 7개가 있다.
     * 1. Function<T, R> -> T 타입을 받아서 R 타입을 리턴하는 함수 인터페이스
     * 2. BiFunction <T, U, R> -> T 타입과 U 타입을 받아서 R 타입을 리턴하는 함수 인터페이스
     * 3. Consumer<T> -> T 타입을 받아서 아무 값도 리턴하지 않는 함수 인터페이스
     * 4. Supplier<T> -> 아무 값도 제공받지 않고 T 타입의 값을 제공하는 함수 인터페이스
     * 5. Predicate<T> -> T 타입을 받아서 boolean 을 리턴하는 함수 인터페이스
     * 6. UnaryOperator<T> -> Function 의 특수 형태로 T 타입을 받아서 동종의 T 타입을 리턴하는 함수 인터페이스
     * 7. BinaryOperator<T> -> BiFunction 의 특수 형태로 T 타입의 값 2개를 받아서 T 타입을 리턴하는 함수 인터페이스
     * */

    /**
     * 각 함수 인터페이스의 예시
     * */
    public static void main ( String[] args ) {
        Function <Integer,Integer> plus10 = (i) -> i+10;
        System.out.println(plus10.apply(1));

        Consumer <Integer> printT = (i) -> System.out.println ( i );
        printT.accept(10);

        Supplier <Integer> get10 = () -> 10;
        System.out.println(get10.get());

        Predicate<String> TorF = (str) -> str.startsWith("길동");
        System.out.println ( TorF.test ( "홍길동" ) );

        Predicate <Integer> isEven = (i) -> i%2 == 0;

        UnaryOperator<Integer> unaryPlus10 = (i) -> i+10;
        UnaryOperator<Integer> unaryMultiply2 = (i) -> i * 2;

        BinaryOperator<Integer> binaryPlus10 = (i,j) -> i+j+10;
        BinaryOperator<Integer> binaryMultiply2 = (i,j) -> i*j*2;

        /**
         * Stream API 의 사용을 통한 함수형 인터페이스의 실전 사용 예
         * */

        List <String> nameList = List.of ( "James", "Jamie", "Alice", "Alicia", "Mark" );

        //stream 의 map 은 컬렉션 객체를 순회하며 그 객체 내부의 요소를 가지고 무언가의 처리를 한 후에 원하는 타입의 값을 리턴하는 메서드이다.
        nameList.stream ().map ( name -> name.toUpperCase() );
        //map 은 그 특성 상 제네릭 타입을 받아서 지정한 값을 리턴해줘야 하기 때문에 Function 의 동작과 부합

        //stream 의 forEach 는 컬렉션 객체를 순회하며 그 객체 내부의 요소를 가지고 무언가의 동작을 하는 메서드이다.
        nameList.forEach ( name -> System.out.println ( name ) );
        //forEach 는 그 특성 상 제네릭 타입을 받아서 어떠한 작업을 하고 리턴을 하지 않아야 하기 때문에 Consumer 의 동작과 부합

        //stream 의 filter 는 컬렉션 객체를 순회하며 그 객체 내부의 요소를 가지고 그 요소가 일정 조건에 맞다면 그 객체를 다음 오퍼레이션으로 보내고 아니라면 보내지 않는 필터링 역할을 한다.
        nameList.stream ().filter ( name -> name.startsWith ( "J" ) ).forEach ( System.out::println);
        //filter 는 그 특성 상 제네릭 타입을 받아서 true, false 를 리턴해줘야 하기 때문에 Predicate 의 동작과 부합

        //stream 의 collect 는 컬렉션 객체를 가지고 collect 즉, 집합 연산을 하거나 결과를 모아 새로운 컬렉션 객체로 만들어주는 역할을 한다.
        nameList.stream ().collect ( () -> "hi", (s1, s2) -> System.out.println ( s1 ), (s1, s2) -> System.out.println ( s2 ) );
        //collect 의 가장 처음 파라미터는 아무것도 제공받지 않고 값을 리턴해줘야 하기 때문에 Supplier 의 동작과 부합한다. 그리고 뒤의 함수들은 BiFunction 과 같이 움직인다.

    }
}
