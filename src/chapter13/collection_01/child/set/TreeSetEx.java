package chapter13.collection_01.child.set;

import java.util.Arrays;
import java.util.TreeSet;

public class TreeSetEx {
    public static void main(String[] args) {
        TreeSet set = new TreeSet();
        int[] score = {80, 95, 50, 35, 45, 65, 10, 100};
        Arrays.stream ( score ).forEach ( set::add );
        /**
         * 현재 상황에서 set에 들어간 숫자들의 트리 형태
         *                    80 -> root node
         *              50         95
         *           35    65        100
         *         10 45 -> Leaf node
         * 트리의 기본 규칙은 부모보다 작은 값은 왼쪽, 큰 값은 오른쪽으로 배치되게 되어있음
         * 따라서 50보다 작은 값과 크거나 같은 값이라는 범위 검색에 큰 강점을 가짐
         * 위에서도 50보다 작은 값은 50의 자식들을 모두 출력하면 되며
         * 50보다 크거나 같은 값은 자신을 포함한 부모와 부모의 오른쪽 자식들만 출력하면 됨
         * */
        System.out.println("50보다 작은 값:"	+ set.headSet(50));
        System.out.println("50보다 큰 값:"	+ set.tailSet(50));
    }
}
