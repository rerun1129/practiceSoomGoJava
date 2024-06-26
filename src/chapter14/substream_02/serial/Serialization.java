package chapter14.substream_02.serial;

import java.io.*;

public class Serialization {
    /**
     * 직렬화 & 역직렬화
     * 자바에서의 직렬화(Serialization)는 객체를 바이트 스트림으로 변환하여 파일이나 네트워크 등을 통해 저장하거나 전송할 수 있도록 하는 과정
     * 직렬화된 객체는 이후에 역직렬화(Deserialization)를 통해 원래 객체로 복원하여 이를 통해 객체의 상태를 저장하거나 전송
     * 직렬화 및 역직렬화를 할 때는 대상 모델 클래스에 Serializable 인터페이스를 반드시 implement 해줘야 오류가 발생하지 않는다.
     *
     * 1. 직렬화
     *    - 객체의 상태를 바이트 스트림으로 변환하는 과정
     *    - 변환된 바이트 스트림은 파일에 저장하거나 네트워크를 통해 전송
     * 2. 역직렬화
     *    - 바이트 스트림을 다시 객체로 변환하는 과정
     *    - 이를 통해 저장되거나 전송된 객체를 다시 사용
     *
     * */

    public static void main(String[] args) {
        serialization();
        deserialization();
    }

    private static void deserialization ( ) {
        Person person = null;
        try ( FileInputStream fis = new FileInputStream( "person.ser");
              ObjectInputStream ois = new ObjectInputStream ( fis)) {
            person = (Person) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Person class가 없습니다.");
            e.printStackTrace();
        }

        System.out.println("역직렬화 중...");
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
//        System.out.println("address: " + person.getAddress ());
    }

    private static void serialization ( ) {
        Person person = new Person("John Doe", 30);
//        Person person = new Person("John Doe", 30, "LA");
        try ( FileOutputStream fileOut = new FileOutputStream("person.ser");
              ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(person);
            System.out.println("직렬화 데이터 저장 완료");
        } catch ( IOException e) {
            e.printStackTrace();
        }
    }
}
