package chapter11.clazz_01;

public class Book {

    private String a = "a";

    private static String b = "book"; //static 필드는 생성자로 접근할 필요가 없다.

    private static final String c = "book";

    public String d = "d";

    protected String e = "e";

    public Book() {
    }

    public Book(String a, String d, String e) {
        this.a = a;
        this.d = d;
        this.e = e;
    }

    private void f() {
        System.out.println("F");
    }

    public void g() {
        System.out.println("G");
    }

    public int h() {
        return 100;
    }

}