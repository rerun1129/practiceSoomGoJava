package chapter10._03_exceptionpractice.ex3.exception;

public class SendExceptionV3 extends NetworkClientExceptionV3 {

    private final String sendData;

    public SendExceptionV3(String sendData, String message) {
        super(message);
        this.sendData = sendData;
    }

    public String getSendData() {
        return sendData;
    }
}
