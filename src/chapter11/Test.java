package chapter11;

public class Test {
    public static void main ( String[] args ) {
        int a = 5;
        int b = 10;
        int c = 20;

        int result = a * b * c;

        int sum = 0;
        for ( int i = 0; i < 4; i++ ) {
            sum += i;
        }

        System.out.println ( "Result: " + result );
        System.out.println ( "Sum: " + sum );
    }
}
