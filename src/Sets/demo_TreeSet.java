package Sets;

import java.util.Set;
import java.util.TreeSet;

public class demo_TreeSet {
    public static void main(String[] args){

        Set<String> uniqueElem=new TreeSet<String>();
        //TreeSets use a Tree-based data structure to store elements.
        //Elements are returned on natural ordering.
        //--For example, in case of String, the order will be alphabetical order.
        //TreeSets use compareTo() method for ordering as well as detecting duplicates.

        Set<String> food = new TreeSet<String>(); // Creating TreeSet object
        food.add("Pasta"); // Adding elements to the TreeSet
        food.add("Noodles");
        food.add("Sandwich");
        food.add("Pasta");
        food.add("Burger");
        food.add("Noodles");
        System.out.print("Set output without the duplicates in the sorted order: ");
        System.out.println(food);
    }
}
