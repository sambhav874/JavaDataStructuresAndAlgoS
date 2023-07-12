package Algorithms.SortingAlgoS.exercise_selectionSort;

//Write a function to find and return the index of the minimum element in a sub-list. Follow the instructions provided in template code.
//Follow the instructions:
//#Remove pass and write the logic to find the minimum element in a sub-list and return the index of the identified element in the num_list.
//    #start_index indicates the start index of the sub-list

public class problem_1 {

        public static int findMinimumIndex(int[] numList, int startIndex) {
            // Set the initial minimum value and its index based on the start index
            int minValue = numList[startIndex];
            int minIndex = startIndex;

            // Iterate through the sub-list starting from start index + 1
            for (int i = startIndex + 1; i < numList.length; i++) {
                // Update the minimum value and index if a smaller value is found
                if (numList[i] < minValue) {
                    minValue = numList[i];
                    minIndex = i;
                }
            }

            // Return the index of the minimum element in the sub-list
            return minIndex;
        }

        public static void main(String[] args) {
            int[] numList = {10, 2, 100, 67};
            int startIndex = 1;
            System.out.println("Index of the next minimum element is " + findMinimumIndex(numList, startIndex));
        }


}
