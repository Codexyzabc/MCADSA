import java.util.*;

class Pair {
    int node;
    int distance;

    public Pair(int distance, int node) {
        this.node = node;
        this.distance = distance;
    }
}

class Dijkstra1 {
    // Function to find the shortest distance of all the vertices
    // from the source vertex S.
    static int[] dijkstra(int V, List<List<Pair>> adj, int S) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        int[] dist = new int[V];

        // Initializing dist array with a large number to
        // indicate the nodes are unvisited initially.
        Arrays.fill(dist, (int) 1e9);

        // Source initialized with dist=0.
        dist[S] = 0;
        pq.add(new Pair(0, S));

        while (!pq.isEmpty()) {
            int dis = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();

            for (Pair edge : adj.get(node)) {
                int adjNode = edge.node;
                int edgeWeight = edge.distance;

                if (dis + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWeight;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        // Given input
        int V = 6; // Number of vertices
        int E = 8; // Number of edges

        // Create adjacency list representation of the graph
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges and weights to the graph
        addEdge(adj, 0, 1, 4);
        addEdge(adj, 0, 2, 4);
        addEdge(adj, 1, 2, 2);
        addEdge(adj, 2, 3, 3);
        addEdge(adj, 3, 5, 2);
        addEdge(adj, 2, 5, 6);
        addEdge(adj, 2, 4, 1);
        addEdge(adj, 4, 5, 3);

        // Source vertex
        int S = 0;

        // Compute shortest distances from source using Dijkstra's algorithm
        int[] distances = dijkstra(V, adj, S);

        // Print shortest distances from source to all other vertices
        System.out.println("Shortest distances from source " + S + " to all other vertices:");
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + ": " + distances[i]);
        }
    }

    // Utility method to add edge to adjacency list
    private static void addEdge(List<List<Pair>> adj, int src, int dest, int weight) {
        adj.get(src).add(new Pair(weight, dest));
        adj.get(dest).add(new Pair(weight, src)); // For undirected graph
    }
}
