import java.util.Scanner;

public class AdjacencyMatrixGraph {
    private int[][] adjacencyMatrix;
    private int numVertices;

    public AdjacencyMatrixGraph(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyMatrix = new int[numVertices + 1][numVertices + 1];
    }

    public void addEdge(int src, int dest) {
        adjacencyMatrix[src][dest] = 1;
        adjacencyMatrix[dest][src] = 1; // for undirected graph
    }

    public void displayMatrix() {
        System.out.println("Adjacency Matrix:");
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

        AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(numVertices);

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

        graph.displayMatrix();

        scanner.close();
    }
}
