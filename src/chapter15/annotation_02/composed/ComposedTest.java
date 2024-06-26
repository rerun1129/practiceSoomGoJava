package chapter15.annotation_02.composed;

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
