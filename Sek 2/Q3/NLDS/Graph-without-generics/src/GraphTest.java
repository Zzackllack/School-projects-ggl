public class GraphTest {

  public static void main(String[] args) {
    Graph g = new Graph();

    GraphNode a = new GraphNode("A");
    GraphNode b = new GraphNode("B");
    GraphNode c = new GraphNode("C");

    g.addNode(a);
    g.addNode(b);
    g.addNode(c);

    g.addEdge(a, b, 1.5);
    g.addEdge(b, c, 2.5);
    g.addEdge(a, c, 3.0);

    System.out.println("Nodes in graph:");
    List<GraphNode> nodes = g.getNodes();
    nodes.toFirst();
    while (nodes.hasAccess()) {
      GraphNode n = nodes.getContent();
      System.out.println("- " + n.getName());
      nodes.next();
    }

    System.out.println("Edge weights:");
    System.out.println("A-B: " + g.getEdgeWeight(a, b));
    System.out.println("B-C: " + g.getEdgeWeight(b, c));
    System.out.println("A-C: " + g.getEdgeWeight(a, c));

    System.out.println("Has edge A-B? " + g.hasEdge(a, b));
    System.out.println("Has node 'B'? " + g.hasNode("B"));

    System.out.println("Removing node B (and its edges)");
    g.removeNode(b);

    System.out.println("Has node 'B'? " + g.hasNode("B"));
    System.out.println("Has edge A-C? " + g.hasEdge(a, c));
  }
}
