import java.util.Scanner;

/**
 * Weighted variant: uses int adjacency matrix where 0 means no edge and any
 * positive integer is the weight of the edge. Prints the weights (0 for none).
 */
public class Represent_Graph_TwoD_Array_b2 {

  private final int vertices;
  private int[][] twoD_array;

  public Represent_Graph_TwoD_Array_b2(int v) {
    vertices = v;
    twoD_array = new int[vertices + 1][vertices + 1];
  }

  /**
   * Adds an edge with a given positive weight. Use weight 0 to indicate no edge.
   */
  public void makeEdge(int to, int from, int weight) {
    try {
      twoD_array[to][from] = weight;
    } catch (ArrayIndexOutOfBoundsException index) {
      System.out.println("The vertex does not exist (b2)");
    }
  }

  public int getEdge(int to, int from) {
    try {
      return twoD_array[to][from];
    } catch (ArrayIndexOutOfBoundsException index) {
      System.out.println("The vertex does not exist (b2)");
    }
    return -1;
  }

  public void printMatrix() {
    System.out.print("  ");
    for (int i = 1; i <= vertices; i++) System.out.print(i + " ");
    System.out.println();

    for (int i = 1; i <= vertices; i++) {
      System.out.print(i + " ");
      for (int j = 1; j <= vertices; j++) System.out.print(getEdge(i, j) + " ");
      System.out.println();
    }
  }

  // Simple interactive demo for b2
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    try {
      System.out.println("Enter the number of vertices: ");
      int v = sc.nextInt();
      System.out.println("Enter the number of edges: ");
      int e = sc.nextInt();

      Represent_Graph_TwoD_Array_b2 graph = new Represent_Graph_TwoD_Array_b2(v);
      System.out.println("Enter the edges: <to> <from> <weight>");
      for (int i = 0; i < e; i++) {
        int to = sc.nextInt();
        int from = sc.nextInt();
        int w = sc.nextInt();
        graph.makeEdge(to, from, w);
      }

      System.out.println("Weighted adjacency matrix (0=no edge):");
      graph.printMatrix();
    } catch (Exception ex) {
      System.out.println("Something went wrong (b2)");
    } finally {
      sc.close();
    }
  }
}
