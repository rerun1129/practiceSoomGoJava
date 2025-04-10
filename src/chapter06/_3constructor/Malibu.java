package chapter06._3constructor;

public class Malibu extends Car {
    String model;
    String color;
    int speed;

    public Malibu ( String model, String color, int speed ) {
        super ( model, color, speed );
        this.model = model;
        this.color = color;
        this.speed = speed;
    }
}
