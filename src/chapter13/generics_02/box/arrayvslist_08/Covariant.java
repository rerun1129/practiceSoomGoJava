package chapter13.generics_02.box.arrayvslist_08;

import java.util.ArrayList;
import java.util.List;

public class Covariant {
    /**
     * 공변과 불공변
     *
     * 공변(covariant)이란?
     *
     * 단어 그대로 같이 변한다는 뜻.
     * 즉, Object[] anything = new String[10]
     * 우변이 String 타입이더라도 좌변이 Object 와 같은 부모 클래스로 자동 캐스팅이 될 수 있다는 뜻
     * 공변으로 인해서 anything 배열에 정수를 넣을 수 있게 되며 컴파일 시점에는 예외 여부를 확인할 수 없고
     * 런타임에 문제가 발생하게 된다.
     *
     * 불공변(invariant)이란?
     *
     * 공변과는 반대로 같이 변하지 않는다는 뜻.
     * List<String> names = new ArrayList<String>()
     * 위와 같이 제네릭 타입은 좌변과 우변의 타입이 완전하게 일치하지 않으면 컴파일 에러가 발생함
     * 컴파일 타임에 이를 잡아주기 때문에 런타임에도 당연히 문제가 발생하지 않는다.
     *
     * 위와 같은 자바의 특성으로 인해서 배열은 최적화가 매우 잘 되어 있지만 타입 안전하게 쓸 수가 없다.
     *
     * */

    public static void main ( String[] args ) {
        //공변 -> 문제없이 컴파일 됨
        Object[] anything = new String[ 10 ];
        anything[0] = 1; //타입 'Integer'의 요소를 'String' 요소의 배열에 저장하면 'ArrayStoreException'이 발생합니다
        //위와 같은 이유로 런타임에 문제가 생김

        //불공변
        List <String> names = new ArrayList <> ( );
        //List<Object> anyList = names; //컴파일 에러 발생
        //같은 논리로 List<Object> anyList = new ArrayList <String> ( ); 도 불가능함

    }
}
