package chapter14.substream_02.buffer;

import java.io.*;

public class NonBufferVsBufferExample {
    public static void main(String[] args) {
//        copyNonBuffer();
        copyWithBuffer();
    }

    public static void copyWithBuffer () {
        try(FileInputStream fis = new FileInputStream( "employees.zip");
            FileOutputStream fos = new FileOutputStream("targetFileBuffer.zip");
            BufferedInputStream bis = new BufferedInputStream( fis);
            BufferedOutputStream bos = new BufferedOutputStream( fos)) {
            double bufferTime = copy(bis, bos);
            System.out.println("버퍼를 사용했을 때:\t\t" + bufferTime + "초");
        }catch ( IOException e ){
            e.printStackTrace();
        }
    }

    public static void copyNonBuffer () {
        try(FileInputStream fis = new FileInputStream("employees.zip");
            FileOutputStream fos = new FileOutputStream("targetFileNonBuffer.zip")) {
            double nonBufferTime = copy(fis, fos);
            System.out.println("버퍼를 사용하지 않았을 때:\t" + nonBufferTime + "초");
        }catch ( IOException e ){
            e.printStackTrace();
        }
    }

    static int data = -1;
    public static double copy ( InputStream is, OutputStream os ) throws IOException {
        long start = System.nanoTime();
        while(true) {
            data = is.read();
            if(data == -1) break;
            os.write(data);
        }
        os.flush();
        long end = System.nanoTime();
        return (end-start) * 0.000000001;
    }
}
