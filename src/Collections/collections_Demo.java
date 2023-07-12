package Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class collections_Demo {
    //The root of the Collection hierarchy is the java.util.Collection<E> interface.

    //It specifies the basic operations for manipulating elements in a collection. These operations are inherited and implemented in child interfaces and the classes implementing the interfaces.

    //The toArray() method converts a collection into an array. If you want to convert an array into a list, you can use the Arrays.asList() method.

    //iterator() allows traversing a collection.

    Iterator<String> it = new Iterator<String>() {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public String next() {
            return null;
        }


    };

    public static void main(String[] args) {

        List<String> orders=new ArrayList<>();

        orders.add("Sambhav");
        orders.add("Shivam");
        orders.add("Kunal");

//The code above sequentially traverses the list in the forward direction.
        Iterator<String> iterator = orders.iterator();
        System.out.println("Elements in the list: ");
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
//The code above can also be simplified and written using the for-each loop as shown below:
        System.out.println("Elements in the list: ");
        for(String order : orders) {
            System.out.println(order);
        }

    }
    //This code has a cleaner syntax and internally uses an iterator.
    //
    //Then why should you explicitly use an iterator?
    //
    //Modification of a collection inside a for loop throws ConcurrentModificationException. Iterator allows modifying a collection while traversing and hence such an exception can be avoided.
    //Note: Iterators maintain a cursor to identify the location of elements.
}

//Java also has a Collections class.
//
//The java.util.Collections class directly extends the Object class. This class consists of static methods that operate on or return collections.
//
//The methods of this class throw a NullPointerException if the collections or class objects provided to them are null.





