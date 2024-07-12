package chapter16.streambase_01;

import java.util.List;
import java.util.stream.Stream;

public class Stream_2 {
    /**
     * 스트림의 중요한 특징
     *
     * 1. 스트림은 데이터 소스, 즉 원본 객체를 변경하지 않는다.
     *   스트림은 원본으로부터 데이터를 읽기만 하지 원본을 변경하지는 않는다.
     *   스트림에서 데이터를 정렬하거나 필터링한다고 해서 원본도 정렬되거나 필터링되지는 않는다는 뜻이다.
     *   ex) List<String> sortedList = stream.sorted().collect(toList()); -> 정렬된 결과를 새로운 List에 담아서 반환한다.
     *
     * 2. 스트림은 일회용이다.
     *   스트림은 한번 사용이 끝나면 재활용이 불가능하다. 만약 재사용이 필요하다면 스트림을 다시 생성해서 사용하는 수 밖에 없다.
     *   스트림의 재활용은 예제로 확인하도록 하자.
     *
     * 3. 스트림은 작업을 내부 반복으로 처리한다.
     *   for문 처럼 외부에 직접적으로 개발자가 로직을 하나하나 늘어놓는 것이 아니라
     *   메서드가 그 내부에 있는 반복 로직을 처리하도록 만들어져 있다.
     *   그래서 반복문의 내부 구현이 겉으로 완전하게 드러나지 않게 람다식으로 처리하는 등의 깔끔한 코드 정리가 가능하다.
     *
     * (추가) 왜 스트림을 굳이 일회용으로 만들었을까?
     *   스트림이 일회용으로 만들어진 이유는 스트림의 설계 철학과 관련이 있다.
     *   1. 불변성
     *      스트림은 위의 1번 항목에서 보았다시피 원본 객체를 변경하지 않도록 설계되어 있다. 만약 스트림을 생성할 때마다 최종 연산의 결과로
     *      원본 객체가 바뀐다면 스트림을 쓸 때마다 원본이 유의미하게 변형되었는지를 매번 체크하면서 사용해야 하는 문제가 생긴다.
     *   2. 일회용 소비
     *      스트림은 데이터 소스 - 중간 연산 - 최종 연산으로 이어지는 파이프 라인으로 동작하는데 여기서 최종 연산이 완료되면 스트림의 사용이 완전히 끝난다.
     *      스트림이 재사용 가능하다면 여러 가지 중간 연산 스트림 객체를 만들어 놓고 계속 재사용을 할텐데 이렇게 되면 중간 연산 스트림 객체를 관리하는 것도 일이 된다.
     *   3. 최적화 및 병렬 처리
     *      스트림은 내부적으로 8버전부터 지금까지 줄곧 다양한 최적화와 병렬 처리 기법을 고안해왔는데
     *      대표적으로 병렬 처리를 위해 멀티 스레딩을 하게 된 경우 재사용이 가능하다고 가정하면
     *      중간 연산 객체를 만든 후에 재사용을 해서 최종 연산을 할 때마다 처리된 값이 항상 변할 가능성이 매우 높아진다.
     *
     * 스트림의 연산
     *
     * 위에서 간단하게 소개했듯이 스트림의 연산 스테이지는 데이터 소스의 스트림 처리를 제외하면 2단계이다.
     *
     * 1. 중간 연산
     *    연산 결과가 스트림인 연산(return 타입이 Stream 이다.).
     *    따라서, 연속해서 중간 연산을 처리할 수 있다.(이건 재사용의 개념은 아니고 1회 사용 중인 개념으로 이해하면 된다.)
     *    여기서 중요한 것은 중간 연산을 호출하면 실제로 연산이 이루어지는 것이 아니고 최종 연산에서 해야할 작업을 미리 지정해준 것이라고 생각해야 한다.
     *    그래서, 중간 연산만 하게 되면 연산을 위한 CPU의 리소스 소모가 없다.
     * 2. 최종 연산
     *    연산 결과가 스트림이 아닌 연산(return 타입은 Stream이 아니거나 void인 무언가이다.).
     *    따라서, 스트림을 소모하는 것과 같은 개념이므로 소모된 스트림은 재사용이 불가능하다.
     * ex) stream.distinct().limit(5).sorted().forEach(System.out::println)
     *            중간연산    중간연산   중간연산  최종연산
     * */
    public static void main ( String[] args ) {
        //위의 예시를 실제로 쪼개서 확인해보자
        List <String> list = List.of ( "a", "b", "c", "d", "b", "a", "e", "p", "o", "g" );
        Stream <String> startStream = list.stream ( ); //스트림의 시작
        Stream <String> distinctStream = startStream.distinct ( ); //스트림 내부 값의 중복 제거(중간 연산)
        Stream <String> limitStream = distinctStream.limit ( 6 ); //스트림 결과 개수 제한(중간 연산)
        Stream <String> sortedStream = limitStream.sorted ( ); // 스트림 정렬(중간 연산)
        sortedStream.forEach ( System.out::print );//스트림 내부 값의 출력 (최종 연산, 반환 값이 void 이므로 이후에 중간 연산이나 최종 연산을 더 진행하는 것은 불가능)
        //위의 결과를 보면 중복 제거 -> 값 개수 제한 -> 정렬 순서로 중간 연산을 했기 때문에 알파벳 순으로 6개인 abcdeg 가 아닌 abcdep 가 나왔다.
        //이 결과를 바탕으로 스트림의 중간 연산의 순서도 중요하다는 것을 인지해야 한다.

        System.out.println ( );
//        sortedStream.forEach ( System.out::print ); //최종 연산이 끝난 스트림을 재사용하려고 하면 이렇게 예외가 발생한다.

        //정말 원본은 스트림 처리의 영향이 없을까?
        List <Integer> integerList = List.of ( 10, 20, 30, 40 );
        integerList.stream ()
                   .map( i -> i * 2 ) //여기서 각 값에 2를 곱해서 다음 연산을 진행시킴
                   .forEach ( System.out ::print );
        System.out.println ( );
        integerList.forEach ( System.out ::print ); //원본 값 확인
        System.out.println ( );
        //정말 무슨일이 있어도 스트림 내부 연산은 원본 컬렉션을 변경시키지 않을까?
        List <Person> personList = List.of ( new Person ( "Mike", 20 ), new Person ( "James", 25 ) );
        personList.stream ().peek ( p -> p.setAge ( 30 )  ).forEach ( System.out ::println );
        System.out.println ( "↑ 스트림 객체" );
        personList.forEach ( System.out ::println );
        System.out.println ( "↑ 원본 객체" );
        //결과를 보면 변경이 되었음을 알 수 있다.

        System.out.println ( );
        /**
         * 첫번째 예시와 두번째 예시의 차이가 생기는 이유
         *
         * 첫번째 예시는 기본형의 객체 값을 수정했기 때문에 원본의 값은 변경이 없는 것이고
         * 두번째 예시는 참조형의 객체 값을 수정했기 때문에 메모리 주소를 참조하는 참조형 객체가 모두 변경이 된 것이다.
         * 이 경우에 스트림 처리를 하면서 원본 객체를 건드리고 싶지 않다면 아래와 같이 처리하면 된다.
         * */
        List <Person> personListImmutable = List.of ( new Person ( "Mike", 20 ), new Person ( "James", 25 ) );
        personListImmutable.stream ().map ( p -> new Person ( p.getName (), 30 )  ).forEach ( System.out ::println );
        System.out.println ( "↑ 스트림 객체" );
        personListImmutable.forEach ( System.out ::println );
        System.out.println ( "↑ 원본 객체" );

    }
}
