/**
 * Baut eine Adjazenzmatrix entsprechend der Aufgabe 4 in Kapitel 11
 * im Buch Informatik Oberstufe 1 Oldenbourg Verlag auf
 * 
 * @author U.Freiberger
 * @version 1.0
 */

public class Test_Graph_Matrix {

    Graph_Matrix g;

    /**
     * Methode AusfuehrenAutobahn()
     * 
     * führt sämtliche Arbeiten zur Implementierung des Graphen
     * Instanzieren des Graphenobjekts; Einfügen der Knoten und Einfügen der Kanten
     * 
     * Am Ende Ausgabe der Adjazenzmatrix zur Kontrolle
     * Aufruf der Suche nach dem kürzesten Weg
     * 
     */
    public void ausfuehrenAutobahn() {
        // Erzeugen eines Graphenobjekts g für 14 Knoten
        Graph_Matrix g = new Graph_Matrix(14);

        // Anlegen der Knoten
        g.knotenEinfuegen("A");
        g.knotenEinfuegen("F");
        g.knotenEinfuegen("FD");
        g.knotenEinfuegen("HO");
        g.knotenEinfuegen("KA");
        g.knotenEinfuegen("LI");
        g.knotenEinfuegen("M");
        g.knotenEinfuegen("N");
        g.knotenEinfuegen("PA");
        g.knotenEinfuegen("R");
        g.knotenEinfuegen("RO");
        g.knotenEinfuegen("S");
        g.knotenEinfuegen("UL");
        g.knotenEinfuegen("WÜ");

        // Anlegen der Kanten
        g.kanteEinfuegen("KA", "F", 127);
        g.kanteEinfuegen("F", "WÜ", 131);
        g.kanteEinfuegen("WÜ", "N", 104);
        g.kanteEinfuegen("N", "R", 80);
        g.kanteEinfuegen("R", "PA", 72);
        g.kanteEinfuegen("HO", "WÜ", 192);
        g.kanteEinfuegen("HO", "N", 116);
        g.kanteEinfuegen("HO", "R", 166);
        g.kanteEinfuegen("FD", "WÜ", 98);
        g.kanteEinfuegen("M", "A", 64);
        g.kanteEinfuegen("M", "N", 163);
        g.kanteEinfuegen("M", "R", 117);
        g.kanteEinfuegen("M", "RO", 60);
        g.kanteEinfuegen("UL", "A", 59);
        g.kanteEinfuegen("UL", "WÜ", 165);
        g.kanteEinfuegen("UL", "LI", 126);
        g.kanteEinfuegen("UL", "S", 103);
        g.kanteEinfuegen("S", "KA", 53);
        g.kanteEinfuegen("S", "WÜ", 155);

        // Formatiertes Ausgeben der Adjazenzmatrix in der Konsole
        g.ausgeben();
        g.kuerzesterWeg("M", "F");
    }

    public static void main(String args[]) {
        Test_Graph_Matrix test = new Test_Graph_Matrix();
        test.ausfuehrenAutobahn();
    }

}