public class VerkehrskontrolleTest {
    public static void main(String[] args) {
        Verkehrskontrolle kontrolle = new Verkehrskontrolle();

        // Create some Fahrzeug objects
        Fahrzeug fahrzeug1 = new Fahrzeug();
        fahrzeug1.setModell("Modell A");
        fahrzeug1.setFarbe("Rot");
        fahrzeug1.setKennzeichen("ABC123");
        fahrzeug1.setVerkehrstauglich(true);

        Fahrzeug fahrzeug2 = new Fahrzeug();
        fahrzeug2.setModell("Modell B");
        fahrzeug2.setFarbe("Blau");
        fahrzeug2.setKennzeichen("DEF456");
        fahrzeug2.setVerkehrstauglich(false);

        // Add vehicles to the kolonne
        kontrolle.fahrzeugInDieKolonne(fahrzeug1);
        kontrolle.fahrzeugInDieKolonne(fahrzeug2);

        // Test kolonneAufloesen method
        kontrolle.kolonneAufloesen();
        System.out.println("Kolonne aufgelöst. Fahrzeuge in Kolonne: " + kontrolle.fahrzeugeInKolonne);

        // Add vehicles again to test herauswinken method
        kontrolle.fahrzeugInDieKolonne(fahrzeug1);
        kontrolle.fahrzeugInDieKolonne(fahrzeug2);

        // Test herauswinken method
        kontrolle.herauswinken();
        System.out.println("Ein Fahrzeug herausgewunken. Fahrzeuge in Kolonne: " + kontrolle.fahrzeugeInKolonne);
        System.out.println("Fahrzeuge in Kontrolle: " + kontrolle.fahrzeugeInKontrolle);
    }
}