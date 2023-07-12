package ArrayLists;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class demo_iterator {
    public static void main(String[] args){
        List<Integer> number=new ArrayList<Integer>();
        number.add(1);
        number.add(2);
        number.add(3);
        number.add(4);
        number.add(5);

        ListIterator<Integer> num= number.listIterator();
        System.out.println("Displaying numbers...");
        while(num.hasNext()){
            System.out.println(num.next());
        }
        System.out.println();
        System.out.println("Display numbers in the reverse order");
        while(num.hasPrevious()){
            System.out.println(num.previous());
        }
    }
}
