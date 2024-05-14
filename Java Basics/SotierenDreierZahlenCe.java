import java.util.Scanner;

public class SotierenDreierZahlenCe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a, b, c;

        // Eingabeaufforderung für den Benutzer
        System.out.print("Bitte geben Sie die erste Zahl ein: ");
        a = scanner.nextInt();

        System.out.print("Bitte geben Sie die zweite Zahl ein: ");
        b = scanner.nextInt();

        System.out.print("Bitte geben Sie die dritte Zahl ein: ");
        c = scanner.nextInt();

        // Sortierung der Zahlen nur mit if-else
        if (a > b) {
            if (b > c) {
          
                    System.out.println("Sortierte Zahlen: " + a + ", " + b + ", " + c);
                }
            }
        }
    }