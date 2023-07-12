package Algorithms.ShortestPathAlgoS.GraphQuestions;

//Design a schedule for a student to complete his degree given the list of the courses along with the prerequisites of each course.
// There are two lists : list of courses and another list of prerequisites for those courses.
//List one contains: [CS 101 , CS 102 , CS 103 , CS 104, CS 105, CS 106 , CS 107]
//Prerequisites list contains two columns first one are the courses and the second one have courses they are prerequisites for.
// Column 1 contains [CS 101 , CS 101 , CS 103 , CS 104 , CS 105]
// Column 2 contains [CS 102 , CS 103 , CS 105 , CS 105 , CS 107]

import Algorithms.ShortestPathAlgoS.AdjacencyMatrixGraph;
import Algorithms.ShortestPathAlgoS.Graph;
import Algorithms.ShortestPathAlgoS.TopologicalSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class problem_1 {

    public static List<String> order(List<String> courseLIST , Map<String , List<String>> prereqs){

        //THE LIST OF COURSES AND THE PRE-REQS ARE INPUTS TO THIS METHOD.
        Graph courseGraph = new AdjacencyMatrixGraph(courseLIST.size(), Graph.GraphType.DIRECTED);
        Map<String , Integer> courseIDMap = new HashMap<>();
        Map<Integer , String> idCourseMAP = new HashMap<>();
        //SET UP A MAPPING FROM THE COURSE NAME TO A UNIQUE INTEGER ID AND THE REVERSE
        //MAPPING AS WELL

        for (int i = 0 ; i < courseLIST.size() ; i++){
            courseIDMap.put(courseLIST.get(i), i );
            idCourseMAP.put(i , courseLIST.get(i));
        }

        for(Map.Entry<String , List<String>> prereq : prereqs.entrySet()){
            //ADD A GRAPH EDGE FOR EVERY PRE-REQ TO COURSE
            for(String course : prereq.getValue()){
                courseGraph.addEdge(courseIDMap.get(prereq.getKey()) , courseIDMap.get(course));
            }
        }
        List<Integer> courseIDlist = TopologicalSort.sort(courseGraph);
        //CALL TOPOLOGICAL SORT ON THE GRAPH

        List<String> courseScheduleList = new ArrayList<>();

        for(int courseId : courseIDlist){
            courseScheduleList.add(idCourseMAP.get(courseId));
            //FIND THE COURSE NAMES FOR THE VERTICES AND YOU HAVE A COURSE SCHEDULE.
        }
        return courseScheduleList;
    }

    public static void main(String[] args){
        List<String> Courses = new ArrayList<>();
        Courses.add("CS100");
        Courses.add("CS101");
        Courses.add("CS102");
        Courses.add("CS103");
        Courses.add("CS104");
        Courses.add("CS105");
        Courses.add("CS106");
        Courses.add("CS107");

        Map<String, List<String>> prereqs = new HashMap<>();
        List<String> list = new ArrayList<>();

        list.add("CS101");
        list.add("CS102");
        list.add("CS103");
        prereqs.put("CS100", list);

        list = new ArrayList<>();
        list.add("CS104");
        prereqs.put("CS102", list);

        list = new ArrayList<>();
        list.add("CS105");
        prereqs.put("CS103", list);

        List<String> courseSchedule = order(Courses, prereqs);
        System.out.println("Valid schedule for CS Students");

        for (String course : courseSchedule) {
            System.out.println(course);
        }
    }

}
