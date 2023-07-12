package Algorithms.MinimumSpanningTreeAlgoS;

import Algorithms.ShortestPathAlgoS.AdjacencyMatrixGraph;
import Algorithms.ShortestPathAlgoS.Graph;

import java.util.*;

public class KruskalSAlgo {
    public static class EdgeInfo{
        private Integer v1;
        private Integer v2;
        private Integer weight;

        public EdgeInfo(int v1 , int v2 , int weight){
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }

        public Integer getV1() {
            return v1;
        }

        public Integer getV2() {
            return v2;
        }

        public Integer getWeight() {
            return weight;
        }

        @Override
        public String toString() {
            return String.valueOf(v1) + String.valueOf(v2);
        }
    }
    static void spanningTree(Graph graph){
        // A priority queue to store and recieve the edges on the basis of their weights.

        PriorityQueue<EdgeInfo> queue = new PriorityQueue<>(new Comparator<EdgeInfo>() {
            @Override
            public int compare(EdgeInfo v1, EdgeInfo v2) {
                //set up a priority queue which returns edges with the smallest weight as it is a "Greedy Solution".
                return v1.getWeight().compareTo(v2.getWeight());
            }
        });

        // add all the edges to priority queue.
        for(int i = 0 ; i < graph.getNumVertices() ; i++){
            for(int neighbour : graph.getAdjacentVertices(i)){
                queue.add(new EdgeInfo(i , neighbour , graph.getWeightedEdge(i , neighbour)));
            }
        }

        Set<EdgeInfo> spanningTree = new HashSet<>();
        Set<Integer> visitedVertices = new HashSet<>();
        //KEEP TRACK OF THE VERTICES ALREADY VISITED, EACH EDGE SHOULD ADD A NEW VERTEX TO THE SET TILL WE GET NUMBER OF VERTICES - 1 EDGES.
        //THE SPANNING TREE IS THE SET OF EDGES CONNECTING ALL THE NODES OF THE GRAPH, AN EDGE IS REPRESENTED BY "O1" IF IT CONNECTS VERTICES O AND 1

        Map<Integer , Set<Integer>> edgeMAP = new HashMap<>();

        for(int i = 0 ; i < graph.getNumVertices() ; i++){
            edgeMAP.put(i , new HashSet<>());
            //the edge map tracks the edges added to the spanning tree to see if it forms a cycle.
        }
        while(!queue.isEmpty() && spanningTree.size() < graph.getNumVertices() - 1 ){
            EdgeInfo currentEdge = queue.poll();

            //Add the new edge to the edge map and see if it ends up with a cycle.
            /// If yes then discard this edge and get the next edge from an priority queue.

            edgeMAP.get(currentEdge.getV1()).add(currentEdge.getV2());
            if(hasCycle(edgeMAP)){
                //ADD THE EDGE TO THE EDGE MAP AND SEE IF IT CAUSES A CYCLE - IF YES THEN DO NOT USE THE EDGE IN THE SPANNING TREE.
                edgeMAP.get(currentEdge.getV1()).remove(currentEdge.getV2());
                continue;
            }
            spanningTree.add(currentEdge);
            //Add both vertices to the visited list, the set will ensure
            //that only one copy of the vertex exists.

            visitedVertices.add(currentEdge.getV1());
            visitedVertices.add(currentEdge.getV2());
        }
//Check whether all vertices have been covered with the spanning tree.
        if(visitedVertices.size() != graph.getNumVertices()){
            System.out.println("Minimum Spanning Tree is not possible.");
        }
        else{
            System.out.println("Performing Minimum Spanning Tree using Kruskal's Algorithm.");
            for(EdgeInfo edge : spanningTree){
                System.out.println(edge);
            }
        }
    }

    public static boolean hasCycle(Map<Integer , Set<Integer>> edgeMAP){
        for(Integer sourceVertex : edgeMAP.keySet()){
            //start from every vertex in the edge map and explore all vertices present in the spanning tree.
            LinkedList<Integer> queue = new LinkedList<>();
            queue.add(sourceVertex);
            Set<Integer> visitedVertices = new HashSet<>();
            while (!queue.isEmpty()){
                int currentVertex = queue.poll();
                //if we ever re-visit a vertex we have already seen in the spanning tree it means there is a cycle in the spanning tree.
                if(visitedVertices.contains(currentVertex)){
                    return true;
                }

                visitedVertices.add(currentVertex);
                queue.addAll(edgeMAP.get(currentVertex));
                // add to queue all the adjacent vertices of the current vertex which are part of the spanning tree.
            }
        }
        return false;
    }

    public static void main(String[] args){
        Graph graph1 = new AdjacencyMatrixGraph(9, Graph.GraphType.UNDIRECTED);
        graph1.addEdge(2, 7, 4);
        graph1.addEdge(0, 3, 2);
        graph1.addEdge(0, 4, 2);
        graph1.addEdge(0, 1, 1);
        graph1.addEdge(2, 1, 3);
        graph1.addEdge(1, 3, 2);
        graph1.addEdge(3, 5, 3);
        graph1.addEdge(3, 6, 2);
        graph1.addEdge(4, 7, 22);
        graph1.addEdge(7, 5, 4);
        graph1.addEdge(6, 5, 1);

        spanningTree(graph1);


        Graph graph2 = new AdjacencyMatrixGraph(8, Graph.GraphType.UNDIRECTED);
        graph2.addEdge(2, 7, 4);
        graph2.addEdge(0, 3, 2);
        graph2.addEdge(0, 4, 2);
        graph2.addEdge(0, 1, 1);
        graph2.addEdge(2, 1, 3);
        graph2.addEdge(1, 3, 2);
        graph2.addEdge(3, 5, 1);
        graph2.addEdge(3, 6, 3);
        graph2.addEdge(4, 7, 22);
        graph2.addEdge(7, 5, 4);

        // the two digit number in the output represents the edges the ones place represent the vertex id of the last vertex and the tens place represent the value of the currentVertex that is explored using the last vertex.

        spanningTree(graph2);
    }
}
