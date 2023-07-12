package Sets;

import java.util.HashSet;
import java.util.Set;

public class demo_HashSets {
    //Set represents an unordered collection with unique elements.
    public static void main(String[] args){
        Set<String> uniqueElements=new HashSet<String>();
        //HashSet uses hash tables the unique elements.
        //There is no guarantee on the iteration order of the set.
        //HashSet depends on the equals() and hashCode() methods for detecting duplicate elements adn null values are allowed.

        Set<String> food=new HashSet<String>();
        food.add("Pasta");
        food.add("Burger");
        food.add("Pizza");
        food.add("Sandwich");
        food.add("Noodles");
        food.add("Burger");
        System.out.print("Set output without the duplicates: ");
        System.out.println(food);
        //this shows that set doesn't allow duplicate elements.
    }
}
