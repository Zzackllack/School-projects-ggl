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
