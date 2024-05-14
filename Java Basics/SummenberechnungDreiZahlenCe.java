import java.util.Scanner;

public class SummenberechnungDreiZahlenCe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int summe = 0;

        System.out.println("Bitte geben Sie nacheinander drei Zahlen ein:");

        for (int i = 0; i < 3; i++) {
            System.out.print("Zahl " + (i + 1) + ": ");
            int zahl = scanner.nextInt();
            summe = summe + zahl;
        }

        System.out.println("Die Summe der eingegebenen Zahlen ist: " + summe);

        scanner.close();
    }
}