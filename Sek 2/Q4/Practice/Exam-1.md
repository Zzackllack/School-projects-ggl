# Klausur Nr. 1 WPF Informatik - Beispiel/Zum Üben

## Aufgabe 1: Fehler finden

```java
import java.util.Scanner;

public class AltersKontrolle {
    public static void main (String[] args) {
        Scanner sc1= new Scanner(System.in);
        System.out.println "(Wie alt bist du?)";
        alter = sc.nextInt();
        System.out.println (Alter: + alter);
}
```

a) Finden Sie die Fehler in der Klasse AltersKontrolle, indem Sie diese markieren und die Korrekturen hinschreiben.
b) Ergänzen Sie die Klasse AltersKontrolle um folgende if-Anweisung in der Methode main.
Wenn das eingelesene Alter größer oder gleich 16, geben Sie eine Meldung aus; falls das eingelesene Alter kleiner als 16, geben Sie ebenfalls eine Meldung aus.

## Aufgabe 2: Schleifen und Methoden

a) Schreiben Sie Anweisunge (/TODO-Teil) innerhalb des Hauptprogramms der Klasse Zahlen, um die ersten 11 natürlichen Zahlen (ohne 0) auszugeben.

Folgende Meldung soll für jede Zahl erscheinen.

Beispiel mit Zahl 10:

```java
Die Zahl lautet: 10!

public class Zahlen{
    public static void main (String[] args) {
        //TODO
    }
}
```

b) Lagern Sie die Anweisung (for Schleife) aus Aufgabe 2a) in eine Methode zahlenSchleife ohne Rückgabewert aus und rufen Sie diese Methode im Hauptprogramm der Klasse Zahlen mithilfe eines Objektes zahlenObj auf. Hinweis: Das Objekt muss vorher erzeugt werden.

c) Schreiben Sie eine Methode istKleiner, die zwei int Zahlen, die als Argumente (Parameter) übergeben werden, vergleicht und true liefert, falls die erste Zahl kleiner als die zweite ist.

d) Schreiben Sie den Aufruf der Methode istKleiner mit zwei Argumenten (Zahlen) Ihrer Wahl mithilfe des Objektes zahlObj und speichern SIe das Ergebnis in einer Variable erg.

## Aufgabe 3: Vererbung

a) Erläutern Sie das Prinzip der Vererbung in Java

b) Schreiben Sie die erste Zeile einer Klasse Kinde, die von einer Klasse Person mit einer Methode public void setName (String name) erbt und eine eigene Methode public double gesamtwertBerechnen (int warenkorbID) besitzt.

c) Schreiben Sie eine Testklasse VererbungTest, die ein Objekt der Klasse Kunde erzeugt und die beiden Methoden aus b) für einen Kunden mit dem namen Winter und den Warenkorb mit der ID 87654 in der main-Methode aufruft und den Gesamtwert des Warenkorbs ausgibt.

## Aufgabe 4: Konstruktor

a) Schreiben Sie einen Konstruktor für eine Klasse Konto, der folgenen Attribute setzt (initialisiert):

- private String name;
- private String vorname;
- private int k_nummer;

b) Schreiben Sie einen Aufruf dieses Konstruktors mit von Ihnen gewählten Werten.
