package chapter06.constructor;


public class OtherCar extends Car {

    String model;
    String color;
    int speed;

    private OtherCar ( String model, String color, int speed ) {
        super ( model, color, speed );
        /**
         * super의 의미
         * super는 자신의 상위 클래스, 즉 슈퍼 클래스에 대한 지시 키워드이다.
         * this와 같은 논리로 동작하여 super()역시 슈퍼 클래스의 생성자로 만들어진다.
         * 서브 클래스의 생성자에서 super()가 필수인 이유는 자바 규약 상 다형성을 활용하기 위해서
         * 슈퍼 클래스의 타입으로 서브 클래스의 인스턴스를 생성하여 할당하는 경우가 있기 때문에 이로 인한 기본적인 슈퍼 클래스의 인스턴스 생성도 필요한 것이다.
         **/

        this.model = model;
        this.color = color;
        this.speed = speed;
    }

    /**
     * this()의 문제점은 생성자를 만드는 당시가 아닌 클래스 선언 시에 값을 초기화해줘야 하는데 이렇게 사용할 이유도 없을 뿐더러 생성자 내부에서
     * 초기화된 값을 생성자를 만들 당시에 알 수가 없다는 점에 있다.
     *
     * 생성자를 효율적으로 만드는 추가적인 3가지 방법
     * 1. 정적 팩토리 메서드 -> 생성자의 접근 제어자를 private으로 막고 대신 인스턴스를 생성해주는 static 메서드를 만들어서 사용한다.
     * 2. 빌더 패턴
     * */

    //정적 팩토리 메서드
    /**
     * 장점
     * 1. 생성자는 이름이 없지만 메서드는 이름을 가질 수 있다. 이 말은 해당 생성자에서 내부 데이터의 유효성 검증을 한다면 유효성 검증을 함을 알리는 메서드명을 사용할 수 있다는 것이다.
     *    또한, 유효성을 검증하는 메서드와 유효성을 검증하지 않는 메서드 모두 동일하게 같은 시그니처를 가진 생성자를 생성할 수 있다는 점이 장점이다.
     * 2. 해당 메서드의 호출 시점에 인스턴스를 리턴하기 때문에 메모리 소모가 덜하다.
     * 3. 리턴 타입 객체의 하위 타입을 리턴할 수 있다.
     * */
    static Car of(String model, String color, int speed) {
        if(model.equals ( "말리부" )){
            return new Malibu (model, color, speed);
        }else {
            return new OtherCar (model, color, speed);
        }
    }

    static OtherCar ofValidated(String model, String color, int speed) {
        //유효성 검증 로직 포함
        return new OtherCar (model, color, speed);
    }

    /**
     * 3. 호출될 때 마다 인스턴스를 생성하지 않아도 된다. 이는 싱글톤 패턴과 맞닿아있는 내용인데 한번 만들어진 인스턴스를 복수로 사용하지 않아도 되는 경우에는 생성자의 인스턴스를 필드에 저장해두고
     *    필요할때마다 생성하는 것이 아닌 꺼내서 쓰는 방법을 취할 수도 있다. 이 방법의 최대 장점은 인스턴스 생성이라는 무거운 작업을 매번 하지 않아도 된다는 점이다.
     * */
    static class CarDefaultSettings {
        private CarDefaultSettings() {

        }
        private static final CarDefaultSettings SETTINGS = new CarDefaultSettings(); //인스턴스를 컴파일 타임에 미리 메모리에 올려놓고

        public static CarDefaultSettings getInstance() { //필요할때는 매번 가져다 쓴다.
            return SETTINGS;
        }

    }

    /**
     * 단점
     * 1. 상속을 하려면 public이나 protected 접근 제어자를 가진 생성자가 필요하나 정적 팩토리 메서드만 제공하면 서브 클래스를 만들수가 없다.(정적 팩토리 메서드의 사상대로 클래스를 구현하면 상속이 어려움)
     *    이를 확인하려면 같은 패키지의 Car 생성자를 private로 만들면 알 수 있다.
     * 2. 매우 일반적인 생성자와 다르게 정적 팩토리 메서드는 개발자가 이것이 인스턴스를 가져오는 메서드임을 인지하고 사용해야 한다.
     * */


    //빌더 패턴 -> NutritionFacts 클래스 참고

    /**
     * 생성자의 초기화 필드들을 메서드 체이닝 방식으로 만들수 있도록 하는 디자인 패턴
     *
     * 장점
     * 1. 생성자의 개수가 많을 경우에 그 대안으로서 사용이 가능하다.
     * 2. 롬복에서 정말 간단하게 @Builder 어노테이션으로 사용이 가능하다.
     *
     * 단점
     * 1. 생성자에 비해서 구현 난이도가 높고 전용 빌더 클래스가 하나 더 필요하다.
     * 2. 롬복의 빌더를 사용하는 경우 커스텀하게 만든 빌더를 사용할 수 없다.
     * */

}
