package chapter07._5promotion_casting.casting;

import chapter07._5promotion_casting.Animal;
import chapter07._5promotion_casting.Cat;
import chapter07._5promotion_casting.Dog;
import chapter07._5promotion_casting.Fish;

import static chapter07._5promotion_casting.casting.Feed.*;

public class Feeder {
    public void feed ( Animal animal, Feed feed ) {
        if(animal instanceof Cat && feed == CAT_FOOD){
            Cat cat = (Cat)animal;
            System.out.println ( "고양이가 기분 좋게 먹이를 먹습니다" );
        }else if(animal instanceof Dog && feed == DOG_FOOD){
            System.out.println ( "강아지가 기분 좋게 먹이를 먹습니다" );
        }else if(animal instanceof Fish && feed == FISH_FOOD){
            System.out.println ( "물고기가 기분 좋게 먹이를 먹습니다" );
        }else {
            throw new IllegalArgumentException("먹이를 잘못 주면 큰일 납니다... 조심하세요!");
        }
    }
}
