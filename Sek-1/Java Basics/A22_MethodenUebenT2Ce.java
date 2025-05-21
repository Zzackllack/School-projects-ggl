import java.lang.Math.*;

public class A22_MethodenUebenT2Ce {

    public static void main(String[] args) {
    
        //Aufruf der Methode max
        int ergebnis = max(10, 20);
        System.out.println("Der größere Wert ist: " + ergebnis);
    
        //Aufruf der Methode min
        int ergebnis2 = min(10, 20);
        System.out.println("Der kleinere Wert ist: " + ergebnis2);
    
        //Aufruf der Methode identisch
        boolean sindIdentisch = identisch(10, 20);
        System.out.println("Die Zahlen sind identisch: " + sindIdentisch);
    
        //5) Schreibe/Definiere die Methode main, in der...
        // Drei Integer x, y, z mithilfe der Methode random() definieren
        int x = (int) (Math.random() * 100);
        int y = (int) (Math.random() * 100);
        int z = (int) (Math.random() * 100);
    
        // Drei Integer x, y, z unsortiert ausgeben
        System.out.println("Unsortierte Werte: x = " + x + ", y = " + y + ", z = " + z);
    
        // Drei Integer min, med, max deklarieren
        int min, med, max;
    
        // Aufruf der Methode max aus 1) mit den Werten x, y
        max = max(x, y);
        System.out.println("Größerer Wert zwischen x und y: " + max);
    
        // Aufruf der Methode min aus 2) mit den Werten y, z
        min = min(y, z);
        System.out.println("Kleinerer Wert zwischen y und z: " + min);
    
        // Aufruf der Methode identisch aus 3) mit den Werten x, z
        boolean sindIdentisch1 = identisch(x, z);
        System.out.println("Sind x und z identisch: " + sindIdentisch1);
    }

    //1) Schreibe/Definiere eine Methode max, die zwei integer übergeben bekommt und den größeren zurückliefert.
    public static int max(int z1, int z2) {
        if (z1 > z2) {
            return z1;
        } else {
            return z2;
        }
    }

    //2) Schreibe/Definiere eine Methode min, die zwei integer übergeben bekommt und den kleineren zurückliefert. 
    public static int min(int z1, int z2) {
        if (z2 > z1) {
            return z1;
        } else {
            return z2;
        }
    }

    //3) Schreibe/Definiere eine Methode identisch, die zwei integer übergeben bekommt und zurückliefert, ob die Zahlen identisch sind. 
    public static boolean identisch(int z1, int z2) {
        if (z1 == z2) {
            return true;
        } else {
            return false;
        }
    }
}