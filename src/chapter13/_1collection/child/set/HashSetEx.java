package chapter13._1collection.child.set;

import java.util.HashSet;
import java.util.Set;

public class HashSetEx {

    public static void main ( String[] args ) {
        Set set = new HashSet();

        set.add("abc");
        set.add("abc"); //abc 문자열이 중복이므로 중복이 제거됨
        set.add(new Person("David",10));
        set.add(new Person("David",10));
        //둘 다 같은 내부 값을 가진 Person 객체이지만 중복이라고 인식되지 않아 제거되지 않음

        System.out.println(set);
    }
}

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
      //아래의 주석을 제거하고 다시 위의 main을 동작시키면 제대로 set의 중복 제거가 동작한다.
//    public boolean equals(Object obj) {
//        if( obj instanceof Person tmp ) {
//            //해시코드의 정의와 유사하게 equals 비교를 name과 age 동시에 적용해주게 되면
//            //Set은 이 equals를 기준으로 하여 중복 판단을 하게 된다.
//            return name.equals(tmp.name) && age==tmp.age;
//        }
//
//        return false;
//    }

//    public int hashCode() {
//        return (name+age).hashCode();
//        //앞선 챕터에서 언급했다시피 equals의 동일성 판단 기준은 hashCode 이기 때문에
//        //name과 age가 동일한 객체에 대한 hashCode가 같아야 하므로 위와 같이 hashCode를 재정의함
//    }

    /**
     * hashCode의 재정의에서 만족시켜야하는 조건
     * 1. 실행 중인 어플리케이션 내의 동일한 객체에 대해서 여러 번 hashCode()를 호출해도 동일한 int 값을 반환해야 한다.
     *    하지만, 실행 시마다 동일한 int 값을 반환할 필요는 없고 한 번의 실행 안에서 같은 값을 가져야 한다.
     * 2. equals 메서드를 이용한 비교에 의해서 true를 얻은 두 객체에 대해 각각 hashCode()를 호출해서 얻은 결과는 반드시 같아야 한다.
     *    즉, a.equals(b) 가 true 이면 a.hashCode() == b.hashCode() 가 true 여야 한다는 것이다.
     * 3. equals 메서드를 호출했을 때 false를 반환하는 두 객체는 hashCode() 호출에 대해 같은 int 값을 반환하는 경우가 있어도 괜찮지만,
     *    hashing을 사용하는 컬렉션의 성능을 향상시키기 위해서는 다른 int 값을 반환하는 것이 좋다.
     *    즉, a.equals(b) 가 false 여도 a.hashCode() == b.hashCode() 가 true 인 경우가 있을 수 있지만 해시 알고리즘의 특성상
     *    1:1 의 키-값 대응이 깨져버린 위의 예와 같은 경우에는 컬렉션의 검색 성능이 떨어지기 때문에 최대한
     *    a.equals(b) 가 false 인 경우 a.hashCode() == b.hashCode() 도 false가 나오게 구현해야 한다는 것이다.
     * */
    public String toString() {
        return name +":"+ age;
    }
}