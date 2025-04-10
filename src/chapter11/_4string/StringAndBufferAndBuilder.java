package chapter11._4string;

public class StringAndBufferAndBuilder {
    /**
     * String 의 단점
     * 불변은 일반적인 객체에서는 장점일 수도 있지만 String 은 어떻게 보면 자동적으로 변수가 불변으로 처리되기 때문에
     * 해당 String 변수의 값이 계속 바뀌면 의미없는 메모리 낭비가 생길 수 있다.
     * */

    /**
     * 아래와 같이 모든 문자열은 그 고유의 메모리 주소를 점유하기 때문에 아래와 같이 문자열을 계속 변경하는 것은 메모리 관리 상 좋지 않음
     * 그래서 등장한 클래스가 StringBuilder 와 StringBuffer 이다.
     *
     * StringBuilder 와 StringBuffer 는 멀티스레드 환경에서 안전하냐 아니냐의 차이점만이 존재한다.
     * StringBuilder는 동기화 처리를 하지 않으므로 그만큼 비동기적 처리에서 성능 상 이점을 가져갈 수 있다는
     * 장점이 있지만 멀티 스레드 환경에서는 사용하지 않는 것이 좋다.
     *
     * StringBuffer는 동기화 처리를 하므로 멀티 스레드 환경에서 안전하게 사용할 수 있지만 그만큼 성능 측면에서 Builder 보다는 떨어진다.
     * */

    public static void main ( String[] args ) {
        String unchanged = "change";
        String unchanged2 = "change";
        System.out.println ( unchanged.hashCode () );
        System.out.println ( unchanged2.hashCode () ); // 동일한 해시코드

        unchanged = unchanged + "!";
        System.out.println ( unchanged.hashCode () );
        //문자열은 각각이 고유한 메모리 주소를 가지므로 해시코드가 변경됨.
        //즉, 변수의 값이 변경된 것이 아닌 주소를 새로 받은, 사실상의 불변 객체 역할을 함

        /**
         * 여기서 for 문으로 문자열에 계속 += 를 하는 코드가 있다면 안그래도 많은 메모리를 점유하는 String 타입의 변수는 더욱 비효율적으로 사용된다.
         * */

        StringBuilder changeable = new StringBuilder ( "change" );
        System.out.println ( changeable.hashCode () );//해시코드가 위아래가 동일함
        changeable.append ( "!" );
        System.out.println ( changeable.hashCode () );//해시코드가 위아래가 동일함(동일한 메모리 주소에서 값이 변경되고 있음을 의미함)
        String s = changeable.toString ( ); //최종적으로 변경되지 않는 경우에는 다시 String 타입으로 변환해서 쓰는 것이 좋다.
    }
}
