package chapter13.generics_02._00_concept;

public class ObjectBox {
    /**
     * 내부에 Object value 를 가지고 있다. Object 는 모든 타입의 부모이다.
     * 부모는 자식을 담을 수 있으므로 세상의 모든 타입을 ObjectBox 에 보관할 수 있다. (다형성 활용)
     * */
    private Object value;
    public void set(Object object) {
        this.value = object;
    }
    public Object get() {
        return value;
    }
}
