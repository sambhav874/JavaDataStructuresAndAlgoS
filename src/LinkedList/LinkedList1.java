package LinkedList;

public class LinkedList1 {
    private Node head;

    public void insertAtHead(int data) {
        Node newNode=new Node(data);
        newNode.setNextNode(this.head);
        this.head=newNode;
    }//Takes the parameter as data and works to enter the data into the node with the address of next node.

    public void deleteAtHead(){
        this.head=head.getNextNode();
    }

        public Node find(int data){
        Node current=this.head;

        while(current != null){
            if(current.getData()==data){
                return current;
            }
            current=current.getNextNode();
        }
        return null;
    }
    public int length(){
        int length=0;
        Node current=this.head;

        while(current !=null){
            length++;
            current=current.getNextNode();
        }
        return  length;
    }



    @Override
    public String toString(){
        String result="{";
        Node current=this.head;

        //this toString is working to print the content of linked list.


        while(current!=null){
            result+= current.toString()+",";
            current=current.getNextNode();
            //the while loop will print the content of the linked list until it is null.
        }
        result+="}";
        return result;
    }
}
