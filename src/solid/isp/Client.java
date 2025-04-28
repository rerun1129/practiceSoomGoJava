package solid.isp;

public class Client {
    public static void main(String[] args) {
        InkjetPrinter inkjetPrinter = new InkjetPrinter();
        inkjetPrinter.print("Document 1");

        MonochromePrinter monochromePrinter = new MonochromePrinter();
        monochromePrinter.print("Document 2");

        LaserPrinter laserPrinter = new LaserPrinter();
        laserPrinter.print("Document 3");
    }
}
