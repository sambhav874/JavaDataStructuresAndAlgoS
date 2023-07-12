package Maps;

import java.util.HashMap;
import java.util.Map;

public class Student {
    public static Map<String,Double> findMinMaxScores(Map<String,Double> scores){

        // To store the result
        Map.Entry<String,Double> entryWithMaxValue=null;
        Map.Entry<String,Double> entryWithMinValue=null;

        // Iterate in the map to find the required entry
        for(Map.Entry<String,Double> currentEntry: scores.entrySet()){
            if (// If this is the first entry, set result as
                // this
                // If this entry's value is more than the
                // max value Set this entry as the max
                    entryWithMaxValue==null|| currentEntry.getValue().compareTo(entryWithMaxValue.getValue())>0){
                entryWithMaxValue=currentEntry;
            }
        }
        for(Map.Entry<String,Double> currentEntry1: scores.entrySet()){
            if (// If this is the first entry, set result as
                // this
                // If this entry's value is less than the
                // max value Set this entry as the min
                    entryWithMinValue==null|| currentEntry1.getValue().compareTo(entryWithMaxValue.getValue())<0){
                entryWithMinValue=currentEntry1;
            }
        }
        // Return the entry with highest value
            System.out.println(entryWithMaxValue);
// Return the entry with lowest value
        System.out.println(entryWithMinValue);
        return scores;
    }
}
class tester{
    public static void main(String[] args){
        Map<String,Double> studentMarks=new HashMap<>();
        studentMarks.put("Lily",90.0);
        studentMarks.put("Robin",68.0);
        studentMarks.put("Marshall",76.5);
        studentMarks.put("Neil",67.0);
        studentMarks.put("Ted",92.0);

        HashMap<String, Double> result = (HashMap<String, Double>) Student.findMinMaxScores(studentMarks);

    }
}
