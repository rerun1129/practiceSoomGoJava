package chapter13.generics_02.box.extendsuse_02;

import java.util.ArrayList;
import java.util.List;

public class StrictUse {

    public static void main ( String[] args ) {
        FruitBox <Fruit> fruitBox = new FruitBox <> ( ); //Fruit 를 상속 또는 구현해야 하기 때문에 Fruit 자신 타입의 선언도 가능
        FruitBox <Apple> appleBox = new FruitBox <> ( ); //Fruit 의 자식인 Apple 선언 가능
//        FruitBox <String> stringBox = new FruitBox <> ( ); //Fruit 의 자식이 아닌 String 타입은 선언 불가능
    }
}

