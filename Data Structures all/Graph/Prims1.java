import java.util.*;

class Pair {
    int vertex, weight;

    Pair(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}

public class Prims1 {
    public static void main(String[] args) {
        // Number of vertices
        int V = 4;

        // Create adjacency list representation of the graph
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        // Add edges to the graph
        addEdge(adjList, 0, 1, 10);
        addEdge(adjList, 0, 2, 6);
        addEdge(adjList, 0, 3, 5);
        addEdge(adjList, 1, 3, 15);
        addEdge(adjList, 2, 3, 4);

        // Apply Prim's algorithm to find MST
        List<Pair> mst = primMST(adjList, V);

        // Print MST
        System.out.println("Minimum Spanning Tree (MST):");
        int totalCost = 0;
        for (Pair edge : mst) {
            //System.out.println("0 - " + edge.vertex + " : " + edge.weight);
            totalCost += edge.weight;
        }
        System.out.println("Total Cost: " + totalCost);
    }

    // Utility method to add edge to adjacency list
    private static void addEdge(ArrayList<ArrayList<Pair>> adjList, int src, int dest, int weight) {
        adjList.get(src).add(new Pair(dest, weight));
        adjList.get(dest).add(new Pair(src, weight)); // For undirected graph
    }

    // Prim's algorithm to find MST
    private static List<Pair> primMST(ArrayList<ArrayList<Pair>> adjList, int V) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        boolean[] visited = new boolean[V];
        List<Pair> mst = new ArrayList<>();

        // Start from vertex 0
        pq.offer(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair minEdge = pq.poll();
            int vertex = minEdge.vertex;

            // Skip if vertex is already visited
            if (visited[vertex]) continue;

            // Mark vertex as visited
            visited[vertex] = true;

            // Add the minimum weight edge to MST
            mst.add(minEdge);

            // Explore adjacent vertices
            for (Pair adjEdge : adjList.get(vertex)) {
                if (!visited[adjEdge.vertex]) {
                    pq.offer(adjEdge);
                }
            }
        }

        return mst;
    }
}
