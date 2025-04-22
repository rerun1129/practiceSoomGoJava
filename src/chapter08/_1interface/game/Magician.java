package chapter08._1interface.game;

public class Magician {
    private Staff staff;

    public void equipStaff(Staff staff) {
        this.staff = staff;
    }

    public void attackStaff() {
        System.out.println("Magician attack with Staff!");
    }

    public void fireball() {
        System.out.println("Fireball!");
    }
}
