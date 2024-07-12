package chapter16.streambase_01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Streams {
    /**
     * 스트림(stream)
     *
     * 자바 8버전 이전에는 어떠한 컬렉션이나 배열을 순회하기 위해서는 for문을 사용해서 코드를 작성했다.
     * 하지만 이러한 코드는 가독성이 떨어지고 사람이 읽기에 장황하다는 단점이 있다.
     * 또한, 어디까지 함수로 추출해야 하는지를 고민하게 되기 때문에
     * 함수로 추출하여 함수형으로 코드를 짜는 것을 포기하게 되고 자연스럽게 코드에 대한 재사용성도 떨어지게 된다.
     *
     * 그리고 컬렉션과 배열에 대한 처리 방식의 차이도 있다. 사실상 컬렉션과 배열은 순회 객체라는 공통점이 있는데
     * 이에 대한 처리 메서드는 완전히 동일한 기능의 Collection.sort()와 Arrays.sort() 로 나누어져 있다.
     *
     * 이러한 문제점을 해결하기 위해서 만들어진 것이 스트림이며 람다와 함께 자바 8버전의 중요한 변경 사항 중 하나이다.
     * 스트림의 중요한 특징은 데이터 소스가 컬렉션이건 배열이건 상관없이 같은 방식으로 데이터를 처리할 수 있다는 것이며,
     * 그 데이터 소스를 처리하는데 자주 사용되는 메서드를 사람이 읽기 쉬운 형태로 정리해 둔 것이다.
     *
     * 스트림을 이용하면 배열, 컬렉션 뿐만 아니라 파일에 저장된 순회 객체도 꺼내서 동일한 기준으로 처리할 수 있게 된다.
     *
     * */
    public static void main ( String[] args ) {
        //스트림의 사용 예시
        //배열의 스트림 화
        String[] strings = {"A", "B", "C"};
        Stream <String> arrayToStream = Arrays.stream ( strings );
        //배열은 가장 기본적은 객체의 형태 중 하나이기 때문에 스트림을 바로 열 수는 없고 Arrays에서 제공하는 메서드로 스트림화 시켜야 한다.

        //컬렉션의 스트림 화
        List <String> list = List.of ( "A", "B", "C" );
        Stream <String> listToStream = list.stream ( );
        //list는 stream이 사용하기 적절하게 만들어진 객체이기 때문에 바로 컬렉션이 가진 stream 메서드로 스트림을 열 수 있다.

        //만약 일반적인 for 문으로 컬렉션에 있는 값들 중에 B를 제외하고 모두 출력한다면?
        for(String s : list){
            if(!s.equals ( "B" )){
                System.out.println ( s );
            }
        }//간단한 기능을 처리하는데 여러 줄의 코드가 필요하고 그만큼 가독성이 떨어진다.

        //이것을 스트림으로 처리한다면?
        listToStream.filter ( s -> !"B".equals ( s ) ).forEach ( System.out::println );
        //filter라는 메서드와 forEach라는 메서드가 동작하는 방식만 파악하면 가독성 좋은 1줄짜리 문장이 된다.
    }
}
