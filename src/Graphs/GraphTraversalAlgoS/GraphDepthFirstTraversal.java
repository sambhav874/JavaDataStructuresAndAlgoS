package Graphs.GraphTraversalAlgoS;

import Graphs.AdjacencyMatrixGraph;
import Graphs.Graph;

import java.util.List;

public class GraphDepthFirstTraversal {
    public static void depthTraversal(Graph graph , int[] visited , int currentVertex){
        if(visited[currentVertex] == 1){
            return;
        }
        visited[currentVertex] = 1;

        List<Integer> list = graph.getAdjacentVertices(currentVertex);
        for(int vertex : list){
            depthTraversal(graph, visited, vertex);
        }
        System.out.print(currentVertex + " -> ");
    }
    private static int N = 8;
    public static void main(String[] args){

        Graph graph = new AdjacencyMatrixGraph(N, Graph.GraphType.DIRECTED);
        graph.addEdge(1, 0);
        graph.addEdge(1, 2);
        graph.addEdge(2, 7);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(1, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 3);
        graph.addEdge(3, 4);

        int[] visited = new int[] {0, 0, 0, 0, 0, 0, 0, 0};

        for (int i = 0; i < N; i++) {
            depthTraversal(graph, visited, i);
        }
    }

}
