package chapter13.collection_01.child.set;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSets {
    /**
     * TreeSet
     *
     * TreeSet은 이진 검색 트리(BST)라는 자료구조의 형태를 Set과 접목한 자료 구조로
     * 검색, 정렬, 범위 검색 등의 성능을 높이기 위해서 만들어졌다.
     * TreeSet은 RBT라는 특수한 이진 검색 트리 알고리즘으로 구현이 되어있다.
     * 이진 검색 트리도 연결 리스트와 마찬가지로 Node 자료 구조 형식으로 요소 간 연결을 하며
     * 아래와 같은 모양으로 구현된 TreeNode를 가진다.
     * 자세한 트리 구조나 구현 로직에 대해서는 위키피디아에 BST와 RBT를 검색해서 보도록 한다.
     * */

    static class TreeNode {
        TreeNode left, right; //왼쪽 및 오른쪽 자식 노드
        Object element; // 객체 저장을 위한 멤버 변수
    }

    public static void main ( String[] args ) {
        /**
         * TreeSet의 특수한 메서드만 골라서 소개함
         * */
        TreeSet <Integer> treeSet = new TreeSet <> ( ); //객체 선언 시 파라미터로 Comparator 를 넣을 수 있음
        treeSet.add (1); treeSet.add (1); treeSet.add (2);
        treeSet.add (2); treeSet.add (3); treeSet.add (4);
        treeSet.add (4); treeSet.add (5); treeSet.add (6);
        treeSet.add (9);
        //1 2 3 4 5 6 9
        //ceiling / floor -> 지정된 객체를 반환, 없으면 지정 객체와 제일 가까운 값 중 바로 인접한 큰 / 작은 값을 가진 객체를 반환(조건에 맞는 객체가 없으면 null)
        System.out.println ( treeSet.ceiling ( 7 ) ); //대상 인접 값 -> 9
        System.out.println ( treeSet.floor ( 7 ) ); //대상 인접 값 -> 6
        System.out.println ( treeSet.ceiling ( 6 ) ); //정확한 값이라면 6을 찾음
        System.out.println ( "========================================================" );
        //comparator -> 해당 TreeSet의 비교자(Comparator)를 반환
        Comparator <? super Integer> comparator = treeSet.comparator ( ); //특별하게 Comparator 를 커스터마이징하여 넣지 않았다면 일반적인 Comparator 를 돌려줌
        //descendingSet -> 해당 TreeSet의 요소들을 역순 정렬하여 반환
        NavigableSet <Integer> descendingSet = treeSet.descendingSet ( );
        descendingSet.forEach ( System.out::print );
        System.out.println ( );
        System.out.println ( "========================================================" );
        //first / last -> 현재 정렬된 순서에서 첫 번째 / 마지막 객체를 반환
        System.out.println ( treeSet.first ( ) ); //정방향의 첫번째
        System.out.println ( descendingSet.last ( ) ); //역방향의 마지막
        System.out.println ( "동일 객체가 반환됨" );
        System.out.println ( "========================================================" );
        //headSet / tailSet -> 지정된 객체보다 작은 / 크거나 같은 값의 객체들을 반환
        treeSet.headSet ( 4 ).forEach ( System.out::print ); //1,2,3
        System.out.println ( );
        treeSet.tailSet ( 4 ).forEach ( System.out::print ); //4,5,6,9
        System.out.println ( );
        System.out.println ( "========================================================" );
        //higher / lower -> 지정된 객체보다 큰 / 작은 값을 가진 객체 중 제일 가까운 값의 객체를 반환(조건에 맞는 객체가 없으면 null)
        System.out.println ( treeSet.higher ( 9 ) ); //9보다 큰 값이 없으니 null
        System.out.println ( treeSet.lower ( 1 ) ); //1보다 작은 값이 없으니 null
        System.out.println ( treeSet.higher ( 6 ) ); //6과 인접한 큰 값은 9
    }
}
