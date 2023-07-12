package assignment_Combined;

import java.util.HashMap;
import java.util.Map;

public class mergeMaps_3 {

    public static Map<String, Integer> mergeMaps(Map<String, Integer> mapOne, Map<String, Integer> mapTwo){
        mapOne.putAll(mapTwo);
        return mapOne;
    }

    public static void main(String[] args){
        Map<String,Integer> mapOne=new HashMap<>();

        mapOne.put("Kelly",10);
        mapOne.put("Micheal", 20);
        mapOne.put("Ryan", 30);

        Map<String,Integer> mapTwo=new HashMap<>();

        mapTwo.put("Jim", 15);
        mapTwo.put("Andy", 45);

        Map<String, Integer> mergedMap = mergeMaps(mapOne, mapTwo);

        System.out.println("Merged Map\n===========");
        for (Map.Entry<String, Integer> entry : mergedMap.entrySet()) {
            System.out.println(entry.getKey()+" -- "+entry.getValue());
        }
    }
}
