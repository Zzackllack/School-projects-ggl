public class Bacteria_growth {
    public static double bacteriaGrowth(int hours) {
        if (hours == 0) {
            return 300;
        } else {
            return 1.2 * bacteriaGrowth(hours - 1);
        }
    }

    public static void main(String[] args) {
        int hours = 24;
        double bacteriaCount = bacteriaGrowth(hours);
        System.out.println("Nach " + hours + " Stunden gibt es " + bacteriaCount + " Bakterien.");
    }
}
