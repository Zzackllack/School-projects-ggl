public class BinaerAdditionCE {
    public static void main(String[] args) {
        // Ändere hier die Binärzahlen, die du addieren möchtest
        String binary1 = "1101"; // Beispiel-Binärzahl 1
        String binary2 = "1011"; // Beispiel-Binärzahl 2

        // Konvertiere die Binärzahlen in Dezimalzahlen
        int decimal1 = binaryToDecimal(binary1);
        int decimal2 = binaryToDecimal(binary2);

        // Addiere die Dezimalzahlen
        int sum = decimal1 + decimal2;

        // Gib die Ergebnisse aus
        System.out.println("Die Dezimalzahl von " + binary1 + " ist: " + decimal1);
        System.out.println("Die Dezimalzahl von " + binary2 + " ist: " + decimal2);
        System.out.println("Die Summe der beiden Dezimalzahlen ist: " + sum);
    }

    // Methode zur Konvertierung einer Binärzahl in eine Dezimalzahl
    public static int binaryToDecimal(String binary) {
        int decimal = 0;
        int length = binary.length();

        // Durchlaufe jeden Charakter in der Binärzeichenfolge
        for (int i = 0; i < length; i++) {
            // Bestimme den Wert des aktuellen Zeichens ('0' oder '1')
            char currentChar = binary.charAt(length - 1 - i);

            // Wenn das Zeichen '1' ist, füge den entsprechenden Wert zur Dezimalzahl hinzu
            if (currentChar == '1') {
                decimal += Math.pow(2, i);
            }
        }

        return decimal;
    }
}
