package implementation_Queues;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class queueAndInfo {

    //Queue is a collection to hold multiple elements prior to processing.
    //The interface is available under the java.util package and extends the java.util.Collection interface
    //Just like list,Queue is a collection of ordered elements but it performs insertion and removal differently.

    //=Queue represent an ordered list of elements.
    //=Queue supports all methods of collection interface.
    //=All queues support insertion at the tail of the queue and removal from the head of the queue, except Deque.
    //=Deque are queues but they support element insertion and removal on the same ends.

    //Queues basically, but not necessarily order the elements in the FIFO(First In First Out) manner.
    // Among the exceptions are:

    //==Priority queues,are queues which order elements according to a supplied comparator , or the element's natural order.
    //==LIFO queues (or stacks) which order the elements according to LIFO (last-in-first-out)

    //Queue implementation does not allow insertion of null elements, although sum of them do not prohibit the insertion of null elements.
    //It is advisable not to insert null into a Queue as null is returned by the poll method when the queue contains no elements.

    //Queue supports all operations supported by Collection interface and also provides additional insertion and extraction operations.
    //
    //Each of these operations exists in two forms.
    //
    //One set of operations throw an exception if the operation fails
    //
    //The other set of operations return a special value (either null or false) if the operation fails

    public static void main(String[] args) {


        Queue queue = new Queue() {
            @Override
            public boolean add(Object o) {
                return false;
            }

            @Override
            public boolean offer(Object o) {
                return false;
            }

            @Override
            public Object remove() {
                return null;
            }

            @Override
            public Object poll() {
                return null;
            }

            @Override
            public Object element() {
                return null;
            }

            @Override
            public Object peek() {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public Object[] toArray(Object[] a) {
                return new Object[0];
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection c) {
                return false;
            }

            @Override
            public boolean addAll(Collection c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection c) {
                return false;
            }

            @Override
            public void clear() {

            }
        };
    }
}
