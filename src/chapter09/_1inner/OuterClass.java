package chapter09._1inner;

public class OuterClass {

    class InnerDefaultClass{ //왜 내부 클래스가 static이 될 수 있다고 경고할까?
        /**
         * 비 정적 멤버 클래스
         * - 바깥 클래스의 인스턴스와 암묵적으로 연결된다. (외부 클래스의 멤버를 참조하는 등)
         * - 멤버 클래스에서 바깥 인스턴스를 참조할 필요가 없다면 무조건 정적 멤버 클래스로 만들자. (외부 클래스의 인스턴스가 자동으로 만들어지게 됨)
         * */
    }

    static class InnerStaticClass{
        /**
         * 정적 멤버 클래스
         * - 바깥 클래스와 함께 쓰일 때만 유용한 public 도우미 클래스.
         *     - 예) Calculator.Operation.PLUS
         * - 외부 클래스와 독립적이기 때문에 인스턴스가 생기지 않는다. 그러나 보통은 외부 클래스와 함께 사용함이 바람직하다.
         * */
    }

    /**
     *
     * */

    void innerMethod(){
        /**
         * 로컬 클래스
         * - 가장 드물게 사용된다.
         * - 지역 변수를 선언하는 곳이면 어디든 지역 클래스를 정의해 사용할 수 있다.
         * - 가독성을 위해 짧게 작성해야 한다.
         * */
        class LocalClass{}
    }

    public static void main ( String[] args ) {
        /**
         * 불필요하게 비 정적 멤버 클래스를 만들게 되면 아래와 같이 반드시 외부 클래스를 먼저 생성하여 외부 인스턴스를 만들고 내부 인스턴스를 만들어야 한다
         * (불필요한 메모리 낭비)
         * */
        OuterClass outerClass = new OuterClass ( );
        System.out.println ( outerClass.new InnerDefaultClass () );
        /**
         * 아래와 같이 정적 멤버 클래스를 만들게 되면 new OuterClass 의 선언 없이 바로 정적 멤버 클래스의 인스턴스를 생성하여 사용할 수 있게 된다.
         * */
        System.out.println ( new InnerStaticClass() );
    }
}
