// Problem Link: https://leetcode.com/problems/graph-valid-tree/description/
// Problem:
// You have a graph of n nodes labeled from 0 to n - 1. 
// You are given an integer n and a list of edges where edges[i] = [ai, bi] indicates that there is an undirected edge between nodes ai and bi in the graph.
// Return true if the edges of the given graph make up a valid tree, and false otherwise.

// Example 1:
// Input: n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
// Output: true

// Example 2:
// Input: n = 5, edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]
// Output: false
 
// Constraints:
// 1 <= n <= 2000
// 0 <= edges.length <= 5000
// edges[i].length == 2
// 0 <= ai, bi < n
// ai != bi
// There are no self-loops or repeated edges.


// Solution:
class Solution {
    private class Graph {
        private Edge[] graph;

        public class Edge {
            private int neighbor;
            private Edge next;

            public Edge(int neighbor) {
                this.neighbor = neighbor;
                this.next = null;
            }
        }

        public Graph(int numVertices) {
            graph = new Edge[numVertices];
        }

        public void addEdge(int vertexId, Edge edge) {
            Edge head = graph[vertexId];
            graph[vertexId] = edge;
            if (head != null) {
                edge.next = head;
            }
        }

        public Edge[] getGraph() {
            return graph;
        }
    }

    public boolean validTree(int n, int[][] edges) {
        if (n <= 1) {
            return true;
        }

        // Create graph and put edges into an adjacency list:
        Graph graph = new Graph(n);
        for (int i = 0; i < edges.length; i++) {
            Graph.Edge edge1 = graph.new Edge(edges[i][1]);
            graph.addEdge(edges[i][0], edge1);
            Graph.Edge edge2 = graph.new Edge(edges[i][0]);
            graph.addEdge(edges[i][1], edge2);
        }

        boolean[] visited = new boolean[n];
        // start dfs from vertex 0 (no parent in the beginnig)
        // run dfs to check if there is a circle, it is, then it's not a valid tree(will return false)
        if (!dfs(0, -1, visited, graph)) {
            return false;
        }

        // Check if all vertex were visited (graph is connected)
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    // Depth-first search to check for cycles and if connected 
    private boolean dfs(int vertex, int parent, boolean[] visited, Graph graph) {
        visited[vertex] = true;
        Graph.Edge curr = graph.getGraph()[vertex];
        while (curr != null) {
            if (!visited[curr.neighbor]) {
                // if not visited yet, check it's neighbours
                if (!dfs(curr.neighbor, vertex, visited, graph)) {
                    return false;
                }
            } else if (curr.neighbor != parent) {
                // If an adjacent vertex is visited and is not the parent, it is a cycle, return false
                return false;
            }
            curr = curr.next;
        }
        return true;
    }
}
