package chapter13.collection_01.child.compare;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorAndComparable {
    /**
     * Comparator 는 흔히 비교자라고 불린다.
     * 우리가 equals 나 sort 등의 프로세스를 동작시킬 때 어떤 것과 비교를 해서
     * 정렬을 하고 동등성의 비교를 해야하는지 따로 정해두지 않았지만 자바에서 제공하는 객체는
     * 비교자가 기본적으로 정의가 되어있기 때문에 따로 신경을 쓰지 않았다.
     * 하지만, 컬렉션 프레임워크와 같은 환경에서는 어떤 기준으로 어떤 객체가 크고 작은지 혹은 동일한지를
     * 비교하는 메서드를 사용하기 위해서(equals, sort 등등..) 비교 기준인 Comparator를 정의해두어야 의도한 바대로 동작하게 된다.
     *
     * Comparator 와 Comparable 은 각각 compare와 compareTo를 구현해야 하는 인터페이스인데
     * 둘 다 비교한다는 개념이나 동작 자체는 동일하지만
     * Comparable 이 해당 클래스에 대한 기본적인 비교 기준을 제공한다면
     * Comparator 는 기본적인 비교 기준 이외의 기준을 제공하기 위해서 존재한다.
     *
     * */
    public static void main(String[] args) {
        String[] strArr = {"cat", "Dog", "lion", "tiger"};

        Arrays.sort ( strArr ); // String의 Comparable 기본 구현에 의한 정렬
        System.out.println("strArr=" + Arrays.toString(strArr));

        Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER); // 대소문자 구분없는 정렬
        System.out.println("strArr=" + Arrays.toString(strArr));

        Arrays.sort(strArr, new Descending()); // 커스텀 클래스로 역순 정렬
        System.out.println("strArr=" + Arrays.toString(strArr));
    }
}

class Descending implements Comparator {
    public int compare(Object o1, Object o2){
        if( o1 instanceof Comparable && o2 instanceof Comparable) {
            Comparable c1 = (Comparable)o1;
            Comparable c2 = (Comparable)o2;
            return c1.compareTo(c2) * -1 ; //-1을 곱해서 기본 정렬 방식의 역순으로 변경
            // 또는 c2.compareTo(c1)과 같이 순서를 변경해도 -1을 곱한 것과 결과가 같음
        }
        return -1;
    }
}