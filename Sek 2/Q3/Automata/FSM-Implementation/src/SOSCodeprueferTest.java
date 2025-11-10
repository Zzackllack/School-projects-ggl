public class SOSCodeprueferTest {

    public static void main(String[] args) {
        SOSCodepruefer pruefer = new SOSCodepruefer();

        String[] testfaelle = {
            "#...---...#",     // korrektes SOS
            "#..--..--#",      // falsch
            "#...---..#",      // unvollständig
            "#-...---...#",    // anderes Zeichen davor
            "#...---...--..#", // Zeichen danach
            "#",              // leerer String
        };

        for (String text : testfaelle) {
            boolean ergebnis = pruefer.wortUntersuchen(text);
            System.out.println("Eingabe: \"" + text + "\" → SOS erkannt: " + ergebnis);
        }
    }
}