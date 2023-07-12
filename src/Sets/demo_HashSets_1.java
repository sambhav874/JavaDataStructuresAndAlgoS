package Sets;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class demo_HashSets_1 {
    public static void main(String[] args){
        Set<String> food=new HashSet<>();

        // Checking if a HashSet is empty
        System.out.println("Is the set empty? : " + food.isEmpty());

        // Adding elements to the HashSet
        food.add("Pasta");
        food.add("Noodles");
        food.add("Sandwich");
        food.add("Pasta");
        food.add("Burger");
        food.add("Noodles");
        System.out.print("Set output without the duplicates: ");
        System.out.println(food);

        //finding the size of the HashSet
        System.out.println("The size of the HashSet is : "+food.size());

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the element that you want to search.");
        String input=sc.next();

        if(food.contains(input)){
            System.out.println("Yes , "+input+" is present in the set .");
        }
        else{
            System.out.println("No , "+input+" is not present in the set .");
        }
        System.out.println();
        // Traversing elements
        Iterator<String> item= food.iterator();
        while (item.hasNext()){
            System.out.println(item.next());
        }
        System.out.println();
        // Removing all the elements from the HashSet
        food.clear();
        System.out.println("After clear() => " + food);
    }
    //In HashSet, as mentioned earlier, equals() and hashCode() methods are used for detecting duplicates.
    //
    //If two objects are equal based on the equals() method, they will be considered as duplicates.
    //
    //Classes like Integer, Float, String, etc. have already overridden equals() and hashCode() for checking the values.
    //
    //When user defined classes are used, equals() and hashCode() needs to be overridden by the developer to compare the objects based on specific attributes.
}
