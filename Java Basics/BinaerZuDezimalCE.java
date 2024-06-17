public class BinaerZuDezimalCE {
    
    public static void main(String[] args) {
        // Hier die Binärzahl ändern
        String binaerZahl = "1011";  // Beispiel: 1011 (entspricht 11 in Dezimal)
        
        // Konvertierung der Binärzahl in eine Dezimalzahl
        int dezimalZahl = binaerZuDezimal(binaerZahl);
        
        // Ausgabe der Dezimalzahl
        System.out.println("Die Dezimalzahl von " + binaerZahl + " ist: " + dezimalZahl);
    }
    
    public static int binaerZuDezimal(String binaerZahl) {
        int dezimalZahl = 0;
        int laenge = binaerZahl.length();
        
        for (int i = 0; i < laenge; i++) {
            // Aktuelles Zeichen (0 oder 1) an der Position i
            char zeichen = binaerZahl.charAt(i);
            
            // Konvertiere das Zeichen in eine Zahl (0 oder 1)
            int zahl = Character.getNumericValue(zeichen);
            
            // Berechne den Wert dieser Stelle und addiere ihn zur Gesamtsumme
            dezimalZahl += zahl * Math.pow(2, laenge - 1 - i);
        }
        
        return dezimalZahl;
    }
}
