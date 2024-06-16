package chapter15.enum_01.responsibility;

import static chapter15.enum_01.responsibility.CalculateConstance.*;

public class BeforeCalculator {
    /**
     * 문제점 1. 상수를 코드를 사용하는 곳과 다른 곳에서 관리함
     * 문제점 2. 상수와 코드가 관계가 있음을 코드의 히스토리를 모르는 사람이 알 수가 없음
     *          즉, 코드의 사용법을 알아야 코딩을 할 수 있는 문제가 생김
     * 문제점 3. 위의 문제점들로 인해서 상수만 알고 있는 개발자가 아래와 같은 계산 메서드를
     *          중복으로 만들어서 사용할 수 있음.
     * 결론. -> 비즈니스 로직 소스코드에서 상수만 바로 접근할 수 있기 때문에 상수를 관리하는 곳에서
     *         로직까지 처리할 수 있어야 함
     * 의문점. -> 이 곳에서 상수까지 관리하면 해결되는 문제가 아닌지?
     *           -> Calculator라는 클래스는 계산기 역할만 해야지 비즈니스 로직에 필요한 개념을 담게 되면
     *              계산기 이상의 책임을 지게 될 가능성이 크다.
     * */
    public static long calculate(String code, long value){
        switch ( code ){
            case CALC_TYPE_A -> { return value; }
            case CALC_TYPE_B -> { return value * 10; }
            case CALC_TYPE_C -> { return value * 3; }
            default -> { return 0; }
        }
    }
}
