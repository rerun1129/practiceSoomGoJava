package solid.ocp;

public class WireEarphone implements SoundDevices {

    public void connect() {
        System.out.println("Wire earphone connected.");
    }

    @Override
    public boolean testConnect() {
        //AUX 포트에 연결되었는지 체크하는 로직
        return true;
    }

    public boolean adjustVolume(boolean isAdjusted) {
        boolean result = detectClick(isAdjusted);
        System.out.println("Volume adjusted." + result);
        return result;
    }

    private boolean detectClick(boolean isClicked) {
        if (isClicked) {
            System.out.println("Click detected.");
            return true;
        } else {
            System.out.println("No click detected.");
            return false;
        }
    }
}
