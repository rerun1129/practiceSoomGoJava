package chapter13.generics_02.box;

public class BoxUse {
    /**
     * 제네릭스 클래스를 사용할 때는 아래와 같이 사용한다.
     * */
    public static void main ( String[] args ) {
        Box<String> stringBox = new Box <String> ();
        //컴파일러가 인스턴스의 타입 변수로 생성자의 타입 변수를 추론할 수 있으므로 생성자의 타입 변수는 생략이 가능하다.
        stringBox.setItem ( "문자열 입니다." );
//        stringBox.setItem ( 10 ); //타입 체크를 통한 컴파일 에러 발생
        String item = stringBox.getItem ( );
        //T 타입을 미리 -> String 으로 인스턴스 생성 시에 선언해두었으므로 타입 체크 및 캐스팅이 필요 없다.
        System.out.println ( item );
    }
}
