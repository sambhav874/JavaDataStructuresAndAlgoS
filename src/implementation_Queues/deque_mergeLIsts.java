package implementation_Queues;

import java.util.ArrayDeque;
import java.util.Deque;

public class deque_mergeLIsts {
    public static Deque<Object> mergeQueue(Deque<Integer> intQueue, Deque<Character> charQueue) {

        Deque<Object> stringIntegerDeque = new ArrayDeque<>();

        for(Integer z1:intQueue){
            stringIntegerDeque.push(z1);
        }
        for(Character z:charQueue){
            stringIntegerDeque.push(z);
        }


        return stringIntegerDeque;
    }

    public static void main(String[] args) {

        Deque<Integer> integerQueue = new ArrayDeque<>();
        integerQueue.add(3);
        integerQueue.add(6);
        integerQueue.add(9);

        Deque<Character> characterQueue = new ArrayDeque<Character>();
        characterQueue.add('a');
        characterQueue.add('e');
        characterQueue.add('i');
        characterQueue.add('o');
        characterQueue.add('u');
        characterQueue.add('b');

        Deque<Object> mergedQueue = mergeQueue(integerQueue, characterQueue);

        System.out.println("The elements in the merged queue are:");
        for(Object element: mergedQueue)
            System.out.println(element);

    }
}
