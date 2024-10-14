public class BicycleRace {
        public static void main(String[] args) {
        ACMEBicycle bike = new ACMEBicycle();
        bike.changeCadence(50);
        bike.changeGear(2);
        bike.speedUp(10);
        bike.applyBrakes(2);
        bike.printStatus();
    }
}
