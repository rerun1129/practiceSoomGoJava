package chapter06.classmember;

public class SingletonTest {

    public static void main ( String[] args ) {
//        Singleton singleton = new Singleton ( ); //생성자의 접근 제한자가 private 이기 때문에 생성 불가
        Singleton instance1 = Singleton.getInstance ( );
        Singleton instance2 = Singleton.getInstance ( );
        System.out.println ( instance1 ); //이것과 아래 모두 같은 주소를 가짐
        System.out.println ( instance2 );
    }
}
