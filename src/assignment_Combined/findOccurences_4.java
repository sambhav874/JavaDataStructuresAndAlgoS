package assignment_Combined;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class findOccurences_4 {
    public static Map<Character,Integer> findOccurences(String in){

        Map<Character,Integer> characterIntegerMap=new HashMap<>();


        for(int i=0;i<in.length();i++){
            int count=0;
            if(characterIntegerMap.containsKey(in.charAt(i))){
                count=characterIntegerMap.get(in.charAt(i));
                characterIntegerMap.put(in.charAt(i),++count);
            }
            else{
                characterIntegerMap.put(in.charAt(i),1);
            }
        }
        return characterIntegerMap;
    }

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        Map<Character,Integer> occurrenceMap=findOccurences(input);

        System.out.println("Occurrences of characters\n=======================");
        for (Map.Entry<Character, Integer> entry : occurrenceMap.entrySet()) {
            System.out.println(entry.getKey()+" -- "+entry.getValue());
        }
    }
}
