import java.util.Scanner;

public class A13_FakultaetBerechnenCe {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geben Sie eine Zahl ein: ");
        int zahl = scanner.nextInt();

        int fakultaet = 1;
        for (int i = 1; i <= zahl; i++) {
            fakultaet = fakultaet * i;
        }

        System.out.println("Die Fakultät von " + zahl + " ist: " + fakultaet);
    }
}
