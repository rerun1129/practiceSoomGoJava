package chapter16.streambase_01;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SpecialStream {
    /**
     * 특정 목적으로 사용하는 타입의 스트림
     *
     * 1. IntStream, LongStream, DoubleStream
     *    for 문의 횟수 및 범위 지정 순회 처럼 동작시키기 위해 사용
     *    (일반적인 스트림은 데이터 소스의 크기 만큼 순회하므로 특정 횟수 지정 순회가 불가능함)
     *
     * 2. 빈 스트림
     *    요소가 하나도 없는 비어있는 스트림을 생성 할 수 있다.
     *    하지만 일반적으로는 데이터 소스를 가지고 스트림을 열어 사용하는 것이 일반적이라 거의 사용되지 않는다.
     *
     * 3. 스트림 연결 메서드
     *    Stream 타입의 static 메서드인 concat()을 사용하면, 두 개의 스트림을 하나로 연결할 수 있다.
     *    연결하려는 스트림의 요소는 같은 타입이어야 한다.
     *
     * */

    public static void main ( String[] args ) {
        //IntStream 예시 (모두 동일하게 1부터 10까지 순회하는 스트림이다.)
        IntStream intStream = IntStream.of ( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ); //값을 지정해서 만드는 방법
        IntStream range = IntStream.range ( 1, 11 ); //범위를 지정하는 방법 (range 는 마지막 파라미터 숫자를 제외)
        IntStream rangeClosed = IntStream.rangeClosed ( 1, 10 ); //범위를 지정하는 방법 (rangeClosed는 마지막 파라미터 숫자를 포함)
        intStream.forEach ( System.out ::print );
        System.out.println ();
        range.forEach ( System.out ::print );
        System.out.println ();
        rangeClosed.forEach ( System.out ::print );
        System.out.println ();

        //빈 스트림 예시
        Stream <Object> empty = Stream.empty ( );
        System.out.println ( empty.count ( ) ); //스트림이 비어있으므로 0
        //스트림 연결
        List <String> aToC = List.of ( "A", "B", "C" );
        List <String> dToF = List.of ( "D", "E", "F" );
        Stream <String> aToCStream = aToC.stream (); //1번 스트림
        Stream <String> dToFStream = dToF.stream (); //2번 스트림
        Stream <String> concatStream = Stream.concat ( aToCStream, dToFStream ); //둘을 합쳐서 새로운 스트림을 만들어냄
        concatStream.forEach ( System.out ::print );
        System.out.println ();
        aToCStream.forEach ( System.out ::print );
        //연결 연산도 중간 연산이기 때문에 연산에 사용된 1번 스트림과 2번 스트림은 재사용이 불가능하다.
    }
}
