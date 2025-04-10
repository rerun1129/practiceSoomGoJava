package chapter13._2generics._01_box._06_casting;

import chapter13._2generics._01_box.Box;
import chapter13._2generics._01_box._02_extendsuse.Apple;
import chapter13._2generics._01_box._02_extendsuse.Fruit;
import chapter13._2generics._01_box._02_extendsuse.FruitBox;
import chapter13._2generics._01_box._02_extendsuse.Grape;

public class CastingGenerics {

    /**
     * 제네릭 타입 간의 형변환
     *
     * 1. 제네릭 타입과 원시 타입 간의 형변환 -> 가능(경고 발생)
     * 2. Object 타입을 다른 타입으로 형변환 -> 불가능(일반적으로 타입 매개변수에 다형성은 적용되지 않는다)
     * 3. 일반 제네릭 타입을 와일드 카드 타입으로 형변환 -> 가능(와일드 카드를 적용하면 타입 매개변수에 다형성이 적용된다)
     * 4. 와일드 카드 타입을 일반 제네릭 타입으로 형변환 -> 가능(하지만 넓게 잡은 개념을 좁게 변환하는 것이기 때문에 경고가 발생)
     * */

    public static void main ( String[] args ) {
        //1번 예시
        Box box = null;
        Box<Object> objBox = null;
        box = (Box)objBox;
        objBox = (Box<Object>)box; //확인되지 않은 형 변환(어떤 타입이 들어있을지 알 수 없다는 뜻)

        //2번 예시
        Box<Object> objBox2 = null;
        Box<String> stringBox = null;
        //objBox2 = (Box<Object>)stringBox; // 컴파일 에러
        //stringBox = (Box<String>)objBox2; // 컴파일 에러

        //3번 예시
        FruitBox<? extends Fruit> wildBox = new FruitBox <Apple> (); //다형성 활용 가능
        FruitBox<? extends Fruit> wildBox2 = new FruitBox <Grape> (); //다형성 활용 가능

        //4번 예시
        FruitBox<? extends Fruit> wildBox3 = null;
        FruitBox<Apple> appleBox = (FruitBox<Apple>) wildBox3; //wildBox3에 Apple 객체 말고 Grape가 들어있을 수도 있으니 경고

        //종합 예시 (Box<Object> -> Box<?> -> Box<Fruit>)
        Box<Object> box2 = new Box <Object> ();
        //Box<Object> -> Box<?>로 변환
        Box<?> boxWild = box2;
        //Box<?> -> Box<Fruit>로 변환
        Box<Fruit> boxFruit = (Box<Fruit>)boxWild;

    }
}
