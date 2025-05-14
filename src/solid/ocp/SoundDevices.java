package solid.ocp;

public interface SoundDevices {
    void connect();
    boolean testConnect();
    boolean adjustVolume(boolean isAdjusted);
}
