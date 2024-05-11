package chapter07.abstractclass_03;

public class Instanceable {

    public static void main ( String[] args ) {

//        Abstract anAbstract = new Abstract ( ); //추상 클래스는 인스턴스화가 불가능!
        Abstract concrete = new Concrete ( ); //이렇게 구현 클래스를 통해서 인스턴스화를 해야한다.
        /**
         * 추상 클래스가 인스턴스화가 불가능한 이유는 간단한데 추상 클래스의 존재이유가 추상 메서드를 포함하므로 추상 메서드의 구현 강제를
         * 자식 클래스에게 하기 위함이며, 그로 인해서 추상 클래스를 그대로 인스턴스화하게 되면 추상 메서드를 사용할 길이 없어지기 때문에
         * 추상 메서드를 구현한 구현 클래스로 인스턴스화를 하여 재정의된 추상 메서드를 사용하도록 하려는 것이다.
         * */
    }

    static abstract class Abstract {

    }

    static class Concrete extends Abstract {

    }
}
