package chapter15._2annotation.custom;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

// 어노테이션 정의
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface InjectValue {
    int intValue() default 0;
    String stringValue() default "";
}
