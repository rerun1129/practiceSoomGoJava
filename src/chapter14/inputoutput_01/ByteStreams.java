package chapter14.inputoutput_01;

import java.io.*;

public class ByteStreams {
    public static void main ( String[] args ) throws IOException {
        write ();
        read ();
    }

    public static void write() throws IOException {
        OutputStream os = new FileOutputStream ( "test.txt" );

        os.write ( 10 );
        os.write ( 20 );
        os.write ( 30 );

        os.flush ();
        os.close (); //자원을 돌려주는 메서드이기 때문에 자원 관리를 위해서는 선언해줘야 함
    }

    public static void read() throws IOException {
        InputStream is = new FileInputStream ( "test.txt" );
        while ( true ) {
            int read = is.read ( ); //1byte 씩 읽기
            if(read == -1) break; //-1이 리턴되면 EOF(End Of File)
            System.out.println ( read );
        }

        is.close ();
    }
}
