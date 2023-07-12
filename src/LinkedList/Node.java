package LinkedList;

public class Node {
    private int data;
    private Node nextNode;

    public Node(int data){
        this.data=data;
    }//this is to initialize a Node.
    public int getData(){
        return data;
    }//to return data
    public Node getNextNode(){
        return nextNode;
    }//to return the address of next node.

    public void setData(int data){
        this.data=data;
    }//to set the data into the node.
    public void setNextNode(Node nextNode){
        this.nextNode=nextNode;
    }//to set the address of next node into the current node.

    @Override
    public String toString(){
        return "Data:"+this.data;
    } // to print the data.

    public void setNext(Node_0 node1) {
    }
}
