package chapter06.accessmodifier.dto;

public class Main {
    public static void main ( String[] args ) {
        UserInfoRecordDto userInfoRecordDto = new UserInfoRecordDto ( "홍길동", "남", 30, 20000 );
        System.out.println ( userInfoRecordDto );
    }
}
