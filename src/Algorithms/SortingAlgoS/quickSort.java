package Algorithms.SortingAlgoS;

import java.util.Arrays;

public class quickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition the array
            int pivotIndex = partition(arr, low, high);

            // Recursively sort the two sub-arrays
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        // Choose the rightmost element as the pivot
        int pivot = arr[high];

        // Index of the smaller element
        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            // If the current element is smaller than or equal to the pivot, swap it with the element at index i
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // Swap the pivot element with the element at index i+1
        swap(arr, i + 1, high);

        // Return the index of the pivot element
        return i + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        System.out.println("Before sorting: " + Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);

        System.out.println("After sorting: " + Arrays.toString(arr));
    }


}
