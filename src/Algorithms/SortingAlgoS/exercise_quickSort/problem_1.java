package Algorithms.SortingAlgoS.exercise_quickSort;

//On the day of exhibition, few students did not turn up. So the teacher followed the below strategy to identify the first 10 students who were sent as group-1.
//
// Suppose the ticket id of the students who turned up on that day is as follows:
//T20, T5, T10, T1, T2, T8, T16, T17, T9, T4, T12, T13, T18
//She made the students stand in a line in increasing order of their ticket numbers. They were asked to leave a vacant position, in case a student has not turned up.
//Ex: T1, T2, V, T4, T5, V, V, T8, T9, T10, V, T12, T13, V, V, T16, T17, T18, V, T20 where V - indicates vacant position.
//Grouped them into 2 groups of 10 each including vacant positions.
//Ex: Group – 1 (T1, T2, V, T4, T5, V, V, T8, T9, T10), Group – 2 (V, T12, T13, V, V, T16, T17, T18, V, T20)
//Filled the vacant positions with the students from the next group as shown in the example below.
//Ex: Group – 1 (T1, T2, T12, T4, T5, T13, T16, T8, T9, T10) Group -2 (T17, T18, T20)
//Write a java program which accepts the unsorted ticket id list and returns the list of ticket ids of the ten students who were finally sent inside as part of Group-1.

import java.util.Arrays;

public class problem_1 {


        public static void quickSort(String[] arr, int low, int high) {
            if (low < high) {
                int pivotIndex = partition(arr, low, high);
                quickSort(arr, low, pivotIndex - 1);
                quickSort(arr, pivotIndex + 1, high);
            }
        }

        public static int partition(String[] arr, int low, int high) {
            String pivot = arr[high];
            int i = low - 1;

            for (int j = low; j <= high - 1; j++) {
                if (arr[j].compareTo(pivot) <= 0) {
                    i++;
                    swap(arr, i, j);
                }
            }

            swap(arr, i + 1, high);
            return i + 1;
        }

        public static void swap(String[] arr, int i, int j) {
            String temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        public static String[] getGroupOneTicketIds(String[] ticketIds) {
            int totalGroups = ticketIds.length / 10;
            String[] sortedTicketIds = Arrays.copyOf(ticketIds, ticketIds.length);
            quickSort(sortedTicketIds, 0, sortedTicketIds.length - 1);

            String[] groupOneTicketIds = new String[10];
            int groupOneIndex = 0;

            for (int i = 0; i < totalGroups; i++) {
                for (int j = i * 10; j < (i * 10) + 10; j++) {
                    if (!sortedTicketIds[j].equals("V")) {
                        groupOneTicketIds[groupOneIndex] = sortedTicketIds[j];
                        groupOneIndex++;
                    }
                }
            }

            return groupOneTicketIds;
        }

        public static void main(String[] args) {
            String[] ticketIds = {"T20", "T5", "T10", "T1", "T2", "T8", "T16", "T17", "T9", "T4", "T12", "T13", "T18"};

            String[] groupOneTicketIds = getGroupOneTicketIds(ticketIds);
            System.out.println("Group-1 Ticket IDs: " + Arrays.toString(groupOneTicketIds));
        }


}
