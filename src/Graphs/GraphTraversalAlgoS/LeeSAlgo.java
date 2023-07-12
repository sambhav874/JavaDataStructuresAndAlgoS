package Graphs.GraphTraversalAlgoS;

import Algorithms.ShortestPathAlgoS.AdjacencyMatrixGraph;
import Algorithms.ShortestPathAlgoS.Graph;

import java.util.*;

public class LeeSAlgo {
    public static void main(String[] args) {
        // Create the graph and add edges
        Graph graph = new AdjacencyMatrixGraph(8, Graph.GraphType.DIRECTED);
        graph.addEdge(2, 7, 4);
        graph.addEdge(0, 3, 23);
        graph.addEdge(0, 4, 23);
        graph.addEdge(0, 1, 1);
        graph.addEdge(2, 1, 3);
        graph.addEdge(1, 3, 2);
        graph.addEdge(3, 5, 1);
        graph.addEdge(3, 6, 3);
        graph.addEdge(4, 7, 2);
        graph.addEdge(7, 5, 4);

        int source = 0;
        int destination = 5;

        shortestPath(graph, source, destination);
    }

    public static void shortestPath(Graph graph, int source, int destination) {
        // Create a visited array to keep track of visited nodes
        boolean[] visited = new boolean[graph.getNumVertices()];

        // Create a queue for BFS traversal
        Queue<Integer> queue = new LinkedList<>();

        // Mark the source node as visited and enqueue it
        visited[source] = true;
        queue.add(source);

        // Create an array to store the previous node of each vertex in the shortest path
        int[] previous = new int[graph.getNumVertices()];
        Arrays.fill(previous, -1);

        // Perform BFS
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            // Stop BFS if the destination vertex is reached
            if (currentVertex == destination)
                break;

            // Get all adjacent vertices of the current vertex
            List<Integer> adjacentVertices = graph.getAdjacentVertices(currentVertex);
            for (int neighbor : adjacentVertices) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    previous[neighbor] = currentVertex;
                    queue.add(neighbor);
                }
            }
        }

        // If no path is found from source to destination
        if (previous[destination] == -1) {
            System.out.println("There is no path from node " + source + " to node " + destination);
        } else {
            // Reconstruct the shortest path
            Stack<Integer> stack = new Stack<>();
            int currentVertex = destination;
            while (currentVertex != -1) {
                stack.push(currentVertex);
                currentVertex = previous[currentVertex];
            }

            // Print the shortest path
            System.out.print("Shortest Path: ");
            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }
            System.out.println();
        }
    }
}

