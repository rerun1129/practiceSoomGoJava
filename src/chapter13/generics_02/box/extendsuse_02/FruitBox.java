package chapter13.generics_02.box.extendsuse_02;

import chapter13.generics_02.box.Box;

import java.util.ArrayList;

public class FruitBox /*<T extends Fruit & Eatable>*/ <T extends Fruit> extends Box <T> { //이렇게 Box의 타입 변수 T를 상속할 수도 있다.
    /**
     * 제네릭 선언부 내부의 extends는 T 타입의 선언 범위를 좁힌다. 우리의 의도는 Fruit 타입만 FruitBox에 들어오길 바라므로
     * 'T는 Fruit 타입의 자식' 임을 나타내는 extends 키워드를 사용해준다.
     * 추후에 대입 될 값을 넣어보면 Apple extends Fruit 처럼 Apple 은 Fruit 를 확장해서 사용하는 것이니
     * T는 apple 을 받을 수 있다고 해석할 수 있다.
     *
     * 만약 클래스를 상속하는 것이 아니라 인터페이스를 구현해야 하는 것일 때도 implement가 아닌 extends로 선언한다.
     *
     * 만약에 두 개 이상의 인터페이스나 클래스를 상속 및 구현받아야 하는 클래스라면
     * <T extends Fruit & Eatable> 과 같이 &로 연결해서 선언할 수도 있다.
     * */
    ArrayList <T> fruits = new ArrayList<>();

    void add(T fruit){ fruits.add(fruit); }
    T get(int i){ return fruits.get(i); }
    ArrayList<T> getList(){ return fruits; }
    int size(T fruit){ return fruits.size(); }

    public ArrayList <T> getFruits ( ) {
        return fruits;
    }
}
