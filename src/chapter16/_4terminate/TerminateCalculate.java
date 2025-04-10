package chapter16._4terminate;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class TerminateCalculate {
    /**
     * 스트림의 최종연산
     *
     * 스트림의 최종연산은 스트림을 소모하는 연산으로 소모한다는 뜻답게 열려져 있던 스트림은 이제 재사용할 수 없게 된다.
     * 중간 연산은 반환 타입이 무조건 Stream<T> 타입이지만 최종 연산은 무조건 Stream<T>이 아닌 타입이 된다.
     *
     * 여기서는 스트림의 최종연산 중 collect 를 제외한 연산들을 배우며 collect 연산은 따로 챕터를 마련하여 학습한다.
     *
     *
     * 스트림의 종류
     * 1. 스트림 단순 열람
     *    forEach -> 앞에서 설명한 peek 과 성격이 유사하지만 peek은 중간 연산, forEach는 최종 연산이라는 차이가 있다.
     *               그리고 forEach는 Stream 타입의 반환 값이 아니어야 하기 때문에 void 반환을 하게 된다.
     *    forEachOrdered -> forEach 와 거의 똑같이 동작하지만 스트림을 병렬 처리할 때 다른 동작을 하게 된다.
     *                     병렬 스트림에 대해서는 따로 다루지 않겠지만 (사용할 일이 거의 없다.) 어떻게 다르게 동작하는지는 아래에서 살펴보자.
     *
     *    ※ 병렬 스트림을 잘 사용하지 않는 이유
     *       보통 병렬 처리는 멀티 스레딩 환경을 이용하는데 멀티 스레딩 환경에서는 스트림 보다는 멀티 스레딩 환경의 데이터 처리에 최적화된
     *       Rx Java 나 스프링에 최근 도입된 WebFlux 라이브러리를 사용해서 처리하는 것이 대세이므로 멀티 스레딩 데이터 처리에 한계가 있는
     *       병렬 스트림은 잘 사용하지 않게 되었다.
     *
     * 2. 스트림 조건 검사
     *    allMatch -> 스트림 요소들이 전부 해당 조건에 일치하는지 확인한다. 전부 일치하면 true, 하나라도 일치하지 않는 요소가 있으면 false를 반환한다.
     *    anyMatch -> 스트림 요소들이 하나라도 해당 조건에 일치하는지 확인한다. 하나라도 일치하면 true, 전부 일치하지 않아야 false를 반환한다.
     *    noneMatch -> 스트림 요소들이 모두 해당 조건에 일치 하지 않음을 확인한다. 전부 일치하지 않으면 true, 하나라도 일치하면 false를 반환한다.
     *    findFirst -> 스트림 요소 중에 해당 조건에 일치하는 값이 있으면 그 값을 찾아서 반환하고 스트림 순회를 중지한다. 반환 값은 Optional<T>가 된다.
     *    findAny -> 스트림 요소 중에 해당 조건에 일치하는 값이 있으면 그 값을 찾아서 반환하고 스트림 순회를 중지한다. 반환 값은 Optional<T>가 된다.
     *               findFirst와 처리 방식은 동일하지만 findAny는 멀티 스레딩에 적합한 최종 연산이며 일반적으로는 findFirst를 사용하는 것이 좋다.
     *
     * 3. 스트림 집계
     *    count -> 스트림 요소의 개수를 세어서 반환한다.
     *    sum -> 스트림의 합계는 기본형 스트림인 경우에는 sum() 메서드가 존재하고 아닌 경우에는 reduce(Integer::sum) 을 이용하면 된다.
     *    average -> 스트림 평균은 기본형 스트림인 경우에는 average() 메서드가 존재하고 아닌 경우에는 collect 의 averagingInt 를 이용하면 된다.
     *    max -> 스트림 요소의 최대값을 반환한다. 어떤 값이 최대 값인지 아닌지 판단해야 하므로 파라미터로 Comparator를 넘겨줘야 한다.
     *    min -> 스트림 요소의 최소값을 반환한다. 어떤 값이 최소 값인지 아닌지 판단해야 하므로 파라미터로 Comparator를 넘겨줘야 한다.
     *
     * 4. 스트림 컬렉션 압축 연산
     *    reduce -> 스트림 요소의 누적 연산을 하기 위해서 만들어진 최종 연산이다.
     *              예를 들어, 1+2...+10 까지 누적 연산을 하면 55가 나오는데 실제 연산은 1+2=3, 3+3=6, 6+4=10... 로
     *              스트림 요소를 누적 처리해가면서 처리하는 최종 연산이다.
     *
     *
     * 5. 스트림 List 직접 반환
     *    toList -> 중간 연산의 결과를 collect 최종 연산 없이 List 컬렉션 객체로 바로 만들어주는 메서드이다.
     *              컬렉션을 반환 받을 때 가장 많이 받는 타입이 Map, Set, List 중에 List이기 때문에 특별히 존재하는 메서드이다.
     *
     * */

    public static void main ( String[] args ) {
        List<Integer> numbers = List.of ( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20 );
        //스트림 단순 열람
        streamOpen(numbers);
        //스트림 조건 검사
        streamPredicate();
        //스트림 집계
        streamGrouping(numbers);
        //스트림 컬렉션 압축 연산
        streamReduce(numbers);

        //스트림 List 직접 반환 -> 스트림 연산의 결과물을 바로 List 로 만든다.
        List <Integer> integerList = numbers.stream ( ).toList ( );
    }



    private static void streamOpen ( List <Integer> numbers ){
        System.out.println ( "스트림 단순 열람\n" );
        //지금까지 forEach의 동작은 자주 봐왔기 때문에 병렬 스트림에서 forEach와 forEachOrdered 의 차이만 보도록 한다.
        //말로 이해하기 어렵다면 중간 연산 중 map과 동일하게 내부에서 동작하지만 반환 타입이 void 라는 차이점만 있다고 생각하면 된다.
        //forEach는 자주 쓰이기 때문에 stream 을 열지 않고도 바로 사용할 수 있도록 되어있지만 병렬 스트림은 다르다.

        System.out.println("forEach를 병렬 처리할 경우");
        numbers.parallelStream().forEach(n -> System.out.print(n + " "));
        System.out.print(" -> 값을 받아온 대로 순차 처리하지 않음");

        System.out.println("\n\nforEachOrdered를 병렬 처리할 경우");
        numbers.parallelStream().forEachOrdered(n -> System.out.print(n + " "));
        System.out.print(" -> 값을 받아온 대로 순차 처리");
        System.out.println ( "\n======================================\n" );
    }

    private static void streamPredicate ( ){
        System.out.println ( "스트림 조건 검사\n" );
        List<String> machineList = List.of(
            "Excavator",  // E로 시작
            "Electric Drill",  // E로 시작
            "Bulldozer",  // B로 시작
            "Backhoe",  // B로 시작
            "Crane",  // C로 시작
            "Concrete Mixer",  // C로 시작
            "Drill",  // D로 시작
            "Dump Truck",  // D로 시작
            "Tractor",  // T로 시작
            "Tunneling Machine"  // T로 시작
        );

        //allMatch, anyMatch, noneMatch
        System.out.print ( machineList.stream ( )
                                        .allMatch ( s -> s.startsWith ( "E" )
                                                                || s.startsWith ( "B" )
                                                                || s.startsWith ( "C" )
                                                                || s.startsWith ( "D" )
                                                                || s.startsWith ( "T" ) ) );
        System.out.print ( " -> allMatch : 모든 기계가 E,B,C,D,T 로 시작하는 것만 있는가?\n" );
        System.out.print ( machineList.stream ( ).anyMatch ( s -> s.startsWith ( "T" ) ) );
        System.out.print ( " -> anyMatch : 기계 중에 T 로 시작하는 것이 존재하는가?\n" );
        System.out.print ( machineList.stream ( ).noneMatch ( s -> s.startsWith ( "O" ) ) );
        System.out.print ( " -> noneMatch : 기계 중에 O 로 시작하는 것이 존재하지 않는가?\n" );
        System.out.println ( "===================================" );
        //findFirst, findAny
        System.out.print ( machineList.stream ( ).filter ( s -> s.startsWith ( "E" )  ).findFirst ( ).orElse (""));
        System.out.print ( " -> findFirst[일반 스트림] : 기계 중에 E 로 시작하는 것 중 가장 먼저 찾은 것을 가져와라\n" );
        System.out.print ( machineList.stream ( ).filter ( s -> s.startsWith ( "E" )  ).findAny ( ).orElse (""));
        System.out.print ( " -> findAny[일반 스트림] : 기계 중에 E 로 시작하는 것 중 가장 먼저 찾은 것을 가져와라\n" );
        System.out.println ( "결과가 항상 동일함\n" );

        System.out.print ( machineList.parallelStream ( ).filter ( s -> s.startsWith ( "E" )  ).findFirst ( ).orElse (""));
        System.out.print ( " -> findFirst[병렬 스트림] : 기계 중에 E 로 시작하는 것 중 가장 먼저 찾은 것을 가져와라\n" );
        System.out.print ( machineList.parallelStream ( ).filter ( s -> s.startsWith ( "E" )  ).findAny ( ).orElse (""));
        System.out.print ( " -> findAny[병렬 스트림] : 기계 중에 E 로 시작하는 것 중 가장 먼저 찾은 것을 가져와라\n" );
        System.out.println ( "findAny는 병렬 연산 시 순서 상관없이 빨리 찾을 수 있는 것을 바로 가져오므로 결과가 가끔 달라짐" );
        System.out.println ( "==================================\n" );
    }

    private static void streamGrouping ( List <Integer> numbers ){
        System.out.println ( "스트림 집계\n" );
        //count
        System.out.print ( "count : " );
        System.out.println ( numbers.stream ( ).filter ( i -> i % 2 == 0 ).count ( ) ); //짝수만 카운트
        System.out.println ( "=================================================" );
        //sum
        System.out.print ( "일반 스트림 sum : " );
        System.out.println ( numbers.stream ( ).reduce ( Integer::sum ).orElse ( 0) ); //일반 스트림 합계
        System.out.print ( "기본형 스트림 sum : " );
        System.out.println ( IntStream.rangeClosed ( 1, 10 ).sum ( ) ); //기본형 스트림 합계
        System.out.println ( "=================================================" );
        //average
        System.out.print ( "기본형 스트림 average : " );
        System.out.println ( IntStream.rangeClosed ( 1, 10 ).average ( ).orElse ( 0.0 ) ); //기본형 스트림 평균
        System.out.println ( "=================================================" );
        //max, min
        System.out.print ( "max : " );
        System.out.println ( numbers.stream ().max ( Comparator.naturalOrder ( ) ).orElse ( 0 ) ); //최고값 20
        System.out.print ( "min : " );
        System.out.println ( numbers.stream ().min ( Comparator.naturalOrder ( ) ).orElse ( 0 ) ); //최저값 1
        //만약 역순으로 Comparator 를 넘겨주게 되면 예상과 반대로 값이 나오게 된다.
        System.out.print ( "Comparator가 역순인 min : " );
        System.out.println ( numbers.stream ().min ( Comparator.reverseOrder ( ) ).orElse ( 0 ) ); //최저값 1
        System.out.println ( "=================================================\n" );
    }

    private static void streamReduce ( List <Integer> numbers ){
        System.out.println ( "스트림 컬렉션 압축 연산\n" );
        //reduce
        //여기서는 위에서 하지 못한 average 연산을 reduce 를 통해서 구현해본다.

        System.out.print ( numbers.stream ( ).reduce ( 0 /*초기 타입은 T 타입이나 그 부모 타입을 지정해줄 수 있다. 초기 타입이 없다면 해당 객체의 기본 초기값이 들어간다.*/, ( accumulator, combiner ) -> {
            /**
             * 두 번째 파라미터는 함수형 인터페이스 중에 BinaryOperator가 사용된다. 따라서, 제네릭 타입이 <T,T,R> 로 주어지는데
             * 여기서 T,T가 accumulator = 누적 계산기(누산기) 이고 combiner 가 현재 순회 객체인 결합기가 된다.
             * 그리고 누산기와 결합기 둘 다 타입이 똑같아야 하기 때문에 T,T가 되는 것이다. 누적 계산을 해야하므로 accumulator 타입 == combiner 타입이 성립된다.
             * 위에서 초기값을 0으로 설정했기 때문에 accumulator 의 시작 값은 0이다.
             * */
            return accumulator + combiner; //여기서 람다식을 메서드 레퍼런스로 바꾸면 위에서와 같이 Integer::sum 으로 축약된다.
        } ) / numbers.size ( ) ); // 75/11 이지만 Integer 이므로 소수점을 버려서 6이 나온다.
        System.out.print ( " -> 평균 \n" );
        //두 번째 예제 -> 과일들 전부에 할인율 20% 를 적용하고 할인된 금액에 대한 합계 구하기
        System.out.println ( "======================================================" );
        Map <String, Integer> fruitPrices = new HashMap <> ();
        fruitPrices.put("Apple", 100);
        fruitPrices.put("Banana", 80);
        fruitPrices.put("Orange", 120);
        fruitPrices.put("Mango", 150);
        fruitPrices.put("Grapes", 200);
        fruitPrices.put("Strawberry", 180);
        fruitPrices.put("Pineapple", 90);
        fruitPrices.put("Watermelon", 130);
        fruitPrices.put("Blueberry", 300);
        fruitPrices.put("Peach", 110);
        int total = fruitPrices.values()
                   .stream()
                   .reduce (0, (acc, com) -> ( int ) (acc + (com * 0.8)) );
        System.out.println("Total Price: " + total);
        System.out.println ( "======================================================" );
    }
}
