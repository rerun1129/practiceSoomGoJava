package chapter15._1enum.responsibility;

public class Main {
    public static void main ( String[] args ) {
        long originalValue = 10000L;
    /**
     * 열거형을 사용하지 않은 경우
     * */
        String codeBefore = CalculateConstance.CALC_TYPE_C; //코드도 알아야 하고
        long beforeResult = BeforeCalculator.calculate ( codeBefore, originalValue ); //코드가 사용하는 전용 메서드도 알고 있어야 한다.
        //즉, 클래스 2개 분에 해당하는 정보와 히스토리를 정확히 알고 있어야 올바른 사용이 가능하다.
        System.out.println ( beforeResult );
     /**
      * 열거형을 사용하는 경우
      * */
        AfterCalculator codeAfter = AfterCalculator.CALC_TYPE_C; //열거형의 코드만 알면
        long afterResult = codeAfter.calculate ( originalValue );
        //계산식은 열거형만 알고 있기 때문에 계산이라는 행위에 필요한 상태와 행위를 전부 한 곳에서 자연스럽게 관리할 수 있게 된다.
        System.out.println ( afterResult );
    }
}
