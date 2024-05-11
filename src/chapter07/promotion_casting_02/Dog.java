package chapter07.promotion_casting_02;

public class Dog extends Animal {
    public Dog ( String speciesName ) { super ( speciesName ); }

    @Override
    public String growl ( ) {
        return "왈왈!";
    }

    public void walk(Animal animal){
        System.out.println ( animal.getSpeciesName() + "는 산책하며 즐거워합니다." );
    }
}
