package solid.srp;

public class StorageService {

    public void saveStringToMemory(String str) {
        encodeForStorage(str);
        System.out.println("Storing string in memory: " + str);
    }

    private void encodeForStorage(String str) {
        System.out.println("Encoding string for storage: " + str);
    }
}
