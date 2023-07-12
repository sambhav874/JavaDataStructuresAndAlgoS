package Algorithms.MinimumSpanningTreeAlgoS.AlgoSDesignTechniques;

//Find out the maximum number of activities that can be performed by a single person using greedy approach based on the given start and finish times.
// A person can perform only one activity at a time.
// Implement the logic in findMaxActivities() method.
//
//Hint: The activities need to be chosen based on the finish time as the finish time of all the activities are sorted in ascending order.



public class greedyApproach_problem1 {
// Java program for activity selection problem.

// The following implementation assumes that the activities
// are already sorted according to their finish time

        // Prints a maximum set of activities that can be done
        // by a single person, one at a time.

    private static int findMaxActivities(int[] start, int[] finish) {

        int size= start.length;

        int i=0;

        for(int j=1;j<size;j++) {
            if (start[j] >= finish[i]) {
                i = j;
            }
        }
        return i;
    }

    public static void main(String[] args)
    {
        int start[] =  {1, 3, 0, 5, 8, 5};
        int finish[] =  {2, 4, 6, 7, 9, 9};


        // Function call

        System.out.println("Maximum number of activities: "+findMaxActivities(start, finish));


        int s[] =  {1, 3, 0, 5, 9, 0};
        int f[] =  {3, 5, 8, 10, 12, 13};


        // Function call

        System.out.println("Maximum number of activities: "+findMaxActivities(s, f));
    }


}
        // Driver code


