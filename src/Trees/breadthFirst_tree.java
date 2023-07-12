package Trees;


public class breadthFirst_tree {


    public static void main(String[] args) throws
            queue.QueueUnderflowException , queue.QueueOverflowException {
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
        b.setLeftChild(x);

        breadthFirst(a);

        print(a);
    }

    public static void print(Node node) {
        System.out.print(node.getData() + "->");
    }

    public static void breadthFirst(Node root) throws
            queue.QueueUnderflowException,  queue.QueueOverflowException {
        if (root == null) {
            return;
        }

        queue<Node> queue1 = new queue<>(Node.class);
        queue1.enqueue(root);
        while (!queue1.isEmpty()) {
            Node node = queue1.dequeue();
            print(node);

            if (node.getLeftChild() != null) {
                queue1.enqueue(node.getLeftChild());
            }
            if (node.getRightChild() != null) {
                queue1.enqueue(node.getRightChild());
            }
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



