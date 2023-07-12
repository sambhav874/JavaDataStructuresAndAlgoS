package Algorithms.SortingAlgoS;

public class shellSort {
    public static void sort(int[] a) {
        int mid = a.length / 2;
        int h = 1;

        // Determine the initial value of 'h' using the Knuth sequence
        while (h < mid / 2) {
            h = 3 * h - 1;
        }

        // Perform Shell Sort
        while (h >= 1) {
            // Iterate through each element in the array
            for (int i = h; i < a.length; i++) {
                // Perform insertion sort on the subarray defined by the gap 'h'
                for (int j = i; j >= h && a[j] < a[j - h]; j -= h) {
                    swap(a, j, j - h);
                }
            }
            // Reduce the gap for the next iteration
            h = h / 2;
        }
    }

    public static void swap(int[] a, int b, int c) {
        // Swap elements in the array
        int temp = a[b];
        a[b] = a[c];
        a[c] = temp;
    }

    public static void main(String[] args) {
        int[] a = new int[5];
        a[0] = 15;
        a[1] = 13;
        a[2] = 5;
        a[3] = 4;
        a[4] = 10;

        // Sort the array using Shell Sort
        sort(a);

        // Print the sorted array
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
