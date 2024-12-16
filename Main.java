class Main {
  public static void main(String[] args) {
    String[] vertices = {"Liberal Arts", "Student Services", "Health Careers & Sciences", "Health Technologies Center",
    "Recreation Center", "Technology Learning Center", "Business & Technology", "Theatre"};

    int[][] edges = {
      {0, 1}, {0, 7}, //Liberal Arts
      {1, 0}, {1, 2}, {1, 4}, {1, 5}, {1, 6}, //Student Services
      {2, 1}, {2, 3}, {2, 4}, //Health Careers & Sciences
      {3, 2}, //Health Technologies Center
      {4, 1}, {4, 2}, //Recreation Center
      {5, 1}, //Technology Learning Center
      {6, 1}, {6, 7}, //Business & Technology
      {7, 0}, {7, 6}
    };

    Graph<String> graph = new UnweightedGraph<>(vertices, edges);
    UnweightedGraph<String>.SearchTree dfs = graph.dfs(graph.getIndex("Business & Technology")); // Get a dfs starting at the Business and Technology Building. Change this is you called it something different in your vertices!

    java.util.List<Integer> searchOrders = dfs.getSearchOrder();
    System.out.println(dfs.getNumberOfVerticesFound() + " vertices are searched in this DFS order:");
    for (int i = 0; i < searchOrders.size(); i++)
      System.out.print(graph.getVertex(searchOrders.get(i)) + " ");
    System.out.println("\n");

    for (int i = 0; i < searchOrders.size(); i++)
      if (dfs.getParent(i) != -1)
        System.out.println("parent of " + graph.getVertex(i) +
          " is " + graph.getVertex(dfs.getParent(i)));
    System.out.println("\n");

    // I added a comma in the printPath code so it's easier to read when output-ed
    dfs.printPath(3);
    System.out.println();
    dfs.printPath(1);
    System.out.println();
    dfs.printPath(4);
    System.out.println("\n");

    dfs.printTree();
  }
}