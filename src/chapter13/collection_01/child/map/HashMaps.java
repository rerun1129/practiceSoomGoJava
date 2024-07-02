package chapter13.collection_01.child.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMaps {
    /**
     * HashMap
     *
     * 해시맵은 Map을 구현한 구현체이며 이는 Map의 컨셉과 동일하게 키-값 쌍으로 자료를 저장하는 구조를 가짐을 의미한다.
     * 키를 가지고 값을 찾을 수 있기 때문에 Map 내부에 있는 데이터에 가장 빠르게 접근할 수 있는 자료구조이다.
     *
     * 해시맵은 Entry 라는 내부 클래스가 정의되어 있고 그 Entry가 Key, Value 필드를 관리한다.
     * 굳이 번거롭게 HashMap.Entry 를 통해서 Key, Value 필드를 관리하는 이유는 Key 와 Value 가 서로 밀접한 관련성을 가진 객체이기 때문에
     * 이를 단순히 HashMap 의 멤버 변수로 두는 것보다 Entry를 Map의 참조 멤버 변수로 두는 것이 관리 상 유리한 점이 많기 때문이다.
     * */

    public static void main ( String[] args ) {
        HashMap <Object, Object> hashMap = new HashMap <> ( );
        HashMap <Object, Object> hashMapLoadFactor = new HashMap <> ( 16, 0.75f); //load factor는 따로 설정하지 않으면 기본값이 0.75임
        //load Factor 는 Capacity 의 임계치라고 보면 된다. 만약 초기 가용량이 16이라면 16 * 0.75 = 12 만큼 Map의 공간을 사용하면
        //13번째 데이터 삽입 시 미리 동적으로 16의 2배인 32로 가용량을 늘려서 데이터를 담게 된다.
        //그리고 다시 32 * 0.75 = 24 만큼 데이터를 담게 되면 다시 25번째에 32 * 2 인 64만큼 가용량을 늘리는 방식으로 계속 이어진다.
        //간단하게 어느 시점에 Map 의 가용 메모리 공간을 리사이징 할지를 결정하는 것이고 적절한 시점에 리사이징을 하면
        //키-값 쌍을 Map 에 넣을 때 키의 충돌 없이 효율적으로 데이터를 배치할 수 있게 된다.

        //of
        Map <String, Integer> stringIntegerMap = new HashMap <> ( Map.of ( "1", 20, "2", 30, "3", 40 ) );
        //Map의 of는 다른 Collection 상속 객체와는 다르게 키1, 값1, 키2, 값2 ... 순서로 파라미터를 넘겨야 Map 인스턴스가 만들어진다.
        //앞에서 설명하지 않았지만 of를 사용해서 컬렉션 인스턴스를 만들면 해당 컬렉션은 불변 객체가 되어 add, remove 등의 추가 삭제가 불가능해진다.
        //그것을 막기 위해서 다시 HashMap 생성자로 랩핑해서 가변 객체를 만들어준 것이다.

        //containsKey / containsValue
        System.out.println ( stringIntegerMap.containsKey ( "1" ) ); //키의 존재여부 확인
        System.out.println ( stringIntegerMap.containsValue ( 30 ) ); //값의 존재여부 확인
        System.out.println ( "=================================================================" );
        //entrySet / keySet / values
        Set <Map.Entry <String, Integer>> entries = stringIntegerMap.entrySet ( );
        //키-값 쌍은 유일하기 때문에 굳이 List로 엔트리를 반환하지 않고 Set으로 반환한다.
        entries.forEach ( System.out::println ); //엔트리의 출력은 키=값 형태로 출력된다.
        Set <String> strings = stringIntegerMap.keySet ( ); //키만 추출
        strings.forEach ( System.out::print );
        System.out.println ( );
        Collection <Integer> values = stringIntegerMap.values ( ); //값만 추출. 값은 중복이 가능하므로 Set으로 반환하지 않는다.
        values.forEach ( System.out::println );
        //Map은 저장 순서를 보장하지 않기 때문에 실행 할 때마다 출력 위치가 변경될 수 있다.
        System.out.println ( "=================================================================" );
        //get / getOrDefault
        System.out.println ( stringIntegerMap.get ( "1" ) ); //키에 대응되는 값을 가져온다.
        System.out.println ( stringIntegerMap.getOrDefault ( "4", 999 ) ); //키에 대응되는 값이 없으면 두번째 파라미터 값을 반환해준다.
        System.out.println ( "=================================================================" );
        //put / replace
        /**
         * 일반적으로 replace 보다는 put을 주로 사용한다.
         * 공통점은 둘 다 값을 덮어씌울 수 있다는 것이 있지만 차이점으로 인해서 대부분의 경우에는 put을 쓴다.
         *
         * 차이점
         * 1. 지정한 키가 대상 Map에 존재하지 않을 때
         *    - put: 새 키-값 쌍을 추가
         *    - replace: 아무 작업도 하지 않으며, null을 반환
         * 2. 조건부 업데이트(잘 쓰지는 않음)
         *    - put : 없음
         *    - replace: 오버로드된 메서드를 사용하면, 특정 키의 현재 값이 예상 값과 일치할 때만 업데이트할 수 있음. replace(key, oldValue, newValue) 메서드 사용
         * 따라서, 매우 드물게 조건부 업데이트를 하는 경우에 replace를 쓰지만 기본적으로는 키에 대한 값을 새로 넣거나 덮어씌울때 모두 put을 쓰는게 통일성이 있다.
         * 만약, Map 에 해당 키가 있는지 아닌지 알 수 없는 경우에 put을 쓰면 덮어씌워지거나 새로 값이 들어가는데 replace를 쓰면 덮어씌워지거나 값이 안들어가기 때문에
         * 보통은 의도한 바가 put일 것이므로 put을 사용하는 것이다.
         * */
        stringIntegerMap.put ( "4", 10 );
        stringIntegerMap.replace ( "4", 9999 );
        stringIntegerMap.replace ( "4", 9999, 10 ); //성공
        stringIntegerMap.replace ( "4", 100, 10000 ); //실패
        //키 4의 값은 최종적으로 10이 된다.
        System.out.println ( stringIntegerMap.get ( "4" ) );

    }


    /**
     * 해싱과 해시함수
     *
     * 해싱이란 해시 함수를 이용해서 데이터를 해시 테이블에 저장하고 검색하는 기법을 말한다.
     * 이러한 해싱을 통해서 유일한 키가 될 해시 코드를 해시 함수를 통해서 구하고 그 해시 코드를 키에 대응하여
     * 하나의 키에 하나의 데이터가 대응되도록 하여 키를 알면 그 데이터에 바로 접근(조회)할 수 있도록 하는 것이 해싱이다.
     * 이상적인 경우에는 키-값 쌍이 1대1 대응되도록 하여 데이터 검색 및 추가/삭제에 시간 복잡도가 O(1)인 이론상 가장 빠른 상수 시간 접근이 가능해진다.
     *
     * 해싱을 구현한 컬렉션 클래스는 HashSet, HashMap, HashTable 등이 있고 HashTable은 HashMap으로 대체되었다.
     * 해싱에서 사용하는 자료구조는 다음과 같이 배열과 연결 리스트의 조합으로 되어 있다.
     * Ex)
     * data[0] [테이블 주소] -> [    ] -> [    ]
     * data[1] [테이블 주소] -> [    ]
     * data[2] [테이블 주소]
     * data[3] [테이블 주소] -> [    ]
     * data[4] [테이블 주소] -> [47xxxx-2xxxxxx]
     * data[5] [테이블 주소] -> [    ] -> [    ] -> [    ] ← 연결 리스트
     * data[6] [테이블 주소]
     * data[7] [테이블 주소] -> [75xxxx-1xxxxxx] -> [79xxxx-1xxxxxx]
     * data[8] [테이블 주소] -> [    ]
     * data[9] [테이블 주소] -> [    ]
     * ↑ 배열    ↑맵핑 테이블
     *
     * 만약 위에 주민등록번호 데이터를 넣어야 한다면 주민등록번호 첫번째 숫자를 배열의 인덱스와 대응시켜 분류하는 방법을 취할 수 있다
     * 물론 해시 함수가 값을 분류하는 방법은 위처럼 단순하진 않고 최대한 해시 테이블에 값들이 균등하게 들어가도록 구현된다
     *
     * 그런데 여기에서 의문점이 몇 가지 생긴다.
     * 1. 위의 예시에서는 하나의 테이블 주소에 여러 값이 매달려 있는데 이 경우에는 어떻게 키로 값을 바로 찾는가?
     * 2. 어째서 해시 함수는 키-값 쌍을 1대1 맵핑하는 것이 목표가 아니고 최대한 균등하게 들어가도록 만드는게 목표인 것인가?
     *
     * 그 의문점에 대한 답은 아래의 링크를 확인해보자.
     * https://ko.wikipedia.org/wiki/%EB%B9%84%EB%91%98%EA%B8%B0%EC%A7%91_%EC%9B%90%EB%A6%AC
     *
     * 위의 원리에 따라서 현실 세계에서는 비둘기 집(키)은 유한하지만 비둘기(값)의 수는 무한하거나 반드시 비둘기 집보다 많다.
     * (컴퓨터가 만들 수 있는 메모리의 주소는 반드시 유한하지만 당장 실수의 범위만 해도 무한대이므로 반드시 하나의 주소에 여러 값이 들어가게 된다.)
     * 따라서 시간복잡도 O(1)으로 하나의 키로 바로 값을 검색할 수 있는 매우 이상적인 자료 구조에서
     * 최선의 경우와 최악의 경우가 O(1)[상수 시간] -> O(N)[선형 시간]으로 크게 차이나는 작업 시간의 편차가 불안정한 자료구조가 되어버린다.
     *
     * 이 결과로 말미암아서 Hash가 만능이 아니며 다른 자료 구조의 필요성이 대두되었고 검색에 더 효율적인 자료구조가 나오게 되었는데
     * 그것이 바로 Tree 자료 구조이다.
     *
     * */

}
