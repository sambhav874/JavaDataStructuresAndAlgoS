package Trees.binarySearchTrees;

public class insertionBST {

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


        inOrder(head);
    }

    public static void print(Node<Integer> node) {
        System.out.print(node.getData() + "->");
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
