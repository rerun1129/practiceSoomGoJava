package solid.ocp;

public class WireEarphone {

    public void connect() {
        System.out.println("Wire earphone connected.");
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
