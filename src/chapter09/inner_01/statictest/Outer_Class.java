package chapter09.inner_01.statictest;

class Outer_Class {
    // 외부 클래스 객체의 크기를 불리기 위한 배열 변수
    private int[] data;

    // 정적 내부 클래스
    static class Inner_Class {
    }

    // 외부 클래스 생성자
    public Outer_Class(int size) {
        data = new int[size]; // 사이즈를 받아 배열 필드의 크기를 불림
    }

    // 내부 클래스 객체를 생성하여 반환하는 메소드
    Inner_Class getInnerObject() {
        return new Inner_Class ( );
    }
}
