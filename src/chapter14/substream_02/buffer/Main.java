package chapter14.substream_02.buffer;

import java.io.*;

public class Main {
    public static void main ( String[] args ) {
        write ( "안녕하세요!" );
        System.out.println ( read ( ) );
    }

    public static void write(String str){
        try( FileOutputStream fos = new FileOutputStream( "test_string1.txt") ){
            Writer writer = new OutputStreamWriter ( fos );
            writer.write ( str );
            writer.flush ();
        }catch ( IOException e ){
            e.printStackTrace();
        }
    }
    public static String read(){
        try( FileInputStream fis = new FileInputStream( "test_string1.txt") ){
            Reader reader = new InputStreamReader ( fis );
            char[] buffer = new char[1024];
            int read = reader.read ( buffer );
            return new String( buffer, 0, read );
        }catch ( IOException e ){
            e.printStackTrace();
        }
        return null;
    }
}
