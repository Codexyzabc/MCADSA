import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

class UnionFind {
    int[] parent;
    int[] rank;

    UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Path compression
        }
        return parent[x];
    }

    void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return;

        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        // } else if (rank[rootX] > rank[rootY]) {
        //     parent[rootY] = rootX;
        } else if(rank[rootY]< rank[rootX]){
            parent[rootY]=rootX;
        
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }
}

class KruskalMST {
    List<Edge> kruskalMST(List<Edge> edges, int V) {
        List<Edge> result = new ArrayList<>();
        UnionFind uf = new UnionFind(V);
        Collections.sort(edges);

        for (Edge edge : edges) {
            int srcParent = uf.find(edge.src);
            int destParent = uf.find(edge.dest);

            if (srcParent != destParent) {//since they are in different sets so their parents are different, so union is performed amongst them
                result.add(edge);
                uf.union(srcParent, destParent);
            }
        }

        return result;
    }
}

public class Kruskal {
    public static void main(String[] args) {
        int V = 4; // Number of vertices

        // Create adjacency list representation of the graph
        List<List<Edge>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        // Add edges to the graph
        addEdge(adjList, 0, 1, 10);
        addEdge(adjList, 0, 2, 6);
        addEdge(adjList, 0, 3, 5);
        addEdge(adjList, 1, 3, 15);
        addEdge(adjList, 2, 3, 4);

        // Convert adjacency list to list of edges
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            for (Edge edge : adjList.get(i)) {
                edges.add(edge);
            }
        }

        // Apply Kruskal's algorithm to find MST
        KruskalMST kruskal = new KruskalMST();
        List<Edge> mst = kruskal.kruskalMST(edges, V);

        // Print MST
        System.out.println("Minimum Spanning Tree (MST):");
        for (Edge edge : mst) {
            System.out.println(edge.src + " - " + edge.dest + " : " + edge.weight);
        }
    }

    // Utility method to add edge to adjacency list
    private static void addEdge(List<List<Edge>> adjList, int src, int dest, int weight) {
        adjList.get(src).add(new Edge(src, dest, weight));
        adjList.get(dest).add(new Edge(dest, src, weight)); // For undirected graph
    }
}
