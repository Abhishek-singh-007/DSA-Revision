import java.util.*;

class Solution {
    private List<List<Integer>> buildList(int[][] edges) {
        // This function takes a 2D array representing edges of a graph and converts it into an adjacency list.
        // An adjacency list is a way to represent a graph where, for each node, you store a list of its neighbors.

        int n = 0;
        // This line initializes an integer 'n' to 0. It will store the maximum node number found in the 'edges' array.
        for (int[] e : edges)
            // This is an enhanced for loop that iterates through each edge in the 'edges' array.
            n = Math.max(n, Math.max(e[0], e[1]));
            // This line finds the maximum node number between the current maximum 'n', the first node in the edge (e[0]), and the second node in the edge (e[1]).
            // It updates 'n' with the largest value found so far.
        n++;
        // This line increments 'n' by 1. This is done because node numbers are 0-indexed (start from 0), so the total number of nodes is one more than the largest node number.

        List<List<Integer>> adj = new ArrayList<>(n);
        // This line creates a new ArrayList called 'adj' to store the adjacency list. The size of the list is initialized to 'n', which is the number of nodes in the graph.
        for (int i = 0; i < n; i++)
            // This loop iterates 'n' times, once for each node in the graph.
            adj.add(new ArrayList<>());
            // This line adds a new, empty ArrayList to 'adj' for each node. This empty ArrayList will later store the neighbors of that node.

        for (int[] e : edges) {
            // This is another enhanced for loop that iterates through each edge in the 'edges' array.
            adj.get(e[0]).add(e[1]);
            // This line adds the second node in the edge (e[1]) to the list of neighbors of the first node (e[0]) in the adjacency list.
            adj.get(e[1]).add(e[0]);
            // This line adds the first node in the edge (e[0]) to the list of neighbors of the second node (e[1]) in the adjacency list.
            // This makes the graph undirected, meaning that if A is a neighbor of B, then B is also a neighbor of A.
        }
        return adj;
        // This line returns the completed adjacency list 'adj'.
    }


    private int dfs(List<List<Integer>> adj, int u, int p, int k) {
        // This function performs a Depth-First Search (DFS) to count the number of nodes reachable from a starting node within a given distance 'k'.
        // adj: The adjacency list representing the graph.
        // u: The current node being visited in the DFS.
        // p: The parent node of the current node (to avoid going back up the tree immediately).
        // k: The maximum distance allowed to travel from the starting node.

        if (k < 0) return 0;
        // If the distance 'k' becomes negative, it means we've exceeded the maximum allowed distance, so return 0 (no more nodes can be reached).
        int cnt = 1;
        // Initialize a counter 'cnt' to 1, representing the current node being reachable.
        for (int v : adj.get(u))
            // This loop iterates through each neighbor 'v' of the current node 'u'.
            if (v != p)
                // If the neighbor 'v' is not the parent node (to avoid going back immediately),
                cnt += dfs(adj, v, u, k - 1);
                // Recursively call the DFS function for the neighbor 'v', setting the current node 'u' as its parent, and decrementing the distance 'k' by 1.
                // Add the result (number of reachable nodes from 'v') to the counter 'cnt'.
        return cnt;
        // Return the total count of reachable nodes from the starting node 'u' within the given distance 'k'.
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        // This is the main function that calculates the maximum number of target nodes reachable in the first graph,
        // combined with the densest subgraph (most reachable nodes) in the second graph.
        // edges1: A 2D array representing the edges of the first graph.
        // edges2: A 2D array representing the edges of the second graph.
        // k: The maximum distance allowed to reach target nodes.

        List<List<Integer>> adj2 = buildList(edges2);
        // Build the adjacency list for the second graph using the 'buildList' function.
        int m = adj2.size(), maxiB = 0;
        // m: Number of nodes in the second graph.
        // maxiB: Maximum number of reachable nodes in the second graph.

        for (int i = 0; i < m; i++)
            // Iterate through each node in the second graph.
            maxiB = Math.max(maxiB, dfs(adj2, i, -1, k - 1));
            // For each node, perform DFS to count the number of reachable nodes within distance 'k-1'.
            // Update 'maxiB' with the maximum value found so far.

        List<List<Integer>> adj1 = buildList(edges1);
        // Build the adjacency list for the first graph using the 'buildList' function.
        int n = adj1.size();
        // n: Number of nodes in the first graph.
        int[] res = new int[n];
        // res: An array to store the result, where res[i] will store the maximum number of target nodes reachable from node 'i' in the first graph.

        for (int i = 0; i < n; i++)
            // Iterate through each node in the first graph.
            res[i] = dfs(adj1, i, -1, k) + maxiB;
            // For each node, perform DFS to count the number of reachable nodes within distance 'k'.
            // Add this count to 'maxiB' (the maximum number of reachable nodes in the second graph) and store the result in res[i].

        return res;
        // Return the result array 'res'.
    }
}