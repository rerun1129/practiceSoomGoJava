package chapter13.generics_02.box.normal_01;

import java.util.ArrayList;

public class FruitBox <T>{
    /**
     * 아래와 같이 정해지지 않은 타입은 T로 모두 통일해서 추후에 인스턴스 생성 시점에 타입을 확정해주기만 하면 된다.
     * */
    ArrayList <T> fruits = new ArrayList<>();

    void add(T fruit){ fruits.add(fruit); }
    T get(int i){ return fruits.get(i); }
    ArrayList<T> getList(){ return fruits; }
    int size(T fruit){ return fruits.size(); }
}
