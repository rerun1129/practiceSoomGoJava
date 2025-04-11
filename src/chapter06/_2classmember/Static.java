package chapter06._2classmember;

public class Static {
    public static String hi; //[정적 변수]해당 클래스를 사용하는 모든 사용자가 같은 메모리로 바로 접근할 수 있다.
    public static final String LAST_HI = "Farewell~"; //[정적 상수]해당 클래스를 사용하는 모든 사용자가 같은 메모리로 바로 접근할 수 있고 final이기 때문에 수정이 불가능하다.
    /**
     * 상수의 장점
     * 1. 더이상 변경되지 않기 때문에 어디서 사용하든 동일한 값을 참조할 수 있다.
     * 2. 뒤에서 나오는 싱글톤 패턴을 더욱 적절하게 사용할 수 있다.
     * 3. 한번 값이 할당되면 변경되지 않기 때문에 메모리 변동이 없어 컴퓨터의 메모리 관리에 큰 도움을 줄 수 있다.
     * */

    public static void main ( String[] args ) {
//        this.hi; //this 참조를 통한 변수 접근
        /**
         * this는 클래스의 인스턴스에 접근하여 참조하기 때문에 인스턴스가 생성되지 않은 시점인 지금 this로 정적 메모리에 이미 올라가 있는 변수에 접근할 수는 없다.
         * 자기 자신 내부를 한정하여 this로는 static 블록 안에서 static 멤버를 참조할 수 없다.
         * */
    }
}
