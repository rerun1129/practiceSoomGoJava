package chapter07._5promotion_casting;

public class Animal {
    private String speciesName;

    public Animal ( String speciesName ) { this.speciesName = speciesName; }

    public String getSpeciesName ( ) {
        return speciesName;
    }

    public String growl ( ){
        return "(반응이 없다.)";
    }

    public void inCage( Animal animal ) {
        System.out.println ( animal.speciesName + "을(를) 성공적으로 우리에 가뒀습니다!" );
    }
}
