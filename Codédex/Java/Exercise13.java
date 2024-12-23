import java.util.Random;

public class Exercise13 {
    public static void main(String[] args) {
        Random random = new Random();
        boolean isCatOwner = random.nextBoolean();
        boolean isDogOwner = random.nextBoolean();
        if (isCatOwner||isDogOwner){ 
            System.out.println("20% off select cat items with code 2025");
            } else if (isDogOwner){
                System.out.println("Use the code WOOF for 20% off dog items.");
            } else if (isCatOwner) {
                System.out.println("Use the code MEOW for 20% off cat items.");
        } else {
            System.out.println("Welcome to the Pets Pets Pets store!");
        }
    }
}
