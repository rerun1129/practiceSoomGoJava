package chapter09.inner_01.nonstatictest;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // inner_Class 객체를 저장할 리스트
        ArrayList<Object> al = new ArrayList <> ();

        for (int counter = 0; counter < 50; counter++) {
            // inner_Class 객체를 생성하기 위해 Outer_Class를 초기화하고
            // 메서드를 호출하여 리스트에 넣는다.
            // 이때 Outer_Class 객체는 메소드 호출용으로 일회용으로 사용되고
            // 버려지기 때문에 GC 대상이 되어야 한다.
            al.add(new Outer_Class(100000000).getInnerObject());
            System.out.println(counter);
        }
    }
}
