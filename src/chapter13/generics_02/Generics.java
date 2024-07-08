package chapter13.generics_02;

import java.util.ArrayList;
import java.util.List;

public class Generics {
    /**
     * 제네릭스
     *
     * 자바 5버전부터 도입된 문법으로서 어떠한 클래스가 다양한 타입을 다뤄야 하는 경우에 컴파일 시에 타입 체크를 해주는 문법이다.
     * 객체의 타입을 컴파일 시에 체크하기 때문에 객체의 타입 안정성을 높이고 형변환의 번거로움이 줄어든다.
     *
     * 타입 안정성이 높아진다는 것은 의도하지 않은 타입의 객체가 저장되는 것을 막고, 저장된 객체를 꺼내올 때 원래의 타입과 다른 타입으로
     * 잘못 형변환되어 발생할 수 있는 오류 및 이에 대해서 검증해야하는 코드를 줄여준다는 뜻이다.
     *
     * 제네릭스의 용어
     * Box<T> -> 제네릭 클래스
     * T -> 타입 변수 또는 타입 매개 변수(T는 타입 문자)
     * Box -> 원시 타입(raw Type)
     * */

    private static void checkAndNonCheckType() {
        List list = new ArrayList (); //이러한 사용법은 5버전 이전의 원시 타입 사용법이라고 한다.
        list.add("문자열 입니다.");
        list.add(10);
        //list의 허용 타입을 지정하지 않았으므로 마치 Object 타입의 인스턴스에 값을 넣듯이 할 수 있다.
        Object whatTypeVar1 = list.get ( 0 );
        Object whatTypeVar2 = list.get ( 1 );
        //무슨 타입인지 알 수 없기 때문에 함부로 캐스팅해서 사용할 수가 없다.
        if( whatTypeVar1 instanceof String stringValue ) {
            //때문에 이런식으로 타입 체크를 한 후에 캐스팅해서 사용해야 하는 번거로움이 있다.
        }else if(whatTypeVar1 instanceof Integer) {

        }
        //만약 캐스팅을 잘못하면?
        int isIntVar = ( int ) whatTypeVar1; //컴파일 시에 잡지 못하므로 런타임 시에 ClassCastException 예외가 발생한다.

    }

    public static void main(String[] args) {
        checkAndNonCheckType();
    }
}
