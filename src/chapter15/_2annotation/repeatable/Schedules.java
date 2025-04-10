package chapter15._2annotation.repeatable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 반복 가능한 어노테이션을 담는 컨테이너 어노테이션 정의
@Retention( RetentionPolicy.RUNTIME)
@Target( ElementType.TYPE)
public @interface Schedules {
    Schedule[] value();
}