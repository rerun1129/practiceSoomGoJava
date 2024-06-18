package chapter15.annotation_02;

import java.lang.annotation.*;

@Target ( ElementType.METHOD )
@Retention ( RetentionPolicy.RUNTIME )
//어노테이션에 붙는 어노테이션은 메타 어노테이션이라 하며 이를 이용해 커스텀 어노테이션 작성이 가능.
//즉, 어노테이션의 정보를 담고 있는 어노테이션으로 이해하면 됨
public @interface Annotations { //어노테이션 선언 방법
    /**
     * 어노테이션
     *
     * 자바 개발을 하다 보면 볼 수 있는 클래스 또는 메서드 또는 변수 앞에 @Override같은 노란색 표시
     * 이 어노테이션은 JEE5(Java Platform, Enterprise Edition 5)부터 새롭게 추가된 요소임
     *
     * 이 어노테이션으로 인해 코드의 유효성 검사 등을 쉽게 할 수 있고, 코드를 간략하게 짤 수 있게 됨.
     * 일단 어노테이션의 용도는 다양한 목적이 있지만 메타 데이터의 비중이 가장 크다
     *    - 메타-테이터(Meta-Data) : 데이터를 위한 데이터를 의미하며, 풀어 이야기하면 한 데이터에 대한 설명을 의미하는 데이터. (자신의 정보를 담고 있는 데이터)
     * 즉, 해당 객체나 클래스에 대한 정의를 내려준다고 보면 된다
     * 그 정의에 맞지 않으면 예외를 발생시키거나 정의에 따라서 코드가 작동하게 해준다.
     * */
    boolean isCheck() default true;

    /**
     * 메타 어노테이션
     * 1. @Retention
     * - 자바 컴파일러가 어노테이션을 다루는 방법을 기술하며, 어느 시점까지 영향을 미치는지를 결정
     * - 종류
     *     - RetentionPolicy.SOURCE: 컴파일 전까지만 유효. (컴파일 이후에는 사라짐)
     *     - RetentionPolicy.CLASS: 컴파일러가 클래스를 참조할 때까지 유효.
     *     - RetentionPolicy.RUNTIME: 컴파일 이후에도 JVM에 의해 계속 참조가 가능. (리플렉션을 사용하는 경우)
     * - 일반적으로 RUNTIME까지 살아야 개발자의 의도대로 움직이기 때문에 RUNTIME을 가장 자주 사용한다.
     *
     * 2. @Target
     * - 어노테이션이 적용될 위치를 선택
     * - 종류(#표시한 것들을 자주 사용함)
     *     - ElementType.PACKAGE: 패키지에 선언
     *     - # ElementType.TYPE: 타입에 선언
     *     - # ElementType.ANNOTATION_TYPE: 어노테이션 타입에 선언
     *     - # ElementType.CONSTRUCTOR: 생성자에 선언
     *     - # ElementType.FIELD: 멤버 변수에 선언
     *     - ElementType.LOCAL_VARIABLE: 지역 변수에 선언(메서드 내부 변수)
     *     - # ElementType.METHOD: 메서드에 선언
     *     - # ElementType.PARAMETER: 파라미터에 선언
     *     - # ElementType.TYPE_PARAMETER: 파라미터 타입에 선언
     *     - ElementType.TYPE_USE: 타입에 선언
     *
     * 3. @Documented
     * - 해당 어노테이션을 Javadoc에 포함시킴
     * - Javadoc은 자바 공식문서 형식으로 표시되는 것인데 일반적으로는 어노테이션은 중요한 정보가 아니므로 문서 구성에서 빠짐
     * 4. @Inherited
     * - 어노테이션의 상속을 가능하게 함
     * - 일반적으로 어노테이션은 붙은 클래스에서만 동작하는데 이 메타어노테이션이 붙으면 어노테이션까지 포함해서 상속함
     * 5. @Repeatable
     * - Java8 부터 지원하며, 연속적으로 어노테이션을 선언할 수 있게 해줌
     * - 동일한 어노테이션은 중복 선언이 불가능한 것이 원칙인데 이 메타 어노테이션이 붙은 어노테이션은 중복 선언이 가능해짐
     * */

}
