package chapter15.annotation_02.repeatable;

import java.lang.annotation.*;

// @Repeatable 어노테이션을 사용하여 반복 가능한 어노테이션 정의
// @Repeatable 주석 처리해보기
@Retention( RetentionPolicy.RUNTIME)
@Target( ElementType.TYPE)
@Repeatable(Schedules.class)
public @interface Schedule {
    String day();
    String time();
}
