package chapter14.inputoutput_01;

import java.io.*;

public class CharacterStreams {
    public static void main ( String[] args ) throws IOException {
        write ();
        read ();
    }

    /**
     * try-with-resources
     * 자바 7에서 도입된 기능으로 리소스를 사용한 후 명시적으로 닫을 필요 없이 자동으로 닫아주는 구문
     * 이 기능은 주로 파일 I/O, 네트워크 소켓 등 자원을 사용하고 난 후 자원을 명확히 해제하는 데 사용
     * 이를 통해 자원 누수를 방지하고 코드의 가독성을 높일 수 있음
     * 또한 하나의 리소스가 아닌 복수의 리소스를 try 블록에 선언하여 사용할 수도 있음
     *
     * - 장점
     *   - 자원 누수 방지: 명시적으로 자원을 닫지 않아도 되어 자원 누수를 방지
     *   - 코드 가독성 향상: finally 블록에서 자원을 닫는 코드를 작성할 필요가 없어 코드가 간결해짐
     *   - 안전한 예외 처리: 여러 리소스를 사용하는 경우에도 각각의 자원에 대한 예외 처리가 자동으로 이루어짐
     *
     * */
    public static void write() {
        try(Writer writer1 = new FileWriter ( "test_char1.txt" ); Writer writer2 = new FileWriter ( "test_char2.txt" )){
            writer1.write ( 'A' );
            writer1.write ( 'B' );
            writer1.write ( 'C' );
            writer2.write ( '안' );
            writer2.write ( '녕' );
            writer2.write ( 'ㅎ' );
        }catch ( IOException e ){
            e.printStackTrace ();
        }
    }

    public static void read() {
        try(Reader reader1 = new FileReader ( "test_char1.txt" ); Reader reader2 = new FileReader ( "test_char2.txt" )){
            while ( true ) {
                int read1 = reader1.read ( ); //1byte 씩 읽기
                int read2 = reader2.read ( ); //1byte 씩 읽기
                if(read1 == -1) break; //-1이 리턴되면 EOF(End Of File)
                System.out.println ( (char) read1 );
                System.out.println ( (char) read2 );
            }
        }catch ( IOException e ){
            e.printStackTrace ();
        }
    }
}
