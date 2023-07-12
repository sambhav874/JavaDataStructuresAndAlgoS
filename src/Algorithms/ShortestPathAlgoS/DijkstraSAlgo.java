package Algorithms.ShortestPathAlgoS;


import java.util.*;

public class DijkstraSAlgo {
    public static class DistanceInfo{
        private int lastVertex;
        private int distance;
        public DistanceInfo(){
            lastVertex=-1;
            distance=Integer.MAX_VALUE;
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

    public static class VertexInfo{
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

        public VertexInfo(int vertexId , int distance){
            this.vertexId = vertexId;
            this.distance = distance;
        }
    }
    public static Map<Integer , DistanceInfo> buildDistanceTable( Graph graph , int source){
        Map<Integer, DistanceInfo> distanceTable = new HashMap<>();
        PriorityQueue<VertexInfo> queue = new PriorityQueue<>(new Comparator<VertexInfo>() {
            @Override
            public int compare(VertexInfo v1, VertexInfo v2) {
                return ((Integer) v1.getDistance()).compareTo(v2.getDistance());
            }
        });
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
                // Get the new distance, account for the weighted edge.
                int distance = distanceTable.get(currentVertex).getDistance()
                        + graph.getWeightedEdge(currentVertex, neighbour);

                // If we find a new shortest path to the neighbour update
                // the distance and the last vertex.
                if (distanceTable.get(neighbour).getDistance() > distance) {
                    distanceTable.get(neighbour).setDistance(distance);
                    distanceTable.get(neighbour).setLastVertex(currentVertex);

                    // We've found a new short path to the neighbour so remove
                    // the old node from the priority queue.
                    VertexInfo neighbourVertexInfo = vertexInfoMap.get(neighbour);
                    if (neighbourVertexInfo != null) {
                        queue.remove(neighbourVertexInfo);
                    }

                    // Add the neighbour back with a new updated distance.
                    neighbourVertexInfo = new VertexInfo(neighbour, distance);
                    queue.add(neighbourVertexInfo);
                    vertexInfoMap.put(neighbour, neighbourVertexInfo);
                }
            }
        }
        return distanceTable;
}


public static void shortestPath(Graph graph , int source , int destination){
    Map<Integer, DistanceInfo> distanceTable = buildDistanceTable(graph, source);

    Stack<Integer> stack = new Stack<>();
    stack.push(destination);

    int previousVertex = distanceTable.get(destination).getLastVertex();
    while (previousVertex != -1 && previousVertex != source) {
        stack.push(previousVertex);
        previousVertex = distanceTable.get(previousVertex).getLastVertex();
    }

    if (previousVertex == -1) {
        System.out.println("There is no path from node: " + source
                + " to node: " + destination);
    }
    else {
        System.out.print("Smallest Path is " + source);
        while (!stack.isEmpty()) {
            System.out.print(" -> " +stack.pop());
        }
        System.out.println(" Dijkstra  DONE!");
    }
}

public static void main(String[] args){

    Graph graph = new AdjacencyMatrixGraph(8 , Graph.GraphType.DIRECTED);
    graph.addEdge(1, 0 , 7);
    graph.addEdge(1, 2 ,4);
    graph.addEdge(2, 7 , 2);
    graph.addEdge(2, 4 ,5);
    graph.addEdge(2, 3,1);
    graph.addEdge(1, 5,2);
    graph.addEdge(5, 6,9);
    graph.addEdge(6, 3,1);
    graph.addEdge(3, 4,4);

    shortestPath(graph , 1 ,6);



    Graph graph1 = new AdjacencyMatrixGraph(8, Graph.GraphType.DIRECTED);
    graph1.addEdge(2, 7, 4);
    graph1.addEdge(0, 3, 2);
    graph1.addEdge(0, 4, 2);
    graph1.addEdge(0, 1, 1);
    graph1.addEdge(2, 1, 3);
    graph1.addEdge(1, 3, 2);
    graph1.addEdge(3, 5, 1);
    graph1.addEdge(3, 6, 3);
    graph1.addEdge(4, 7, 2);
    graph1.addEdge(7, 5, 4);

    shortestPath(graph1, 0, 5);
}
}
