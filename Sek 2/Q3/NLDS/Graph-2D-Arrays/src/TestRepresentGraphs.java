/**
 * Test runner that demonstrates the original, boolean, and weighted variants.
 *
 * This class constructs small graphs and prints their adjacency matrices.
 */
public class TestRepresentGraphs {
  public static void main(String[] args) {
    System.out.println("--- Original (int 1/0) ---");
    Represent_Graph_TwoD_Array original = new Represent_Graph_TwoD_Array(4);
    original.makeEdge(1, 2, 1);
    original.makeEdge(2, 3, 1);
    original.makeEdge(4, 1, 1);
    // print using existing class by reusing its print logic via getEdge
    System.out.print("  ");
    for (int i = 1; i <= 4; i++) System.out.print(i + " ");
    System.out.println();
    for (int i = 1; i <= 4; i++) {
      System.out.print(i + " ");
      for (int j = 1; j <= 4; j++) System.out.print(original.getEdge(i, j) + " ");
      System.out.println();
    }

    System.out.println("\n--- Boolean variant (true/false) ---");
    Represent_Graph_TwoD_Array_b1 b1 = new Represent_Graph_TwoD_Array_b1(4);
    b1.makeEdge(1, 2, true);
    b1.makeEdge(2, 3, true);
    b1.makeEdge(4, 1, true);
    b1.printMatrix();

    System.out.println("\n--- Weighted variant ---");
    Represent_Graph_TwoD_Array_b2 b2 = new Represent_Graph_TwoD_Array_b2(4);
    b2.makeEdge(1, 2, 5);
    b2.makeEdge(2, 3, 7);
    b2.makeEdge(4, 1, 3);
    b2.printMatrix();
  }
}
