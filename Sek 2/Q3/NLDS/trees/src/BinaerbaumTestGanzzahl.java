public class BinaerbaumTestGanzzahl {
    public static void main(String[] args) {
        Binaerbaum baum = new Binaerbaum();
        // Baumelement des Typs Abschluss erzeugen
        Abschluss abschluss = new Abschluss();

        // 7 Datenelemente des Typs Ganzzahl mit Werten 0..6 erzeugen
        Ganzzahl[] daten = new Ganzzahl[7];
        for (int i = 0; i < daten.length; i++) {
            daten[i] = new Ganzzahl(i);
        }
        // Erzeuge 7 Datenknoten (knoten0..knoten6) und verknüpfe sie zu einem
        // zusammenhängenden Binärbaum. Wir bauen einen vollständigen Baum der
        // Höhe 3 (3 Ebenen), wobei knoten0 die Wurzel ist:
        //
        //           knoten0
        //          /       \
        //      knoten1     knoten2
        //      /   \        /   \
        //   knoten3 knoten4 knoten5 knoten6

        // Blätter: knoten3..knoten6 haben Abschluss als Kinder
        Datenknoten knoten3 = new Datenknoten(abschluss, abschluss, daten[3]);
        Datenknoten knoten4 = new Datenknoten(abschluss, abschluss, daten[4]);
        Datenknoten knoten5 = new Datenknoten(abschluss, abschluss, daten[5]);
        Datenknoten knoten6 = new Datenknoten(abschluss, abschluss, daten[6]);

        // innere Knoten: knoten1 hat knoten3 und knoten4, knoten2 hat knoten5 und knoten6
        Datenknoten knoten1 = new Datenknoten(knoten3, knoten4, daten[1]);
        Datenknoten knoten2 = new Datenknoten(knoten5, knoten6, daten[2]);

        // Wurzel: knoten0 mit knoten1 und knoten2
        Datenknoten knoten0 = new Datenknoten(knoten1, knoten2, daten[0]);

        // Fülle den Baum (setzt die Wurzel und gibt Traversierungen aus)
        baumFuellen(baum, knoten0);
    }

    /**
     * Setzt die Wurzel des Baumes auf den übergebenen Knoten und gibt die
     * Knoteninhalte in verschiedenen Traversierungsordnungen aus.
     */
    public static void baumFuellen(Binaerbaum baum, Baumelement wurzel)
    {
        // Wurzel setzen
        baum.wurzelSetzen(wurzel);

        System.out.println("Preorder-Ausgabe:");
        baum.datenPreorderAusgeben();

        System.out.println("Inorder-Ausgabe:");
        baum.datenInorderAusgeben();

        System.out.println("Postorder-Ausgabe:");
        baum.datenPostorderAusgeben();
    }
}
