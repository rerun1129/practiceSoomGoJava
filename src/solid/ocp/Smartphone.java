package solid.ocp;

import java.util.ArrayList;
import java.util.List;

public class Smartphone {
    private final List <SoundDevices> devices;

    public Smartphone() {
        devices = new ArrayList <>();
    }

    public void addDevice(SoundDevices device) {
        if(device.testConnect()) {
            devices.add(device);
            System.out.println("Wire Device added: " + device.getClass().getName());
        }else {
            System.out.println("Device connection failed.");
        }
    }

    public void removeDevice(Object device) {
        devices.remove(device);
    }
}
