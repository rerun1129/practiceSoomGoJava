package chapter13._2generics._00_concept;

public class IntegerBox {
    //숫자를 보관하고 꺼낼 수 있는 단순한 기능을 제공
    private Integer value; public void set(Integer value) {
        this.value = value;
    }
    public Integer get() {
        return value;
    }
}
