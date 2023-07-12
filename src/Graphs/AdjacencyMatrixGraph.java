package Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdjacencyMatrixGraph implements Graph {

    int [][] adjacencyMatrix ; // array to where we are going to store the relationship between edges and vertices of the graph.
    private GraphType graphType = GraphType.DIRECTED; // here we are specifying if the graph is directed or indirected.
    private int numVertices = 0; // specifying the total number of vertices in the graph.


    // constructor class for the Adjacency matrix graph
    public AdjacencyMatrixGraph(int numVertices , GraphType graphType){
        this.numVertices = numVertices ;
        this.graphType = graphType ;

        adjacencyMatrix = new int[numVertices][numVertices];

        for (int i = 0 ; i < numVertices ; i ++){
            for (int j = 0 ; j < numVertices ; j ++){
                adjacencyMatrix[i][j] = 0 ;
                //initialize the matrix and other information in the array.
            }
        }
    }



    @Override
    public void addEdge(int v1, int v2) //specify vertices that you want to connect such as v1 and v2 where v1 is the source vertex and v2 is the destination vertex.
     {
        if(v1 >= numVertices || v1 < 0 || v2 >= numVertices || v2 < 0){
            throw new IllegalArgumentException("Vertex number is not valid"); // checking if the vertices are valid or not.
        }

        adjacencyMatrix[v1][v2] = 1 ;  // setting the vertex row v1 and column v2 to 1.
        if(graphType == GraphType.UNDIRECTED){
            adjacencyMatrix[v2][v1] = 1 ; // if the graph type is undirected then the connection will go both ways - setting the column v1 and row v2 to 1.
        }
    }

    @Override
    public List<Integer> getAdjacentVertices(int v) {
        if(v >= numVertices || v < 0){
            throw new IllegalArgumentException("Vertex number is not valid");// checking if the vertices are valid or not.
        }

        List<Integer> adjacentVerticesList = new ArrayList<>();// this list will hold the adjacent elements.
        for(int i = 0 ; i < numVertices ; i++){
            if(adjacencyMatrix[v][i] != 0){
                adjacentVerticesList.add(i);// this loop will check if 1 is present in the cell then it means that vertex v is directly connected to the another vertex.
            }
        }

        Collections.sort(adjacentVerticesList);// this will always return the vertices in the ascending order.Sorting it in ascending order will make the return values consistent.
        return adjacentVerticesList;
    }

    @Override
    public int getIndegree(int v) {
        if(v < 0 || v >= numVertices){//check if the vertex is valid.
            throw new IllegalArgumentException("Vertex number is not valid.");
        }
        int indegree = 0;
        for(int i = 0 ; i < getNumVertices() ; i++){//iterating through all the vertices of the graph.
            if(adjacencyMatrix[i][v] != 0){
                indegree++; // check if current vertex is present as an adjacent vertex for any other vertex then increment the indegree count for the current vertex.
            }
        }
        return indegree;
    }

    @Override
    public int getNumVertices(){
        return numVertices;
    }
}
