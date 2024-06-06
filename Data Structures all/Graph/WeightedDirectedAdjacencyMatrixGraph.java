import java.util.Scanner;

public class WeightedDirectedAdjacencyMatrixGraph {
    private int[][] adjacencyMatrix;
    private int numVertices;

    public WeightedDirectedAdjacencyMatrixGraph(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyMatrix = new int[numVertices + 1][numVertices + 1];
    }

    public void addEdge(int src, int dest, int weight) {
        adjacencyMatrix[src][dest] = weight; // for directed graph
    }

    public void displayMatrix() {
        System.out.println("Weighted Directed Adjacency Matrix:");
        for (int i = 0; i <= numVertices; i++) {
            for (int j = 0; j <= numVertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int numVertices = scanner.nextInt();

        WeightedDirectedAdjacencyMatrixGraph graph = new WeightedDirectedAdjacencyMatrixGraph(numVertices);

        System.out.print("Enter the number of edges: ");
        int numEdges = scanner.nextInt();

        System.out.println("Enter edges and weights (source destination weight):");
        for (int i = 0; i < numEdges; i++) {
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            int weight = scanner.nextInt();

            if (src >= 1 && src <= numVertices && dest >= 1 && dest <= numVertices) {
                graph.addEdge(src, dest, weight);
            } else {
                System.out.println("Invalid edge. Please enter valid vertices.");
                i--; // Decrement i to allow re-entry of the same edge
            }
        }

        graph.displayMatrix();

        scanner.close();
    }
}
