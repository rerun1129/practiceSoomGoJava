package solid.srp;

public class EncodeService {

    public String encode(String str) {
        return str.replaceAll(" ", "%20");
    }

    public String decode(String str) {
        return str.replaceAll("%20", " ");
    }
}
