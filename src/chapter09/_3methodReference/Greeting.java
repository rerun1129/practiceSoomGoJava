package chapter09._3methodReference;

public class Greeting {
    private String hey;
    private String hey2;
    private String hey3;

    static String hi (String greet){
        return greet;
    }

    String hello (String greet){
        return greet;
    }

    public Greeting ( ) {
    }

    public Greeting ( String hey ) {
        this.hey = hey;
    }

    public Greeting ( String hey, String hey2 ) {
        this.hey = hey;
        this.hey2 = hey2;
    }

    public Greeting ( String hey, String hey2, String hey3 ) {
        this.hey = hey;
        this.hey2 = hey2;
        this.hey3 = hey3;
    }

    @Override
    public String toString ( ) {
        return "Greeting{" +
                "hey='" + hey + '\'' +
                ", hey2='" + hey2 + '\'' +
                ", hey3='" + hey3 + '\'' +
                '}';
    }
}
