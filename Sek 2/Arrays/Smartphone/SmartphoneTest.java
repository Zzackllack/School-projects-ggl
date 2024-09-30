public class SmartphoneTest {
    private Smartphone[] smartphonearray;

    public static void main(String[] args) {
        // c) Testen des Konstruktors und Ausgabe der Attribute
        Smartphone smartphone1 = new Smartphone("OnePlus", "Nord", 256);
        Smartphone smartphone2 = new Smartphone("Apple iPhone", "16 Pro", 256);

        System.out.println("Smartphone 1: " + smartphone1.getHersteller() + " " + smartphone1.getModell() + " " + smartphone1.getSpeicher() + "GB");
        System.out.println("Smartphone 2: " + smartphone2.getHersteller() + " " + smartphone2.getModell() + " " + smartphone2.getSpeicher() + "GB");

        // d) Deklaration des Arrays und Speichern der Objekte
        Smartphone[] smartphonearray = new Smartphone[3];
        smartphonearray[0] = smartphone1;
        smartphonearray[1] = smartphone2;
        smartphonearray[2] = new Smartphone("Samsung", "A-Series", 64); // Neues Objekt direkt im Array erstellen

        // Ausgabe bestimmter Attribute aus dem Array
        System.out.println("\nSmartphone im Array (Index 0): " + smartphonearray[0].getHersteller() + " " + smartphonearray[0].getModell());
        System.out.println("Smartphone im Array (Index 2): Speicher: " + smartphonearray[2].getSpeicher() + "GB");
    }
}
