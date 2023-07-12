package Algorithms.ShortestPathAlgoS;


import java.util.List;


public interface Graph{
    enum GraphType {
        DIRECTED,
        UNDIRECTED
    }

    void addEdge(int v1 , int v2);

    void addEdge(int v1 , int v2 , int weight);

    int getWeightedEdge(int v1 , int v2);

    List<Integer> getAdjacentVertices(int v) ;

    int getIndegree(int v);

    int getNumVertices();


}

