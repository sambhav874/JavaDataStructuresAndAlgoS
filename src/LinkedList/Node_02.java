package LinkedList;

import java.util.Scanner;

//Implement the method addAtBeginning(String data) to add a new element at the beginning of a linked list.
//      You can make use of the below steps to implement the method.
//    Create a new node with the data passed to the method
//    If the linked list is empty, make the new node as the head and the tail node.
//    If the linked list is not empty, add the new node at the beginning, i.e., before the current head node and make the new node as the head.
//display()
//        1.Take a temp reference and assign it with the head node
//        2.While temp is not null,
//        a.Display the data at the temp node
//        b.Make the next node as tempC

//find(data)
//        1.Take a temp reference and assign it with head node
//        2.While temp is not null,
//        a.If the data at temp is equal to the data being searched for then, return temp
//        b.Else, make the next node as temp
//        3.If data is not found then, return null

//insert(data,dataBefore)
//      1.Create a new node with the given data
//    3.Find the node with dataBefore. If found then,
//  a.Call this as the nodeBefore
//  b.Make the link of the new node refer to the link of nodeBefore
//  c.Make the link of nodeBefore refer to the new node
//  d.If link of the new node is null, make it as the tail node
//  4. If node with dataBefore is not found, display appropriate error message

//delete(data):
//        1. Find the node with the given data. If found,
//        a. If the node to be deleted is head node, make the next node as head node
//        i.   If it is also the tail node, make the tail node as null
//        b. Otherwise,
//        i.   Traverse till the node before the node to be deleted, call it nodeBefore
//        ii.  Make link of nodeBefore refer to link of node to be deleted.
//        iii. If the node to be deleted is the tail node, call the nodeBefore as tail node
//        iv.  Make the link of the node to be deleted as null
//        2. If the node to be deleted is not found, display appropriate error message

//shiftListLeft(LinkedList linkedList, int n)
//    Left shift the given linked list by n number of times

//shiftListRight(LinkedList linkedlist,int n)
//    Right shift the given linked list by n number of times

//public static void reverseList(Node head, LinkedList reversedLinkedList) {
//   Input:     Data->Structures->and->Algorithms
//   Output:    Algorithms ->and->Structures->Data
//    }


class Node_02 {
    private String data;
    private Node_02 nextN;

    public Node_02(String data){
        this.data=data;
    }

    public void setData(String data){
        this.data=data;
    }

    public void setNextN(Node_02 nextN){
    this.nextN=nextN;}
    public String getdata(){
        return data;
    }

    public Node_02 getNextN(){
        return nextN;
    }



}
class LinkedList_prac{
    private Node_02 head;
    private Node_02 tail;

    public Node_02 getHead() {
        return head;
    }

    public Node_02 getTail() {
        return tail;
    }

    public void addAtEnd(String data){
        Node_02 node_a=new Node_02(data);

        if (this.head==null){
            head=tail=node_a;
        }
        else{
            this.tail.setNextN(node_a);
            this.tail=node_a;
        }


    }
    public void addAtBegin(String data){
        Node_02 node_a=new Node_02(data);

        if(this.head==null){
            head=tail=node_a;
        }
        else{
            node_a.setNextN(this.head);
            this.head=node_a;
        }
    }

    public void display(){
        Node_02 temp = this.head;
        // Traverse the list and print data of each node
        while (temp != null) {
            System.out.print(temp.getdata()+"->");
            temp = temp.getNextN();
        }
    }
    public Node_02 search(){
        Scanner sc=new Scanner(System.in);
        Node_02 tmp=this.head;
        String data;
        data=sc.next();
        while(tmp!=null){
            if (tmp.getdata().equals(data)){
                return tmp;
            }
            tmp=tmp.getNextN();
        }return null;

    }

    public Node_02 find(String data){
        Node_02 tmp1=this.head;
        while(tmp1!=null){
            if (tmp1.getdata().equals(data)){
                return tmp1;
            }
            tmp1=tmp1.getNextN();
        }return null;

    }
    public void insert(String data,String dataBefore){

        Node_02 n3= new Node_02(data);
        //check if the node is empty.If empty make it the head and tail
        if (this.head==null){
            this.head=this.tail=n3;
        }
        else{
            Node_02 nodeBefore=this.find(dataBefore);
            if(nodeBefore!=null){
                n3.setNextN(nodeBefore.getNextN());
                nodeBefore.setNextN(n3);
                if(nodeBefore==this.tail){
                    this.tail=n3;
                }
                else{
                    System.out.println("Node not found.");
                }
            }
        }
    }

    public void delete(String data){
        if(head==null){
            System.out.println("List is empty.");
        }
        else {
            Node_02 n4=this.find(data);
            if(n4==null){
                System.out.println("Node not found");
            }
            else if(n4==head){
                head=head.getNextN();
                n4.setNextN(null);
                if (n4==tail){
                    tail=null;
                }
            }
            else {
                // Traverse to the node present before the node to be deleted
                Node_02 nodeBefore=null;
                Node_02 temp=this.head;
                while(temp != null){
                    if(temp.getNextN()==n4){
                        nodeBefore=temp;
                        break;

                    }
                    temp=temp.getNextN();
                }
                // Remove the node
                nodeBefore.setNextN(n4.getNextN());
                // If the node to be deleted is the tail node,
                // then make the previous node as the tail
                if(n4==tail){
                    tail=nodeBefore;
                }
                n4.setNextN(null);
            }
        }
    }
    public void findPosition(String data) {
        Node_02 temp = this.head;
        int position = 0;
        // Traverse the list and print data of each node
        while (temp != null) {
            position++;
            if (temp.getdata().equals(data)) {
                System.out.println(position);
                break;
            }
            temp=temp.getNextN();
        }
    }

    public int size(){
        Node_02 head1=this.head;
        int n=0;
        while(head1!=null){
            n++;
            head1=head1.getNextN();
        }
        return n;
    }
    public void shiftListLeft(LinkedList_prac linkedlist,int k){
        if (head == null || k == 0)
            return;
        Node_02 temp = head;
        int count = 1;
        while (count < k && temp != null) {
            temp = temp.getNextN();
            count++;
        }
        if (temp == null)
            return;
        Node_02 kthNode = temp;
        while (temp.getNextN() != null) {
            temp = temp.getNextN();
        }
        temp.setNextN(head);
        head = kthNode.getNextN();
        kthNode.setNextN(null);
    }


    public void shiftListRight(LinkedList_prac linkedlist,int k){


        int size=linkedlist.size();
        int normalizedShift = (k % size + size) % size;
        if (normalizedShift != 0) {
            tail.setNextN(head);
            for (int i = 0; i < size - normalizedShift - 1; i++)
                head = head.getNextN();
            tail = head;
            head = head.getNextN();
            tail.setNextN(null);
        }
    }

    public Node_02 reverseList(Node_02 head1){

        if(head==null)
            return null;

        if(head.getNextN() ==null)
        {
            return head;
        }
        Node_02 prevNode =null;
        Node_02 currNode = head1;
        Node_02 nextNode=head.getNextN();

        while(nextNode!=null){
            currNode.setNextN(prevNode);
            prevNode=currNode;
            currNode=nextNode;
            nextNode=nextNode.getNextN();
        }
        currNode.setNextN(prevNode);

        while (currNode != null) {
            System.out.print(currNode.getdata()+"->");
            currNode = currNode.getNextN();
        }
        return currNode;



    }

    public static void main(String[] args){
        LinkedList_prac li1=new LinkedList_prac();


        li1.addAtEnd("Kunal");
        li1.addAtBegin("Shaurya");
        li1.addAtEnd("Shorya");
        li1.addAtBegin("Ayush");
        li1.addAtEnd("Utsav");
        li1.addAtBegin("Sambhav");

        System.out.println("Elements are added to the array" );
        li1.display();

        System.out.println();
        System.out.println("Search for the element in nodes.");
        if(li1.search()!= null){
            System.out.println("Node found.");
        }
        else {
            System.out.println("Node not found.");
        }

        System.out.println("Inserting an element.");
        li1.insert("Krishna","Ayush");

        System.out.println();

        li1.display();

        System.out.println();
        System.out.println("Deleting an element.");
        li1.delete("Shaurya");
        System.out.println();
        li1.display();

        System.out.println();
        System.out.println("Size of the element is:");
        li1.size();

        System.out.println();
        System.out.println("The index of the element is:");
        li1.findPosition("Kunal");

        System.out.println();
        System.out.println("Shifted list is:");

        li1.shiftListRight(li1,2);
        li1.display();

        System.out.println();
        System.out.println();

        System.out.println("Shifted list is:");
        li1.shiftListLeft(li1,5);
        li1.display();

        System.out.println();
        System.out.println();

        System.out.println("The reversed LinkedList is");
        li1.reverseList(li1.head);

    }
}



