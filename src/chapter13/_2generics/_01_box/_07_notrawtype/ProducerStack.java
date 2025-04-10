package chapter13._2generics._01_box._07_notrawtype;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;

public class ProducerStack<E extends Integer> {
    /**
     * 제네릭을 생산자로 사용하는 방법
     * */
    private Integer[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    // 배열 elements 는 push(E)로 넘어온 E 인스턴스만 담는다.
    // 따라서 타입 안전성을 보장하지만,
    // 이 배열의 런타임 타입은 E[]가 아닌 Object[]다
    public ProducerStack ( ) {
        elements = new Integer[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0)
            throw new EmptyStackException ();
        //push로 값 자체가 E 타입만 들어올 것이기 때문에 E 타입의 안전 캐스팅이 보장됨
        E result = (E)elements[--size];
        elements[size] = null; // 다 쓴 참조 해제
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size) elements = Arrays.copyOf ( elements, 2 * size + 1 );
    }

    public static void main(String[] args) {
        ProducerStack <Integer> stack = new ProducerStack <> ();
        for (Integer arg : List.of(1, 2, 3)) stack.push(arg);
        while (!stack.isEmpty()) System.out.println(stack.pop());
    }
}
