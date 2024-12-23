import java.util.Random;

public class Exercise14 {
    public static void main(String[] args) {
        Random random = new Random();
        int weight = random.nextInt(100);
        int height = random.nextInt(240);

        if (weight > 40 && height > 120) {
            System.out.println("Congrats! You can ride!");
        } else {
            System.out.println("Sorry, You can't ride today.");
        }
    }

}