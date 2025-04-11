package chapter07._5promotion_casting.casting;

import chapter07._5promotion_casting.Animal;
import chapter07._5promotion_casting.Cat;
import chapter07._5promotion_casting.Dog;
import chapter07._5promotion_casting.Fish;

import java.util.HashMap;
import java.util.Map;

import static chapter07._5promotion_casting.casting.Feed.*;

public class Casting {
    public static void main ( String[] args ) {
        /**
         * 가장 흔한 캐스팅(강제 형변환)의 사례
         * */

        Map <String, Object> multiCage = new HashMap <> ( );
        multiCage.put ( "까망이", new Cat ( "고양이" ) );
        multiCage.put ( "돌순이", new Dog ( "강아지" ) );
        multiCage.put ( "뻐끔이", new Fish ( "금붕어" ) );
        multiCage.put ( "???", new Animal ( "정체불명의 생물" ) );

        //Map 은 값을 꺼낼 키로 뭐가 나올 지 미리 예상하고 만들 수 없기 때문에 값을 꺼낼 때 모든 타입으로 변환될 수 있도록
        //모든 클래스의 부모 클래스인 Object 타입으로 리턴한다.
        Object black = multiCage.get ( "까망이" );
        Object stonee = multiCage.get ( "돌순이" );
        Object bulpee = multiCage.get ( "뻐끔이" );
        Object unknown = multiCage.get ( "???" );
//        stonee.walk(); //Dog 타입에 있는 메서드이나 사용할 수 없다. Object 는 자식 클래스인 Dog 클래스의 정보를 가지고 있지 않기 때문이다.

        ((Dog)stonee).walk ( (Dog) stonee );//사용하려면 이렇게 강제로 타입을 다운 캐스팅해줘야 한다.


        /**
         * instanceof의 사용 예 -> Feeder 타입의 feed 메서드 같이 보기
         * */
        Feeder feeder = new Feeder ( );
        feeder.feed ( (Animal) black, CAT_FOOD );
        feeder.feed ( (Animal) bulpee, FISH_FOOD );
        feeder.feed ( (Animal) stonee, DOG_FOOD );
        feeder.feed ( (Animal) unknown, DOG_FOOD );
    }
}
