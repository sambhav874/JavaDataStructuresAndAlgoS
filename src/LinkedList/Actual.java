package LinkedList;

class Node4 {
    private String data;
    private Node4 next;

    public Node4(String data) {
        this.data = data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setNext(Node4 node) {
        this.next = node;
    }

    public String getData() {
        return this.data;
    }

    public Node4 getNext() {
        return this.next;
    }
}

class LinkedList6 {

    private Node4 head;
    private Node4 tail;

    public Node4 getHead() {
        return this.head;
    }

    public Node4 getTail() {
        return this.tail;
    }

    public void addAtEnd(String data) {
        // Create a new node
        Node4 node = new Node4(data);

        // Check if the list is empty,
        // if yes, make the node as the head and the tail
        if (this.head == null)
            this.head = this.tail = node;
        else {
            // If the list is not empty, add the element at the end
            this.tail.setNext(node);
            // Make the new node as the tail
            this.tail = node;
        }
    }

    public void addAtBeginning(String data) {
        // Create a new node
        Node4 node = new Node4(data);

        // Check if the list is empty,
        // if yes, make the node as the head and the tail
        if (this.head == null)
            this.head = this.tail = node;
        else {
            // If the list is not empty, add the element at the beginning
            node.setNext(this.head);
            // Make the new node as the head
            this.head = node;
        }
    }

    public void display() {
        // Initialize temp to the head node
        Node4 temp = this.head;
        // Traverse the list and print data of each node
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }

    public static void main(String args[]) {
        LinkedList6 list = new LinkedList6();
        list.addAtEnd("Milan");
        list.addAtEnd("Venice");
        list.addAtEnd("Munich");
        list.addAtEnd("Vienna");
        list.display();
    }
}
