package Algorithms.ShortestPathAlgoS;



import java.util.*;

public class TopologicalSort {
    public static int N = 8 ;
    public static void main(String[] args){
        Graph graph = new AdjacencyMatrixGraph(N , Graph.GraphType.DIRECTED);
        graph.addEdge(1, 0);
        graph.addEdge(1, 2);
        graph.addEdge(2, 7);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(1, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 3);
        graph.addEdge(3, 4);


        printList(sort(graph));

    }

public static List<Integer> sort(Graph graph){

    LinkedList<Integer> queue = new LinkedList<>();
    Map<Integer , Integer> inDegreeMap = new HashMap<>();//will store the mapping of the vertex with its indegree.

    for(int vertex = 0 ; vertex < graph.getNumVertices() ; vertex++){
        int indegree = graph.getIndegree(vertex);//initialize the indegree map by iterating through all vertices.
        inDegreeMap.put(vertex , indegree);
        if(indegree == 0){
            queue.add(vertex);// add all the vertices will indegree zero into the linked list to explore.
        }

    }
    List<Integer> sortedList = new ArrayList<>();
    while(!queue.isEmpty()){
        //dequeue of the nodes from the list if they are more than one.
        //if more than one element exists than it means that the graph has more than one topological graph solution.
        int vertex = queue.pollLast();
        sortedList.add(vertex);

        List<Integer> adjacentVertices = graph.getAdjacentVertices(vertex);
        for(int adjacentVertex : adjacentVertices){// get the adjacent vertices of the current one and decrement the indegree by 1.
            int updatedInDegree = inDegreeMap.get(adjacentVertex) - 1;
            inDegreeMap.remove(adjacentVertex);
            inDegreeMap.put(adjacentVertex , updatedInDegree);

            if(updatedInDegree == 0){
                queue.add(adjacentVertex); // for every vertex which has now 0 as its indegree , then its a potenial vertex or the topological sort.
            }
        }
    }
    if(sortedList.size() != graph.getNumVertices()){
        throw new RuntimeException("The graph has a cycle.");
    }
return sortedList;
    }

    public static void printList(List<Integer> list){
        for (int v : list){
            System.out.print(v + " , ");
        }
    }


}
