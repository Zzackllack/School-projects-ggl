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