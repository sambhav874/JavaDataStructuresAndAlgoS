
package Algorithms.SortingAlgoS;

import java.util.Scanner;

public class heapSort {


    public static void swap(int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void printArray() {
        System.out.print("[");
        for (int n : array) {
            System.out.print(n + " , ");
        }
        System.out.print("]");
    }

    public static int getLeftChild(int index, int endIndex) {
        int leftChild = 2 * index + 1;
        if (leftChild > endIndex) {
            return -1;
        }
        return leftChild;
    }

    public static int getRightChild(int index, int endIndex) {
        int rightChild = 2 * index + 2;
        if (rightChild > endIndex) {
            return -1;
        }
        return rightChild;
    }

    public static int getParent(int index, int endIndex) {
        if (index < 0 || index > endIndex) {
            return -1;
        }

        return (index - 1) / 2;
    }

    public static void percolateDown(int index, int endIndex) {
        int theLeftChild = getLeftChild(index, endIndex);
        int theRightChild = getRightChild(index, endIndex);

        if (theLeftChild != -1 && array[theLeftChild] > array[index]) {
            swap(theLeftChild, index);
            percolateDown(theLeftChild, endIndex);
        }

        if (theRightChild != -1 && array[theRightChild] > array[index]) {
            swap(theRightChild, index);
            percolateDown(theRightChild, endIndex);
        }
    }

    public static void heapify(int endIndex) {
        int index = getParent(endIndex, endIndex);
        while (index >= 0) {
            percolateDown(index, endIndex);
            index--;
        }
    }

    public static void sort() {
        heapify(array.length - 1);

        int endIndex = array.length - 1;
        while (endIndex > 0) {
            swap(0, endIndex);
            endIndex--;
            percolateDown(0, endIndex);
        }
    }

  public static int[] array = {1, 4, 2, 9, 6, 3, 7, 8, 5};

    public static void main(String[] args) {

        printArray();
        sort();
        printArray();

    }
}