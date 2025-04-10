package chapter13._1collection.child.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HashSets {
    /**
     * HashSet
     *
     * 해시셋은 Set 인터페이스 구현체 중에 가장 대표적인 구현체
     * Set의 특징대로 저장 순서를 보장하지 않는 중복 없는 자료 구조로 동작한다.
     * 해시셋은 내부적으로 HashMap으로 만들어졌는데 일단 중복이 없어야 하는 자료구조인 Set의 특성 상
     * Hashing과 잘 맞으며 HashMap의 키 관리 로직을 Set에 접목시켜서 동작하게 함.
     * */

    public static void main ( String[] args ) {
        /**
         * 기본적으로 Set은 List와 같은 인터페이스 Collection을 상속한 객체이기 때문에 메서드가 매우 유사하므로
         * Set의 특징을 볼 수 있는 예제를 몇가지 보도록 한다.
         * */
        Object[] objArr = {"4","4","4","1",1,"2","2","3","3",}; //저장 순서는 4,1,2,3 이지만
        Set set = new HashSet ();
        set.addAll ( Arrays.asList ( objArr ) );// HashSet에 objArr의 요소들을 저장한다.
        System.out.println(set);// 출력될때는 1,1,2,3,4 (저장 순서를 보장하지 않는 특성 및 중복을 제거하는 특성)
        //왜 1,2,3,4가 아닌 중복 값이 출력되냐면 1 두 개 중에 하나는 String이고 하나는 Integer이기 때문에
        //하나는 정수이고 하나는 문자열이므로 중복이 아님
    }
}
