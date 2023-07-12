package LinkedList;

//add(data)
  //      1.Create a new node with the given data
    //    2.If the linked list is empty, then make this new node the head and the tail node
      //  3.Else,
      //  a.Make the link of the tail node refer to the new node
      //  b.Make the tail refer to the new node
class Linked1{
    private Node_0 head;
    private Node_0 tail;

    public Node_0 getHead() {
        return head;
    }

    public Node_0 getTail() {
        return tail;
    }

    public void addAtEnd(String data){

        Node_0 node1=new Node_0(data);//Creating a new node.

        if(head==null){
            this.head=this.tail=node1;
        }
        else{
            this.tail.setNext(node1);
            this.tail=node1;
        }
    }

}
class Node_0{
    private String data;
    private Node_0 next;

    public Node_0(String data){
        this.data=data;
    }

    public void setData(String data){
        this.data=data;
    }
    public void setNext(Node_0 next){
        this.next=next;
    }
    public String getData(){
        return  data;
    }
    public Node_0 getNext(){
        return next;
    }

}
class testLinkedList{
    public static void main(String args[]){
        Linked1 list1=new Linked1();
        list1.addAtEnd("My");
        list1.addAtEnd("Name");
        list1.addAtEnd("Is");
        list1.addAtEnd("Sambhav");
        list1.addAtEnd("Jain");
        System.out.println("The elements are being added.");
    }

}