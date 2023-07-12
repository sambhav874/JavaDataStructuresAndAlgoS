package Algorithms.SortingAlgoS.exercise_insertionSort;

//You don't have to read input or print anything. Your task is to complete the function insert() and insertionSort() where insert() takes the array,
// it's size and an index i and insertionSort() uses insert function to sort the array in ascending order using insertion sort algorithm .

import java.util.Arrays;

public class problem_1 {

        public static void insert(int[] arr, int size, int i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }

        public static void insertionSort(int[] arr, int size) {
            for (int i = 1; i < size; i++) {
                insert(arr, size, i);
            }
        }

        public static void main(String[] args) {
            int[] arr = {5, 2, 9, 1, 3};
            int size = arr.length;

            System.out.println("Before sorting: " + Arrays.toString(arr));
            insertionSort(arr, size);
            System.out.println("After sorting: " + Arrays.toString(arr));
        }


}
