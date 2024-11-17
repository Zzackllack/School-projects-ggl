# Abstrakte Klassen in Java

## Was ist eine abstrakte Klasse?

Eine abstrakte Klasse in Java ist eine Klasse, die nicht instanziiert werden kann. Sie dient als Basisklasse für andere Klassen. Abstrakte Klassen können abstrakte Methoden enthalten, die von den Unterklassen implementiert werden müssen.

## Beispiel: GeometrischeFigur

In dem späterm Code hat man eine abstrakte Klasse `GeometrischeFigur` definiert:

```java
public abstract class GeometrischeFigur {
    private String farbe;

    public String getFarbe() {
        return farbe;
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    // Abstrakte Methode zur Berechnung des Flächeninhalts
    public abstract double berechneFlaecheninhalt();
}
```

## Erklärung:

GeometrischeFigur ist eine abstrakte Klasse.
Sie enthält eine abstrakte Methode berechneFlaecheninhalt(), die von den Unterklassen implementiert werden muss.
Sie enthält auch konkrete Methoden getFarbe() und setFarbe().

## Unterklassen: Rechteck und Kreis

Die Klassen Rechteck und Kreis erben von GeometrischeFigur und implementieren die abstrakte Methode berechneFlaecheninhalt().

### Rechteck.java

```java
public class Rechteck extends GeometrischeFigur {
    private double breite;
    private double hoehe;

    public double getBreite() {
        return breite;
    }

    public void setBreite(double breite) {
        this.breite = breite;
    }

    public double getHoehe() {
        return hoehe;
    }

    public void setHoehe(double hoehe) {
        this.hoehe = hoehe;
    }

    @Override
    public double berechneFlaecheninhalt() {
        return hoehe * breite;
    }
}
```

### Kreis.java

```java
public class Kreis extends GeometrischeFigur {
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double berechneFlaecheninhalt() {
        return Math.PI * radius * radius;
    }
}
```

## Erklärung:

Beide Klassen implementieren die Methode berechneFlaecheninhalt(), um den Flächeninhalt der jeweiligen geometrischen Figur zu berechnen.

## Verwendung der abstrakten Klasse

In der Test-Klasse werden Instanzen von Rechteck und Kreis erstellt und deren Flächeninhalt wird über die Konsole-Klasse ausgegeben.

### Test.java

```java
public class Test {
    public static void main(String[] args) {
        Konsole konsole = new Konsole();
        Rechteck rechteck = new Rechteck();
        Kreis kreis = new Kreis();

        rechteck.setBreite(10);
        rechteck.setHoehe(5);
        kreis.setRadius(10);

        konsole.zeigeFlaecheninhalt(rechteck);
        konsole.zeigeFlaecheninhalt(kreis);
    }
}
```

### Konsole.java

```java
public class Konsole {
    public void zeigeFlaecheninhalt(GeometrischeFigur pGeometrischeFigur) {
        System.out.println("Flächeninhalt: " + pGeometrischeFigur.berechneFlaecheninhalt());
    }
}
```

## Erklärung:

Die Konsole-Klasse hat eine Methode zeigeFlaecheninhalt(), die eine Instanz von GeometrischeFigur akzeptiert und den Flächeninhalt ausgibt.
In der Test-Klasse werden die Methoden setBreite(), setHoehe() und setRadius() verwendet, um die Abmessungen der Figuren festzulegen.
Die Methode zeigeFlaecheninhalt() wird aufgerufen, um den Flächeninhalt der Figuren auszugeben.
