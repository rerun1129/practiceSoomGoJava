package chapter13.generics_02.box.wildsuper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class WildSuperEx {
    public static void main(String[] args) {
        FruitBox<Apple> appleBox = new FruitBox<Apple>();
        FruitBox<Grape> grapeBox = new FruitBox<Grape>();

        appleBox.add(new Apple("GreenApple", 300));
        appleBox.add(new Apple("GreenApple", 100));
        appleBox.add(new Apple("GreenApple", 200));

        grapeBox.add(new Grape("GreenGrape", 400));
        grapeBox.add(new Grape("GreenGrape", 300));
        grapeBox.add(new Grape("GreenGrape", 200));

        Collections.sort(appleBox.getList(), new AppleComp());//각자의 타입 매개변수의 Comparator로 동작함
        Collections.sort(grapeBox.getList(), new GrapeComp());//각자의 타입 매개변수의 Comparator로 동작함
        System.out.println(appleBox); //구분을 위해 내림차순 정렬
        System.out.println(grapeBox);
        System.out.println();
        Collections.sort(appleBox.getList(), new FruitComp());//동일한 타입 매개변수의 Comparator로 동작함
        Collections.sort(grapeBox.getList(), new FruitComp());//동일한 타입 매개변수의 Comparator로 동작함
        System.out.println(appleBox); //구분을 위해 오름차순 정렬
        System.out.println(grapeBox);
    }
}

class Fruit	{
    String name;
    int weight;

    Fruit(String name, int weight) {
        this.name   = name;
        this.weight = weight;
    }

    public String toString() { return name+"("+weight+")";}

}

class Apple extends Fruit {
    Apple(String name, int weight) {
        super(name, weight);
    }
}

class Grape extends Fruit {
    Grape(String name, int weight) {
        super(name, weight);
    }
}

/**
 * 이 예제는 정렬을 사용하기 위해서 appleBox와 grapeBox를 무게 순으로 정렬하도록 만들었다.
 * Collections.sort()를 찾아가 보면 선언부가 이렇게 되어있다.
 * static <T> void sort (List<T> list, Comparator<? super T> c)
 * 메서드 좌측의 T는 메서드 내부에서 사용할 타입 변수가 선언되어 있으며 이 내용은 다음 패키지에서 다룬다.
 * 여기서는 두 번째 매개변수인 Comparator를 봐야하는데 여기에는 super 제한이 걸려있다.
 *
 * 그런데 아래 AppleComp와 GrapeComp를 보면 각 Fruit의 자식 타입을 정렬하기 위해서 Comparator 를 구현했는데
 * Comparator 의 제네릭 타입만 제외하면 매우 유사한 코드이다.
 * 이러한 중복을 막기 위해서 Comparator<? super T> 와 같이 sort가 만들어져 있는데
 * 위의 메서드 선언부에 Apple이 대입되면
 * static void sort (List<Apple> list, Comparator<? super Apple> c)
 * 이기 때문에 Comparator<? super Apple>의 타입 매개변수 자리에는
 *  1. Apple 자신
 *  2. Apple의 부모 타입인 Fruit
 *  3. 모든 클래스의 부모인 Object
 *  이렇게 들어갈 수 있다. 모두 자신 혹은 자신의 부모 클래스 들이다.
 *  이해가 어려울 수 있으니 다시 Grape를 대입해보면
 * static void sort (List<Grape> list, Comparator<? super Grape> c)
 * Comparator<? super Grape>의 타입 매개변수 자리에는
 *  1. Grape 자신
 *  2. Grape의 부모 타입인 Fruit
 *  3. 모든 클래스의 부모인 Object
 *
 *  공통 조상인 Object를 제외하면 Apple과 Grape의 부모인 Fruit가 공통적으로 들어가게 된다.
 *  그렇기 때문에 Comparator 자리에 FruitComp 만 들어가도 <Fruit super Apple or Grape>
 *  가 성립하므로 컴파일 시에 아무런 문제가 없이 동작하게 된다.
 *  <? super T> 내부는 '?는 T의 부모 혹은 자기 자신의 타입이다.' 라고 해석하도록 하자.
 *
 * */
class AppleComp implements Comparator <Apple> {
    public int compare(Apple t1, Apple t2) {
        return t2.weight - t1.weight;
    }
}

class GrapeComp implements Comparator<Grape> {
    public int compare(Grape t1, Grape t2) {
        return t2.weight - t1.weight;
    }
}

class FruitComp implements Comparator<Fruit> {
    public int compare(Fruit t1, Fruit t2) {
        return t1.weight - t2.weight;
    }
}



class FruitBox<T extends Fruit> extends Box<T> {}

class Box<T> {
    ArrayList <T> list = new ArrayList<T>();

    void add(T item) {
        list.add(item);
    }

    T get(int i) {
        return list.get(i);
    }

    ArrayList<T> getList() { return list; }

    int size() {
        return list.size();
    }

    public String toString() {
        return list.toString();
    }
}
