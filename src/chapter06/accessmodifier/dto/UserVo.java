package chapter06.accessmodifier.dto;

public class UserVo {
    //불변이자 비즈니스의 모델 역할
    private String name;
    private String registNumber;
    private String gender;
    private String password;
    private int age;
    private long salary;

    //Getter는 허용하지만
    public String getName ( ) {
        return name;
    }

    public String getRegistNumber ( ) {
        return registNumber;
    }

    public String getGender ( ) {
        return gender;
    }

    public String getPassword ( ) {
        return password;
    }

    public int getAge ( ) {
        return age;
    }

    public long getSalary ( ) {
        return salary;
    }

    //불변성을 유지해야 하므로 Setter는 사용하지 않는다.
    public UserInfoDto toDto ( UserVo user ) {
        return new UserInfoDto (user.name, user.gender, user.age, user.salary);
    }
}
