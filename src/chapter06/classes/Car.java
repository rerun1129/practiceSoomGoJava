package chapter06.classes;

public class Car extends Machine {
    String model;
    int speed;

    Engine engine;//Composition
    SteeringWheel steeringWheel;
    Tire tire;

    public Car ( String color, int size, String model, int speed ) {
        super ( color, size );
        this.model = model;
        this.speed = speed;
    }


    @Override
    public void machineName(){
        System.out.println ( "자동차" );
    }
}
