package Algorithms.ShortestPathAlgoS;

import Graphs.AdjacencyMatrixGraph;
import Graphs.Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class UnweightedShortestPath {
    public static class DistanceInfo{
        private int lastVertex;
        private int distance;
        public DistanceInfo(){
            lastVertex=-1;
            distance=-1;
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
    public static Map<Integer, DistanceInfo> buildDistanceTable(Graph graph , int source){
        Map<Integer , DistanceInfo> distanceTable = new HashMap<>();
        for(int i = 0 ;  i < graph.getNumVertices() ; i++){
            distanceTable.put(i ,new DistanceInfo());// set an entry in the distance table for every vertex in the graph.
        }
        distanceTable.get(source).setDistance(0);// initialize the distance to source and the last vertex in the path to source.
        distanceTable.get(source).setLastVertex(source);

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(source);

        while(!queue.isEmpty()){
            int currentVertex = queue.pollLast();
            for(int i : graph.getAdjacentVertices(currentVertex)){// explore the neighboring vertices of every vertex added to the queue.
                int currentDistance = distanceTable.get(i).getDistance();
                if(currentDistance == -1){
                    currentDistance = 1 + distanceTable.get(currentVertex).getDistance();
                    distanceTable.get(i).setDistance(currentDistance);// if the vertex is seen for the first time then update its entry in the distance table.
                    distanceTable.get(i).setLastVertex(currentVertex);

                    //Enqueue the neighbour only if it has other adjacent vertices so the neighbours can be explored.
                    if(!graph.getAdjacentVertices(1).isEmpty()){
                        queue.add(i);
                    }
                }

            }
        }
        return distanceTable;
    }

    public static void shortestPath(Graph graph , int source , int destination){

        Map<Integer , DistanceInfo> table = buildDistanceTable(graph , source);// build the distance table for whole graph.

        Stack<Integer> stack = new Stack<>();
        stack.push(destination);// backtrack using a stack start from the destination node.

        int previousVertex = table.get(destination).getLastVertex();
        while(previousVertex != -1 && previousVertex != source){// backtrack by getting the last vertex of every node and adding it to the stack.
            stack.push(previousVertex);
            previousVertex = table.get(previousVertex).getLastVertex();
        }
        if(previousVertex == -1){// if no valid last vertex was found in the distance table there was no path from source to destination.
            System.out.println("There is no path from node: "+ source +" to node: "+destination);

        }
        else {
            System.out.print("Smallest path is "+ source);
            while (!stack.isEmpty()){
                System.out.print(" -> " + stack.pop());
            }
            System.out.println("    Shortest path unweighted done.  ");
        }
    }
    public static void main(String[] args){


        Graph graph = new AdjacencyMatrixGraph(8 , Graph.GraphType.DIRECTED);
        graph.addEdge(1, 0);
        graph.addEdge(1, 2);
        graph.addEdge(2, 7);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(1, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 3);
        graph.addEdge(3, 4);

        shortestPath(graph , 1 ,6);



        Graph graph1 = new AdjacencyMatrixGraph(8, Graph.GraphType.DIRECTED);
        graph1.addEdge(2, 7);
        graph1.addEdge(3, 0);
        graph1.addEdge(0, 4);
        graph1.addEdge(0, 1);
        graph1.addEdge(2, 1);
        graph1.addEdge(1, 3);
        graph1.addEdge(3, 5);
        graph1.addEdge(6, 3);
        graph1.addEdge(4, 7);

        shortestPath(graph1, 1, 7);
    }

}
