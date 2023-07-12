package Sets;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class demo_LinkedHashSets {
    public static void main(String[] args){
        Set<String> uniqueItems=new HashSet<String>();
        //Linked HashSETS are a combination of hash tables and linked lists that are used for storing elements.
        //Elements are returned in the order of insertion.
        //LinkedHashSet depends on the equals() and hashCode() methods for detecting duplicates and null values are allowed.

        Set<String> food = new LinkedHashSet<String>(); // Creating LinkedHashSet object
        food.add("Pasta"); // Adding elements to the LinkedHashSet
        food.add("Noodles");
        food.add("Sandwich");
        food.add("Pasta");
        food.add("Burger");
        food.add("Noodles");
        System.out.print("The duplicates are removed and displayed in the order in which the elements are inserted: ");
        System.out.println(food);

    }
}
