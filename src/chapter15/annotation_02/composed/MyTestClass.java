package chapter15.annotation_02.composed;

import java.lang.reflect.Method;

public class MyTestClass {
    @ComposedTest
    public void testMethod() {
        System.out.println("Running composed test...");
    }

    @Before("setup")
    public void setup() {
        System.out.println("Setting up...");
    }

    @Test("singleTest")
    public void singleTestMethod() {
        System.out.println("Running single test...");
    }

    public static void main(String[] args) throws Exception {
        MyTestClass testInstance = new MyTestClass();

        // 리플렉션을 사용하여 어노테이션이 적용된 메서드 인스턴스를 가져와서 순회
        for ( Method method : MyTestClass.class.getDeclaredMethods ( )) {
            // ComposedTest 어노테이션이 존재하는지 확인
            if (method.isAnnotationPresent(ComposedTest.class)) {
                // ComposedTest 어노테이션 가져오기
                ComposedTest composedTest = method.getAnnotation(ComposedTest.class);
                //ComposedTest 어노테이션에 딸린 Test 어노테이션의 value 값 가져오기
                Test testAnnotation = composedTest.annotationType().getAnnotation(Test.class);
                System.out.println("Test annotation value: " + testAnnotation.value());
                //ComposedTest 어노테이션에 딸린 Before 어노테이션의 value 값 가져오기
                Before beforeAnnotation = composedTest.annotationType().getAnnotation(Before.class);
                System.out.println("Before annotation value: " + beforeAnnotation.value());
                method.invoke(testInstance); //@ComposedTest가 붙은 testMethod 실행
            }
        }
    }
}
