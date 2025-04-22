package chapter08._1interface.game;

public class Healer {
    private Bracelet bracelet;

    public void equipBracelet(Bracelet bracelet) {
        this.bracelet = bracelet;
    }

    public void attackBracelet() {
        System.out.println("Healer attack with Bracelet!");
    }

    public void heal() {
        System.out.println("heal!");
    }
}
