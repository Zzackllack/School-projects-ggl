public class BicycleRace {
    public static void main(String[] args) {
        ACMEBicycle bike = new ACMEBicycle();
        bike.changeCadence(50);
        bike.speedUp(10);
        bike.changeGear(2);
        bike.applyBrakes(5);

        System.out.println("Bike current state:");
        bike.printStates();
    }
    
}
