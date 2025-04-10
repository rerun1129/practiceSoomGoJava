package chapter15._1enum.relate;

public enum AfterTableStatus {
    /**
     * 데이터들 간의 연관관계 표현
     * 만약 참이라는 의미가 Y, 1, true 이고
     * 거짓이라는 의미가 N, 0, false 라면 아래와 같이 데이터의 의미대로 값들을 묶어서
     * 해당 열거형에서 가져다가 사용하면 된다.
     * 만약 참 거짓의 분류가 추가된다면 아래의 열거형 파라미터에 값을 추가하고 필드와 getter만 추가해주면 된다.
     * */
    YES(1, true, "Yes"), NO(0, false, "No");
    private final int status1;
    private final boolean status2;
    private final String status3;

    AfterTableStatus ( int status1, boolean status2, String status3 ) {
        this.status1 = status1;
        this.status2 = status2;
        this.status3 = status3;
    }
    public int getStatus1() {
        return status1;
    }
    public boolean getStatus2() {
        return status2;
    }
    public String getStatus3() {
        return status3;
    }
}
