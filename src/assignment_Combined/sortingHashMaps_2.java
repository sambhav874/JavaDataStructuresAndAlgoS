package assignment_Combined;

import java.util.*;

public class sortingHashMaps_2 {

    public static List<String> sortSales(Map<String,Integer> m1){

        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(m1.entrySet());
        Collections.sort(sortedList, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                return e2.getValue().compareTo(e1.getValue());
            }
        });
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : sortedList) {
            result.add(entry.getKey());
        }
        return result;
    }

    public static void main(String[] args){

        Map<String,Integer> sales=new HashMap<>();

        sales.put("Mathew", 50);
        sales.put("Lisa", 76);
        sales.put("Courtney", 45);
        sales.put("David", 49);
        sales.put("Paul", 49);

        System.out.println(sales);
        List<String> employeesList=sortSales(sales);
        System.out.println();
        System.out.println("Employees in the decreasing order of their sales\n=====================================");
        for (String employeeName : employeesList) {
            System.out.println(employeeName);
        }

    }
}
