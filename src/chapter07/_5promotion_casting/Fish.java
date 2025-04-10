package chapter07._5promotion_casting;

public class Fish extends Animal {
    public Fish ( String speciesName ) { super ( speciesName ); }

    @Override
    public String growl ( ) {
        return "물고기는 울 수 없습니다 ;)";
    }
}
