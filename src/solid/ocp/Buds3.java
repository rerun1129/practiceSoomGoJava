package solid.ocp;

public class Buds3 implements SoundDevices {
    public void connect() {
        System.out.println("Buds2 connected.");
    }

    @Override
    public boolean testConnect() {
        //블루투스 연결 체크하는 로직
        return true;
    }

    public boolean adjustVolume(boolean isAdjusted) {
        boolean result = detectTouch(isAdjusted);
        System.out.println("Volume adjusted." + result);
        return result;
    }

    private boolean detectTouch(boolean isTouched) {
        if (isTouched) {
            System.out.println("Touch detected.");
            return true;
        } else {
            System.out.println("No touch detected.");
            return false;
        }
    }
}
