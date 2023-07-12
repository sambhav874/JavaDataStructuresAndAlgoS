package Algorithms.MinimumSpanningTreeAlgoS.problems_PrimS;

import java.util.*;

public class problem_2 {
    /**
     * You are managing a delivery service. Given a list of cities and the transportation costs between them,
     * determine the minimum cost to deliver packages to all cities from a central hub.
     * Implement the Prim's algorithm to calculate the minimum cost of delivering packages to all cities.
     */

    public static class Edge {
        private int source;
        private int destination;
        private int cost;

        public Edge(int source, int destination, int cost) {
            this.source = source;
            this.destination = destination;
            this.cost = cost;
        }
    }

    public static List<Edge> minimumCostDelivery(List<Edge> edges, int numCities) {
        List<Edge> minimumCostDelivery = new ArrayList<>();
        boolean[] visited = new boolean[numCities];
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));

        // Start from the first city
        visited[0] = true;

        // Add all edges connected to the first city to the priority queue
        for (Edge edge : edges) {
            if (edge.source == 0) {
                priorityQueue.add(edge);
            }
        }

        // Process the remaining cities
        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            int destination = edge.destination;

            if (!visited[destination]) {
                visited[destination] = true;
                minimumCostDelivery.add(edge);

                // Add all edges connected to the newly visited city to the priority queue
                for (Edge nextEdge : edges) {
                    if (nextEdge.source == destination) {
                        priorityQueue.add(nextEdge);
                    }
                }
            }
        }

        return minimumCostDelivery;
    }

    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 2));
        edges.add(new Edge(0, 2, 3));
        edges.add(new Edge(0, 3, 1));
        edges.add(new Edge(1, 2, 4));
        edges.add(new Edge(1, 3, 2));
        edges.add(new Edge(2, 3, 3));

        int numCities = 4;

        List<Edge> minimumCostDelivery = minimumCostDelivery(edges, numCities);

        System.out.println("Minimum Cost Delivery:");
        for (Edge edge : minimumCostDelivery) {
            System.out.println(edge.source + " - " + edge.destination + " : " + edge.cost);
        }
    }
}

