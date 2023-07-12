package Algorithms.ShortestPathAlgoS;

import java.util.*;

public class BellmanFordAlgo {
    public static class DistanceInfo {

        private int distance;
        private int lastVertex;

        public DistanceInfo() {
            // The initial distance to all nodes is assumed
            // infinite.
            distance = 10000;
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

    public static Map<Integer , DistanceInfo> buildDistanceTable(Graph graph , int source ){
        Map<Integer , DistanceInfo > table = new HashMap<>();
        for(int i = 0; i < graph.getNumVertices() ; i++){
            table.put(i , new DistanceInfo());
        }
        table.get(source).setDistance(0);
        table.get(source).setLastVertex(source);

        LinkedList<Integer> queue = new LinkedList<>();

        //relaxing (processing) all the edges numVertices - 1 times.
        for(int j = 0 ; j < graph.getNumVertices() - 1 ; j++){
            for(int v = 0 ; v < graph.getNumVertices() ; v++){
                queue.add(v);
            }
            Set<String> visitedEdges = new HashSet<>();
            while(!queue.isEmpty()){
                int currentIndex = queue.pollLast();

                for(int neighbour : graph.getAdjacentVertices(currentIndex)){
                    String edge = String.valueOf(currentIndex) + String.valueOf(neighbour);

                    if(visitedEdges.contains(edge)){
                        continue;
                    }

                    visitedEdges.add(edge);
                    int distance= table.get(currentIndex).getDistance() + graph.getWeightedEdge(currentIndex , neighbour);

                    if(table.get(neighbour).getDistance() > distance){
                        table.get(neighbour).setDistance(distance);
                        table.get(neighbour).setLastVertex(currentIndex);
                    }

                }

            }

        }
        for(int v =0 ; v < graph.getNumVertices() ; v++){
            queue.add(v);
        }

        while (!queue.isEmpty()){
            int currentVertex = queue.pollFirst();
            for(int neighbor : graph.getAdjacentVertices(currentVertex)){
            int distance = table.get(currentVertex).getDistance() + graph.getWeightedEdge(currentVertex , neighbor);

            if(table.get(neighbor).getDistance() > distance){
                throw new IllegalArgumentException("The graph have a negative cycle .");
            }
            }
        }
        return table;
    }

    public static void shortestPath(Graph graph , int source , int destination){
        Map<Integer , DistanceInfo> table = buildDistanceTable(graph , source);

        Stack<Integer> stack = new Stack<>();
        stack.push(destination);

        int previousVertex = table.get(destination).getLastVertex();
        while(previousVertex != -1 && previousVertex != source ){
            stack.push(previousVertex);
            previousVertex = table.get(previousVertex).getLastVertex();
        }

        if(previousVertex == -1){
            System.out.println("There is no path from node: " + source
                    + " to node: " + destination);
        }
        else {
            System.out.print("Smallest Path is " + source);
            while (!stack.isEmpty()) {
                System.out.print(" -> " +stack.pop());
            }
            System.out.println(" Bellman Ford  DONE!");
        }

    }

    public static void main(String[] args){


        Graph graph1 = new AdjacencyMatrixGraph(8, Graph.GraphType.DIRECTED);
        graph1.addEdge(2, 7, 4);
        graph1.addEdge(0, 3, 23);
        graph1.addEdge(0, 4, 23);
        graph1.addEdge(0, 1, 1);
        graph1.addEdge(2, 1, 3);
        graph1.addEdge(1, 3, 2);
        graph1.addEdge(3, 5, 1);
        graph1.addEdge(3, 6, 3);
        graph1.addEdge(4, 7, 2);
        graph1.addEdge(7, 5, 4);

        shortestPath(graph1, 0, 5);


        Graph graph2 = new AdjacencyMatrixGraph(5, Graph.GraphType.DIRECTED);
        graph2.addEdge(0, 1, 2);
        graph2.addEdge(0, 2, 1);
        graph2.addEdge(1, 3, 3);
        graph2.addEdge(1, 4, -2);
        graph2.addEdge(2, 4, 2);
        graph2.addEdge(4, 3, 1);
        graph2.addEdge(2, 1, -5);

        shortestPath(graph2, 0, 3);

        Graph graph3 = new AdjacencyMatrixGraph(5, Graph.GraphType.DIRECTED);
        graph3.addEdge(0, 1, 2);
        graph3.addEdge(0, 2, 3);
        graph3.addEdge(3, 1, 2);
        graph3.addEdge(1, 4, -5);
        graph3.addEdge(2, 4, 6);
        graph3.addEdge(4, 3, -4);

        shortestPath(graph3, 0, 3);

        Graph graph4 = new AdjacencyMatrixGraph(6, Graph.GraphType.DIRECTED);
        graph4.addEdge(0, 1, 2);
        graph4.addEdge(1, 2, 3);
        graph4.addEdge(2, 3, 2);
        graph4.addEdge(3, 4, -5);
        graph4.addEdge(3, 5, 1);
        graph4.addEdge(4, 5, -3);
        graph4.addEdge(5, 4, -3);

        shortestPath(graph4, 0, 5);


    }
}
