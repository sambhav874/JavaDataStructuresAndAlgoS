package Algorithms.MinimumSpanningTreeAlgoS.problems_PrimS;

import java.util.*;

public class problem_1 {
    /**
     * You are designing a network infrastructure for a city. Given a list of locations and the distances between them,
     * find the minimum cost to connect all locations together using the minimum amount of cable.
     * Implement the Prim's algorithm to calculate the minimum cost of connecting all locations.
     */

    public static class Edge {
        private int source;
        private int destination;
        private int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static List<Edge> minimumSpanningTree(List<Edge> edges, int numVertices) {
        List<Edge> minimumSpanningTree = new ArrayList<>();
        boolean[] visited = new boolean[numVertices];
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

        // Start from the first vertex
        visited[0] = true;

        // Add all edges connected to the first vertex to the priority queue
        for (Edge edge : edges) {
            if (edge.source == 0) {
                priorityQueue.add(edge);
            }
        }

        // Process the remaining vertices
        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            int destination = edge.destination;

            if (!visited[destination]) {
                visited[destination] = true;
                minimumSpanningTree.add(edge);

                // Add all edges connected to the newly visited vertex to the priority queue
                for (Edge nextEdge : edges) {
                    if (nextEdge.source == destination) {
                        priorityQueue.add(nextEdge);
                    }
                }
            }
        }

        return minimumSpanningTree;
    }

    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 2));
        edges.add(new Edge(0, 2, 3));
        edges.add(new Edge(1, 2, 1));
        edges.add(new Edge(1, 3, 4));
        edges.add(new Edge(2, 3, 2));

        int numVertices = 4;

        List<Edge> minimumSpanningTree = minimumSpanningTree(edges, numVertices);

        System.out.println("Minimum Spanning Tree:");
        for (Edge edge : minimumSpanningTree) {
            System.out.println(edge.source + " - " + edge.destination + " : " + edge.weight);
        }
    }
}
