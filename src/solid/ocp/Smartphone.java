package solid.ocp;

import java.util.ArrayList;
import java.util.List;

public class Smartphone {
    private final List <Object> devices;

    public Smartphone() {
        devices = new ArrayList <>();
    }

    public void addDevice(Object device) {
        if(device instanceof WireEarphone wireEarphone) {
            //AUX 포트에 연결되었는지 체크하는 로직
            devices.add(wireEarphone);
            System.out.println("Wire Device added: " + device.getClass().getName());
        } else if(device instanceof Buds1 buds1) {
            //블루투스 연결 체크하는 로직
            devices.add(buds1);
            System.out.println("Wireless Device added: " + device.getClass().getName());
        }
    }

    public void removeDevice(Object device) {
        devices.remove(device);
    }
}
