package Algorithms.SortingAlgoS;

public class insertionSort {
    public static void sort(int[] a){
        int n = a.length;

        // Iterate from the second element to the last element
        for (int i = 1; i < n; i++) {

            // Compare the current element with the elements before it and swap if necessary
            for (int j = i; j > 0 && a[j] < a[j-1]; j--) {
                swap(a, j, j-1);
            }
        }
    }

    // Helper function to swap two elements in an array
    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String args[]){
        int[] a = new int[5];

        // Initialize the array with some values
        a[0] = 15;
        a[1] = 13;
        a[2] = 5;
        a[3] = 4;
        a[4] = 10;

        // Sort the array using the insertion sort algorithm
        sort(a);

        // Print the sorted array
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }


}
