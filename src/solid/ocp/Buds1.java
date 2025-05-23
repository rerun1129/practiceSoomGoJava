package solid.ocp;

public class Buds1 implements SoundDevices {
    public void connect() {
        System.out.println("Buds1 connected.");
    }

    @Override
    public boolean testConnect() {
        //블루투스 연결 체크하는 로직
        return true;
    }

    public boolean adjustVolume(boolean isAdjusted) {
        boolean result = detectPushBud(isAdjusted);
        System.out.println("Volume adjusted." + result);
        return result;
    }

    private boolean detectPushBud(boolean isPushed) {
        if (isPushed) {
            System.out.println("Push detected.");
            return true;
        } else {
            System.out.println("No push detected.");
            return false;
        }
    }
}
