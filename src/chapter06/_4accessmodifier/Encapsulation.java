package chapter06._4accessmodifier;

public class Encapsulation {
    /**
    * 클래스 레벨에서 private와 protected 접근 제한자를 사용할 수 없는 이유
    *
    * - 접근 제한자는 주로 멤버(필드, 메서드)의 접근 범위를 제어하기 위한 것이며,
    *   클래스 레벨에서는 의미가 다르게 해석될 수 있음.
    *
    * - private 클래스는 외부는 물론 동일 패키지 내에서도 접근할 수 없어,
    *   사실상 해당 클래스 자체를 사용할 수 없는 상태가 되므로 정의할 이유가 없음.
    *
    * - 자바에서는 클래스의 공개 범위를 명확히 하기 위해 public과 package-private(default)만 허용함.
    *   → public: 모든 패키지에서 사용 가능
    *   → default: 같은 패키지 내에서만 사용 가능
    *
    * - 클래스의 존재 자체를 은닉하는 것(private/protected)은 언어 설계 상 부자연스럽고 비효율적이기 때문에,
    *   문법적으로 제한되어 있음.
    */


    /**
     * 캡슐화
     *
     * - 데이터와 관련 기능을 가진 객체를 묶어서 감추는 것
     * - 객체라는 것의 정의에 가장 부합하는 프로그래밍 특성
     * - 정보 은닉의 의미가 포함되어 있으나 본질적인 캡슐화의 의미는 아니다.
     * - 캡슐화의 가장 중요한 의미는 외부에 영향을 주지 않고 객체의 내부 구현을 변경할 수 있다는 것이다.
     * - 객체는 서로 상호작용해야하지만 객체 내부의 데이터 및 기능은 그 객체가 책임져야 한다.
     * - 책임이라는 의미에서 해당 객체가 접근 수준을 완화하게 되면 그만큼 객체가 책임져야 하는 범위가 기하급수적으로 늘어날 수 있기 때문에 적절한 캡슐화를 통해서 책임의 범위를 좁히는 것이다.
     * - 캡슐화를 시도하게 되면 해당 기능 단위에 대한 이해를 높일 수 있다.
     * */
}