package LinkedList;

public class Node1 {
    private String data;
    private Node next;

    public  Node1(String data){
        this.data=data;
    }

    public String getData(){
        return data;
    }
    public Node getNext(){
        return next;
    }
    public void setData(String data){
        this.data=data;
    }
    public void setNext(Node next){
        this.next=next;
    }
}
