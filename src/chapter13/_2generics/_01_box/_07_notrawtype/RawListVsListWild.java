package chapter13._2generics._01_box._07_notrawtype;

import java.util.ArrayList;
import java.util.List;

public class RawListVsListWild {
    /**
     * List와 List<?>의 차이점 (원시 타입을 사용하면 안되는 이유)
     *
     * 기본적으로 제네릭스를 사용하는 이유는 제네릭 타입 객체의 타입 안정성을 지키기 위함이다.
     * 원시 타입과 와일드 카드 타입의 비교를 통해서 어떤 차이가 있고 원시 타입 사용을 지양해야 하는 이유를 보도록 하자.
     * */

    static int sumRawType( List s1){
        //어떤 값이든 넣을 수가 있다.
        s1.add ( 4 );
        s1.add ( 5 );
//        s1.add ( "안녕!" ); //이렇게 의도하지 않은 타입의 값도 들어갈 수 있으므로 문제가 된다.
        return (int) s1.stream ( ).reduce ( 0,(a,b) -> {
            Integer a1 = ( Integer ) a;
            Integer b1 = ( Integer ) b;
            return a1 + b1;
        } );
    }

    //static int sumWildCard( List<?> s1){ //아래에 이런식으로 쓸 수 없는 안정성 대책이 마련되어 있다.
    //    s1.add ( null ); //null은 정말 특수한 타입이기 때문에 와일드 카드처럼 타입이 정해지지 않은 경우에도 값을 넣을 수가 있음
    //    s1.add ( 3 ); //null 이외의 값은 모두 집어 넣으려고 하면 컴파일 에러가 발생함
    //    s1.get ( 0 ); //값을 꺼내는 것은 가능함. 값을 꺼내는 것은 타입 안정성을 해치지 않으므로
    //    //와일드 카드 타입 제네릭 객체는 자신을 변경시키는 절차에 대해서만 컴파일 에러를 발생시킴
    //    //return s1.stream ( ).reduce ( 0,(a,b) -> {
    //    //    Integer a1 = ( Integer ) a;
    //    //    Integer b1 = ( Integer ) b;
    //    //    //reduce 는 누적 객체에 현재 객체를 더하는 메서드인데 현재 객체를 정수형으로 강제 변환해서 계산해도
    //    //    //누적 객체가 타입이 정해지지 않은 ?이기 때문에 누적 연산이 불가능하다.
    //    //    //이 또한 객체를 변경시켜서 무언가의 처리를 하는 것이기 때문에 타입 안정성 측면에서 막는 것이다.
    //    //    return a1 + b1;
    //    //} );
    //    //위와 같은 타입 관련 제한이 엄격하기 때문에 제네릭 타입을 사용하면 타입 안정성이 올라가게 되는 것이다.
    //    return (int) s1.get ( 0 ) + (int) s1.get ( 1 ); //이것은 객체의 변경을 야기하지 않는 사용법이기 때문에 허용된다.
    //}
    /**
     * 위와 같이 add 와 같은 객체 생산 프로세스는 불가능하고 get 과 같은 객체 소비 프로세스만 가능한 것을 소비자 역할을 한다고 표현한다.
     * 와일드 카드는 자신이 붙은 타입 객체의 타입 안정성을 위해 철저하게 자신을 소비자 입장에만 세운다.
     * 이는 와일드 카드 뿐만 아니라 Custom<T> 와 같은 형태인 제네릭 클래스 및 메서드 에서도 동일하게 동작한다.
     * */

    public static void main ( String[] args ) {
        //원시 타입을 쓰면 사실상 List<Object> 이기 떄문에 어떤 타입이 값이든 들어가므로 이를 꺼내서 사용할 때 문제가 생길 수도 있다.
        System.out.println ( sumRawType ( new ArrayList ( List.of ( 1, 2, 3 ) ) ) ); //사용을 잘 한 케이스
        System.out.println ( sumRawType ( new ArrayList (List.of ( 1, 2.0, 3 ) ) ) );
        //정수의 합을 의도한 메서드인데 실수가 들어갔으므로 실패한 케이스 -> ClassCastException
    }
}
