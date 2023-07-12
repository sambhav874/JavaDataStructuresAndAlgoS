package Algorithms;

public class timeComplexity_example1 {
    public static int getCount(int[] arr, int n) {
        int count1 = 0;
        int count2 = 0;
        int index;
        for (int index1 = 0; index1 < n - 1; index1++)
            for (int index2 = index1 + 1; index2 < n; index2++)
                if (arr[index1] > arr[index2])
                    count1++;
                else {
                    index=index2;
                    count2=0;
                    while(index>index1) {
                        count2++;
                        index--;
                    }
                }
        return Math.max(count1, count2);
    }
    // the declaration of count1,count2,index will take constqnt time,O(1).
    //the outer loop 'index1' iterates from 0 to n - 2 - This loop executes (n - 1) times.
    //the outer loop 'index1'  iterates from index1 + 1 to n - 1 - This loop executes (n - 1) + (n - 2) + ... + 2 + 1 times. In Big O notation, this sum is equivalent to (n - 1) * n / 2, which simplifies to O(n^2).
    //Comparison and increment: In each iteration of the inner loop, there is one comparison and possibly one increment of either count1 or count2, depending on the condition. Both operations take constant time, O(1).
    //Nested while loop: This loop executes count2 times, where count2 is the number of times the inner else condition is encountered.
    //Maximum operation: The Math.max operation compares count1 and count2 and returns the maximum value. This step takes constant time, O(1).

    //Hence, the time complexity of this method is O(n^2).
}
