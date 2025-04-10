package chapter13._2generics._01_box._08_arrayvslist;

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

        //불공변한 제네릭 List를 공변하도록 만들고 싶다면?
        List<? extends Object> anyList = names; //와일드 카드를 이용하면 타입 매개변수의 다형성 사용이 가능하기 때문에 배열과 유사하게 공변성을 띈다.

        //물론, 공변으로서의 문제점인 런타임 시의 타입 불합치 문제가 있을 수 있어 주의해서 사용해야 한다.
        anyList.forEach ( item -> ((String) item).toString () ); //실제로 사용할 때는 일반 제네릭 타입처럼 명확한 타입 지정이 이루어져 있지 않아 강제 캐스팅이 불가피함

    }
}
