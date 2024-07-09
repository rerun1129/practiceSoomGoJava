package chapter13.generics_02.box.wildcard_03;

import chapter13.generics_02.box.extendsuse_02.Fruit;
import chapter13.generics_02.box.extendsuse_02.FruitBox;

public class JuicerWild {
    /**
     * 와일드 카드의 사용법
     * <? extends T> -> 와일드 카드의 상한 제한, T와 그 자손들만 가능
     * <? super T> -> 와일드 카드의 하한 제한, T와 그 조상들만 가능
     * <?> -> 제한 없음. 모든 타입이 가능. <? extends Object>와 동일
     *
     * 아래와 같이 와일드 카드를 사용하면 이와 같은 환경에서 T 타입 변수 없이 제네릭 타입의 상한과 하한을 활용할 수 있게 된다.
     *
     * */
    static Juice makeJuiceFruit ( FruitBox <? extends Fruit> fruitBox ) { //Fruit 타입만 매개변수로 들어올 수 있다.
        return new Juice ();
    }

    static Juice makeJuiceAll ( FruitBox <? extends Object> fruitBox ) { //모든 타입이 매개변수로 들어올 수 있다.
        /**
         * <?>도 동일한 의미를 가지고 동작한다.
         * 만약 fruitBox 내부의 List 가 Fruit 와 그 자식 타입 변수만 담고 있다면 여기서 문제가 없지만
         * Fruit 및 자식 타입 이외의 타입 데이터가 들어올 수 있으므로 (여기서 FruitBox는 Object 하위 타입 모두를 담을 수 있음)
         * 캐스팅 예외가 발생할 수 있다. 위와 같은 와일드 카드 선언을 컴파일 시에 체크하지 않는 이유는 Object 가 Fruit의 공통 조상이기
         * 때문이며 위의 <? extends Object> 를 <? extends String> 으로 바꾸면 컴파일 에러가 발생한다.
         * */
        for ( Fruit f : fruitBox.getFruits ()) {
            System.out.println ( f.toString () ); //만약 여기서 타입 캐스팅이 실패하면 예외가 발생한다.
        }
        return new Juice ();
    }

}
