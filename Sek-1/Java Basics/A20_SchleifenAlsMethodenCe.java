import java.util.Scanner;

public class A20_SchleifenAlsMethodenCe {

    public static void main(String[] args) {
        countdown(10);
        summe(5, 14); // Beispielwerte
        fakultaetBerechnen();
        potenzrechner();
    }

    public static void countdown(int startzahl) {
        System.out.println("Countdown:");
        for (int i = startzahl; i >= 0; i--) {
            System.out.println(i);
        }
        System.out.println();
    }

    public static void summe(int anfang, int ende) {
        int summe = 0;
        System.out.println("Summe der Zahlen von " + anfang + " bis " + ende + ":");
        for (int i = anfang; i <= ende; i++) {
            summe += i;
        }
        System.out.println("Summe = " + summe + "\n");
    }

    public static void fakultaetBerechnen() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geben Sie eine Zahl für die Fakultätsberechnung ein: ");
        int zahl = scanner.nextInt();

        int fakultaet = 1;
        for (int i = 1; i <= zahl; i++) {
            fakultaet *= i;
        }

        System.out.println("Die Fakultät von " + zahl + " ist: " + fakultaet);
    }

    public static void potenzrechner() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geben Sie die Basis für den Potenzrechner ein: ");
        int basis = scanner.nextInt();

        System.out.println("Geben Sie den Exponenten ein: ");
        int exponent = scanner.nextInt();

        int ergebnis = 1;
        if (exponent == 0) {
            System.out.println("Das Ergebnis ist: " + ergebnis);
        } else {
            for (int i = 0; i < exponent; i++) {
                int summe = 0;
                for (int j = 0; j < basis; j++) {
                    summe += ergebnis;
                }
                ergebnis = summe;
            }
            System.out.println("Das Ergebnis von " + basis + "^" + exponent + " ist: " + ergebnis);
        }
    }
}
