import java.util.ArrayList;
import java.util.Scanner;

public class AdjacencyListGraph {
    private ArrayList<ArrayList<Integer>> adjacencyList;
    private int numVertices;

    public AdjacencyListGraph(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyList = new ArrayList<>(numVertices + 1);

        // Initialize adjacencyList
        for (int i = 0; i <= numVertices; i++) {
            this.adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest) {
        adjacencyList.get(src).add(dest);
        adjacencyList.get(dest).add(src); // for undirected graph
    }

    public void displayList() {
        System.out.println("Adjacency List:");
        for (int i = 1; i <= numVertices; i++) {
            System.out.print(i + " -> ");
            for (int j : adjacencyList.get(i)) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int numVertices = scanner.nextInt();

        AdjacencyListGraph graph = new AdjacencyListGraph(numVertices);

        System.out.print("Enter the number of edges: ");
        int numEdges = scanner.nextInt();

        System.out.println("Enter edges (source destination):");
        for (int i = 0; i < numEdges; i++) {
            int src = scanner.nextInt();
            int dest = scanner.nextInt();

            if (src >= 1 && src <= numVertices && dest >= 1 && dest <= numVertices) {
                graph.addEdge(src, dest);
            } else {
                System.out.println("Invalid edge. Please enter valid vertices.");
                i--; // Decrement i to allow re-entry of the same edge
            }
        }

        graph.displayList();

        scanner.close();
    }
}
