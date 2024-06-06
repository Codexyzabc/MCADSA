


import java.util.*;

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
}
