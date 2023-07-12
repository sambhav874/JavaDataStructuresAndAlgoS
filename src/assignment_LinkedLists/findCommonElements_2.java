package assignment_LinkedLists;

import java.util.LinkedList;
import java.util.List;

public class findCommonElements_2 {
    public static void findCommonElements(List<Integer> listOne, List<Integer> listTwo){

        List<Integer> li1=new LinkedList<Integer>();

        for(Integer it: listTwo){
            if(listOne.contains(it)){
                li1.add(it);
            }
        }
        System.out.println(li1);
    }

    public static void main(String[] args){
        List<Integer> listOne=new LinkedList<Integer>();
        listOne.add(10);
        listOne.add(21);
        listOne.add(21);
        listOne.add(1);
        listOne.add(53);
        listOne.add(1);

        List<Integer> listTwo=new LinkedList<Integer>();
        listTwo.add(11);
        listTwo.add(21);
        listTwo.add(25);
        listTwo.add(53);
        listTwo.add(47);
        listTwo.add(1);

        findCommonElements(listOne,listTwo);

    }
}
