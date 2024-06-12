package chapter14.substream_02.serial;

import java.io.Serializable;

public class Person implements Serializable {
    /**
     * serialVersionUID
     *
     * serialVersionUID는 자바 직렬화에서 클래스의 버전을 관리하는 데 사용되는 고유 식별자
     * 직렬화와 역직렬화 과정에서 클래스 버전 호환성을 유지하기 위해 중요한 역할을 한다.
     *
     * 1. 역할
     *   1.1 버전 관리
     *      - serialVersionUID는 직렬화된 객체의 클래스 버전을 식별하는 데 사용
     *      - 클래스의 구조(필드, 메서드 등)가 변경되었을 때 직렬화된 객체와 현재 클래스의 호환성을 검사
     *   1.2 역직렬화 시 호환성 검증
     *      - 역직렬화 과정에서 serialVersionUID가 일치하는지 확인
     *      - 일치하면, 클래스가 동일하다고 간주하여 객체를 정상적으로 역직렬화
     *      - 일치하지 않으면 InvalidClassException이 발생하여 역직렬화를 거부
     * */

    //TODO : 버전 1의 Person 객체
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //TODO : 버전 2의 Person 객체
//    private static final long serialVersionUID = 2L; // 변경된 serialVersionUID
//    private String name;
//    private int age;
//    private String address;
//    public Person(String name, int age, String address) {
//        this.name = name;
//        this.age = age;
//        this.address = address;
//    }

    /**
     * 버전 1에서 직렬화를 하고 버전 2에서 버전 1의 객체를 역직렬화하는 경우, 이전 버전으로 직렬화된 객체는 새로운 클래스 버전에서 역직렬화할 수 없음
     * serialVersionUID가 다르기 때문에 InvalidClassException이 발생
     *
     * serialVersionUID가 같다면 역직렬화가 가능하며 만약 버전 2에서 직렬화를 하고
     * 버전 1에서 역직렬화를 하는데 serialVersionUID가 같다면 address는 읽을 수가 없는 상태가 되지만 직렬화 자체는 오류없이 성공함
     * */


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    public String getAddress ( ) {
//        return address;
//    }
}
