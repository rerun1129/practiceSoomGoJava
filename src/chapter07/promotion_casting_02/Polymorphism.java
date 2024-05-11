package chapter07.promotion_casting_02;

public class Polymorphism {
    /**
     * 다형성
     *
     * '인스턴스는 다양한 형태를 가질 수 있는 자격이 부여된다.'
     * 큰 바구니에 작은 물체가 들어갈 수 있지만 작은 바구니에는 큰 물체가 들어갈 수 없는 개념이다.
     * 어떠한 추상적인 개념 안에는 구체적인 개념이 들어갈 수 있는 것이다.
     * ex) Parent parent[우항에서 건네어준 자식 멤버의 정보 + 자기 자신의 부모 클래스 멤버의 정보] = new Child()[<-자식 클래스 멤버의 정보를 가지고 있다.];
     *    => Child는 Parent의 확장이고 과정이 어떻던 간에 Child 인스턴스가 Parent 타입에서 제공하지 않는 메서드 및 변수를 가지고 있을 가능성이 존재한다.
     *    => 따라서 parent는 Child의 클래스 정보를 가지고 생성된 Parent 타입 인스턴스이며 Parent 타입 뿐만 아니라 Child 타입의 정보도 가지고 동작할 수 있다.
     *    => (중요)여기서 주의 깊게 봐야할 것이 바로 'parent는 Parent 타입 뿐만 아니라 Child 타입의 정보도 가지고 동작'이다. 이러한 정보 전달로 인해서 다형성을 이용한 객체 지향 프로그래밍이 가능해진다.
     *
     * 하지만, 자식 클래스가 부모 클래스의 인스턴스를 생성자로 받지 못하는 자바의 논리는 부모 클래스로 생성된 인스턴스는 자식 클래스의 메서드 정보를 가지지 못하기 때문에
     * 정보 자체는 자식 클래스의 정보를 써야하므로 문제가 된다.
     * ex) Child child[우항에서 건네어준 부모 멤버의 정보 + 자기 자신의 자식 클래스 멤버의 정보] = new Parent()[<-부모 클래스 멤버의 정보를 가지고 있다.];
     *    => new Parent()의 정보를 가진 인스턴스는 Child 타입의 정보를 담을 수 없다. Child 클래스에 Parent에 없는 메서드가 추가 선언되어 있다면 이를 알지 못하는
     *    => Parent는 정말 당연히 Child의 기능을 사용할 수 없으므로 자식 클래스의 인스턴스가 슈퍼 클래스의 생성자 정보를 받아서 처리할 수 없는 것이다.
     * */

    public static void main ( String[] args ) {
        Animal animal = new Animal ( "없음" );
        Animal cat = new Cat( "고양이" );
        Animal dog = new Dog( "개" );
        Animal fish = new Fish ( "물고기" );

        //이 아래부터 (중요)로 표시한 개념을 코드로 보여주게 됩니다. 'animal은 Animal 타입 뿐만 아니라 각종 자식 타입의 정보도 가지고 동작' 하게 됩니다.
        //그래서 부모의 정보와 자식의 정보가 충돌하게 되면 더욱 구체적인 개념인 자식의 정보로 대체를 할 수 있게 됩니다.
        //하지만 자식의 타입에 부모의 정보를 담게 되면 자식이 막상 필요한 정보는 인스턴스에 없으므로 논리가 맞지 않습니다.

//        Cat cat2 = new Animal ( "없음" ); <- 불가능한 문법으로 컴파일러가 에러를 표시합니다.

        System.out.println ( "동물이라는 개념 : " + animal.growl () );
        System.out.println ( "고양이 : " + cat.growl () );
        System.out.println ( "개 : " + dog.growl () );
        System.out.println ( "물고기 : " + fish.growl () );

        animal.inCage ( animal );
        animal.inCage ( cat );
        animal.inCage ( dog );
        animal.inCage ( fish );


        //cat도 결국엔 Animal 타입이기 때문에 동일한 부모의 자식 클래스의 메서드를 다형성을 이용해서 활용할 수 있게 됩니다.
        cat.inCage ( animal );
        cat.inCage ( cat );
        cat.inCage ( dog );
        cat.inCage ( fish );

        //inCage 자체는 Animal에 선언된 메서드이기 때문에 타입이 다른 각각의 자식 클래스도 Animal 타입으로 수용되어 문제없이 동작합니다.
        Cat bengol = new Cat ( "뱅골" );
        Dog huski = new Dog ( "허스키" );

        bengol.inCage ( bengol );
        bengol.inCage ( huski );

        //만약 walk가 Dog에만 선언된 메서드여도 매개변수의 타입이 부모 타입인 Animal이라면 Dog 타입 메서드에 Cat 타입 인스턴스가 들어가도 정상적으로 동작합니다.
        huski.walk ( bengol );

    }
}
