package chapter16._3optional;

import java.util.*;
import java.util.stream.IntStream;

public class Optionals {
    /**
     * Optional<T>란?
     *
     * 자바에는 유구한 역사를 가진 예외인 NullPointerException 이라는 예외가 있다.
     * 전세계 자바 개발자라면 모두 한번 쯤은 경험해봤을 런타임 예외인데 만들어진 의도 자체는 개발자들이
     * null을 참조하는 것을 조기에 발견할 수 있도록 만든 것인데 이 예외로 인해서 정말 많은 서비스들이
     * 예기치 못한 장애를 겪는 일이 많아졌다.
     *
     * 얼마나 장애가 많았냐면 NPE를 처음 만든 토니 호어가 '10억 불짜리 실수'(billion dollar mistake)였다고 회고한 적이 있다.
     * 그래서 최신 언어들은 모두 이 NPE 를 개발자들에게 인지만 시키고 실제로 서비스가 죽어버리는 현상은 제외시키는 추세인데
     * 자바도 이에 따른 문제들을 잘 알고 있었기 때문에 도입한 것이 객체 랩핑 클래스인 Optional 이다.
     *
     * 여기서 Optional 을 언급하는 이유는 자바 8의 중요한 변화는 람다, 스트림 그리고 Optional 이라고 해도 과언이 아니기 때문이다.
     * (자바 8은 거의 대격변과 같은 변경 사항을 가져온 LTS 버전이다)
     * 따라서, 스트림도 Optional 을 적극 채용하여 스트림의 최종 연산의 반환 값이 Optional 인 경우가 종종 있으므로 여기에서 보도록 하는 것이다.
     *
     * Optional 사용법
     *
     * 1. Optional 은 제네릭 클래스이기 때문에 Optional<T> 로 사용한다.
     * 2. Optional 객체 생성은 정적 팩토리 메서드인 of(), ofNullable() 로 생성한다.
     *    2-1. of()에 담기는 값이 null일 가능성이 있다면 of() 대신 ofNullable()을 사용해야 한다.
     *         단어의 의미 Nullable을 잘 생각해보자.
     * 3. Optional 의 초기화는 empty()로 하는 것이 좋다. Optional<String> optVal = null; 보다는 Optional.empty(); 가 Optional 의 의도에 맞다.
     * 4. Optional 의 객체 값 추출 메서드
     *    4-1. get()
     *        정말 단순하게 객체내부의 값을 가져온다. 만약 객체 내부의 값이 null 이라면 NPE 대신에 NoSuchElementException 을 발생시킨다.
     *    4-2. orElse(), orElseGet(), orElseThrow()
     *        위와 같이 NoSuchElementException 이 발생하면 곤란하니 이에 대처하기 위한 두 가지 방법을 마련해두었다. 그 중 하나가 위의 메서드들이다.
     *        위의 메서드들은 객체 내부의 값을 가져오되 만약 객체 내부에 값이 null 이라면 대신하여 할 동작을 정의한다.
     *        orElse 는 값이 null 이라면 대신할 값을 파라미터로 담아두었다가 반환해주고,
     *        orElseGet은 orElse와 비슷하지만 직접적인 값 대신에 값을 공급해주는 Supplier 람다식을 파라미터로 넘겨줘야 한다.
     *        orElseThrow는 값이 null일 때 파라미터로 넘긴 예외가 발생하게 하는 것이다. 기본 예외는 NoSuchElementException 이지만 개발자의 의도에 따라서
     *        다른 예외를 발생시킬 수도 있다.
     *    4-3. isPresent(), ifPresent(), ifPresentOrElse()
     *        NoSuchElementException 발생 시 대처하기 위한 나머지 하나의 방법이 바로 값이 존재하는지 체크하는 것이다.
     *        isPresent는 boolean 값을 반환하며 값이 null 이면 false, 있다면 true 를 반환한다.
     *        ifPresent 는 값이 있다면 어떠한 동작을 하는 Consumer 를 파라미터로 넘겨서 동작하게 하고 값이 null 이라면 아무것도 하지 않도록 한다.
     *        ifPresentOrElse 는 ifPresent 와 orElseGet 을 합친 것으로 값이 존재하는 경우의 동작을 첫 번째 파라미터인 consumer 가 담당하고
     *        값이 null 인 경우의 동작을 두 번째 파라미터인 Runnable 이 담당한다.(Runnable 은 스레드 파트에서 간략하게 설명한 바가 있다.)
     *        그 두 파라미터의 구현부가 각각의 상황에서 어떠한 동작을 할지 정의한다.
     *
     * 5. 기본형 스트림과 함께 사용하는 OptionalInt, OptionalLong, OptionalDouble
     *    IntStream, LongStream 등으로 스트림 연산을 실행한 결과가 Optional 로 나올때 사용하는 특수한 기본형의 Optional 객체이다.
     * */
    public static void main ( String[] args ) {
        //메서드 사용 예시
        //Optional <Object> nullOpt = Optional.of ( null ); //이렇게 값을 담아둔 것 만으로도 내부에서 Optional 객체를 만들 때 파라미터를 참조하므로 NPE가 발생한다.
        Optional <Object> nullOptNullable = Optional.ofNullable ( null ); //ofNullable은 null 에 대한 예외 처리를 한 객체이기 때문에 선언만으로 NPE가 발생하지는 않는다.
        Optional <Object> emptyOpt = Optional.empty ( ); //만약 정말 초기화의 의미가 담긴 Optional 객체라면 이렇게 정의하는게 좋다. 사실상 내부에 null 이 담겨 있는 것과 다름 없는 객체다.
        Optional <String> presentOpt = Optional.of ( "Hi There!" ); //만약 정말 초기화의 의미가 담긴 Optional 객체라면 이렇게 정의하는게 좋다. 사실상 내부에 null 이 담겨 있는 것과 다름 없는 객체다.


        //get

        //System.out.println ( nullOptNullable.get ( ) ); //값을 가져온다. 하지만 참조한 Optional 객체가 null을 담고 있기 때문에 NoSuchElementException 이 발생한다.
        System.out.print ( presentOpt.get ( ) );
        System.out.print ( " -> get : null 이 아니라면 정상적으로 값을 가져온다.\n" );
        System.out.println ( "===========================================" );

        //orElse, orElseGet, orElseThrow

        //위의 null 값을 가진 객체를 위의 메서드 들을 이용해서 처리해보자
        System.out.print ( nullOptNullable.orElse ( "null 이 안나오도록 처리함" ) );
        System.out.print ( " -> orElse : null이 담긴 객체\n" );
        System.out.print ( presentOpt.orElse ( "null 이 안나오도록 처리함" ) );
        System.out.print ( " -> orElse : 값이 담겨있는 객체\n" );
        System.out.println ( "===========================================" );

        System.out.print ( nullOptNullable.orElseGet ( () -> "null 이 안나오도록 처리함" ) );
        System.out.print ( " -> orElseGet : null이 담긴 객체\n" );
        //위와 같은 동작을 람다식으로 표현함. Supplier 함수 이기 때문에 파라미터가 넘어오는 것은 없고 공급하는 부분만 있다.
        //Supplier 일 수 밖에 없는 이유는 애초에 null 일 경우의 동작이므로 파라미터가 넘어와봤자 null 인 것을 참조하면 오히려 피하려 했던 NPE가 발생하게 된다.
        System.out.println ( "===========================================" );

        //일반적으로 값이 없다면 NoSuchElementException 이 발생하지만 여기서는 우리가 만든 특수한 예외를 던지도록 해보겠다.
        //nullOptNullable.orElseThrow ( () -> new WrongOptionalDeclareException ( "잘못된 Optional 선언" ) );
        System.out.println ( "===========================================" );


        //isPresent, ifPresent, ifPresentOrElse

        //null 체크 없이 Optional 객체에 get() 을 호출하면 노란색 경고가 발생하는데 isPresent 검사 없는 호출이라고 한다.
        //그래서 값 검사를 해서 값을 가져오도록 해보겠다.
        if(nullOptNullable.isPresent ()){
            System.out.print ( nullOptNullable.get ( ) ); //항상 값이 null 이므로 도달하지 못하는 구문
        }
        if(presentOpt.isPresent ()){
            System.out.print ( presentOpt.get ( ) );
            System.out.print ( " isPresent : -> 항상 값이 있으므로 도달하는 구문\n" );
        }
        System.out.println ( "===========================================" );

        //ifPresent 는 값이 존재할 때 동작을 정의함
        nullOptNullable.ifPresent ( System.out::print );
        System.out.print ( " -> ifPresent : 값이 없으므로 내부 객체 값 출력 불가\n" );
        presentOpt.ifPresent ( System.out::print );
        System.out.print ( " -> ifPresent : 값이 있으므로 내부 객체 값 출력 가능\n" );
        System.out.println ( "===========================================" );

        //ifPresentOrElse 는 값의 존재와 부존재 모두의 동작을 정의할 수 있음
        nullOptNullable.ifPresentOrElse ( System.out::print, () -> System.out.print ( "값이 없습니다!" ) );
        System.out.print ( " -> ifPresentOrElse : 두 파라미터 중 값이 없는 객체를 참조했으므로 후자 출력\n" );
        presentOpt.ifPresentOrElse ( System.out::print, () -> System.out.print ( "값이 없습니다!" ) );
        System.out.print ( " -> ifPresentOrElse : 두 파라미터 중 값이 있는 객체를 참조했으므로 전자 출력\n" );
        System.out.println ( "===========================================" );

        //기본형 스트림과 사용하는 OptionalInt(대표 예제)
        OptionalInt optionalInt = IntStream.of ( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ).findAny ( );
        //조건에 맞는 것을 바로 찾아오는 메서드, 나중에 최종 연산에서 다룬다. Optional 을 리턴함. 이 예제에서는 무조건 1을 가져온다.
        System.out.println ( optionalInt.getAsInt ( ) ); //기본형의 Optional 은 get 이 아닌 getAs기본형타입 으로 메서드가 존재한다.
        System.out.println ( "===========================================" );

        //Optional 을 사용하는 null 처리와 그렇지 않은 null 처리(실행 시 마다 객체에 반환되는 값이 null 이거나 아니거나 함)
        String stringNullOrNot = stringNullOrPresentReturn ( );
        if( stringNullOrNot != null) {
            System.out.println ( stringNullOrNot );
        }

        Optional.ofNullable ( stringNullOrNot ).ifPresent ( System.out::println );
        //3줄 짜리 if 분기문이 하나로 줄어들었으며 가독성이 좋아지고 사용 가능한 자바 공통 처리 메서드가 많아졌다.

    }

    public static String stringNullOrPresentReturn(){
        return (int) ((Math.random() * 2) + 1) == 1 ? null : "짜잔!";
    }
}
