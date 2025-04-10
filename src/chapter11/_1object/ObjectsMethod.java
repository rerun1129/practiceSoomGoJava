package chapter11._1object;

import java.util.Objects;

public class ObjectsMethod {
    private String name;

    public ObjectsMethod ( ) {
        super ( );
    }

    @Override
    protected Object clone ( ) throws CloneNotSupportedException {
        return super.clone ( );
        /**
         * 보통 불변 객체를 복사할 때 사용한다.
         * 기본적으로 얕은 복사이기 때문에 주소값을 원본과 복사 객체가 공유한다.
         * */
    }

    @Override
    public String toString ( ) {
        return super.toString ( ); //클래스이름@16진수로 표시한 해시 코드
        //일반적으로는 사용자가 해당 클래스의 필드 멤버들을 보기 쉽게 커스터마이징하여 만든다.
    }

    @Override
    public boolean equals ( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass ( ) != o.getClass ( ) ) return false;
        ObjectsMethod that = ( ObjectsMethod ) o;
        return Objects.equals ( name, that.name );
        /**
         * 이 equals 는 개발자가 커스터마이징하여 사용할 수 있다.
         * 예를 들어 사람의 동일성을 나이, 이름, 주민등록번호 이 3개로 구하고자 한다면
         * 그 3가지 값을 비교해서 boolean 을 리턴하게 할 수도 있다는 것이다.
         * */
    }

    @Override
    public int hashCode ( ) {
        return Objects.hash ( name );
        //equals를 재정의 할 때 hashCode도 반드시 재정의 해야한다.
        //두 객체에 대한 equals가 같다면, hashCode의 값도 같아야 한다.
        //이 부분은 지금 이해하기 너무 어렵기 때문에 이렇구나 하고 넘어가시고
        //나중에 다시 충분히 자바 공부가 되셨다면 다시 떠올려주시면 됩니다.
    }

    @Override
    protected void finalize ( ) throws Throwable {
        super.finalize ( );
        /**
         * 자바의 finalize 메서드는 객체가 가비지 컬렉션에 의해 회수되기 전에 호출되는 메서드
         * 이 메서드는 객체가 소멸되기 전에 정리 작업을 수행할 기회를 제공
         * 여러가지 심각한 단점으로 인해서 자바9 버전부터는 사용이 불가능하게 되었다.
         * 대안으로는 try-with-resources 구문의 사용을 권장한다.
         * */
    }
}
