package chapter07._1extend;


import java.util.ArrayList;

public class Extends {

    /**
     * 상속의 특징
     * 1. 단일 상속
     *    만약 비행기와 자동차를 상속 받아서 하늘을 나는 자동차를 만든다고 가정해보자. 만약 다중 상속을 사용하
     *    게 되면 하늘을 나는 자동차 입장에서 move() 를 호출할 때 어떤 부모의 move() 를 사용해야 할지 애매한 문제가 발생
     *    한다. 이것을 다이아몬드 문제라 한다. 그리고 다중 상속을 사용하면 클래스 계층 구조가 매우 복잡해지 수 있다. 이런
     *    문제점 때문에 자바는 클래스의 다중 상속을 허용하지 않는다. 대신에 이후에 설명한 인터페이스의 다중 구현을 허용해
     *    서 이러한 문제를 피한다.
     *
     * 2. 부모 - 자식 클래스의 메모리 구조
     *    - 상속 관계의 객체를 생성하면 그 내부에는 부모와 자식이 모두 생성된다. [자식 생성자 호출 시 부모 생성자 super() 호출 강제]
     *    - 상속 관계의 객체를 호출할 때, 대상 타입을 정해야 한다. 이때 호출자의 타입을 통해 대상 타입을 찾는다.
     *    - 현재 타입에서 기능을 찾지 못하면 상위 부모 타입으로 기능을 찾아서 실행한다. 기능을 찾지 못하면 컴파일 오류가 발생한다.
     *
     *
     *
     * */

    /**
     * 상속의 장점
     * 1. 어떠한 클래스들이 동일한 기능의 필드 및 메서드 멤버를 '그대로' 사용한다면 불필요한 코드 중복을 제거할 수 있다.
     * 2. 부모 클래스만 수정해도 자식 클래스까지 영향이 쉽게 전파되어 수정해야되는 코드의 양이 줄어든다.
     *
     * 상속의 단점
     * 1. 부모 클래스의 수정으로 인해서 자식 클래스에 에러가 발생하는 경우가 있어 오히려 이 경우에는 작성해야하는 코드의 양이 증가한다.
     * 2. 필요에 따라서 자식 클래스를 계속 추가하게 되면 코드의 응집도가 떨어진다.(하나의 논리를 가진 기능이 다른 클래스로 분산되는 것)
     * 3. 상속 오용이 발생할 수도 있다. [아래 코드 참고]
     *
     * */

    static class Container extends ArrayList <Luggage> {
        private int maxSize;
        private int currentSize;

        public Container(int maxSize){
            this.maxSize = maxSize;
        }

        public void put(Luggage lug) throws NotEnoughSpaceException {
            //여기의 put 말고 ArrayList 의 add를 사용해도 Container 에 객체를 추가할 수 있다
            if(!canContain(lug)) throw new NotEnoughSpaceException();
            super.add(lug);
            currentSize += lug.getSize();
            //그런데 직접 super 의 add 를 사용하게 되면 put 이 가지고 있는 위의 if 분기를 거치지 않아서
            //maxSize 보다 더 많은 객체가 Container 에 추가될 수 있는 문제가 있다.
        }

        public void extract(Luggage lug){
            super.remove(lug);
            this.currentSize -= lug.getSize();
        }

        public boolean canContain(Luggage lug) {
            return maxSize >= currentSize + lug.getSize();
        }
    }

    public static void main ( String[] args ) throws NotEnoughSpaceException {
        Container container = new Container ( 10 );
        container.put ( new Luggage () );
        container.add ( new Luggage () );
    }

    /**
     * 위의 코드에서 maxSize와 currentSize를 통한 검증 로직은 부모 클래스인 ArrayList에는 없고 최대치에 대한 내용을 Container에서만 컨트롤하기 때문에
     * 부모 타입인 ArrayList에서 리스트의 사이즈를 조절하는 메서드를 호출하면 Container내부의 필드 값 변동 없이 List 요소가 추가 및
     * 제거되므로 논리상의 오류가 발생한다.
     * */

}
