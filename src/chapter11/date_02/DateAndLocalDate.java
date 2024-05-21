package chapter11.date_02;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.TimeZone;

public class DateAndLocalDate {
    /**
     * 자바 8에서 Date 타입 대신에 LocalDate 가 생겨나게 된 이유
     *
     * 1. 설계 결함
     * java.util.Date 클래스는 잘못 설계된 부분이 많다. 예를 들어, Date 클래스는 실제로 날짜와 시간을 모두 포함하지만, java.sql.Date는 날짜만 포함하고 java.sql.Time은 시간만 포함하여 일관성이 없습니다.
     *
     * 2. 변경 불가능성 (Immutability)
     * Date 객체는 변경 가능한(mutable) 객체로 설계되었다. 이는 멀티스레드 환경에서 동기화 문제를 일으킬 수 있다. 반면 LocalDate 등 java.time 패키지의 클래스들은 변경 불가능(immutable)하게 설계되어 이러한 문제를 피할 수 있다.
     *
     * 3. 명확한 API 설계
     *
     * Date 클래스의 메서드들은 직관적이지 않고 사용하기 어려웠다. 많은 메서드들이 폐기(deprecated)되었고, 사용자가 직접 보완해야 할 부분이 많았다. LocalDate는 더 명확하고 직관적인 API를 제공하여 사용성이 개선되었다.
     *
     * 4. 타입 안전성:
     * LocalDate, LocalTime, LocalDateTime 등의 클래스들은 더 구체적인 타입을 제공하여 타입 안전성을 향상시켰다. 이로 인해 실수로 인한 버그가 줄어들게 되었다.
     *
     * 5.표준화된 시간대 및 캘린더 시스템 지원:
     * Date 클래스는 기본적으로 UTC 기반으로 작동하며, 시간대나 다양한 캘린더 시스템을 제대로 지원하지 못했다. java.time 패키지의 클래스들은 이러한 요구사항을 충족하며, 특히 ZonedDateTime 클래스는 시간대 정보를 포함하여 처리할 수 있다.
     *
     * */


    public static void main ( String[] args ) {
        //1. 설계 결함
        Date dateOld = new Date ( 2024, 4, 21);  // 연도는 1900을 기준으로, 월은 0부터 시작
        System.out.println("Date: " + dateOld);  // 출력: Date: Tue May 21 00:00:00 GMT 3924

        LocalDate dateNew = LocalDate.of ( 2024, 5, 21 );
        System.out.println("LocalDate: " + dateNew);  // 출력: LocalDate: 2024-05-21

        //2. 불변성
        Date dateMutable = new Date();
        System.out.println("Original Date: " + dateMutable);
        dateMutable.setTime(dateMutable.getTime() + 1000000000);  // Date 객체를 변경
        System.out.println("Modified Date: " + dateMutable);

        LocalDate dateImmutable1 = LocalDate.now();
        System.out.println("Original LocalDate: " + dateImmutable1);
        LocalDate dateImmutable2 = dateImmutable1.plusDays(10);  // 새로운 LocalDate 객체를 반환 (소스 코드를 찾아 들어가보기)
        System.out.println("Modified LocalDate: " + dateImmutable2);

        //3. 명확한 설계
        Date dateAmbiguous = new Date();
        System.out.println("Year: " + (dateAmbiguous.getYear() + 1900));  // 연도는 1900을 더해야 함
        System.out.println("Month: " + dateAmbiguous.getMonth());  // 월은 0부터 시작
        System.out.println("Day: " + dateAmbiguous.getDate());

        LocalDate dateObvious = LocalDate.now();
        System.out.println("Year: " + dateObvious.getYear());
        System.out.println("Month: " + dateObvious.getMonthValue());
        System.out.println("Day: " + dateObvious.getDayOfMonth());

        //4. 타입 안전성
        Date dateUnsafe = new Date(); //Date 인데 시간 타입과 날짜 타입 모두 반환한다.
        processDate(dateUnsafe);
        processDateTime(dateUnsafe);

        LocalDate dateSafe = LocalDate.now();
        processDate(dateSafe);

        LocalDateTime dateTimeSafe = LocalDateTime.now();
        processDateTime(dateTimeSafe);  // 타입 혼동이 없음

        //5. 시간대 지원

        Date dateUnSupport = new Date();
        TimeZone timeZone = TimeZone.getTimeZone ( "America/New_York" );
        System.out.println("Date: " + dateUnSupport);
        System.out.println("TimeZone: " + timeZone.getDisplayName());
        // Date 클래스 자체는 시간대 정보를 포함하지 않음

        ZonedDateTime dateTimeSupport = ZonedDateTime.now ( ZoneId.of ( "America/New_York" ) );
        // ZonedDateTime 은 자기 자신이 시간대 정보를 포함할 수 있음
        System.out.println("ZonedDateTime: " + dateTimeSupport);

    }

    public static void processDate(Date date) {
        System.out.println("Processing date: " + date);
    }

    public static void processDateTime(Date date) {
        System.out.println("Processing date and time: " + date);
    }

    public static void processDate(LocalDate date) {
        System.out.println("Processing date: " + date);
    }

    public static void processDateTime ( LocalDateTime dateTime ) {
        System.out.println("Processing date and time: " + dateTime);
    }
}
