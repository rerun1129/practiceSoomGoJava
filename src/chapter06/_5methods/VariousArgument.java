package chapter06._5methods;

import java.util.Arrays;

public class VariousArgument {

    public static void printVarArg(String ...vars){
        //가변 인자는 배열로 취급합니다.
        System.out.println ( Arrays.toString ( vars ) );
    }

    public void printVarArg2(String startString, String ...vars){
        //가변 인자는 가장 마지막에 들어가야 합니다.
        System.out.println ( startString + Arrays.toString ( vars ) );
    }

//    public void printVarArgError(String ...vars, String startString){
////      그렇지 않으면 에러가 발생합니다. 그 이유는 가장 마지막에 무한정 들어올 수 있는 파라미터 자리를 마련해주어야 하는데 가변 인자 뒤에 파라미터가 추가로 들어오면
////      어디까지가 가변 인자고 어디부터가 새로운 인자인지 알 수가 없습니다.
//    }
}
