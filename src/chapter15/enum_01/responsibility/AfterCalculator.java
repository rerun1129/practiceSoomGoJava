package chapter15.enum_01.responsibility;

import java.util.function.Function;

public enum AfterCalculator {
    /**
     * 상태와 행위를 여기 한 곳에서 관리
     * */

    CALC_TYPE_A(value -> value), //상태
    CALC_TYPE_B(value -> value * 10), //상태
    CALC_TYPE_C(value -> value * 3), //상태
    CALC_TYPE_DEFAULT(value -> 0L); //상태

    private final Function<Long, Long> expression;

    AfterCalculator ( Function <Long, Long> expression ) {
        this.expression = expression;
    }

    public long calculate(long value) {
        return expression.apply ( value );
    }
}
