package Algorithms.MinimumSpanningTreeAlgoS;

import Algorithms.ShortestPathAlgoS.AdjacencyMatrixGraph;
import Algorithms.ShortestPathAlgoS.Graph;

import java.util.*;

public class PrimSAlgo {

    public static class DistanceInfo{
        private int distance;
        private int lastVertex;

        public DistanceInfo() {
            // The initial distance to all nodes is assumed
            // infinite.
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

    public static class VertexInfo{

        private int vertexId;
        private int distance;

        public VertexInfo(int vertexId, int distance) {
            this.vertexId = vertexId;
            this.distance = distance;
        }

        public int getVertexID() {
            return vertexId;
        }

        public int getDistance() {
            return distance;
        }
    }

    public static void spanningTree(Graph graph , int source){
        Map<Integer , DistanceInfo> distanceTable = new HashMap<>();

        //Setup a priority queue which returns node in order to order of the shortest distance from the source. This is called "Greedy Solution".

        PriorityQueue<VertexInfo> queue = new PriorityQueue<>(new Comparator<VertexInfo>() {
            @Override
            public int compare(VertexInfo v1, VertexInfo v2) {
                return ((Integer) v1.getDistance()).compareTo(v2.getDistance());
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });
        for(int i = 0 ; i < graph.getNumVertices() ; i++){
            distanceTable.put(i , new DistanceInfo());// add a distance table entry for each node in the graph.
        }

        distanceTable.get(source).setDistance(0);
        distanceTable.get(source).setLastVertex(source);

        Map <Integer, VertexInfo> vertexInfoMap = new HashMap<>();

        // add the source to the priority queue and setup a mapping to the mapping to the vertex info for every vertex in the queue.
        VertexInfo sourceVertexInfo = new VertexInfo(source, 0);
        queue.add(sourceVertexInfo);
        vertexInfoMap.put(source , sourceVertexInfo);

        //the spanning tree is the set of edges connecting all the nodes of the graph , an edge is represented by 01 if it connects vertices 0 and 1.
        Set<String> spanningTree = new HashSet<>();
        Set<Integer> visitedVertices = new HashSet<>();
        // the vertices which we have already included in the spanning tree.

        while(!queue.isEmpty()){
            VertexInfo vertexInfo = queue.poll();
            //access the priority queue to find the closest vertex following the greedy algorithm.
            int currentVertex = vertexInfo.getVertexID();

            //Do not revisit vertices which are already part of the spanning tree.
            if(visitedVertices.contains(currentVertex)){
                continue;
            }
            visitedVertices.add(currentVertex);

            //if the current vertex is a source we don't have an edge yet.
            if(currentVertex != source){
                String edge = String.valueOf(currentVertex) + String.valueOf(distanceTable.get(currentVertex).getLastVertex());
                // here the first string value is the current vertex and the second string value is the last vertex id at the first iteraation it would start from the source.
                if(!spanningTree.contains(edge)){
                    spanningTree.add(edge);
                    //add the edge to the spanning tree if it does not already exist.
                }
            }

            for(Integer neighbour : graph.getAdjacentVertices(currentVertex)){
                // note that we only consider the weight of edge in assigningt the distance to a node , not the current distance from source to that node.
                int distance = graph.getWeightedEdge(currentVertex , neighbour);

                //if we find a new shortest path to the neighbour update the distance and the last vertex.
                if(distanceTable.get(neighbour).getDistance() > distance) {

                    distanceTable.get(neighbour).setDistance(distance);
                    distanceTable.get(neighbour).setLastVertex(currentVertex);


                    VertexInfo neighbourVertexInfo = vertexInfoMap.get(neighbour);
                    if (neighbourVertexInfo != null) {
                        queue.remove(neighbourVertexInfo);
                    }

                    neighbourVertexInfo = new VertexInfo(neighbour, distance);
                    vertexInfoMap.put(neighbour, neighbourVertexInfo);
                    queue.add(neighbourVertexInfo);
                }
            }
        }
        for(String edge : spanningTree){
            System.out.println(edge);
        }
    }

    public static void main(String[] args){
        Graph graph1 = new AdjacencyMatrixGraph(8, Graph.GraphType.UNDIRECTED);
        graph1.addEdge(2, 7, 4);
        graph1.addEdge(0, 3, 2);
        graph1.addEdge(0, 4, 2);
        graph1.addEdge(0, 1, 1);
        graph1.addEdge(2, 1, 3);
        graph1.addEdge(1, 3, 2);
        graph1.addEdge(3, 5, 1);
        graph1.addEdge(3, 6, 3);
        graph1.addEdge(4, 7, 22);
        graph1.addEdge(7, 5, 4);

        // the two digit number in the output represents the edges the ones place represent the vertex id of the last vertex and the tens place represent the value of the currentVertex that is explored using the last vertex.

        spanningTree(graph1, 0);
    }
}
