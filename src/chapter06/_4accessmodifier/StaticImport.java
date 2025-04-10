package chapter06._4accessmodifier;

import java.util.Arrays;
import java.util.List;

import static java.util.List.of;

class StaticImport {
    public static void main ( String[] args ) {
        List <Object> objects = Arrays.asList ( ); //일반 정적 메소드 호출
        List <Object> of = of ( );//정적 임포트 메서드 호출
    }
}
