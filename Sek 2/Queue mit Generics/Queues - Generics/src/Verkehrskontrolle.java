import queues.Queue;

public class Verkehrskontrolle {
    public Queue<Fahrzeug> kolonneQueue;
    //STS: Field kolonneQueue can be final(hints(1): 4:29-4:41)
    int fahrzeugeInKolonne;
    //STS: The value of the field Verkehrskontrolle.fahrzeugeInKolonne is not usedJava(570425421)
    public Queue<Fahrzeug> kontrolleQueue; 
    //STS: Field kontrolleQueue can be final(hints(2): 6:29-6:43)
    public int fahrzeugeInKontrolle; 
    //STS: The value of the field Verkehrskontrolle.fahrzeugeInKontrolle is not usedJava(570425421)

    public Verkehrskontrolle() {
        kolonneQueue = new Queue<Fahrzeug>();
        //STS: Redundant type arguments in new expression (use diamond operator instead).(hints(3): 14:28-14:43)
        fahrzeugeInKolonne = 0;
        kontrolleQueue = new Queue<Fahrzeug>();
        //STS: Redundant type arguments in new expression (use diamond operator instead).(hints(4): 17:30-17:45)
        fahrzeugeInKontrolle = 0;
    }

    public void fahrzeugInDieKolonne(Fahrzeug pFahrzeug) {
        kolonneQueue.enqueue(pFahrzeug);
        fahrzeugeInKolonne++;
    }

    public void kolonneAufloesen() {
        while (!kolonneQueue.isEmpty()) {
            kolonneQueue.dequeue();
            fahrzeugeInKolonne--;
        }
    }

    public void herauswinken() {
        if (!kolonneQueue.isEmpty()) {
            Fahrzeug herausgewunkenesFahrzeug = kolonneQueue.front();
            kolonneQueue.dequeue();
            fahrzeugeInKolonne--;
            kontrolleQueue.enqueue(herausgewunkenesFahrzeug);
            fahrzeugeInKontrolle++;
        }
    }
}