package chapter09.Anonymous_02;

import java.util.HashMap;
import java.util.Map;

public class PureFunction {
    public static void main ( String[] args ) {
        int baseNum = 10;
        Functional functionalAnonymous = new Functional ( ) {
            int baseNum2 = 10;
            //이 자체를 구현이 완료된 것으로 보아 인터페이스 임에도 불구하고 new가 가능함
            @Override
            public void func ( String str ) {
                System.out.println ( str );
//                baseNum++; //여기는 PureFunction 과 엄밀히 다른 내부 클래스 블록이기 때문에 외부 클래스의 값 변경은 불가능하다.
                baseNum2++; //내부 클래스 내부에서 선언된 변수이기 때문에 접근 및 값 변경이 당연히 가능하다
            }
        };

        Map <String, Integer> baseNumMap =  new HashMap <> (Map.of ( "baseNum", baseNum ));
        Functional functionalAnonymous2 = new Functional ( ) {

            //이 자체를 구현이 완료된 것으로 보아 인터페이스 임에도 불구하고 new가 가능함
            @Override
            public void func ( String str ) {
                System.out.println ( str );
                //값을 바꿀 수 있는 방법
                Integer baseNumByMap = baseNumMap.get ( "baseNum" );
                baseNumMap.put ( "baseNum", baseNumByMap++ ); //이렇게 하면 외부 값을 변경해서 내보낼 수 있게 된다.
                //하지만 위와 같이 변경하는 것은 순수 함수 프로그래밍에서 권고하는 바가 아니며 값의 변경을 확실히 알 수가 없기 때문에 지양해야 한다.
            }
        };
    }
    /**
     * 위와 같은 경우를 바로 순수 함수 프로그래밍이라고 하는데
     * 순수 함수 프로그래밍이라 함은 외부에서 들어온 값이나 파라미터를 함수 내부에서 바꾸지 않아야 한다는 것인데
     * 물론 바꾸는 것이 불가능하지는 않지만 외부의 값을 내부에서 변경하는 것은 예기치 못한 부작용을
     * 야기시킬 가능성이 있기 때문에 특히 유지보수나 협업시에는 주의해야한다.
     * */

    /**
     * 또한 익명 클래스 내부나 람다식 내부에서는 모든 외부 클래스의 변수가 final이나 유사 final이어야 한다고 하는데
     * 순수 함수 프로그래밍의 특성 상 함수 내부에서는 외부 변수를 변경해서는 안되기 때문에
     * 당연히 외부 변수는 익명 클래스 내부로 값이 들어온 시점을 기준으로 final 취급을 받아야 하고 값이 변경되어서는 안되는 것이다.
     * 의미상 baseNum 을 익명 클래스 내부에서 사용할 때 baseNum 대신에 상수인 10을 써도 의미나 동작이 전혀 달라질 게 없다.
     * */
}
