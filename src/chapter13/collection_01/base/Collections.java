package chapter13.collection_01.base;

import java.util.Collection;
import java.util.List;

public class Collections {
    /**
     * 컬렉션 프레임워크
     * - 데이터의 모음을 저장하는 클래스들을 표준화한 설계
     *
     * 자바 2버전 이전의 컬렉션 프레임워크
     * - Vector
     * - Hashtable
     * - Properties
     *
     * 자바 2버전부터의 컬렉션 프레임워크
     * - Collection(부모 인터페이스)
     *   - List(자식 인터페이스) -> '순서(중요)' 가 있는 데이터의 집합. 데이터의 '중복(중요)' 을 허용한다.
     *      - 구현 클래스 -> ArrayList, LinkedList, Stack, Vector(이전 버전 호환성을 위해 놔둠) 등...
     *   - Set(자식 인터페이스) -> '순서(중요)' 가 없는 데이터의 집합. 데이터의 '중복(중요)' 을 허용하지 않는다.
     *      - 구현 클래스 -> HashSet, TreeSet, SortedSet 등...
     * - Map -> 키와 값 쌍으로 이루어진 데이터의 집합. 순서는 유지되지 않으며, 키는 중복을 허용하지 않고 값은 중복을 허용한다.
     *      - 구현 클래스 -> HashMap, TreeMap, Hashtable(이전 버전 호환성), Properties(이전 버전 호환성)
     *
     * */
    public static void main ( String[] args ) {
        /**
         * 기본적인 Collection 인터페이스의 메서드들(List나 Set의 공통 메서드로 보면 된다.)
         * */
        Class <Collection> collectionClass = Collection.class; //Collection 은 인터페이스이기 때문에 여기에 들어가서 확인 해보기
        /**
         * boolean add(Object o) -> 해당 컬렉션에 지정된 객체를 추가함
         * boolean addAll(Collection c) -> 해당 컬렉션에 지정된 Collection에 담긴 객체들을 모두 추가함
         * void clear() -> 해당 컬렉션에 담긴 모든 객체를 삭제함
         * boolean contains(Object o) -> 해당 컬렉션에 파라미터로 넘긴 객체가 포함되어 있는지 확인
         * boolean containsAll(Collection c) -> 해당 컬렉션에 파라미터로 넘긴 컬렉션의 내부 객체들이 포함되어 있는지 확인
         * boolean equals(Object o) -> 해당 컬렉션과 동일한 컬렉션 인지 비교함
         * boolean isEmpty() -> 해당 컬렉션이 비어있는지 확인함
         * Iterator iterator() -> 해당 컬렉션의 iterator 객체, 즉 순회 객체를 받아옴
         * boolean remove(Object o) -> 해당 컬렉션에서 지정된 객체를 삭제
         * boolean removeAll(Collection c) -> 해당 컬렉션에서 지정된 컬렉션에 담긴 객체들을 모두 삭제함
         *
         * boolean retainAll(Collection c) -> 해당 컬렉션에 대해서 지정된 컬렉션에 포함된 객체만 남기고 다른 객체들은 컬렉션에서 삭제한다.(교집합만 남김)
         *                                    이 작업으로 인해 컬렉션에 변화가 있으면 true를 그렇지 않으면 false를 반환한다.
         * int size() -> 해당 컬렉션의 크기를 반환
         * Object[] toArray() -> 해당 컬렉션을 Object 배열로 반환
         *
         * 위의 메서드들은 List나 Set을 시연하면서 동작을 확인하겠습니다.
         * */

    }
}
