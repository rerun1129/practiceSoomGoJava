package solid.srp;

import static solid.srp.EncodeService.encodeForStorage;

public class StorageService {

    public void saveStringToMemory(String str) {
        encodeForStorage(str);
        System.out.println("Storing string in memory: " + str);
    }
}
