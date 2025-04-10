package chapter15._1enum.grouping;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static chapter15._1enum.grouping.PayType.*;

public enum AfterPayGroup {
    /**
     * PayType 열거형을 추가함으로써 문자열 입력으로 인한 오타 문제 발생이 제거됨
     * */
    CASH("현금", Arrays.asList(ACCOUNT_TRANSFER, REMITTANCE, ON_SITE_PAYMENT, TOSS), "현금 결제가 완료되었습니다!"),
    CARD("카드", Arrays.asList(PAYCO, PayType.CARD, KAKAO_PAY), "카드 결제가 완료되었습니다!"),
    ETC("기타", Arrays.asList(POINT, COUPON), "기타 결제가 완료되었습니다!"),
    EMPTY( "없음", Collections.EMPTY_LIST, "잘못된 결제 수단입니다!");

    private final String title;
    private final List<PayType> payList;
    private final String pushAlarm;

    AfterPayGroup (String title, List <PayType> payList, String pushAlarm ) {
        this.title = title;
        this.payList = payList;
        this.pushAlarm = pushAlarm;
    }

    /**
     * 열거형을 손쉽게 순회할 수 있게 됨으로써 비효율적인 if문 분기 체크를 통한 실행 메서드 선택이 아닌
     * 단순한 Stream API 사용으로 추가 메서드 구현이 간결해지고 상태와 행위의 관리도 깔끔하게 정리됨
     * */
    public static AfterPayGroup findByPayCode(PayType payType) {
        return Arrays.stream ( AfterPayGroup.values ( ) )
                     .filter(payGroup -> payGroup.hasPayCode(payType))
                     .findAny()
                     .orElse(EMPTY);
    }

    public static String pushByPayCode(PayType payType) {
        return findByPayCode(payType).pushAlarm;
    }

    public boolean hasPayCode(PayType payType) {
        return payList.stream().anyMatch(pay -> pay == payType);
    }

    public String getTitle() {
        return title;
    }

}
