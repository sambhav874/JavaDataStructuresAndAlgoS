package assignment_LinkedLists;

import java.util.LinkedList;
import java.util.List;

public class mergeLists_3 {
    public static void main(String[] args){
        List<Integer> listOne = new LinkedList<Integer>();
        listOne.add(10);
        listOne.add(13);
        listOne.add(21);
        listOne.add(42);
        listOne.add(56);

        List<Integer> listTwo = new LinkedList<Integer>();
        listTwo.add(15);
        listTwo.add(20);
        listTwo.add(21);
        listTwo.add(85);
        listTwo.add(92);

        System.out.println(mergeLists(listOne,listTwo));;
    }
    public static List<Integer> mergeLists(List<Integer> li1,List<Integer> li2){

            if(!li2.isEmpty()){
                li1.addAll(li2);
            }
        return li1;
    }
}
