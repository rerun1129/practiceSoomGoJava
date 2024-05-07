package chapter06.classmember;

public class Main {
    static String hello;
    String greeting;

    public static void main ( String[] args ) {
        String lastHi = Static.LAST_HI;
        Static aStatic = new Static ( );
        String hi = aStatic.LAST_HI; //인스턴스 참조를 통한 변수 접근(굳이 할 필요가 없음)
        /**
         * 이미 외부에서 인스턴스를 생성했고 그를 통해서 static 멤버에 접근하는 것은 시점 문제가 발생하지 않는다.
         *
         * static 블록에서 비 static 멤버를 참조하는 것은 불가능하다.
         * static 보다 Heap 메모리가 더 느리게 JVM에 로드되기 때문에 느린 비 static 멤버들은 static 블록 안에서 불러들일 수 없다.
         * */
        hello = ""; //참조 가능
//        greeting = ""; //참조 불가능

        System.out.println ( hi );
    }


    public void notMain(){
        hello = ""; //참조 가능
        greeting = ""; //참조 가능
        /**
         * 비 static 블록에서 static 멤버를 참조하는 것은 가능하다.
         * Heap 메모리 보다 static 메모리가 더 빠르게 JVM에 로드되기 때문에 빠른 static 멤버들은 비 static 블록 안에서 불러들일 수 있다.
         * */
    }
}
