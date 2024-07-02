package chapter13.collection_01.child.list;

import java.util.PriorityQueue;
import java.util.Queue;

public class Queues {
    /**
     * 큐
     * - 큐는 처음에 저장한 데이터를 가장 먼저 꺼내는 FIFO(First In First Out) 구조를 가지고 있다.
     *   - 큐는 파이프에 어떤 물체를 넣으면서 계속 밀어내면 가장 먼저 넣은 물체가 반대편으로 가장 먼저 나오는 것을 상상하면 된다.
     * - 큐는 데이터를 꺼낼 때 단순 배열로 처리되어 있다면 배열의 1번지에 있다가 다시 1번지, 2번지 이런식으로 처음 들어간 값이
     *   새로 들어온 값을 위해서 계속 위치를 이동해야 하기 때문에 불필요한 데이터 복사가 자주 일어나게 되므로 ArrayList 보다는
     *   LinkedList로 구현되는 것이 효율적이다.
     * - 스택과 달리 큐는 인터페이스로 구현되어 있으며 일반적인 큐의 동작 및 구현은 LinkedList를 따른다.
     * - 큐의 다른 종류로는 우선순위 큐(PriorityQueue)와 디큐 혹은 덱(Deque)이라 부르는 것의 구현체인 ArrayDeque로 이루어져 있다.
     *   - 우선순위 큐는 저장한 순서에 관계없이 우선순위가 높은 것부터 꺼내게 되어있다. 그리고 null을 저장할 수 없으며 저장하면 NPE가 발생한다.
     *     우선순위 큐의 요소는 heap 이라는 자료 구조로 저장이 되며 메모리 구조의 heap과는 다른 개념이다.
     *   - 디큐는 LinkedList 부분을 참고하면 된다.
     * */

    public static void main ( String[] args ) {
        /**
         * 우선순위 큐
         * */
        Queue <Integer> priorityQueue = new PriorityQueue <> ( );
        //add - 객체에 값 추가(저장 공간이 부족하면 IllegalStateException)
        priorityQueue.add ( 1 );
        priorityQueue.add ( 3 );
        priorityQueue.add ( 2 );
        priorityQueue.add ( 5 );
        priorityQueue.add ( 4 );
        //element - 큐의 마지막 값을 반환(큐가 비어있으면 NoSuchElementException)
        System.out.println ( "===================================" );
        System.out.println ( priorityQueue.element ( ) );
        priorityQueue.forEach ( System.out::print ); //값을 찍어보면 우선순위대로 출력되지는 않음
        System.out.println ( );
        //poll - 큐의 마지막 값을 반환(이 메서드만 값을 꺼내서 버림)
        System.out.println ( "===================================" );
        System.out.println ( priorityQueue.poll ( ) );
        priorityQueue.forEach ( System.out::print );
        System.out.println ( );
        //offer - 객체에 값 추가(저장 공간이 없어도 예외가 발생하지 않음)
        priorityQueue.offer ( 1 );
        //peek - 큐의 마지막 값을 반환(큐가 비어있으면 null)
        System.out.println ( "===================================" );
        System.out.print ( priorityQueue.poll () );
        System.out.print ( priorityQueue.poll () );
        System.out.print ( priorityQueue.poll () );
        System.out.print ( priorityQueue.poll () );
        System.out.print ( priorityQueue.poll () );
        //값을 출력할 때는 우선순위가 적용되지 않았으나 값을 꺼낼 때는 우선순위로 값을 꺼낸다.

    }
}
