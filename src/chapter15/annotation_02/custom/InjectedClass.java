package chapter15.annotation_02.custom;

public class InjectedClass {
    @InjectValue(stringValue = "Injected Value")
    private String field1;

    @InjectValue(intValue = 20)
    private int field2;

    public InjectedClass ( String field1, int field2 ) {
        //파라미터가 있는 생성자로 인스턴스 생성 시 파라미터 값을 통해 필드 값 주입
        this.field1 = field1;
        this.field2 = field2;
    }

    public InjectedClass ( ) {
        // 빈 생성자로 인스턴스 생성 시 리플렉션을 통해 필드 값 주입
        FieldInjector.injectValues(this);
    }

    @Override
    public String toString ( ) {
        return "InjectedClass{" +
                "field1='" + field1 + '\'' +
                ", field2=" + field2 +
                '}';
    }
}
