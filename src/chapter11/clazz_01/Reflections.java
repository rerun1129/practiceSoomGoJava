package chapter11.clazz_01;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflections {

    /**
     * 리플렉션의 시작은 Class<T>
     *
     * Class<T>에 접근하는 방법
     * 모든 클래스를 로딩 한 다음 Class<T>의 인스턴스가 생긴다. “타입.class”로 접근할 수 있다. 이 인스턴스는 heap 메모리에 들어가게 된다.
     * 모든 인스턴스는 getClass() 메소드를 가지고 있다. “인스턴스.getClass()”로 접근할 수 있다.
     * 클래스를 문자열로 읽어오는 방법
     *   - Class.forName(“Book”)
     *   - 클래스 경로에 해당 클래스가 없다면 ClassNotFoundException이 발생한다.
     * */

    /**
     * Class<T>를 통해 할 수 있는 것
     *  - 필드 (목록) 가져오기
     *  - 메소드 (목록) 가져오기
     *  - 상위 클래스 가져오기
     *  - 인터페이스 (목록) 가져오기
     *  - 어노테이션 가져오기
     *  - 생성자 가져오기
     * */

    /**
     * 리플렉션으로 필드 정보를 가져올때는 getField 메서드의 경우에는 public 제한자만 가져오기 때문에
     * 모든 필드의 정보를 가져오고 싶다면 getDeclaredFields를 사용해야 한다.
     *
     * 생성자나 기타 객체들도 마찬가지로 Declared 메서드를 통해서 접근 제한자의 구분 없이 가져올 수가 있게 된다.
     * */

    /**
     * 생성자로 인스턴스 만들기 -> Constructor.newInstance(params)
     * */

    /**
     * @ 필드 값 접근하기 및 설정하기(Declared 필드나 메서드 사용 권장)
     * - 특정 인스턴스가 가지고 있는 값을 가져오는 것이기 때문에 인스턴스가 필요하다.
     * - Field.get(object) -> 여기에서 object가 인스턴스 역할을 한다.
     * - Filed.set(object, value)
     * - Field.get(object)으로 Static 필드를 가져올 때는 object가 없어도 되니까 null을 넘기면 된다.
     * */

    /**
     * @ 메소드 실행하기
     * Method.invoke(object, params[배열 혹은 복수의 파라미터])
     * */

    /**
     * 리플렉션 사용시 주의점
     * - 지나친 사용은 성능 이슈를 야기할 수 있다. 반드시 필요한 경우에만 사용할 것
     * - 컴파일 타임에 확인되지 않고 런타임 시에만 발생하는 문제를 만들 가능성이 있다.
     * - 접근 지시자를 무시할 수 있다.
     * */

    public static void main ( String[] args ) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class <?> bookClass = Class.forName ( "chapter11.clazz_01.Book" ); //경로가 잘못되면 ClassNotFoundException
        Constructor <?> constructor = bookClass.getConstructor ( String.class, String.class, String.class );
        //파라미터 개수를 정확히 맞춰주지 않으면 NoSuchMethodException인데 여기서 NoSuchMethodException이 뜨는 이유는 생성자도 메서드 취급을 하기 때문이다.
        Book book = (Book) constructor.newInstance ( "a", "여기에 책이 있다.", "c" );
        System.out.println ( book.d );

        Field a = Book.class.getDeclaredField ( "a" ); //필드 변수명을 정확히 기입하지 않으면 NoSuchFieldException

        a.setAccessible ( true );//a는 private이기 때문에 접근제한을 풀어줄 수 있다.

        System.out.println ( a.get ( book ) );
        //book 객체에서 a 필드의 값을 가져온다. 초기화된 값인 book을 가져온다.
        // 일반적으로는 private 변수이기 때문에 접근이 불가능하지만 접근 제한을 풀었기 때문에 가능하다.
        // 만약 setAccessible을 true로 하지 않았다면 IllegalAccessException 이 발생한다.
        a.set ( book, "AAAAAA" ); //book 객체의 a 필드에 새로운 값을 쓴다
        System.out.println ( a.get ( book ) );




        Field b = Book.class.getDeclaredField ( "b" );
        b.setAccessible ( true );
        System.out.println ( b.get ( null ) ); //static 필드이기 때문에 인스턴스가 필요가 없다.
        b.set ( null, "BBBBB" );
        System.out.println ( b.get ( book ) );

        Method g = Book.class.getMethod ( "g" );
        g.invoke ( book );
    }

    /**
     * 이걸 어디에 사용하는가?
     *
     * 1. 스프링 DI(의존성 주입)
     * 2. Junit (자바 테스팅 프레임워크)
     * 3. 프록시에서의 추가 작업
     * 4. 스프링 시큐리티 등에서 사용되는 필터 클래스에서 전처리에 사용
     * */
}
