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