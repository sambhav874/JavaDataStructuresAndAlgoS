package Maps;

import java.util.HashMap;
import java.util.Map;

public class demo_1 {
    //A map is a mapping between a key and its value.It is similar to a dictionary where lookup is performed based on a key nd the respective value is returned.
    //In the case of Tree House book store, the key can be book name and the value can be shelf number as we would search for a book using the book name and try to find the shelf number of it.
    //public interface Map<K,V> where K stands for the key and V stands for the value.
    //The HashMap class implements the Map interface and can also be used to store key value pairs.
    public static void main(String[] args){

        //Adding key-value pairs to the map
        Map<String,Integer> books=new HashMap<String,Integer>();
        books.put("Data Structures with Java",800);
        books.put("Object oriented programming with c++",500);
        books.put("Operating Systems",1000);
        books.put("Machine Learning with Python",750);
        books.put("Java Fundamentals", 400);

        //Displaying all the key-value pairs present in the map
        System.out.println(books);

        System.out.println();

        //Traversing the map
        //entrySet() method is used to retrieve all the key value pairs
        for(Map.Entry<String,Integer> book: books.entrySet()){
            System.out.println(book);
        }

        System.out.println();

        //keySet() method returns the keys in the Map
        for(String keys: books.keySet()){
            System.out.println(keys);
        }

        System.out.println();

        //values() method returns the values in the Map
        for(Integer values: books.values()){
            System.out.println(values);
        }

        System.out.println();

        //Removing element based on key
        books.remove("Data Structures with Java");
        System.out.println(books);

        System.out.println();

        //Removing element based on key and value
        books.remove("Java Fundamentals",400);
        System.out.println(books);

        System.out.println();

        //Replacing key-value pair in the map
        books.replace("Operating Systems",1000,1200);
        System.out.println(books);

        System.out.println();

        //Getting a value from the map based on key
        System.out.println(books.get("Operating Systems"));

        System.out.println();


        //Printing size of the map
        System.out.println(books.size());

        System.out.println();

        //Removing all the key-value pairs from the map
        books.clear();

        //Checking if the map is empty
        System.out.println(books.isEmpty());

    }


}
