package chapter13.generics_02._01_box;

/**
 * 제네릭스 클래스를 선언하는 방법 자체는 아래와 같다.
 * */
public class Box<T> { //여기서는 타입을 특정할 수는 없고 타입을 변수처럼 선언한다.
    /**
     * 타입 변수는 T가 될 수도 있고, 정말 길게 IntegerValue 라는 문장이 될 수도 있다. (일반 변수를 선언한다고 생각하면 쉬움)
     * 타입 변수는 이 클래스 내부에서는 <T>와 같이 선언된 경우에는 Object 타입으로 취급된다.
     * 그래서 Box<T>는 Box<Object> 상태라고 생각하면 된다.
     * 인텔리 제이에서 보면 T의 색상이 다른 텍스트의 색상과 다른데 이 색상이 바로 타입 변수를 상징하는 색이다.
     * 타입 변수는 일반적으로 의미가 없는 1글자 변수이지만
     * Map에 들어가는 타입 변수처럼 Map<K,V> -> Key, Value
     * Function에 들어가는 타입 변수처럼 Function<T,R> -> T = 주입되는 변수 , R = Return Type
     * 처럼 간결한 의미를 가지는 경우도 있다.
     * */
    T item;

//    static T item;
    /**
     * 타입 변수 T는 컴파일 시에 타입이 확정되는데 static으로 변수를 선언하면 이 클래스에서 지금 당장 T 타입을 알아야
     * static 으로써 사용이 가능한 것이기 때문에 static 멤버 변수는 사용이 불가능하다.
     * 이는 멤버 변수 뿐만 아니라 메서드도 동일하게 적용된다
     */

    T[] itemArr; //T 타입의 배열을 선언하는 것은 가능하다. 컴파일 시에 제네릭 클래스의 타입이 확정된 후에는
                 //배열에 접근해서 데이터를 처리해도 타입이 무엇인지 알 수 있기 때문
    T[] toArray() {
//        T[] tmpArr = new T[itemArr.length];
        /**
         * 제네릭 타입의 배열을 생성하는 것은 불가능하다.
         * new 연산자는 컴파일 시점에 타입 T가 무엇인지 정확히 알아야 하는데 Box<T> 클래스의 시점에서는 T가 무엇인지 알 수 없기 때문에
         * new 로 인스턴스를 만드는 행위를 할 수 없는 것이다.
         * 위의 itemArr를 선언할 때는 당장 T 타입이 무엇인지 알 필요가 없으나 new T[]를 할때는 당장 T 타입이 무엇인지 알아야
         * new T[]의 정보를 가진 인스턴스 변수를 생성할 수 있는 것이다.
         * */
        Object[] objects = new Object[itemArr.length];
        itemArr = ( T[] ) objects;
        //만약 new T[] 배열을 여기서 무조건 사용해야 한다면 위와 같이 T와 동일한 의미의 타입인 Object 타입으로 배열을 선언한 후에
        //해당 배열을 T 타입 배열로 캐스팅해서 대입하는 식으로 사용이 가능하지만 일반적으로 사용하는 방법은 아니다.
        return null;
    }



    public T getItem ( ) {
        return item;
    }

    public void setItem ( T item ) {
        this.item = item;
    }
}

/**
 * 만약 타입 변수로 String 을 선언하면 클래스는 이렇게 변하는 것으로 생각하면 된다.
 * */
/* public class Box<String> {
    String item;

    public String getItem ( ) {
        return item;
    }

    public void setItem ( String item ) {
        this.item = item;
    }
}
*/
