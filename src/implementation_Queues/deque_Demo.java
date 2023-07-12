package implementation_Queues;

import java.util.ArrayDeque;
import java.util.Deque;

public class deque_Demo {


    //ArrayDeque is the implementation of the Deque interface.
    //Unlike queue, you can add or delete the elements from both the ends through ArrayDeque.
    //Using this ArrayDeque class both the Queue and Stacks can be implemented.
public static void main(String[] args){


    Deque<String> queue = new ArrayDeque<String>();	// no restrictions in capacity


    //Deque can be used as a queue to exhibit the FIFO (First-In-First-Out) behavior.
    //
    //Elements are added at the rear of the deque and removed from the front.

    queue.add("Joe");
    queue.add("Jack");
    queue.add("Eva");
    queue.add("Mia");
    queue.add("Luke");

    System.out.println("People in queue - After addition of 5 people");
    for (String str : queue) {System.out.println(str);
    }
    queue.remove();
    queue.remove();
    queue.remove();

    System.out.println("\nPeople in queue - After removal of 3 people");
    for (String str : queue) {
        System.out.println(str);
    }

    System.out.println();
    System.out.println("Head of the queue using element() - "+queue.element());
    System.out.println("Head of the queue using peek() - "+queue.peek());
    queue.remove();
    queue.remove();

    // new person added to the empty queue using offer()
    queue.offer("Emma");

    // newly added person removed using poll()
    queue.poll();

    System.out.println();
    System.out.println("Removing the head of the queue using poll when queue is empty - "+queue.poll());	// returns null since queue is empty

    System.out.println("Head of the queue using peek() when queue is empty - "+queue.peek());	// returns null since queue is empty

    /* Uncomment the lines of code given below one at a time and observe the output */
    //System.out.println("Head of the queue using element() when queue is empty - "+queue.element());	// throws NoSuchElementException since queue is empty

    //System.out.println("Removing the head of the queue using remove() when queue is empty");
    //queue.remove();		// throws NoSuchElementException since queue is empty


    //Deque is a linear collection that supports element insertion and removal at both ends. This interface extends the Queue interface.
    //
    //The name deque is short for "double ended queue" and is usually pronounced "deck".
    //
    //It supports capacity restricted deques as well as those with no fixed size limit.

    //Unlike the List interface, Queue interface does not provide support for indexed access to elements.
    }
}
