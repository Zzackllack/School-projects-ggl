import java.util.Random;

public class Exercise12 {
    public static void main(String[] args) {
        Random random = new Random();
        boolean isCatOwner = random.nextBoolean();
        if (isCatOwner){
            System.out.println("20% off select cat items with code MEOW2025");
        } else {
            System.out.println("Welcome to the Pets Pets Pets store!");
        }
    }
}
