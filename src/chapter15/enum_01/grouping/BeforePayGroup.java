package chapter15.enum_01.grouping;

public class BeforePayGroup {
    /**
     * 예를 들어 결제라는 데이터는 결제 종류와 결제 수단이라는 2가지 형태로 표현됨
     * 신용카드 결제는 신용카드 결제라는 결제 수단 + 카드라는 결제 종류로 정의됨
     * */

    public static String getPayGroup(String payCode) {
        if("ACCOUNT_TRANSFER".equals(payCode) || "REMITTANCE".equals(payCode) || "ON_SITE_PAYMENT".equals(payCode) || "TOSS".equals(payCode)) {
            //계좌 이체                             무통장 입금                        현장 결제                            토스 페이
            return "CASH";
        } else if("PAYCO".equals(payCode) || "CARD".equals(payCode) || "KAKAO_PAY".equals(payCode)) {
            //     페이코                       카드                       카카오 페이
            return "CARD";
        } else if("POINT".equals(payCode) || "COUPON".equals(payCode)) {
            //     포인트                       쿠폰
            return "ETC";
        } else {
            return "EMPTY";
        }
    }

    /**
     * 위의 코드의 문제는
     *
     * 1. 둘의 관계를 파악하기가 어렵다.
     *    a. 현재는 결제종류가 결제수단을 포함하고 있는 관계인데, 메소드만으로 표현이 불가능.
     * 2. 입력값과 결과값이 메서드 사용부에서 예측 불가능하다.
     *    a. 결제 수단의 범위를 지정할수 없어서 문자열이면 전부 파라미터로 전달 될 수 있으므로 오타가 발생했을 시에는 모두 EMPTY로 리턴.
     *    b. 마찬가지로 결과를 받는 쪽에서도 문자열을 받기 때문에 결제종류로 지정된 값만 받을 수 있도록 검증코드가 필요
     * 3. 그룹별 기능을 추가하기가 어렵다.
     *    a. 결제 종류에 따라 추가 기능이 필요할 경우 현재 상태라면 어떻게 구현해야 할까?
     *    b. 또다시 결제종류에 따른 if문으로 메소드를 실행하는 코드를 작성?
     * */


    //3.a. 문제의 예시 메서드들
    public static String pushPayGroup(String payCode) { //push 메세지를 출력해주는 메서드
        if("CASH".equals ( payCode )) {
            return "현금 결제 시 푸시 알림";
        } else if( "CARD".equals(payCode)) {
            return "카드 결제 시 푸시 알림";
        } else if("ETC".equals(payCode)) {
            return "기타 수단 결제 시 푸시 알림";
        } else {
            throw new IllegalStateException ( "존재하지 않는 payCode 입니다." );
        }
    }

    public static String refundPayGroup(String payCode) { //환불 처리를 해주는 메서드
        if("CASH".equals ( payCode )) {
            return "현금 결제 시 환불 처리 프로세스";
        } else if( "CARD".equals(payCode)) {
            return "카드 결제 시 환불 처리 프로세스";
        } else if("ETC".equals(payCode)) {
            return "기타 수단 결제 시 환불 처리 프로세스";
        } else {
            throw new IllegalStateException ( "존재하지 않는 payCode 입니다." );
        }
    }
    /**
     * 위와 같은 코드가 계속 추가되어야 하는가?
     * */
}
