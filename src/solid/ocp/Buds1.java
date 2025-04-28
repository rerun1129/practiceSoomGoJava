package solid.ocp;

public class Buds1 {
    public void connect() {
        System.out.println("Buds1 connected.");
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
