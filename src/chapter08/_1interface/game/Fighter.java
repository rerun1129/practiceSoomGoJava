package chapter08._1interface.game;

public class Fighter {
    private Sword sword;

    public void equipSword(Sword sword) {
        this.sword = sword;
    }

    public void attackSword() {
        System.out.println("Fighter attack with Sword!");
    }

    public void bash() {
        System.out.println("bash!");
    }
}
