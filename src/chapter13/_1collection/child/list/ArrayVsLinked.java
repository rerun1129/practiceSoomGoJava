package chapter13._1collection.child.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayVsLinked {
    /**
     * 데이터를 순차적으로 추가/삭제하는 경우에는 당연히 배열로 이루어진 ArrayList가 빠르다.
     * 하지만, 데이터를 비순차적인 즉, 중간 데이터를 추가/삭제해야 하는 경우가 많다면 LinkedList가 빠르다.
     * 일반적으로는 ArrayList가 많이 쓰이지만 예외적으로 랜덤 엑세스 후 데이터 수정이 이루어진다면 LinkedList를 사용하는 것이 좋다.
     * */

    public static void main(String args[]) {
        ArrayList al = new ArrayList( 2000000);
        LinkedList ll = new LinkedList();

        System.out.println("순차적으로 추가하기");
        System.out.println("ArrayList :"+add1(al));
        System.out.println("LinkedList :"+add1(ll));
        System.out.println();
        System.out.println("중간에 추가하기");
        System.out.println("ArrayList :"+add2(al));
        System.out.println("LinkedList :"+add2(ll));
        System.out.println();
        System.out.println("중간에 제거하기");
        System.out.println("ArrayList :"+remove2(al));
        System.out.println("LinkedList :"+remove2(ll));
        System.out.println();
        System.out.println("순차적으로 제거하기");
        System.out.println("ArrayList :"+remove1(al));
        System.out.println("LinkedList :"+remove1(ll));
    }

    public static long add1 ( List list ) {
        long start = System.currentTimeMillis();
        for(int i=0; i<1000000;i++) list.add(i+"");//마지막 / 맨 앞의 위치에서 계속 더함(순차적)
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long add2(List list) {
        long start = System.currentTimeMillis();
        for(int i=0; i<10000;i++) list.add(500, "X");//500번째 위치에서 계속 더함(중간)
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long remove1(List list) {
        long start = System.currentTimeMillis();
        for(int i=list.size()-1; i >= 0;i--) list.remove(i);//list의 마지막에 계속 위치하면서 지움(순차적)
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long remove2(List list) {
        long start = System.currentTimeMillis();
        for(int i=0; i<10000;i++) list.remove(i); //i가 계속 커지면서 중간 데이터로 나아가며 지워나감(중간)
        long end = System.currentTimeMillis();
        return end - start;
    }

}
