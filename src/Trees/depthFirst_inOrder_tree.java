package Trees;

public class depthFirst_inOrder_tree {

    public static void main(String[] args) {
        depthFirst_tree.Node<Character> a = new depthFirst_tree.Node<>('A');
        depthFirst_tree.Node<Character> b = new depthFirst_tree.Node<>('B');
        depthFirst_tree.Node<Character> c = new depthFirst_tree.Node<>('C');
        depthFirst_tree.Node<Character> d = new depthFirst_tree.Node<>('D');
        depthFirst_tree.Node<Character> e = new depthFirst_tree.Node<>('E');
        depthFirst_tree.Node<Character> f = new depthFirst_tree.Node<>('F');
        depthFirst_tree.Node<Character> g = new depthFirst_tree.Node<>('G');
        depthFirst_tree.Node<Character> h = new depthFirst_tree.Node<>('H');
        depthFirst_tree.Node<Character> x = new depthFirst_tree.Node<>('X');

        a.setLeftChild(b);
        a.setRightChild(c);
        c.setLeftChild(d);
        c.setRightChild(e);
        d.setLeftChild(f);
        d.setRightChild(h);
        e.setRightChild(g);
        b.setLeftChild(x);

        inOrder(a);
    }

    public static void print(depthFirst_tree.Node<Character> node) {
        System.out.print(node.getData() + "->");
    }

    public static void inOrder(depthFirst_tree.Node<Character> root) {
        if (root == null) {// base case - when there is nothing to traverse.
            return;
        }

        inOrder(root.getLeftChild());
        print(root);// process the node before recursing to the left and right subtrees.
        inOrder(root.getRightChild());
    }

    public static class Node<T> {
        private T data;
        private depthFirst_tree.Node<T> leftChild;
        private depthFirst_tree.Node<T> rightChild;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public depthFirst_tree.Node<T> getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(depthFirst_tree.Node<T> leftChild) {
            this.leftChild = leftChild;
        }

        public depthFirst_tree.Node<T> getRightChild() {
            return rightChild;
        }

        public void setRightChild(depthFirst_tree.Node<T> rightChild) {
            this.rightChild = rightChild;
        }
    }



}
