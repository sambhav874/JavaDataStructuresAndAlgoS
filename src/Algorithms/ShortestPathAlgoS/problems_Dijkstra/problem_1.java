package Algorithms.ShortestPathAlgoS.problems_Dijkstra;

//Question: You are given a network with multiple nodes and connections between them, each with a specific weight.
// Write a Java program to determine the shortest path for data packets to travel from a source node to a destination node,
// considering the weights of the connections as the travel time.

// You need to implement Dijkstra's algorithm to find the shortest path from the source node to the destination node,
// considering the weights as the travel time. Assume that the network connections are represented as a graph with nodes and edges,
// and each edge has a weight representing the travel time between nodes.
//
// Implement the 'shortestPath' function to calculate the shortest path from the source node to the destination node
// and return the path as a list of nodes.


import Algorithms.ShortestPathAlgoS.AdjacencyMatrixGraph;
import Algorithms.ShortestPathAlgoS.Graph;
import java.util.*;

public class problem_1 {

    public static class DistanceInfo {
        private int lastVertex;
        private int distance;

        public DistanceInfo() {
            lastVertex = -1;
            distance = Integer.MAX_VALUE;
        }

        public int getDistance() {
            return distance;
        }

        public int getLastVertex() {
            return lastVertex;
        }

        public void setLastVertex(int lastVertex) {
            this.lastVertex = lastVertex;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }
    }

    public static class VertexInfo {
        private int vertexId;
        private int distance;

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public int getDistance() {
            return distance;
        }

        public int getVertexId() {
            return vertexId;
        }

        public void setVertexId(int vertexId) {
            this.vertexId = vertexId;
        }

        public VertexInfo(int vertexId, int distance) {
            this.vertexId = vertexId;
            this.distance = distance;
        }
    }

    public static Map<Integer, DistanceInfo> buildDistanceTable(Graph graph, int source) {
        Map<Integer, DistanceInfo> distanceTable = new HashMap<>();
        PriorityQueue<VertexInfo> queue = new PriorityQueue<>(Comparator.comparingInt(VertexInfo::getDistance));
        Map<Integer, VertexInfo> vertexInfoMap = new HashMap<>();

        for (int j = 0; j < graph.getNumVertices(); j++) {
            distanceTable.put(j, new DistanceInfo());
        }

        distanceTable.get(source).setDistance(0);
        distanceTable.get(source).setLastVertex(source);

        VertexInfo sourceVertexInfo = new VertexInfo(source, 0);
        queue.add(sourceVertexInfo);
        vertexInfoMap.put(source, sourceVertexInfo);

        while (!queue.isEmpty()) {
            VertexInfo vertexInfo = queue.poll();
            int currentVertex = vertexInfo.getVertexId();

            for (Integer neighbour : graph.getAdjacentVertices(currentVertex)) {
                int distance = distanceTable.get(currentVertex).getDistance() + graph.getWeightedEdge(currentVertex, neighbour);

                if (distanceTable.get(neighbour).getDistance() > distance) {
                    distanceTable.get(neighbour).setDistance(distance);
                    distanceTable.get(neighbour).setLastVertex(currentVertex);

                    VertexInfo neighbourVertexInfo = vertexInfoMap.get(neighbour);
                    if (neighbourVertexInfo != null) {
                        queue.remove(neighbourVertexInfo);
                    }

                    neighbourVertexInfo = new VertexInfo(neighbour, distance);
                    queue.add(neighbourVertexInfo);
                    vertexInfoMap.put(neighbour, neighbourVertexInfo);
                }
            }
        }

        return distanceTable;
    }

    public static void shortestPath(Graph graph, int source, int destination) {
        Map<Integer, DistanceInfo> distanceTable = buildDistanceTable(graph, source);

        Stack<Integer> stack = new Stack<>();
        stack.push(destination);

        int previousVertex = distanceTable.get(destination).getLastVertex();
        while (previousVertex != -1 && previousVertex != source) {
            stack.push(previousVertex);
            previousVertex = distanceTable.get(previousVertex).getLastVertex();
        }

        if (previousVertex == -1) {
            System.out.println("There is no path from node " + source + " to node " + destination);
        } else {
            System.out.print("Shortest path from node " + source + " to node " + destination + ": ");
            System.out.print(source);
            while (!stack.isEmpty()) {
                System.out.print(" -> " + stack.pop());
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph graph = new AdjacencyMatrixGraph(6, Graph.GraphType.DIRECTED);
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 7);
        graph.addEdge(2, 4, 3);
        graph.addEdge(3, 4, 1);
        graph.addEdge(3, 5, 5);
        graph.addEdge(4, 5, 2);

        int sourceNode = 0;
        int destinationNode = 5;
        shortestPath(graph, sourceNode, destinationNode);
    }
}
