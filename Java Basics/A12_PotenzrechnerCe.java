import java.util.Scanner;

public class A12_PotenzrechnerCe {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geben Sie die Basis ein: ");
        int basis = scanner.nextInt();

        System.out.println("Geben Sie den Exponenten ein: ");
        int exponent = scanner.nextInt();

        int ergebnis = 1;

        // Für den Exponenten 0 ist das Ergebnis immer 1
        if (exponent == 0) {
            System.out.println("Das Ergebnis ist: " + ergebnis);
        } else {
            // Multiplikation durch wiederholte Addition
            // Schleife läuft exponent-Mal, Index i beginnt bei 0 und zählt hoch bis exponent - 1, jeder Durchlauf führt innere Schleife vollständig aus
            for (int i = 0; i < exponent; i++) {
                int summe = 0;
                //Schleife läuft basis-Mal, Index j beginnt bei 0 und zählt hoch bis basis - 1, In jedem Durchlauf wird summe um den Wert von ergebnis erhöht.
                for (int j = 0; j < basis; j++) {
                    summe = summe + ergebnis;
                }
                ergebnis = summe;
            }
            System.out.println("Das Ergebnis von " + basis + "^" + exponent + " ist: " + ergebnis);
        }
    }
}