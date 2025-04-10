package chapter06._5methods;

public class EarlyReturn {
    private boolean conditionA;
    private boolean conditionB;
    private boolean conditionC;

    /**
     * 아래와 같이 if문의 깊이가 계속 깊어지면 가독성도 좋지 않고 어떤 조건으로 어떤 값이 리턴되는지 알기가 쉽지 않아 디버깅에서 애를 먹게 된다.
     * 조건이 반드시 아래와 같이 중첩되어야 한다면
     * */

    public boolean checkValidProfileBad() throws Exception {
        if(conditionA){
            //무언가 작업하는 코드가 여기 존재한다고 가정
            //하지만 조건 B를 만족하지 않는다면 결국 예외를 던지는 분기로 빠지게 됨
            if(conditionB){
                //무언가 작업하는 코드가 여기 존재한다고 가정
                //하지만 조건 C를 만족하지 않는다면 결국 예외를 던지는 분기로 빠지게 됨
                if(conditionC){
                    return true;
                }else{
                    throw new Exception();
                }
            }else{
                throw new Exception();
            }
        }else{
            throw new Exception();
        }
    }

    /**
     * 이렇게 바꿔줘야 한다. 이렇게 단순하지 않더라도 최대한 if문의 깊이는 얕은게 좋다. 그리고 이렇게 얕아야 최대한 리턴을 빠르게 해줄 수 있다.
     * */

    public boolean checkValidProfileGood() throws Exception {
        if(conditionA && conditionB && conditionC){
            //여기서 어떤 작업을 해도 이미 값을 리턴하는 코드까지 예외없이 진행할 수 있어 실행을 실컷하고 죽어버리는 코드가 없어짐.
            return true;
        }else{
            throw new Exception();
        }
    }
}
