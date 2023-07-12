package Algorithms.ShortestPathAlgoS;

import java.util.*;

public class FloydWarshallAlgo {
    public static class DistanceInfo {
        private int distance;
        private int lastVertex;

        public DistanceInfo() {
            // The initial distance to all nodes is assumed infinite.
            distance = Integer.MAX_VALUE;
            lastVertex = -1;
        }

        public int getDistance() {
            return distance;
        }

        public int getLastVertex() {
            return lastVertex;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public void setLastVertex(int lastVertex) {
            this.lastVertex = lastVertex;
        }
    }

    public static Map<Integer, DistanceInfo> buildDistanceTable(Graph graph, int source) {
        Map<Integer, DistanceInfo> table = new HashMap<>();
        int numVertices = graph.getNumVertices();

        for (int i = 0; i < numVertices; i++) {
            table.put(i, new DistanceInfo());
        }

        table.get(source).setDistance(0);
        table.get(source).setLastVertex(source);

        // Applying Floyd-Warshall algorithm
        for (int k = 0; k < numVertices; k++) {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    int distance = table.get(i).getDistance();
                    if (distance != Integer.MAX_VALUE && graph.getWeightedEdge(i, j) != 0
                            && distance + graph.getWeightedEdge(i, j) < table.get(j).getDistance()) {
                        table.get(j).setDistance(distance + graph.getWeightedEdge(i, j));
                        table.get(j).setLastVertex(i);
                    }
                }
            }
        }

        return table;
    }

    public static void shortestPath(Graph graph, int source, int destination) {
        Map<Integer, DistanceInfo> table = buildDistanceTable(graph, source);

        Stack<Integer> stack = new Stack<>();
        stack.push(destination);

        int previousVertex = table.get(destination).getLastVertex();
        while (previousVertex != -1 && previousVertex != source) {
            stack.push(previousVertex);
            previousVertex = table.get(previousVertex).getLastVertex();
        }

        if (previousVertex == -1) {
            System.out.println("There is no path from node: " + source + " to node: " + destination);
        } else {
            System.out.print("Smallest Path is " + source);
            while (!stack.isEmpty()) {
                System.out.print(" -> " + stack.pop());
            }
            System.out.println(" Floyd-Warshall DONE!");
        }
    }

    public static void main(String[] args) {
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
}
