package Heaps;

import java.lang.reflect.Array;


    //a generic heap that hold any type of value.
public abstract class Heap<T extends Comparable>{
        private static int MAX_SIZE = 40;
        private T[] array;
        private int count = 0;

        public Heap(Class<T> clazz) {
            this(clazz, MAX_SIZE);
        }

        public Heap(Class<T> clazz, int size) {
            array = (T[]) Array.newInstance(clazz, size);
        }

        public void printHeapArray() {
            for (int i = 0; i < count; i++) {
                System.out.print(array[i] + ", ");
            }
            System.out.println();

            try {
                System.out.println("Highest priority: " + getHighestPriority());
            } catch (HeapEmptyException ex) {

            }
        }

        public int getParent(int index) {
            if (index < 0 || index > count) {
                return -1;
            }

            return (index - 1) / 2;
        }

        public int getLeftChild(int index) {
            int leftChild = 2 * index + 1;
            if (leftChild >= count) {
                return -1;
            }

            return leftChild;
        }

        public int getRightChild(int index) {
            int rightChild = 2 * index + 2;
            if (rightChild >= count) {
                return -1;
            }

            return rightChild;
        }

        public T getHighestPriority() throws HeapEmptyException {
            if (count == 0) {
                throw new HeapEmptyException();
            }

            return array[0];
        }

        public void insert(T value) throws HeapFullException {
            if (count >= array.length) {
                throw new HeapFullException();
            }

            array[count] = value;
            shiftUp(count);

            count++;
        }

        public T removeHighestPriority() throws HeapEmptyException {
            T min = getHighestPriority();

            array[0] = array[count - 1];
            count--;
            shiftDown(0);

            return min;
        }

        protected abstract void shiftDown(int index);

        protected abstract void shiftUp(int index);

        protected void swap(int index1, int index2) {
            T tempValue = array[index1];
            array[index1] = array[index2];
            array[index2] = tempValue;
        }

        public int getCount() {
            return count;
        }

        public boolean isEmpty() {
            return count == 0;
        }

        public boolean isFull() {
            return count == array.length;
        }

        public T getElementbyIndex(int index) {
            return array[index];
        }

        public static class HeapFullException extends  Exception{
        }

        public static class HeapEmptyException extends Exception{

        }
    }

