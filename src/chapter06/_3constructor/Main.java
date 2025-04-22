package chapter06._3constructor;

public class Main {
    public static void main ( String[] args ) {
        NutritionFacts build = new NutritionFacts.Builder(12, 34)
                .calories(100)
                .fat(20)
                .sodium(30)
                .carbohydrate(40)
                .build();
    }
}
