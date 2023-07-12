package implementation_LinkedList;

import java.util.LinkedList;
import java.util.List;

public class EuropeTrip {
    public static void main(String[] args){
        List<String> cities=new LinkedList<String>();

        cities.add("Milan");
        cities.add("Venice");
        cities.add("Munich");
        cities.add("Vienna");
        //adding the elements.

        System.out.println(cities);
        System.out.println();

        cities.add(2,"London");
        System.out.println(cities);
        System.out.println();
        // adding the element at tje specified index.

        cities.remove("Venice");
        System.out.println(cities);
        System.out.println();
        //removing an element.

        cities.set(2,"Prague");
        System.out.println(cities);
        System.out.println();
        // replacing an element at a specified index.

        if(cities.contains("Milan"))
            System.out.println("Yes , The city is in the list.");
        else
            System.out.println("No , the element is not present.");
        System.out.println();
        // checking if the specified element is present in the list or not.

        System.out.print("Size of the element is : ");
        System.out.println(cities.size());
        System.out.println();
        //obtaining the size of the linked list.

        System.out.print("Element at index 0 is : ");
        System.out.println(cities.get(0));
        System.out.println();
        // to obtain an element present at the specified index.

        cities.clear();
        System.out.println(cities);
        System.out.println();
        //deleting all the elements of a linked list.

    }



}
