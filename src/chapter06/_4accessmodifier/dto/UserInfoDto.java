package chapter06._4accessmodifier.dto;

public class UserInfoDto {
    private String name;
    private String gender;
    private int age;
    private long salary;

    public UserInfoDto ( String name, String gender, int age, long salary ) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.salary = salary;
    }

    public String getName ( ) {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public String getGender ( ) {
        return gender;
    }

    public void setGender ( String gender ) {
        this.gender = gender;
    }

    public int getAge ( ) {
        return age;
    }

    public void setAge ( int age ) {
        this.age = age;
    }

    public long getSalary ( ) {
        return salary;
    }

    public void setSalary ( long salary ) {
        this.salary = salary;
    }

    /**
     * 데이터의 간편한 이동을 지원하기 위해 만들어진 개념
     * 장점
     * 1. 민감한 정보를 제거하고 꼭 필요한 정보만 담아서 이동시킬 수 있다.
     * 2. 비즈니스 로직을 가지지 않는 단순 데이터 구조이므로, Setter의 사용이 비교적 자유롭다.
     * 3. 쉽게 Vo에서 Dto를 추출해낼 수 있는 생성자나 메서드를 Vo에 만들어서 사용할 수 있다.
     * 4. 자바 15버전에서 DTO로 사용이 아주 편리한 객체인 Record 타입을 만들어 주었다.
     *
     * 단점
     * 1. 필요에 따라서 DTO를 매번 만들어줘야 하기 때문에 여기에 시간이 많이 걸린다.
     * 2. 필요에 따라서 DTO를 매번 만들기 때문에 DTO의 수가 많아지고 관리가 힘들어진다.
     * */


}
