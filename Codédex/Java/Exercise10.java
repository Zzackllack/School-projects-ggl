import java.util.Scanner;

public class Exercise10 {
    public static void main(String[] args) {
        System.out.println("How many coins do you have?");
        Scanner scanner = new Scanner(System.in);
        int coins = scanner.nextInt();
        double inusd = coins / 0.0045;
        System.out.println("You have " + coins + " coins." + " That is equivalent to $" + inusd + " USD.");
    }
}
