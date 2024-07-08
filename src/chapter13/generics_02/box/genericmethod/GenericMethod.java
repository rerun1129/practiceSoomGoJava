package chapter13.generics_02.box.genericmethod;

import chapter13.generics_02.box.extendsuse.Apple;
import chapter13.generics_02.box.extendsuse.Fruit;
import chapter13.generics_02.box.extendsuse.FruitBox;
import chapter13.generics_02.box.wildcard.Juice;

public class GenericMethod<T> {

    /**
     * 제네릭 메서드
     *
     * 메서드의 선언부에 제네릭 타입이 선언된 메서드를 말한다.
     * 와일드카드에서 보았던 sort 메서드가 제네릭 메서드이며 선언 위치는 반환 타입 바로 앞이다.
     * static <T> [ <- 이게 제네릭 타입] void sort (List<T> list, Comparator<? super T> c)
     *
     * 제네릭 메서드는 제네릭 클래스가 아닌 클래스에도 정의될 수 있다.
     *
     * 아래의 이전에 보았던 와일드 카드 메서드를 제네릭 메서드로 바꿔 볼 수가 있다.
     * */
    static Juice makeJuiceFruitWild ( FruitBox <? extends Fruit> fruitBox ) {
        return new Juice ();
    }

    static <T extends Fruit> Juice makeJuiceFruitGeneric ( FruitBox <T> fruitBox ) {
        return new Juice ();
    }
    /**
     * 그리고 이 클래스에 선언된 T 클래스 타입 변수를 보면 알겠지만 불이 들어오지 않고 있고
     * 위의 제네릭 메서드 타입 변수를 보면 불이 들어와 있다.
     * 이로 볼때 제네릭 클래스의 타입 변수와 제네릭 메서드의 타입 변수는 연관이 없고 서로 다르게 움직인다.
     * 그래서 아래와 같은 예시처럼 메서드와 클래스의 타입 변수의 타입이 서로 다르게 동작할 수 있다.
     * 간단하게 제네릭 메서드의 타입 변수는 지역 변수이고 제네릭 클래스의 타입 변수는 클래스 전역 변수라고 생각하면 된다.
     * */

    public static void main ( String[] args ) {
        GenericMethod <String> stringGenericMethod = new GenericMethod <> ( ); //'String' 으로 클래스의 타입 변수 T를 확정했다.
        stringGenericMethod.makeJuiceFruitGeneric ( new FruitBox <Apple> () );
        //메서드의 타입 변수와 클래스의 타입 변수가 달라도 문제가 없기 때문에 FruitBox의 타입 변수로 'Apple' 이 들어갈 수 있는 것이다.

        GenericMethod.<Apple>makeJuiceFruitGeneric ( new FruitBox <Apple> () );
        //그리고 이 메서드는 static 메서드이기 때문에 위와 같이 사용하는 것이 예전 방식이었으나
        //자바 7버전부터는 컴파일러가 타입 추론을 하여 제네릭 클래스 타입의 생략이 가능해졌으므로 제네릭 타입 선언은 생략하도록 변경되었다.
    }

    /**
     * 제네릭 메서드가 유용한 것은 중복되는 제네릭 타입 변수를 모아서 공통 변수처럼 뽑아낼 수 있다는 것이다.
     * */
    static Juice makeJuiceFruitComplex ( FruitBox <? extends Fruit> fruitBox1, FruitBox <? extends Fruit> fruitBox2 ) {
        return new Juice ();
    }
    //위의 코드를 아래와 같이 간결화 할 수 있다. 물론 와일드 카드의 중복 타입 매개 변수가 있는 경우에 한해서 가능하다.
    static <T extends Fruit> Juice makeJuiceFruitCompact ( FruitBox <T> fruitBox1, FruitBox <T> fruitBox2 ) {
        return new Juice ();
    }

    /**
     * 복잡한 제네릭 메서드는 어떻게 해석해야 하는지 알아보자.
     *
     * public static <T extends Comparable<? super T>> void sort(List<T> list)
     * 여기서는 파라미터 단에서 뽑아낸 제네릭 메서드 타입 변수가 복잡하게 선언되어 있다.
     *
     * 가장 복잡한 <? super T> 부터 떼어내서 해석해보면 '?는 T 자신 혹은 부모여야 한다' 이고
     * T는 타입 확정 전까지는 Object로 취급하므로 <? super Object> 가 되어
     * '?는 Object 자신 혹은 부모여야 한다' 가 되기 때문에
     *
     * "Object 자기 자신 = Object or Object의 부모 = 없음" 이므로 자연스럽게 <? super T>는 Object -> <T>로 정리가 된다.
     *
     * 그럼 다시 메서드 구조를 보면
     * public static <T extends Comparable<T>> void sort(List<T> list)
     * 어려운 부분이 간결해졌고 결국 이를 해석하면
     *
     * <T extends Comparable<T>> -> 'T는 Comparable<T> 자신 혹은 자식이어야 한다'
     * -> 인터페이스의 자식이라고 함은 인터페이스의 구현체이므로 정리하면
     * -> T는 Comparable<T>의 구현 클래스라는 뜻이 된다.
     *
     * List<T> -> 타입 T를 List의 요소로 허용한다. -> 타입 T는 제네릭 메서드 타입 변수로 추출한 <T extends Comparable<T>>이다.
     *
     * 원형 메서드로 다시 해석하면
     * public static <T extends Comparable<? super T>> void sort(List<T> list)
     * 'List<T>의 T는 Comparable을 구현한 클래스이고 T는 T 자신 또는 자신의 조상만을 허용하는 타입 변수이다.'
     * 예를 들어서 T가 Apple 이고 Fruit의 자식 클래스라면 <? super T>는 Fruit, Apple, Object 가 모두 가능하다.
     * */

}
