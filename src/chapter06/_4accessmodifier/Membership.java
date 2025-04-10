package chapter06._4accessmodifier;

public enum Membership {
    REGULAR("정회원"), GUEST("손님"), SUPER("슈퍼 회원"), NORMAL("일반 회원"), TEMP("임시 회원");

    private final String title;

    Membership ( String title ) {
        this.title = title;
    }
}
