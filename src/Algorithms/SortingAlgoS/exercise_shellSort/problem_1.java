package Algorithms.SortingAlgoS.exercise_shellSort;

//Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order using shell sort

import java.util.Arrays;

public class problem_1 {

        public static void shellSort(int[] arr) {
            int n = arr.length;

            // Start with a large gap, then reduce the gap in each iteration
            for (int gap = n / 2; gap > 0; gap /= 2) {
                // Perform insertion sort on subarrays defined by the gap
                for (int i = gap; i < n; i++) {
                    int temp = arr[i];
                    int j = i;

                    // Shift elements of the subarray to the right
                    while (j >= gap && arr[j - gap] > temp) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }

                    arr[j] = temp;
                }
            }
        }

        public static void main(String[] args) {
            int[] arr = {0, 1, 2, 2, 1, 0, 1, 2, 0};
            System.out.println("Before sorting: " + Arrays.toString(arr));

            shellSort(arr);

            System.out.println("After sorting: " + Arrays.toString(arr));
        }


}
