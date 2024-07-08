package chapter13.generics_02.box.normal;

public class GenericsTypeUse {

    public static void main ( String[] args ) {
        //제네릭 타입의 일반적인 사용 방법
        FruitBox <Fruit> fruitBox = new FruitBox <Fruit> ( ); //타입이 일치하면 생성된다.
        FruitBox <Apple> appleBox = new FruitBox <Apple> ( ); //타입이 일치하면 생성된다.
        //FruitBox <Grape> grapeBox = new FruitBox <Apple> ( ); //타입이 불일치하면 컴파일 에러가 발생한다.
        //FruitBox <Fruit> fruitBox = new FruitBox <Apple> ( ); //다형성을 활용해서 자식 타입 변수 타입을 부모 타입 변수에 할당해도 컴파일 에러가 발생한다.

        appleBox.add ( new Apple () );
        //appleBox.add ( new Grape () ); //appleBox에는 Apple 타입만 넣을 수 있다.

        fruitBox.add ( new Apple () ); //인스턴스 생성 후에는 타입이 확정되어있기 때문에 다형성 활용이 가능하다.
        fruitBox.add ( new Grape () ); //인스턴스 생성 후에는 타입이 확정되어있기 때문에 다형성 활용이 가능하다.

        //만약 T 에 String 타입을 넣으면?
        FruitBox <String> stringFruitBox = new FruitBox <> ( );
        stringFruitBox.add ( "뭔가 의도와는 다르게 동작함." );
    }
}

