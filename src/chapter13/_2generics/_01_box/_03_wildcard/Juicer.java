package chapter13._2generics._01_box._03_wildcard;

import chapter13._2generics._01_box._02_extendsuse.Fruit;
import chapter13._2generics._01_box._02_extendsuse.FruitBox;

public class Juicer {
    /**
     * 아래와 같은 메서드가 있고 FruitBox의 타입에 T를 넣어서 인스턴스 생성 시점에 타입을 확정하고 싶다면 어떻게 해야 할까?
     * 일단 Juicer가 제네릭 클래스가 아니고 제네릭 클래스라고 해도 static 멤버에는 타입 변수를 사용할 수 없다.
     *
     * 아래와 같이 FruitBox의 타입을 Fruit로 고정해두면 FruitBox<Apple> 은 타입이 맞지 않아 에러가 발생한다. (아래 코드 참조)
     * 이 때 사용하기 위한 것이 바로 와일드 카드 ? 이다.
     * */
    static Juice makeJuice ( FruitBox<Fruit> fruitBox ) {
        return new Juice ();
    }

    /**
     * 그렇다고 아래 처럼 오버로딩하면 컴파일 에러가 발생한다.
     * 이전에도 배웠듯이 메서드의 시그니처는 반환 타입, 메서드 명, 매개변수의 타입 및 위치, 갯수 등으로 구별이 되어
     * 오버로딩이 되는데 타입 변수의 타입이 다른 것은 구분점이 되지 않으므로 오버로딩이 성립하지 않는다.
     * */
//    static Juice makeJuice ( FruitBox<Apple> fruitBox ) {
//        return new Juice ();
//    }

    public static void main ( String[] args ) {
        //makeJuice ( new FruitBox <Apple> () );
        //일반 매개변수의 타입과는 달리 타입 변수는 상속 여부와는 상관없이 타입이 일치해야 된다.
    }
}
