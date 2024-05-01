package chapter06.constructor;

public class Main {
    public static void main ( String[] args ) {
        //빌더 사용
        NutritionFacts nutritionFacts = new NutritionFacts.Builder ( 10, 10 ).carbohydrate ( 10 ).sodium ( 10 ).fat ( 10 ).calories ( 10 ).build ( );
    }
}
