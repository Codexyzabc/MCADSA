import java.util.*;

class Pair {
    int node;
    int distance;

    public Pair(int distance, int node) {
        this.node = node;
        this.distance = distance;
    }
}

class Prims {
    // Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        PriorityQueue<Pair> pq =
            new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);

        int[] vis = new int[V+1];
        // {wt, node}
        pq.add(new Pair(0, 0));
        int sum = 0;

        // List to store edges in MST
        //ArrayList<ArrayList<Integer>> mstEdges = new ArrayList<>();

        while (pq.size() > 0) {
            int wt = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();

            if (vis[node] == 1) continue;
            // add it to the mst
            vis[node] = 1;
            sum += wt;

            for (int i = 0; i < adj.get(node).size(); i++) {
                int edW = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);
                if (vis[adjNode] == 0) {
                    pq.add(new Pair(edW, adjNode));

                    
                }
            }
        }


        return sum;
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
            adj.get(v).add(new ArrayList<>(Arrays.asList(u, w))); // Assuming undirected graph
        }

        int minWeight = spanningTree(V, adj);
        System.out.println("Total weight of Minimum Spanning Tree: " + minWeight);

        sc.close();
    }
}



/*import java.util.*;

class Pair {
    int node;
    int distance;

    public Pair(int distance, int node) {
        this.node = node;
        this.distance = distance;
    }
}

class Prims {
    // Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        PriorityQueue<Pair> pq =
            new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);

        int[] vis = new int[V+1];
        pq.add(new Pair(0, 0));
        int sum = 0;

        while (pq.size() > 0) {
            int wt = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();

            if (vis[node] == 1) continue;
            vis[node] = 1;
            sum += wt;

            for (int i = 0; i < adj.get(node).size(); i++) {
                int edW = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);
                if (vis[adjNode] == 0) {
                    pq.add(new Pair(edW, adjNode));
                }
            }
        }

        // Print MST edges
        System.out.println("Edges included in Minimum Spanning Tree:");
        for (int i = 0; i <= V; i++) {
            for (ArrayList<Integer> edge : adj.get(i)) {
                if (vis[edge.get(0)] == 1 && edge.get(1) == sum) {
                    System.out.println(i + " - " + edge.get(0));
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int V = sc.nextInt();
        System.out.print("Enter the number of edges: ");
        int E = sc.nextInt();

        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.println("Enter edges and weights (neighbour node, weight):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            // Adding edge and weight to adjacency list
            adj.get(u).add(new ArrayList<>(Arrays.asList(v, w)));
            adj.get(v).add(new ArrayList<>(Arrays.asList(u, w))); // Assuming undirected graph
        }

        int minWeight = spanningTree(V, adj);
        System.out.println("Total weight of Minimum Spanning Tree: " + minWeight);

        sc.close();
    }
}*/




