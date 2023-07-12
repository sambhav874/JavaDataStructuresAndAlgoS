package ArrayLists;

import java.util.ArrayList;
import java.util.List;


public class demo_1 {

    static void display(List li){
        for(int i=0;i<li.toArray().length;i++){
            System.out.println(li.get(i));}
    }
    public static void main(String[] args){
        //This is an array.
        // String[] orders = new String[5];

        //What are the limitations of using an array?
        //-Assume that the size of the array is 4 and you have already placed 4 orders. Now, you want to add the fifth order, i.e., your favorite pizza.
        //
        //Will you be able to add?
        //-Since arrays have fixed size, ordering food items after a limit is not possible.

        //Once an order is processed or cancelled, it needs to be removed from the array. This requires an extra processing code for item removal.
        //These issues of size limitations and extra processing code for item removal can be overcome by using a collection called ArrayList.

        List<String> food = new ArrayList<String>();


        // Adding the elements
        food.add("Lasagna");
        food.add("Burger");
        food.add("Pasta");
        food.add("Sandwich");

        display(food);
        System.out.println();
        food.set(1, "Pizza"); // Modifying the element at a specified index
        display(food);
        System.out.println();

        if (food.contains("Pasta"))
            System.out.println("The food is present.");
        else {
            System.out.println("The food is not present.");// Checking whether the element is present or not
        }

        System.out.println();
        food.remove(2); // Removing the element from the second index position
        display(food);
        System.out.println();
    }
}


