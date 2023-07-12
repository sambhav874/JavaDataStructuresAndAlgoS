package LinkedList;

public class LinkedList2 {
    public static void main(String[] args){
        LinkedList1 list=new LinkedList1();

        list.insertAtHead(10);
        list.insertAtHead(15);
        list.insertAtHead(4);
        list.insertAtHead(9);
        list.insertAtHead(16);
        list.insertAtHead(2);
        list.insertAtHead(8);

        //all these insertAtHead commands are entering the data into the current node.

        list.deleteAtHead();

        System.out.println(list.find(2));
        System.out.println(list);
        System.out.println(list.length());
    }
}
