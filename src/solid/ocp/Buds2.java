package solid.ocp;

public class Buds2 {
    public void connect() {
        System.out.println("Buds2 connected.");
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
