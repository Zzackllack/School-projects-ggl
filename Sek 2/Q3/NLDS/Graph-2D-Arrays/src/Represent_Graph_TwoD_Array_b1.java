import java.util.Scanner;

/**
 * Boolean variant: uses boolean adjacency matrix and prints true/false instead of 1/0.
 */
public class Represent_Graph_TwoD_Array_b1 {

  private final int vertices;
  private boolean[][] twoD_array;

  public Represent_Graph_TwoD_Array_b1(int v) {
    vertices = v;
    twoD_array = new boolean[vertices + 1][vertices + 1];
  }

  public void makeEdge(int to, int from, boolean edge) {
    try {
      twoD_array[to][from] = edge;
    } catch (ArrayIndexOutOfBoundsException index) {
      System.out.println("The vertex does not exist (b1)");
    }
  }

  public boolean getEdge(int to, int from) {
    try {
      return twoD_array[to][from];
    } catch (ArrayIndexOutOfBoundsException index) {
      System.out.println("The vertex does not exist (b1)");
    }
    return false;
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

  // Simple interactive demo for b1
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    try {
      System.out.println("Enter the number of vertices: ");
      int v = sc.nextInt();
      System.out.println("Enter the number of edges: ");
      int e = sc.nextInt();

      Represent_Graph_TwoD_Array_b1 graph = new Represent_Graph_TwoD_Array_b1(v);
      System.out.println("Enter the edges: <to> <from> (each pair)\nOptional: pass 1 for edge=true, 0 for false");
      for (int i = 0; i < e; i++) {
        int to = sc.nextInt();
        int from = sc.nextInt();
        int val = 1;
        if (sc.hasNextInt()) val = sc.nextInt();
        graph.makeEdge(to, from, val != 0);
      }

      System.out.println("Boolean adjacency matrix (true/false):");
      graph.printMatrix();
    } catch (Exception ex) {
      System.out.println("Something went wrong (b1)");
    } finally {
      sc.close();
    }
  }
}
