public class Verkehrskontrolle {
    private Queue<Fahrzeug> kolonneQueue;
    private int fahrzeugInKolonne;
    
    private Queue<Fahrzeug> kontrollQueue;
    private int fahrzeugInKontrolle;

    public Verkehrskontrolle() {
        kolonneQueue = new Queue<>();
        fahrzeugInKolonne = 0;

        kontrollQueue = new Queue<>();
        fahrzeugInKontrolle = 0;
    }

    public void kolonneAufloesen() {
        while (!kolonneQueue.isEmpty()){
            // kolonneQueue.front(); unnötig, returnt das erste Element, wir müssen nicht nach vorne navigieren wie bei einem Array, da wir mit einer Queue arbeiten, die automatisch das erste Element entfernt, wenn wir dequeue() aufrufen
            kolonneQueue.dequeue();
            fahrzeugInKolonne--;
        }
    }

    public void herrauswinken() {
        if (!kolonneQueue.isEmpty()) {
            Fahrzeug aktuellesFahrzeug = kolonneQueue.front();
            kolonneQueue.dequeue();
            kontrollQueue.enqueue(aktuellesFahrzeug);
            fahrzeugInKontrolle++;
            fahrzeugInKolonne--;
        } else {
            System.out.println("Keine Fahrzeuge mehr in der Kolonne!");
        }
    }
}
