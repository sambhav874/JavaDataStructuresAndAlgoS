package assignment_LinkedLists;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class removeDuplicates_1 {
    public static void main(String[] args){

        List<Integer> list =new LinkedList<Integer>();
        list.add(10);
        list.add(15);
        list.add(21);
        list.add(15);
        list.add(10);
        System.out.println(list);

        removeDuplicates(list);


    }
   public static List<Integer> removeDuplicates(List<Integer> li){
       ListIterator<Integer> liIT=li.listIterator();
       List<Integer> li1=new LinkedList<Integer>();
       while(liIT.hasNext()){
           if(!li1.contains(liIT.next()))
                li1.add(liIT.previous());
       }
       System.out.println(li1);
       return li1;
   }
}
