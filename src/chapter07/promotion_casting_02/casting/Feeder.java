package chapter07.promotion_casting_02.casting;

import chapter07.promotion_casting_02.Animal;
import chapter07.promotion_casting_02.Cat;
import chapter07.promotion_casting_02.Dog;
import chapter07.promotion_casting_02.Fish;

import static chapter07.promotion_casting_02.casting.Feed.*;

public class Feeder {
    public void feed ( Animal animal, Feed feed ) {
        if(animal instanceof Cat && feed == CAT_FOOD){
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
