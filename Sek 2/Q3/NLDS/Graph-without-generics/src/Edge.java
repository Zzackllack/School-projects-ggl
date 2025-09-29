//Klasse Edge
public class Edge {

  protected GraphNode neighbour;
  protected double weight;
  protected boolean marked;

  public Edge(GraphNode pNeighbour, double pWeight) {
    neighbour = pNeighbour;
    weight = pWeight;
    marked = false;
  }

  public GraphNode getNeighbour() {
    return neighbour;
  }

  public double getWeight() {
    return weight;
  }

  public boolean isMarked() {
    return marked;
  }
}
