package chapter13.collection_01.base;

public class Maps {
    /**
     * Map의 기타 특징
     * - 기존에 저장된 데이터와 중복된 키로 값을 저장하면 이전에 해당 키로 저장했던 값은 덮어쓰기되어 사라진다.
     *
     * Map의 메서드
     *
     * void clear() -> 맵의 모든 객체를 삭제
     * boolean containsKey(Object key) -> 지정된 키 객체와 일치하는 맵의 키 객체가 있는지 확인한다.
     * boolean containsValue(Object value) -> 지정된 값 객체와 일치하는 맵의 값 객체가 있는지 확인한다.
     * Set entrySet() -> 맵에 저장되어 있는 키-값 쌍을 Map.Entry 타입의 객체로 저장한 Set으로 반환한다.
     * boolean equals(Object o) -> 동일한 맵인지 비교한다.
     * Object get(Object key) -> 지정한 키 객체에 대응하는 값 객체를 찾아서 반환한다.
     * boolean isEmpty() -> 맵이 비어있는지 확인한다.
     * Set keySet() -> 맵에 저장된 모든 키 객체를 반환한다. (키는 중복 불가이므로 Set 타입으로 반환)
     * Object put(Object key, Object value) -> 맵에 값 객체를 키 객체에 맵핑하여 저장한다
     * void putAll(Map m) -> 해당 맵에 지정된 맵의 모든 키-값 쌍을 저장한다
     * Object remove(Object key) -> 지정한 키 객체와 일치하는 키-값 쌍을 삭제한다
     * int size() -> 맵에 저장된 키-값 쌍의 개수를 반환
     * Collection values() -> 맵에 저장된 모든 값 객체를 반환한다.(값은 중복 가능이므로 Collection 타입으로 반환)
     *
     * Map.Entry의 특징
     * - Map 인터페이스의 내부 인터페이스
     * - Map에 저장되는 키-값 쌍을 다루기 위해서 별도로 선언된 인터페이스
     *
     * Map.Entry의 메서드
     *
     * boolean equals(Object o) -> 동일한 Entry인지 비교한다
     * Object getKey() -> Entry의 키 객체를 반환한다.
     * Object getValue() -> Entry의 값 객체를 반환한다.
     *
     * */
}
