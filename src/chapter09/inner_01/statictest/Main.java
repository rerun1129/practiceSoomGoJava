package chapter09.inner_01.statictest;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // inner_Class 객체를 저장할 리스트
        ArrayList<Object> al = new ArrayList <> ();

        for (int counter = 0; counter < 500; counter++) {
            // 내부 클래스가 static이 된다면 내부 클래스만 독자적으로 생성되므로 메모리 생성 및
            // 정리가 빨라서 비 정적 클래스의 테스트 시 보다 속도가 훨씬 빠르다
            al.add (new Outer_Class ( 100000000).getInnerObject ( ) );
            System.out.println(counter);
        }
    }
}
