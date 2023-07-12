package Trees.binarySearchTreeProblems;

import Trees.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class problem_3 {

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

    public static void print(Node node) {
        System.out.print(node.getData() + "->");
    }

    public static void breadthFirst(Node root){
        if(root == null){
            return;
        }

        Queue<Node> queue = new ArrayDeque<>(Node.class.getModifiers());
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            print(node);

            if (node.getLeftChild() != null) {
                queue.add(node.getLeftChild());
            }
            if (node.getRightChild() != null) {
                queue.add(node.getRightChild());
            }
        }

    }
    public static void main(String[] args) throws
            queue.QueueUnderflowException, queue.QueueOverflowException {
        Node<Integer> one = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> three = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        Node<Integer> five = new Node<>(5);
        Node<Integer> six = new Node<>(6);
        Node<Integer> seven = new Node<>(7);
        Node<Integer> eight = new Node<>(8);
        Node<Integer> nine = new Node<>(9);
        Node<Integer> ten = new Node<>(10);
        Node<Integer> eleven = new Node<>(11);

        three.setLeftChild(one);
        three.setRightChild(nine);
        nine.setLeftChild(two);
        nine.setRightChild(four);
        one.setLeftChild(six);
        six.setRightChild(seven);
        six.setLeftChild(ten);
        two.setRightChild(five);
        four.setLeftChild(eight);
        four.setRightChild(eleven);

        System.out.println("Original");
        breadthFirst(three);

        mirror(three);
        System.out.println();
        System.out.println("Mirror");
        breadthFirst(three);

    }

    public static void mirror(Node<Integer> root){
        if(root == null){
            return;
        }

        Node<Integer> temp = root.getLeftChild();
        root.setLeftChild(root.getRightChild());
        root.setRightChild(temp);

        mirror(root.getLeftChild());
        mirror(root.getRightChild());

    }


}
