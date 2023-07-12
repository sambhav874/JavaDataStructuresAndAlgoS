package Trees.binarySearchTreeProblems;

import Trees.binarySearchTrees.lookupBST;

//Find the minimum value in a binary search tree.

public class problem_1 {
    public static void main(String[] args) {

        Node<Integer> one = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> three = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        Node<Integer> five = new Node<>(5);
        Node<Integer> six = new Node<>(6);
        Node<Integer> seven = new Node<>(7);
        Node<Integer> eight = new Node<>(8);
        Node<Integer> nine = new Node<>(9);

        Node<Integer> head = insert(null , five);

        insert(head , one);
        insert(head , two);
        insert(head , three);
        insert(head , four);
        insert(head , six);
        insert(head , seven);
        insert(head , eight);
        insert(head , nine);


        print(lookup(head , 17));
        print(lookup(head , 4));

        System.out.println("Minimum value is "+min(head));
    }

    public static void print(Node<Integer> node) {
        if(node == null){
            System.out.println("Not Found .");
            return;
        }
        System.out.println(node.getData() + " is Found .");
    }

    public static void inOrder(Node<Integer> root) {
        if (root == null) {// base case - when there is nothing to traverse.
            return;
        }

        // process the node before recursing to the left and right subtrees.
        inOrder(root.getLeftChild());
        print(root);
        inOrder(root.getRightChild());
    }

    public static int min(Node<Integer> head){
        if(head == null){
            return Integer.MIN_VALUE;
        }
        if(head.getLeftChild() == null){
            return head.getData();
        }
        return min(head.getLeftChild());
    }

    public static Node<Integer> insert(Node<Integer> head , Node<Integer> node){

        if(head == null){
            return node;
        }

        if(node.getData() <= head.getData()){
            head.setLeftChild(insert(head.getLeftChild(), node));
        }
        else {
            head.setRightChild(insert(head.getRightChild() , node));
        }

        return head;
    }

    public static Node<Integer> lookup(Node<Integer> head , int data){
        if (head == null) {
            return null;
        }
        if (head.getData() == data) {
            return head;
        }

        if (data <= head.getData()) {
            return lookup(head.getLeftChild(), data);
        } else {
            return lookup(head.getRightChild(), data);
        }
    }

    public static class Node<T> {
        private T data;
        private Node<T> leftChild;
        private Node<T> rightChild;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public Node<T> getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node<T> leftChild) {
            this.leftChild = leftChild;
        }

        public Node<T> getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node<T> rightChild) {
            this.rightChild = rightChild;
        }
    }

}
