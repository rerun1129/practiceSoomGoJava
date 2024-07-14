package chapter16.middle_02;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

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
     *
     *    takeWhile() -> 영문명의 뜻을 풀어보면 take -> 가져옴, While -> ~까지 이므로 이를 자세히 설명하면
     *                   주어진 조건을 만족하는 것을 만날 때 까지(While) 요소를 가져온(Take)다는 뜻이다.
     *                   위의 dropWhile 과는 반대로 동작한다.
     *                   자세한 동작은 아래 예시 참고 [자바 9 버전에서 추가된 연산 메서드이기 때문에 사용 전에 버전을 확인하자.]
     * 3. 스트림 정렬
     *    sorted() -> 스트림을 정렬해서 반환함, 정렬 순서나 조건은 Comparator 인터페이스에 이미 정의된 메서드를 쓸 수도 있고
     *                내가 직접 구현해서 쓸 수도 있다. 기본 정렬은 ASCII 코드 기준으로 내림차순 정렬된다.
     *
     * 4. 스트림 열람
     *    peek() -> 스트림을 열람함. 이 메서드가 최종 연산인 forEach와 다른 점은 Stream 타입을 그대로 반환하는 중간 연산이라는 점.
     *              내부 객체의 타입이나 값을 변경할 수는 없으나 제네릭 타입의 객체인 경우는 타입 변경없이 값을 변경할 수 있음.
     *
     * 5. 스트림 변환
     *    map() -> 스트림의 요소들을 순회하면서 해당 요소들을 원하는 대로 변환 등의 처리를 해서 반환한다.
     *
     *    mapToInt(), mapToLong(), mapToDouble() -> map()의 변환 처리의 결과 타입이 Int, Long, Double의 경우에는 이 메서드를 사용함
     *
     *    flatMap() -> Stream<T[]> 를 Stream<T>로 변환.
     *                만약 List<List<String>>과 같은 List 안의 List를 한 번에 접어서 List<String>과 같이 만들고 싶다면 사용할 수 있다.
     *
     *
     * */

    public static void main ( String[] args ) {
        List <String> baseList = List.of ( "중복값2 ", "중복값1 ", "값1 ", "값2 ", "중복값2 ", "중복값3 ", "중복값1 ", "중복값3 ", "값5 " );
        //스트림 자르기
        streamCut ( baseList );
        //스트림 필터링
        streamFilter ( baseList );
        //스트림 정렬
        streamSort(baseList);
        //스트림 열람
        streamOpen(baseList);
        //스트림 변환
        streamModify(baseList);
    }

    private static void streamCut ( List <String> baseList ) {
        System.out.println ( "스트림 자르기\n" );
        //skip
        baseList.stream ( ).skip ( 5 ).forEach ( System.out::print );
        System.out.print ( " -> skip : 9개의 요소 중에 5개를 건너 뛰었으니 뒤의 4개만 출력된다.\n" );

        //limit
        baseList.stream ( ).limit ( 5 ).forEach ( System.out::print );
        System.out.print ( " -> limit : 5개의 요소로 제한했으므로 따로 skip을 앞에서 하지 않았다면 맨 앞의 5개 요소만 출력된다.\n" );
        System.out.println ( "======================================\n" );
    }

    private static void streamFilter ( List <String> baseList ) {
        System.out.println ( "스트림 필터링\n" );
        //filter
        baseList.stream ().filter ( s -> s.startsWith ( "중복" ) ).forEach ( System.out::print );
        System.out.print ( " -> filter : 문자열 앞이 중복으로 시작되는 것들만 가져오기\n" );
        System.out.println ( "======================================" );

        //distinct
        baseList.stream ().distinct ().forEach ( System.out::print );
        System.out.print ( " -> distinct : 문자열들 중에 중복 제거하기\n" );
        System.out.println ( "======================================" );


        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> numbersOther = List.of(1, 2, 3, 4, 5, 6, 7, 1, 2, 8, 9, 10);
        //아래 예시를 위해서 List 추가


        //dropWhile
        numbers.stream().dropWhile(n -> n < 5).forEach ( System.out::print );
        System.out.print ( " -> dropWhile : n < 5 조건을 만족하는 숫자들(1,2,3,4)을 제거하고 첫 번째로 조건을 만족하지 않는 숫자인 5를 만난 시점부터 모든 숫자가 포함\n" );
        numbersOther.stream().dropWhile(n -> n < 5).forEach ( System.out::print );
        System.out.print ( " -> dropWhile : 첫 번째로 조건을 만족하지 않는 숫자부터 모든 숫자가 포함되므로 이후에 조건에 맞지 않는 숫자가 나와도 그것들은 포함됨\n" );
        System.out.println ( "======================================" );


        //takeWhile
        numbers.stream().takeWhile (n -> n < 5).forEach ( System.out::print );
        System.out.print ( " -> takeWhile : n < 5 조건을 만족하는 숫자들을 포함하고 첫 번째로 조건을 만족하지 않는 숫자인 5를 만나는 즉시 스트림 처리를 중지하고 그 이후의 숫자들은 포함하지 않음\n" );
        numbersOther.stream().takeWhile(n -> n < 5).forEach ( System.out::print );
        System.out.print ( " -> takeWhile : 첫 번째로 조건을 만족하지 않는 숫자부터 모든 숫자가 제외되므로 이후에 조건에 맞는 숫자가 나와도 그것들은 제외됨\n" );
        System.out.println ( "======================================\n" );
    }

    private static void streamSort ( List <String> baseList ) {
        System.out.println ( "스트림 정렬\n" );
        //sorted
        baseList.stream ( ).sorted ( ).forEach ( System.out::print );
        System.out.print ( " -> sorted : 기본 정렬이므로 ㄱ으로 시작하는 값이 먼저 오고 나머지는 뒤의 숫자 기준으로 정렬됨\n" );
        System.out.println ( "======================================" );

        List<String> stringList = List.of ("1 ", "2 ", "10 ", "20 ");
        List<Integer> integerList = List.of (1, 2, 10, 20);
        stringList.stream ( ).sorted ( ).forEach ( System.out::print );
        System.out.print ( " -> sorted : 문자열 정렬이므로 자리수가 차이나도 맨 앞 문자의 ASCII 코드 기준으로 정렬함\n" );
        integerList.stream ( ).sorted ( ).forEach ( i -> System.out.print ( i + " " ) );
        System.out.print ( " -> sorted : 정수의 정렬이므로 숫자의 크기 기준으로 정렬함\n" );
        //(주의) 기본적으로 정렬 기준인 Comparator 나 Comparable 은 크기 비교에서 정렬 결과가 음수, 0, 양수를 기준으로 서로를 비교함
        //따라서 정수형의 정렬과 문자열의 정렬은 겉으로 보이는 값이 같아도 결과가 달라질 수 있음
        System.out.println ( "======================================\n" );
    }

    private static void streamOpen ( List <String> baseList ) {
        System.out.println ( "스트림 열람\n" );
        //peek
        //단순 중간 출력 후 중복 제거 후 최종 출력
        baseList.stream ()
                .map ( s -> s.replace ( " ", "" ) ) //후행 공백 제거
                .peek ( s -> System.out.print ( s + "(중복O)" )  ) //반환 타입이 변하지 않기 때문에 이렇게 중간에 출력해서 값이 제대로 변하고 있는지 확인도 가능함
                .distinct () //중복 제거
                .forEach ( s -> System.out.print ( s + "(중복X)"  ));
        System.out.println ( " \n-> 보통 peek에서는 중간 출력확인을 하지 않는데 위의 예시와 같이 중간 연산은 바로 실행되는 것이 아니고 최종 연산이 호출된 시점에 한꺼번에 순차연산되는 방식이기 때문에 원하는 결과를 얻을 수가 없다\n" );
        System.out.println ( "======================================" );

        //List 내부에 담긴 Map의 값을 바꿔서 처리하는 경우
        //Map의 키=제품명, 값=제품가격 일 때, 제품가격에 부가가치세 10%를 추가하는 경우
        List<Map <String, Integer>> fruitMapList = List.of (new HashMap<>(Map.of ( "사과", 5000 )), new HashMap<> ( Map.of ( "바나나", 3000 ) ), new HashMap<> ( Map.of ( "배", 8000 ) ) );
        fruitMapList.stream ().peek ( item -> {
            Set <String> keys = item.keySet ( );
            String key = keys.stream ( ).findFirst ( ).get ( );
            item.put ( key, ( int )(item.get ( key ) * 1.1));
        } ).forEach ( System.out::print );
        System.out.print ( " -> 여기서 peek 을 사용해서 객체 내부의 값을 변경할 때 문제가 생기는데 내부의 원본 객체에 변경을 가하므로\n" );
        fruitMapList.forEach ( System.out::print );
        System.out.print ( " -> 같은 주소를 보고 있는 원본도 동일하게 영향을 받아 변경되어 스트림의 취지인 원본 객체가 변경되지 않는다를 위반한다.\n" );

        //이 경우에 원본 객체가 손상됨을 감수하고 처리한다고 하면 문제가 없으나 일반적으로 원본 객체가 변경되는 것은 원하는 바가 아닐 것이므로
        //map()을 써서 객체 return 시에 필요하다면 new HashMap<> () 으로 새로운 객체 주소에 담아서 스트림을 처리하는 것이 확실하다.
        System.out.println ( "======================================\n" );
    }

    private static void streamModify ( List <String> baseList ) {
        System.out.println ( "스트림 변환\n" );

        //map

        //int index = 0; -> 이렇게 외부 값을 기본형으로 순차 증가시키는 방식으로는 스코프 문제로 불가능함 (람다식 참고)
        AtomicInteger index = new AtomicInteger (0);
        //이와 같이 순차 처리 시에 값을 직접적으로 수정하는 기본형이 아닌 참조형의 메서드를 호출해서 인덱스를 키로 잡아줄 수 있음
        baseList.stream ()
                .map ( s -> Map.of ( index.getAndIncrement () , s.replace ( " ", "" ) ) )
                .forEach ( m -> System.out.print ( m + " " ) );
        System.out.print ( "\n -> map : 문자열을 Map 으로 변환하되 요소의 인덱스를 키로, 문자열을 값으로 만들기, 추가로 공백도 제거\n" );
        System.out.println ( "======================================" );

        //mapToInt(기본형 변환의 예시)
        baseList.stream ()
                .mapToInt ( s -> Integer.parseInt ( s.replace ( " ", "" ).substring ( s.length () -2, s.length ()-1 ) ) )
                .forEach ( i -> System.out.print ( i + " " ) );
        System.out.print ( "\n -> mapToInt : 문자열 내부의 맨 뒤의 숫자만 정수형으로 변환하여 추출, 공백은 제거\n" );
        System.out.println ( "======================================" );

        //flatMap
        //컬렉션의 컬렉션, 배열의 배열을 하나의 컬렉션이나 배열로 압축할 때 사용한다고 생각하면 편하다.
        //3개의 카페의 메뉴들을 중복 제거하여 가나다순으로 정렬하기
        List <String> cafeAMenus = List.of("아메리카노", "쿠키", "라떼", "마키아토", "가나슈", "치즈 케익", "아이스티" );
        List <String> cafeBMenus = List.of("아메리카노", "아이스크림", "샌드위치", "라떼", "마키아토", "아이스티");
        List <String> cafeCMenus = List.of("아메리카노", "라떼", "아포가토",  "마키아토", "붕어빵", "아이스티");
        List <List <String>> cafeMenuCatalog = List.of ( cafeAMenus, cafeBMenus, cafeCMenus );

        //만약 flatMap 없이 처리하려고 한다면?
        List<String> allCafeMenus = new ArrayList <> ();
        cafeMenuCatalog.forEach ( allCafeMenus::addAll );
        allCafeMenus.stream ().distinct ().forEach ( s -> System.out.print ( s + " " ) );
        System.out.print ( " -> flatMap없이 처리\n" );
        //스트림을 2번 쪼개서 써야 하고 외부에 불필요한 컬렉션 객체를 따로 선언해서 처리해야 한다.

        //flatMap으로 처리했다면?
        //중간 연산이기 때문에 리턴 값은 반드시 Stream<R => 여기서는 String>로 반환해줘야 한다.
        cafeMenuCatalog.stream ().flatMap ( Collection::stream ).distinct ().forEach ( s -> System.out.print ( s + " " ) );
        System.out.print ( " -> flatMap으로 처리\n" );
        //동일한 처리 결과이지만 여기서는 코드 한줄로 처리할 수 있고 불필요하게 추가 객체를 선언할 필요도 없다.
        System.out.println ( "======================================" );
    }
}
