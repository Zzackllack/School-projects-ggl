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
