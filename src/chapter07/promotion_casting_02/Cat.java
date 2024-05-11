package chapter07.promotion_casting_02;

public class Cat extends Animal {
    public Cat ( String speciesName ) { super ( speciesName ); }

    @Override
    public String growl ( ) {
        return "야옹~";
    }
}
