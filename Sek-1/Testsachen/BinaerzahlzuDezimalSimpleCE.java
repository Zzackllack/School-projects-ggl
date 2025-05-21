public class BinaerzahlzuDezimalSimpleCE {
    public static void main(String[] args) {
        String binäreZahl = "1011"; // Beispiel-Binärzahl

        int dezimalZahl = Integer.parseInt(binäreZahl, 2);
        System.out.println("Die Dezimalzahl von " + binäreZahl + " ist " + dezimalZahl);
    }
}
