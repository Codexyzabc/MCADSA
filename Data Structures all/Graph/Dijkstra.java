import java.util.*;

class Pair {
    int node;
    int distance;

    public Pair(int distance, int node) {
        this.node = node;
        this.distance = distance;
    }
}

class Dijkstra {
    // Function to find the shortest distance of all the vertices
    // from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        int[] dist = new int[V+1];

        // Initializing dist array with a large number to
        // indicate the nodes are unvisited initially.
        Arrays.fill(dist, (int) 1e9);

        // Source initialized with dist=0.
        dist[S] = 0;
        pq.add(new Pair(0, S));

        while (!pq.isEmpty()) {
            int dis = pq.peek().distance;
            int node = pq.peek().node;//reference of pair class.node
            pq.remove();

            for (ArrayList<Integer> edge : adj.get(node)) {
                int adjNode = edge.get(0);
                int edgeWeight = edge.get(1);

                if (dis + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWeight;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int V = sc.nextInt();
        System.out.print("Enter the number of edges: ");
        int E = sc.nextInt();

        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        for (int i = 0; i <=V; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.println("Enter edges and weights (node neighbour node, weight):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            // Adding edge and weight to adjacency list
            adj.get(u).add(new ArrayList<>(Arrays.asList(v, w)));
            adj.get(v).add(new ArrayList<>(Arrays.asList(u, w)));
        }

        System.out.print("Enter the source vertex (0-based indexing): ");
        int S = sc.nextInt();

        Dijkstra obj = new Dijkstra();
        int[] distances = dijkstra(V, adj, S);

        System.out.println("Shortest distances from source " + S + " to all other vertices:");
        for (int i = 0; i <=V; i++) {
            System.out.println("Vertex " + i + ": " + distances[i]);
        }

        sc.close();
    }
}
