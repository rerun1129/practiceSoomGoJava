package chapter15._2annotation.composed;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//기본적인 어노테이션
//(일반적인 어노테이션은 @Retention과 @Target의 의미를 가진 합성 어노테이션)
@Retention( RetentionPolicy.RUNTIME)
@Target( { ElementType.ANNOTATION_TYPE, ElementType.METHOD })
//어노테이션에도 적용할 것이기 때문에 타입을 배열로 넣어준다.
public @interface Test {
    /**
     * 합성 어노테이션(Composed annotation)
     *  여러 개의 기존 어노테이션을 조합하여 새로운 어노테이션을 정의하는 것
     *  기존의 어노테이션의 동작 및 의미를 그대로 계승해서 거기에 더해
     *  새로 만드는 어노테이션을 마치 어노테이션을 상속하듯이 만드는 것을 말함
     *
     *  실제로 어노테이션 자체가 합성 어노테이션을 말하기도 하고
     *  스프링에서는 이 합성 어노테이션을 정말 광범위하게 사용한다.
     *  Ex) @Service, @Controller, @Repository, @Component ...
     *
     *  합성 어노테이션은 어노테이션을 여러개 붙이는 것보다 하나의 어노테이션으로 묶어서
     *  사용이 가능하기 때문에 코드의 가독성 및 재사용성을 유의미하게 높일 수 있다.
     * */
    String value() default "";
}
