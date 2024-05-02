// Problem Link: https://leetcode.com/problems/course-schedule/description/

// // Problem:
// There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
// For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
// Return true if you can finish all courses. Otherwise, return false.

// Example 1:
// Input: numCourses = 2, prerequisites = [[1,0]]
// Output: true
// Explanation: There are a total of 2 courses to take. 
// To take course 1 you should have finished course 0. So it is possible.

// Example 2:
// Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
// Output: false
// Explanation: There are a total of 2 courses to take. 
// To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

// Constraints:
// 1 <= numCourses <= 2000
// 0 <= prerequisites.length <= 5000
// prerequisites[i].length == 2
// 0 <= ai, bi < numCourses
// All the pairs prerequisites[i] are unique.

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

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create a graph with numCourses vertexes
        Graph graph = new Graph(numCourses);
        for (int i = 0; i < prerequisites.length; i++) {
            // Course to take
            int course = prerequisites[i][0];
            // Prerequisite for this course
            int pre = prerequisites[i][1];
            // Create graph which shows each course' prerequisite
            Graph.Edge edge = graph.new Edge(pre);
            graph.addEdge(course, edge);
        }

        boolean[] visited = new boolean[numCourses];
        // track current path searcing courses
        boolean[] currentSearch = new boolean[numCourses];

        // Check each course to see if it is part of a cycle(if there is a cycle, then we can never take those courses)
        for (int course = 0; course < numCourses; course++) {
            if (!visited[course]) { 
                // If not visited, use depth first search to search from this course, if there is a cycle, return false
                if (isCycle(course, visited, currentSearch, graph)) {
                    return false;
                }
            }
        }
        return true; // If no cycles detected in any component, return true
    }

    private boolean isCycle(int vertex, boolean[] visited, boolean[] currentSearch, Graph graph) {
        // If the vertex is already in the currentSearch path, a cycle is detected
        if (currentSearch[vertex]) {
            return true;
        }
        if (visited[vertex]) {
            return false; // If already visited and not in currentSearch, no cycle from this vertex
        }
        
        // Mark the vertex as visited
        visited[vertex] = true;
        // set current searching to true for this vertex
        currentSearch[vertex] = true;
        // check all the edges
        Graph.Edge edge = graph.getGraph()[vertex];
        while (edge != null) {
            if (isCycle(edge.neighbor, visited, currentSearch, graph)) {
                return true; 
            }
            edge = edge.next; // Move to the next edge in the adjacency list
        }
        // Remove vertex from the current search array after exploring all neighbors
        currentSearch[vertex] = false;
        return false;
    }
}
