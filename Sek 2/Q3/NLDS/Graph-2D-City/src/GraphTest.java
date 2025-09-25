public class GraphTest {
    public static void main(String[] args) {
        Graph g = new Graph(5);

        Stadt s1 = new Stadt();
        s1.setName("A");
        s1.setProvinz("P1");

        Stadt s2 = new Stadt();
        s2.setName("B");
        s2.setProvinz("P1");

        Stadt s3 = new Stadt();
        s3.setName("C");
        s3.setProvinz("P2");

        g.einfügenKnoten(s1);
        g.einfügenKnoten(s2);
        g.einfügenKnoten(s3);

        // create some edges
        g.kanteEinfuegen(s1, s2);
        g.kanteEinfuegen(s2, s3);

        // attempt a non-existing edge (should warn)
        Stadt s4 = new Stadt();
        s4.setName("D");
        s4.setProvinz("P3");
        g.kanteEinfuegen(s1, s4);

        // test vergleiche
        System.out.println("vergleiche s1,s2: " + g.vergleiche(s1, s2));
        Stadt s1copy = new Stadt();
        s1copy.setName("A");
        s1copy.setProvinz("P1");
        System.out.println("vergleiche s1,s1copy: " + g.vergleiche(s1, s1copy));

        // print matrix
        g.matrixAusgeben();
    }
}
