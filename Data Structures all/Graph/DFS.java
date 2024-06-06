import java.util.*;

class DFS {
    // Function to perform Depth First Search traversal
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean[] vis = new boolean[V + 1]; // Adjusting for 1-based indexing
        dfsUtil(1, adj, vis, dfs); // Starting DFS from vertex 1
        return dfs;
    }

    // Utility function for DFS traversal
    private void dfsUtil(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> dfs) {
        vis[node] = true;
        dfs.add(node);

        // Traverse all adjacent vertices of the current vertex
        for (Integer it : adj.get(node)) {
            if (!vis[it]) {
                dfsUtil(it, adj, vis, dfs);
            }
        }
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


        DFS sl = new DFS();
        ArrayList<Integer> ans = sl.dfsOfGraph(5, adj); // Passing 5 as the number of vertices
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}
