


/*import java.util.*;

class BFS {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[V + 1]; // Adjusting for 1-based indexing
        Queue<Integer> q = new LinkedList<>();

        q.add(1); // Starting from vertex 1
        vis[1] = true;

        while (!q.isEmpty()) {
            Integer node = q.poll();
            bfs.add(node);

            // Get all adjacent vertices of the dequeued vertex
            // If an adjacent has not been visited, then mark it visited and enqueue it
            for (Integer it : adj.get(node)) {
                if (!vis[it]) {
                    vis[it] = true;
                    q.add(it);
                }
            }
        }

        return bfs;
    }

    public static void main(String args[]) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= 5; i++) { // Adjusting for 1-based indexing
            adj.add(new ArrayList<>());
        }

        // Adding edges for the graph with 1-based indexing
        // adj.get(1).add(2);
        // adj.get(2).add(1);
        // adj.get(1).add(5);
        // adj.get(5).add(1);
        // adj.get(2).add(3);
        // adj.get(3).add(2);
        // adj.get(2).add(4);
        // adj.get(4).add(2);


        adj.get(1).add(2);
        adj.get(1).add(3);
        adj.get(2).add(1);
        adj.get(2).add(4);
        adj.get(2).add(5);
        adj.get(3).add(1);

        BFS sl = new BFS();
        ArrayList<Integer> ans = sl.bfsOfGraph(5, adj); // Passing 5 as the number of vertices
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}*/




/*import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSGraph {
    private int vertices;
    private int[][] connect;
    
    // Constructor to initialize graph with vertices
    public BFSGraph(int vertices) {
        this.vertices = vertices;
        this.connect = new int[vertices + 1][vertices + 1]; // Adjusting index to start from 1
    }

    // Function to add edges to the graph (adjacency matrix)
    public void addEdge(int src, int dest) {
        connect[src][dest] = 1;
        connect[dest][src] = 1; // Since it's an undirected graph
    }

    // Function to display the adjacency matrix (with vertex labels)
    public void printGraph() {
        System.out.print("\t");
        for (int i = 1; i <= vertices; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();

        for (int i = 1; i <= vertices; i++) {
            System.out.print(i + "\t");
            for (int j = 1; j <= vertices; j++) {
                System.out.print(connect[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // BFS implementation using a queue
    public void bfs(int startNode, int endNode) {
        boolean[] visited = new boolean[vertices + 1]; // Tracks visited nodes
        int[] parent = new int[vertices + 1]; // Stores parent of each node to reconstruct path
        
        // Initialize parent array with -1
        for (int i = 1; i <= vertices; i++) {
            parent[i] = -1;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            
            if (visited[currentNode]) {
                continue;
            }
            
            visited[currentNode] = true;

            for (int i = 1; i <= vertices; i++) {
                if (connect[currentNode][i] == 1 && !visited[i]) {
                    if (parent[i] == -1) {
                        parent[i] = currentNode;
                    }
                    queue.add(i);
                }
            }
        }

        // Print visited nodes
        System.out.print("Visited nodes: ");
        for (int i = 1; i <= vertices; i++) {
            System.out.print((visited[i] ? 1 : 0) + " ");
        }
        System.out.println();

        // Reconstruct path from startNode to endNode
        System.out.print("Path from " + startNode + " to " + endNode + ": ");
        while (endNode != startNode) {
            System.out.print(endNode + " <- ");
            endNode = parent[endNode];
        }
        System.out.println(startNode);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for the number of vertices
        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();
        
        BFSGraph graph = new BFSGraph(vertices);

        // Input for adjacency matrix
        System.out.println("Enter the adjacency matrix:");
        for (int i = 1; i <= vertices; i++) {
            for (int j = 1; j <= vertices; j++) {
                graph.connect[i][j] = scanner.nextInt();
            }
        }

        // Display the adjacency matrix
        graph.printGraph();

        // Input for start and end node
        System.out.print("Enter start node: ");
        int startNode = scanner.nextInt();

        System.out.print("Enter end node: ");
        int endNode = scanner.nextInt();

        // Perform BFS and print the path
        graph.bfs(startNode, endNode);

        scanner.close();
    }
}*/



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSGraphAdjList {
    private int vertices;
    private ArrayList<ArrayList<Integer>> adjList;

    // Constructor to initialize the graph
    public BFSGraphAdjList(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>(vertices + 1);

        // Initialize adjacency list
        for (int i = 0; i <= vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Function to add edges to the graph (Adjacency List)
    public void addEdge(int src, int dest) {
        adjList.get(src).add(dest);
        adjList.get(dest).add(src); // Since it's an undirected graph
    }

    // Function to display the adjacency list (with vertex labels)
    public void printGraph() {
        System.out.println("Adjacency List Representation of the Graph:");
        for (int i = 1; i <= vertices; i++) {
            System.out.print(i + " -> ");
            for (int neighbor : adjList.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    // BFS implementation using a queue
    public void bfs(int startNode, int endNode) {
        boolean[] visited = new boolean[vertices + 1]; // Tracks visited nodes
        int[] parent = new int[vertices + 1]; // Stores parent of each node to reconstruct path
        
        // Initialize parent array with -1
        for (int i = 1; i <= vertices; i++) {
            parent[i] = -1;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            
            if (visited[currentNode]) {
                continue;
            }
            
            visited[currentNode] = true;

            // Visit all the neighbors of the current node
            for (int neighbor : adjList.get(currentNode)) {
                if (!visited[neighbor]) {
                    if (parent[neighbor] == -1) {
                        parent[neighbor] = currentNode;
                    }
                    queue.add(neighbor);
                }
            }
        }

        // Print visited nodes
        System.out.print("Visited nodes: ");
        for (int i = 1; i <= vertices; i++) {
            System.out.print((visited[i] ? 1 : 0) + " ");
        }
        System.out.println();

        // Reconstruct path from startNode to endNode
        System.out.print("Path from " + startNode + " to " + endNode + ": ");
        while (endNode != startNode) {
            System.out.print(endNode + " <- ");
            endNode = parent[endNode];
        }
        System.out.println(startNode);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for the number of vertices
        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        BFSGraphAdjList graph = new BFSGraphAdjList(vertices);

        // Input for the number of edges
        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();

        // Input edges (source, destination)
        System.out.println("Enter the edges (source destination):");
        for (int i = 0; i < edges; i++) {
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            graph.addEdge(src, dest);
        }

        // Display the adjacency list
        graph.printGraph();

        // Input for start and end node
        System.out.print("Enter start node: ");
        int startNode = scanner.nextInt();

        System.out.print("Enter end node: ");
        int endNode = scanner.nextInt();

        // Perform BFS and print the path
        graph.bfs(startNode, endNode);

        scanner.close();
    }
}

