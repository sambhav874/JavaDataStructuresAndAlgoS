package assignment_LinkedLists;


class Node{
     private Object data;
     private Node next;

     public Node(Object data) {
         this.data=data;
         this.next=null;
     }

     public Node getNext() {
         return next;
     }

     public Object getData() {
         return data;
     }

     public void setData(int data) {
         this.data = data;
     }

     public void setNext(Node next) {
         this.next = next;
     }

 }
class queue{

    private Node rear=null;
    private int maxSize;
    private Node front=null;

    // rear represents the index position of the last element of the queue.
    // maxSize is the maximum number of elements that can be stored in the queue.
    // front represents the index position of the first element of the queue.


    queue(int maxSize){
        this.rear=null;
        //rear have the index -1 when the queue is created and it keeps changing as the elements keep on adding.
        this.front=null;
        // front will always be 0
        this.maxSize=0;

    }
    //En-queue: adds an element to the end of the queue
    //
    //De-queue: removes an element from the front of the queue. The items are removed in the same order as they were added unlike Stack.

    public boolean isFull(){
        if(front==null){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isEmpty(){

        if(front!=null){
            return false;
        }
        else{
            return true;
        }

    }

    public void enqueue(Object o1){
        Node toAdd=new Node(o1);
        if(front==null){
            front=toAdd;
            rear=toAdd;
        }
        else{
            rear.setNext(toAdd);
            rear=toAdd;
        }
    }

    public void dequeue(){
        if(front==null){
            System.out.println("List is empty");
        }
        else{
            front=front.getNext();
        }
    }

    public void getQueue(){
        Node temp=front;
        while(temp!=null){
            System.out.println(temp.getData());
            temp=temp.getNext();
        }
    }

}
class tester{
    public static void main(String[] args){
        queue queue1=new queue(5);
        queue1.enqueue("Emily");
        queue1.enqueue("Lily");
        queue1.enqueue("Rachel");
        queue1.enqueue("Rose");

        queue1.dequeue();
        queue1.dequeue();
        queue1.getQueue();


        if(queue1.isEmpty()){
            System.out.println("Empty.");
        }
        else {
            System.out.println("Not Empty.");
        }
    }
}