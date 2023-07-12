package Trees;

import java.lang.reflect.Array;
import java.util.Arrays;

public class queue<T> {

    // Constants
    private static final int empty_value = -1;
    private static int max_size = 40;

    // Array to store queue elements
    private T[] ARR;

    // Index variables for head and tail
    private int headIndex = empty_value;
    private int tailIndex = empty_value;

    // Constructor
    public queue(Class<T> qu1) {
        this(qu1, max_size);
    }

    // Constructor with size parameter
    public queue(Class<T> qu1, int size) {
        ARR = (T[]) Array.newInstance(qu1, max_size);
    }

    // Exception class for queue underflow
    public static class QueueUnderflowException extends Exception {

    }

    // Exception class for queue overflow
    public static class QueueOverflowException extends Exception {

    }

    /**
     * Check if the queue is empty.
     * @return true if the queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        return headIndex == empty_value;
    }

    /**
     * Check if the queue is full.
     * @return true if the queue is full, false otherwise.
     */
    public boolean isFull() {
        int nextIndex = (tailIndex + 1) % ARR.length;
        //tailIndex: It represents the index of the tail, which is the last element in the queue.
        //+ 1: This increments the tailIndex by 1 to calculate the index of the next element.
        //% ARR.length: The modulo operation is used to ensure that the index wraps around to the beginning of the array when it reaches the end. It helps to keep the index within the valid range of the array's length.

        return nextIndex == headIndex;
    }

    //Add an element to the end of the queue.
    public void enqueue(T data) throws QueueOverflowException {
        if (isFull()) {
            throw new QueueOverflowException();
        }
        tailIndex = (tailIndex + 1) % ARR.length;
        ARR[tailIndex] = data;
    }

     // Remove and return the element at the front of the queue.

    public T dequeue() throws QueueUnderflowException {
        if (isFull()) {
            throw new QueueUnderflowException();
        }
        T data = ARR[headIndex];

        if (headIndex == tailIndex) {
            headIndex = empty_value;
        } else {
            headIndex = (headIndex + 1) % ARR.length;
        }
        return data;
    }

    // Return the element at the front of the queue without removing it.
    public T peek() throws QueueUnderflowException {
        if (isFull()) {
            throw new QueueUnderflowException();
        }
        return ARR[tailIndex];
    }

    /**
     * Offer an element to the end of the queue.
     * @param data the element to be offered.
     */
    public boolean offer(T data) {
        if (isFull()) {
            return false;
        }
        try {
            enqueue(data);
        } catch (QueueOverflowException qoe) {
            // Ignore, this should never happen, we've checked for a full queue already.
        }
        return true;
    }


}
