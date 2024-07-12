package chapter16.middle_02;

import java.util.List;
import java.util.stream.Stream;

public class MiddleCalculate {
    /**
     * 스트림의 중간 연산 메서드
     *
     * 1. 스트림 자르기
     *    skip() -> 특정 횟수 만큼 스트림을 건너 뛴 후에 나머지 스트림을 반환함
     *
     *    limit() -> 지금 위치한 스트림 요소부터 특정 갯수 만큼 스트림을 반환함
     *
     * 2. 스트림 필터링
     *    filter() -> 특정 조건에 맞는 스트림 요소들만 걸러내서 반환함
     *
     *    distinct() -> 스트림의 중복되는 요소를 반환함
     *
     *    dropWhile() -> 영문명의 뜻을 풀어보면 drop -> 제거함, While -> ~까지 이므로 이를 자세히 설명하면
     *                   주어진 조건을 만족하는 것을 만날 때 까지(While) 요소를 제거(Drop)한다는 뜻이다.
     *                   자세한 동작은 아래 예시 참고 [자바 9 버전에서 추가된 연산 메서드이기 때문에 사용 전에 버전을 확인하자.]
     *    takeWhile() -> 영문명의 뜻을 풀어보면 take -> 가져옴, While -> ~까지 이므로 이를 자세히 설명하면
     *                   주어진 조건을 만족하는 것을 만날 때 까지(While) 요소를 가져온(Take)다는 뜻이다.
     *                   위의 dropWhile 과는 반대로 동작한다.
     *                   자세한 동작은 아래 예시 참고 [자바 9 버전에서 추가된 연산 메서드이기 때문에 사용 전에 버전을 확인하자.]
     * 3. 스트림 정렬
     *    sorted() -> 스트림을 정렬해서 반환함, 정렬 순서나 조건은 Comparator 인터페이스에 이미 정의된 메서드를 쓸 수도 있고
     *                내가 직접 구현해서 쓸 수도 있다. 기본 정렬은 ASCII 코드 기준으로 내림차순 정렬된다.
     *
     * 4. 스트림 변환
     *    map() -> 스트림의 요소들을 순회하면서 해당 요소들을 원하는 대로 변환 등의 처리를 해서 반환한다.
     *
     *    mapToInt(), mapToLong(), mapToDouble() -> map()의 변환 처리의 결과 타입이 Int, Long, Double의 경우에는 이 메서드를 사용함
     *
     *    peek() -> 이 메서드는 약간 특수한 성격을 가지고 있는데 map() 처럼 동작하지만 타입을 바꾸지 않는 처리를 하는 경우에 사용함
     *              타입을 바꾸지 않기 때문에 중간에 확인 차 값을 출력할 때도 최종 연산인 forEach 대신에 사용할 수도 있음
     *
     *    flatMap() -> Stream<T[]> 를 Stream<T>로 변환.
     *                만약 List<List<String>>과 같은 List 안의 List를 한 번에 접어서 List<String>과 같이 만들고 싶다면 사용할 수 있다.
     *
     * 추가적인 기능의 중간 연산 메서드가 있지만 그것은 나중에 예제 챕터에서 학습한다.
     *
     * */

    public static void main ( String[] args ) {
        List <String> baseList = List.of ( "중복값2 ", "중복값1 ", "값1 ", "값2 ", "중복값2 ", "중복값3 ", "중복값1 ", "중복값3 ", "값5 " );
        //스트림 자르기
        streamCut ( baseList );

        //스트림 필터링
        streamFilter ( baseList );

    }

    private static void streamCut ( List <String> baseList ) {
        System.out.println ( "스트림 자르기" );
        //skip
        baseList.stream ( ).skip ( 5 ).forEach ( System.out::print );
        //9개의 요소 중에 5개를 건너 뛰었으니 뒤의 4개만 출력된다.
        System.out.println ( );
        System.out.println ( "======================================" );

        //limit
        baseList.stream ( ).limit ( 5 ).forEach ( System.out::print );
        System.out.println ( );
        System.out.println ( "======================================" );
        //5개의 요소로 제한했으므로 따로 skip을 앞에서 하지 않았다면 맨 앞의 5개 요소만 출력된다.
    }

    private static void streamFilter ( List <String> baseList ) {
        System.out.println ( "스트림 필터링" );
        //filter
        System.out.println ( );
        System.out.println ( "======================================" );

        //distinct
        System.out.println ( );
        System.out.println ( "======================================" );


        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> numbersOther = List.of(1, 2, 3, 4, 5, 6, 7, 1, 2, 8, 9, 10);
        //아래 예시를 위해서 List 추가


        //dropWhile
        numbers.stream().dropWhile(n -> n < 5).forEach ( System.out::print );
        //n < 5 조건을 만족하는 숫자들(1,2,3,4)을 제거하고 첫 번째로 조건을 만족하지 않는 숫자인 5를 만난 시점부터 모든 숫자가 포함

        System.out.println ( );
        numbersOther.stream().dropWhile(n -> n < 5).forEach ( System.out::print );
        //첫 번째로 조건을 만족하지 않는 숫자부터 모든 숫자가 포함되므로 이후에 조건에 맞지 않는 숫자가 나와도 그것들은 포함됨

        System.out.println ( );
        System.out.println ( "======================================" );


        //takeWhile
        numbers.stream().takeWhile (n -> n < 5).forEach ( System.out::print );
        //n < 5 조건을 만족하는 숫자들을 포함하고 첫 번째로 조건을 만족하지 않는 숫자인 5를 만나는 즉시 스트림 처리를 중지하고 그 이후의 숫자들은 포함하지 않음

        System.out.println ( );
        numbersOther.stream().takeWhile(n -> n < 5).forEach ( System.out::print );
        //첫 번째로 조건을 만족하지 않는 숫자부터 모든 숫자가 제외되므로 이후에 조건에 맞는 숫자가 나와도 그것들은 제외됨

        System.out.println ( );
        System.out.println ( "======================================" );
    }

}
