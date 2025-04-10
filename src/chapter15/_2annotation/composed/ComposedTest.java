package chapter15._2annotation.composed;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention( RetentionPolicy.RUNTIME)
@Target( ElementType.METHOD)
@Test("composedTest")
@Before("setup")
public @interface ComposedTest {

}
