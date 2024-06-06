package chapter11.wrapper_01;

import java.net.http.HttpResponse;
import java.util.Map;

public class NullableWrapper {
    /**
     * Wrapper 클래스를 사용하는 이유
     *
     * 1. 기본형에는 없는 유틸리티 메서드를 Wrapper 에서 제공함
     * 2. 기본형은 null을 받을 수 없지만 Wrapper 는 받을 수 있음
     *    이 의미는 기본형은 null 자체를 받을 수 없기 때문에 컴파일 예외가 발생하지만
     *    Wrapper 는 null을 일단 받을 수 있으므로 추후에 null 값을 처리할 기회를 얻을 수 있다.
     * */

    public static void main ( String[] args ) {
        Integer integer = 1;
        int i = 1;

        System.out.println ( wrapperNullToZero ( 1 ) );
        System.out.println ( wrapperNullToZero ( null ) );
//        System.out.println ( primeNullToZero ( null ) ); //애초에 int 파라미터에 null을 할당할 수가 없다.

    }

    static int wrapperNullToZero(Integer integer) {
        if ( integer == null ) return 0;
        else return integer;
        //여기서 자동으로 intValue() 메서드를 호출해서 자동 언박싱을 해 int 기본형으로 바꿔서 리턴한다.
    }

//    static int primeNullToZero(int i) {
//        if ( i == null ) return 0;
//        else return i;
//    }
}
