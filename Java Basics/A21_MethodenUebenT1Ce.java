import java.lang.Math.*;

public class A21_MethodenUebenT1Ce
{
  // hier in main werden die Methoden aufgerufen / verwendet
  public static void main (String[] args)
  {
    //Definition von drei Ganzzahlen, einem String und einem Boolean
    
    System.out.println("\nAufgabe 1)");
    // 1a) Aufruf der Methode "... ausgabe()" aus 1)
        // Aufruf der Methode ausgabe
        ausgabe();
    
    System.out.println("\nAufgabe 2)");
    // 2a) Aufruf der Methode "... ausgabe(String text)" 
    // Aufruf diesmal mit der Uebergabe eines Strings fuer die Ausgabe
        ausgabe("Hallo, das ist ein Test.");

    System.out.println("\nAufgabe 3)");
    // 3a) Aufruf der Methode "... ausgabe(int zahl)"
    // Aufruf diesmal mit einer zu uebergebenen Zahl, die ausgegeben werden soll
        ausgabe(123);

    System.out.println("\nAufgabe 4)");
    // 4a) Aufruf der Methode "... ausgabe(boolean jaOderNein)"
    // Aufruf diesmal mit einem zu uebergebenen boolean, der ausgegeben werden soll
        ausgabe(true);
        ausgabe(false);
    
    System.out.println("\nAufgabe 5)");
    // 5a) Aufruf der Methode "...summe(int zahl1, int zahl2)"
        int ergebnis = summe(10, 20);
        System.out.println("Die Summe ist: " + ergebnis );

    System.out.println("\nAufgabe 6)");
    // 6a) Aufruf der Methode "...summe(int zahl1, int zahl2,zahl3)"
        int ergebnis1 = summe(10, 20, 30);
        System.out.println("Die Summe ist: " + ergebnis1);

    System.out.println("\nAufgabe 7)");
    // 7a) Aufruf der Methode "...summe(double zahl1, double zahl2)"
        double ergebnis2 = summe(10.5, 20.3);
        System.out.println("Die Summe ist: " + ergebnis2);
}
  
 
  // hier (nach main - aber innerhalb der Klasse [der geschweiften Klammern])
  // werden die anderen Methoden definiert
  

  // 1) Definiere eine Methode ausgabe, die "Hallo Welt!" ausgibt.
    public static void ausgabe() {
        System.out.println("Hallo Welt!");
    }

  // 2) Definiere eine Methode ausgabe, 
  // die einen String uebergeben bekommt, um diesen auszugeben.
    public static void ausgabe(String text) {
        System.out.println(text);
    }

  // 3) Definiere eine Methode ausgabe, 
  // die einen integer uebergeben bekommt, um diesen auszugeben. 
    public static void ausgabe(int zahl) {
        System.out.println(zahl);
    }
  
  // 4) Definiere eine Methode ausgabe, 
  // die einen boolean uebergeben bekommt, um diesen auszugeben. 
    public static void ausgabe(boolean wert) {
        System.out.println(wert);
    }
  
  // 5) Definiere eine Methode summe, 
  // die zwei integer uebergeben bekommt, deren Summe berechnet und zurueckliefert. 
    public static int summe(int zahl1, int zahl2) {
        return zahl1 + zahl2;
    }
     
  // 6) Definiere eine Methode summe, 
  // die drei integer uebergeben bekommt, deren Summe berechnet und zurueckliefert. 
    public static int summe(int zahl1, int zahl2, int zahl3) {
        return zahl1 + zahl2 + zahl3;
    }
  
  // 7) Definiere eine Methode summe, 
  // die zwei double uebergeben bekommt, deren Summe berechnet und zurueckliefert. 
    public static double summe(double zahl1, double zahl2) {
        return zahl1 + zahl2;
    }

  // returns a number between 0 and 99
  public static int random()
  {
    return( (int)Math.round(100*Math.random()) );
  }
}