package chapter06._1classes;

public class Machine {
    String color;
    int size;

    public Machine ( String color, int size ) {
        this.color = color;
        this.size = size;
    }

    public void machineName(){
        System.out.println ( "일반 기계" );
    }

    public void machineColor(){
        System.out.println ( color );
    }
}
