package Trees.binarySearchTreeProblems;

public class problem_2 {

    public static void main(String[] args) {

        Node<Character> a = new Node<>('A');
        Node<Character> b = new Node<>('B');
        Node<Character> c = new Node<>('C');
        Node<Character> d = new Node<>('D');
        Node<Character> e = new Node<>('E');
        Node<Character> f = new Node<>('F');
        Node<Character> g = new Node<>('G');
        Node<Character> h = new Node<>('H');
        Node<Character> x = new Node<>('X');

        a.setLeftChild(b);
        a.setRightChild(c);
        c.setLeftChild(d);
        c.setRightChild(e);
        d.setLeftChild(f);
        d.setRightChild(h);
        e.setRightChild(g);
        g.setLeftChild(x);

        System.out.println("Maximum depth is " + maxDepth(a));
    }

    public static void print(Node<Character> node) {
        if(node == null){
            System.out.println("Not Found .");
            return;
        }
        System.out.println(node.getData() + " is Found .");
    }

    public static void inOrder(Node<Character> root) {
        if (root == null) {// base case - when there is nothing to traverse.
            return;
        }

        // process the node before recursing to the left and right subtrees.
        inOrder(root.getLeftChild());
        print(root);
        inOrder(root.getRightChild());
    }

    public static int maxDepth(Node<Character> root){

        if(root == null){
            return 0;
        }
        if(root.getLeftChild() == null && root.getRightChild() == null){
            return 0;
        }
        int leftMaxDepth = 1 + maxDepth(root.getLeftChild());
        int rightMaxDepth = 1 + maxDepth(root.getRightChild());

        return Math.max(leftMaxDepth , rightMaxDepth);
    }

    public static int min(Node<Character> head){
        if(head == null){
            return Integer.MIN_VALUE;
        }
        if(head.getRightChild() == null){
            return head.getData();
        }
        return min(head.getLeftChild());
    }

    public static Node<Character> insert(Node<Character> head , Node<Character> node){

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

    public static Node<Character> lookup(Node<Character> head , int data){
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
