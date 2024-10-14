public class Car implements Auto {
    boolean engineAn = false;

    public void startEngine() {
        engineAn = true;
        System.out.println("Engine started.");
    }

    public void stopEngine() {
        engineAn = false;
        System.out.println("Engine stopped.");
    }

    public void printEngineStatus() {
        System.out.println("Engine is " + (engineAn? "on" : "off"));
    }
}
