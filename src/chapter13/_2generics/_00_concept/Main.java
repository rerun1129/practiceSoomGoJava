package chapter13._2generics._00_concept;

public class Main {
    /**
     * 만약 ObjectBox를 그대로 쓴다면 ObjectBox에서 get()으로 꺼낸 객체의 타입은 과연 무엇인가?
     * 컴파일 타임에 이를 특정할 수 있는가?
     * 잘못된 타입, 즉 원하는 타입으로 강제 캐스팅이 불가능한 데이터를 set 하고 그것을 캐스팅해서 사용한다면?
     * */



    public static void main ( String[] args ) {
        ObjectBox integerBox = new ObjectBox();
        integerBox.set ( 10 );
        Integer integer = (Integer) integerBox.get(); //컴파일 타임에 특정하려면 이렇게 강제 캐스팅을 해서 타입을 일일이 명시해줘야 함

        integerBox.set("문자100"); //잘못된 타입의 인수 전달 문제, 런타임에 이를 Integer 로 get 해서 사용하면 예외가 발생한다.
                                  //개발자는 런타임에 들어오는 변수를 정수형이나 문자열로 당연히 특정해서 사용할 수 없고 억지로 사용하려면 불필요한 코드가 엄청나게 늘어난다.


    }




}
