package chapter13.collection_01.child.list;

import java.util.LinkedList;
import java.util.List;

public class LinkedLists {
    /**
     * ArrayList(배열 리스트)의 단점과 LinkedList(연결 리스트)
     *
     * 배열은 가장 기본적인 형태의 자료구조로 구조가 간단하며 사용하기 쉽고 데이터를 읽어 오는데 걸리는 시간이 가장 빠르다.
     * 하지만, 아래와 같은 단점도 존재한다.
     *
     * 1. 배열의 크기는 변경할 수 없다
     *   - 크기 변경이 불가하므로 새로운 배열을 생성해서 기존 데이터를 새로운 배열에 복사해야 한다.
     *   - 위의 단점을 극복하기 위해 메모리 공간을 초기에 크게 잡으면 불필요한 메모리 낭비가 생긴다.
     * 2. 비순차적인 데이터의 추가 또는 삭제에 시간이 많이 걸린다
     *   - 차례대로 데이터를 추가하고 마지막에서부터 데이터를 삭제하는 것은 빠르다
     *   - 하지만, 배열의 중간에 데이터를 추가하면 빈자리를 만들기 위해 다른 데이터들이 이동해야 한다.
     *   - 삭제도 마찬가지로 삭제 후에 남겨진 빈 공간을 채우는 프로세스가 동작하기 때문에 CPU가 일을 해야 한다.
     *
     * 이러한 단점들을 보완하기 위해서 나온 자료구조가 바로 연결 리스트이다.
     * [ArrayList(괄호 안은 주소)] 0x100 -> [0(0x100)][1][2][3][4] => 왼쪽처럼 배열이 연속적인 형태로 존재한다
     * [LinkedList] 0x200 -> [0x300(0x200)] -> [0x400(0x300)] -> [0x500(0x400)] -> [0x600(0x500)] -> [0x700(0x600)] [다음 요소의 주소]
     *                       [0]               [1]               [2]               [3]               [4]            [실제 데이터]
     * 기본적으로 연결 리스트는 아래 Node 클래스와 같은 구조로 이루어져 있다.
     * 자바의 연결 리스트는 아래와 같은 단일 연결 리스트가 아닌 쌍방향의 Node에 접근할 수 있는 이중 연결 리스트로 구현되어 있다.
     * */
    static class Node {
        Node next; //C언어에서는 이 Node 객체를 바로 주소를 가리키는 객체, 포인터로 부른다.
        Object obj;
    }

    public static void main ( String[] args ) {
        LinkedList <Integer> list = new LinkedList <> ( );
        list.add ( 1 );
        list.add ( 2 );
        list.add ( 3 );
        list.add ( 4 );
        list.add ( 5 );
        //element, peek - 첫번째 요소 반환
        System.out.println ( list.element ( ) );
        System.out.println ( list.peek ( ) );
        System.out.println ( "===============================================" );
        //offer - 객체를 리스트 끝에 추가
        list.offer ( 6 );
        list.forEach ( System.out::print );
        System.out.println ( );
        System.out.println ( "===============================================" );
        //poll - 첫번째 요소 반환 후 제거
        System.out.println ( list.poll ( ) );
        list.forEach ( System.out::print );
        System.out.println ( );
        list.add ( 1 );
        System.out.println ( "===============================================" );
        //remove - 첫번째 요소 제거(마지막 아님)
        System.out.println ( list.remove ( ) );
        list.forEach ( System.out::print );
        System.out.println ( );
        list.add ( 1 );
        System.out.println ( "===============================================" );
        /**
         * 위에서 언급한 추가 및 제거 메서드들에 모두 First와 Last 메서드가 추가적으로 존재하는데
         * 말 그대로 앞에 추가하거나 뒤에 추가, 혹은 앞의 요소를 가져오거나 뒤의 요소를 가져옴
         * */

    }
}
