package Graphs;


import java.util.*;


public class AdjacencySetGraph implements Graph{



    public static class Node {// this class represents a  vertex.
        private int vertexNUM;
        private Set<Integer> adjacencySet = new HashSet<Integer>();
        // each node have a set of adjacent vertex.
        public Node(int vertexNUM){//each vertex has an index or unique number associated with it.
            this.vertexNUM = vertexNUM;
        }

        public int getVertexNUM() {
            return vertexNUM;
        }

        public void addEdge(int vertexNUM){
            adjacencySet.add(vertexNUM);// this is a helper method to add an edge with this node as the source.
        }

        public List<Integer> getAdjacentVertices() {
            // get the adjacent vertices for this node.
            List<Integer> sortedList = new ArrayList<>(adjacencySet);
            Collections.sort(sortedList);
            return sortedList;
        }
    }


    private List<Node> vertexList = new ArrayList<>();
    private GraphType graphType = GraphType.DIRECTED;
    private int numVertices = 0;


    public AdjacencySetGraph(int numVertices , GraphType graphType){
        this.numVertices = numVertices ;// a constructor class to initialize the data members
        for (int i = 0 ; i < numVertices ; i++){
            vertexList.add( new Node(i) ) ; // this loop will create as much as nodes that has been entered by the user.
        }
        this.graphType = graphType ;
    }


    @Override
    public void addEdge(int v1, int v2) {// specify the vertices , here v1 will be the source vertex and v2 is the destination vertex.

        if (v1 >= numVertices || v1 < 0 || v2 >= numVertices || v2 < 0) {
            throw new IllegalArgumentException("Vertex number is not valid: " + v1 + ", " + v2); // checking if the vertices are valid.
        }
        vertexList.get(v1).addEdge(v2);//first we will add v2 to the set of node v1.
        if(graphType == GraphType.UNDIRECTED){
            vertexList.get(v2).addEdge(v1); // if the graph is undirected then it will make the connection both sides by adding v1 to the set of node v2.
        }

    }

    @Override
    public List<Integer> getAdjacentVertices(int v) {
        if (v >= numVertices || v < 0) {
            // checking if the vertices are valid.
            throw new IllegalArgumentException("Vertex number is not valid: " + v);
        }

        return vertexList.get(v).getAdjacentVertices(); //just return the adjacent vertices from the node class.
    }

    @Override
    public int getIndegree(int v) {
        if(v < 0 || v >= numVertices){
            throw new IllegalArgumentException("Vertex number is not valid.");
        }
        int inDegree = 0;
        for(int i = 0 ; i < numVertices ; i++){//iterating through all the vertices of the graph.
            if(getAdjacentVertices(i).contains(v)){
                inDegree++; // check if current vertex is present as an adjacent vertex for any other vertex then increment the indegree count for the current vertex.
            }
        }
        return inDegree;
    }

    @Override
    public int getNumVertices() {
        return numVertices;
    }


}


