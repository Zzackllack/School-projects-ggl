import java.util.Scanner;

public class Exercise09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("I speak without a mouth and hear without ears. I have no body, but I come alive with the wind. What am I?");
        String answer = scanner.nextLine();
        String correctAnswer = "Echo";
        
        if (answer.equalsIgnoreCase(correctAnswer)){
            System.out.println("Correct!");
        } else {
            System.out.println("Incorrect! The correct answer is Echo.");
        }
    }
}
