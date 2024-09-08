package chapter13.generics_02._00_concept;

public class StringBox {
    //문자열을 보관하고 꺼낼 수 있는 단순한 기능을 제공
    private String value;
    public void set(String object) {
        this.value = object;
    }
    public String get() {
        return value;
    }

    /**
     * 만약 추가적인 요구사항으로 Double, Boolean 등을 담을 수 있는 박스 객체가 필요하다면?
     * 타입 별로 하나 하나 일일이 만들어 두어야 하는가?
     * */
}
