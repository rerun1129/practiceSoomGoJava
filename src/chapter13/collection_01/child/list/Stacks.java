package chapter13.collection_01.child.list;

import java.util.Stack;

public class Stacks {
    /**
     * 스택
     * - 기본적으로 프로그래밍 언어에서 이벤트 처리 및 호출을 관리하기 위해 사용하는 자료구조
     * - 스택은 마지막에 저장한 데이터를 가장 먼저 꺼내는 LIFO(Last In First Out) 구조를 가지고 있다.
     *   - 예를 들어 탄창에 탄알을 넣고 다시 그것을 꺼낼 때는 맨 위에 것부터 꺼내야 하는 구조
     * - 스택은 메모리의 빈 공간없이 들어온 자리에서 바로 데이터가 나가기 때문에 ArrayList 기반으로 만들어지는 것이 효율적이다.
     * */

    public static void main ( String[] args ) {
        Stack <String> stack = new Stack <> ( );
        //empty - 빈 객체 여부
        System.out.println ( stack.empty ( ) );
        System.out.println ( "===================================" );
        //push - 객체에 값 추가
        stack.push ( "1" );
        stack.push ( "2" );
        stack.push ( "3" );
        stack.push ( "4" );
        stack.push ( "5" );
        //위에 push한 순서대로 통에 1,2,3,4,5 가 세로로 들어간다고 상상하면 된다
        //그러면 통 안에는 위에서 넣은 것과 반대로 5,4,3,2,1 을 세로로 세운 모양으로 값이 들어간다.
        //peek - 스택의 맨 위의 값을 반환
        System.out.println ( "===================================" );
        System.out.println ( stack.peek ( ) );
        stack.forEach ( System.out::print );
        System.out.println ( );
        //pop - 스택의 맨 위의 값을 반환(값을 꺼내서 버림)
        System.out.println ( "===================================" );
        System.out.println ( stack.pop ( ) );
        stack.forEach ( System.out::print );
        System.out.println ( );
        //search - 스택의 객체 값을 찾아서 그 위치를 반환(단, 인덱스는 1부터 시작함)
        System.out.println ( "===================================" );
        System.out.println ( stack.search ( "3" ) );
        System.out.println ( stack.search ( "5" ) ); //찾는 값이 없으면 -1
        //pop이나 peek을 할 때 꺼낼 값이 더이상 없으면 EmptyStackException 발생
        System.out.println ( "===================================" );
        stack.pop ( );
        stack.pop ( );
        stack.pop ( );
        stack.pop ( );
        stack.pop ( ); //이 지점에서 예외 발생

    }
}
