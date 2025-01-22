public class ACMEBicycle implements Bicycle {
    int cadence = 0;
    int speed = 0;
    int gear = 1;
     
    public void changeCadence(int neuerwert) {
        neuerwert = cadence;
    }

    public void changeGear(int neuerwert) {
        neuerwert = gear;
    }

    public void speedUp(int increment) {
        speed += increment;
    }

    public void applyBrakes(int decrement) {
        speed -= decrement;
    }

    public void printStatus() {
        System.out.println("Cadence: " + cadence + ", Speed: " + speed + ", Gear: " + gear);
    } 
}
