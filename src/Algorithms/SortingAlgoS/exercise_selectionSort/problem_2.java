package Algorithms.SortingAlgoS.exercise_selectionSort;

import java.util.Arrays;
//Using the swap() and find_next_min() functions, implement the selection sort algorithm to sort a list of numbers in ascending order.

public class problem_2 {

        public static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        public static int findMinimumIndex(int[] arr, int startIndex) {
            int minValue = arr[startIndex];
            int minIndex = startIndex;

            for (int i = startIndex + 1; i < arr.length; i++) {
                if (arr[i] < minValue) {
                    minValue = arr[i];
                    minIndex = i;
                }
            }

            return minIndex;
        }

        public static void selectionSort(int[] arr) {
            for (int i = 0; i < arr.length - 1; i++) {
                int minIndex = findMinimumIndex(arr, i);
                swap(arr, i, minIndex);
            }
        }

        public static void main(String[] args) {
            int[] arr = {10, 2, 100, 67, 5};
            System.out.println("Before sorting: " + Arrays.toString(arr));

            selectionSort(arr);

            System.out.println("After sorting: " + Arrays.toString(arr));
        }


}
