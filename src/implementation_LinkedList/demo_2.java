package implementation_LinkedList;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class demo_2 {
    public static List<Object> concatenateLists(List<Object> listOne,List<Object> listTwo){

        List<Object> listThree=new LinkedList<>();


        ListIterator<Object> li1IT=listOne.listIterator();
        while(li1IT.hasNext()){
            listThree.add(li1IT.next());
        }
        ListIterator<Object> li2IT=listTwo.listIterator();
        while(li2IT.hasNext()){
            listThree.add(li2IT.next());
        }

        return listThree;
    }

    public static void main(String[] args){
        List<Object> listOne=new LinkedList<Object>();
        listOne.add("Hello");
        listOne.add(102);
        listOne.add(25);
        listOne.add(38.5);

        List<Object> listTwo=new LinkedList<Object>();
        listTwo.add(150);
        listTwo.add(200);
        listTwo.add('A');
        listTwo.add("Welcome");

        List<Object>concate=concatenateLists(listOne,listTwo);
        System.out.println(concate);

    }
}
