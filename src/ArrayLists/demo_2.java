package ArrayLists;

import java.util.ArrayList;
import java.util.List;

public class demo_2 {
    public static void main(String[] args){
        List<String>names=new ArrayList<String>();

        names.add("Brian");
        names.add("Ross");
        names.add("Steve");
        names.add("Rachel");
        names.add("Steve");


        //Checking whether any element is present or not
        if(names.isEmpty()){
            System.out.println("No names are present!!");
        }

        //Displaying the number of names
        System.out.println("Number Of names: " + names.size());

        //Creating newNames list
        List<String> newNames=new ArrayList<String>();
        newNames.add("Emily");
        newNames.add("Melissa");

        // Adding elements of newNames list into names
        names.addAll(newNames);

        //Displaying all names
        System.out.println("The list of names after adding all the names from newNames to names: ");
        for (String name : names) {
            System.out.println(name);
        }

        // Checking whether the name Ross is present or not
        if (names.contains("Ross")) {
            System.out.println("This name is already present!");
        } else {
            System.out.println("This name is not present!");
        }

        //Converting list to array
        Object[] objArr= names.toArray();


        // Deleting all the names from the names list
        names.clear();
        System.out.println();
        System.out.println("Checking whether the names list is empty or not : ");
        //Confirming whether all the elements are deleted or not
        System.out.println(names.isEmpty());


    }



}
