// This is a java program to represent graph as a two dimensional array

import java.util.Scanner;

/**
 * Represents a directed graph using a two-dimensional adjacency matrix.
 * The implementation uses 1-based vertex indexing: valid vertex identifiers
 * are expected to be in the range 1..vertices. Internally the matrix is
 * allocated with dimensions (vertices + 1) x (vertices + 1) to allow direct
 * use of 1-based indices.
 */
public class Represent_Graph_TwoD_Array {

  private final int vertices;
  private int[][] twoD_array;

  /**
   * Constructs the graph representation with the specified number of vertices.
   *
   * @param v the number of vertices in the graph; expected to be >= 1.
   *          Allocates an adjacency matrix of size (v + 1) x (v + 1) to support
   *          1-based vertex indices.
   */
  public Represent_Graph_TwoD_Array(int v) {
    vertices = v;
    twoD_array = new int[vertices + 1][vertices + 1];
  }

  /**
   * Adds or sets an entry in the adjacency matrix to represent an edge.
   *
   * This method writes the provided edge value into the matrix at position
   * [to][from]. The code assumes vertices are numbered 1..vertices. If the
   * provided indices are outside the valid range, the method catches the
   * ArrayIndexOutOfBoundsException and prints an informative message without
   * throwing.
   *
   * @param to    the destination vertex index (row), expected 1..vertices
   * @param from  the source vertex index (column), expected 1..vertices
   * @param edge  the integer value to store in the adjacency matrix (commonly 1
   *              to indicate the presence of an edge)
   */
  public void makeEdge(int to, int from, int edge) {
    try {
      twoD_array[to][from] = edge;
    } catch (ArrayIndexOutOfBoundsException index) {
      System.out.println("The vertices does not exists");
    }
  }

  /**
   * Retrieves the value stored in the adjacency matrix for the given pair of vertices.
   *
   * If the indices are valid (1..vertices) the stored integer value is returned.
   * If the indices are invalid an error message is printed and the method returns -1
   * to indicate an invalid query.
   *
   * @param to    the destination vertex index (row), expected 1..vertices
   * @param from  the source vertex index (column), expected 1..vertices
   * @return      the integer value at matrix[to][from], or -1 if the indices are invalid
   */
  public int getEdge(int to, int from) {
    try {
      return twoD_array[to][from];
    } catch (ArrayIndexOutOfBoundsException index) {
      System.out.println("The vertices does not exists");
    }
    return -1;
  }

  /**
   * Command-line demonstration of building and printing the adjacency matrix.
   *
   * The program prompts the user for:
   *  - the number of vertices (v)
   *  - the number of edges (e)
   *  - e pairs of integers specifying edges in the form "<to> <from>"
   *
   * It constructs a Represent_Graph_TwoD_Array for v vertices, reads e edges from
   * standard input, sets each specified matrix cell to 1, and then prints the
   * complete adjacency matrix with 1-based row and column headers. Any exception
   * during input or processing is caught and results in an error message.
   *
   * @param args command-line arguments (ignored)
   */
    public static void main(String args[]) {
    int v,
      e,
      count = 1,
      to = 0,
      from = 0;
    Scanner sc = new Scanner(System.in);
    Represent_Graph_TwoD_Array graph;
    try {
      System.out.println("Enter the number of vertices: ");
      v = sc.nextInt();
      System.out.println("Enter the number of edges: ");
      e = sc.nextInt();

      graph = new Represent_Graph_TwoD_Array(v);

      System.out.println("Enter the edges: <to> <from>");
      while (count <= e) {
        to = sc.nextInt();
        from = sc.nextInt();

        graph.makeEdge(to, from, 1);
        count++;
      }

      System.out.println("The two d array for the given graph is: ");
      System.out.print("  ");
      for (int i = 1; i <= v; i++) System.out.print(i + " ");
      System.out.println();

      for (int i = 1; i <= v; i++) {
        System.out.print(i + " ");
        for (int j = 1; j <= v; j++) System.out.print(
          graph.getEdge(i, j) + " "
        );
        System.out.println();
      }
    } catch (Exception E) {
      System.out.println("Something went wrong");
    }
    sc.close();
  }
}
