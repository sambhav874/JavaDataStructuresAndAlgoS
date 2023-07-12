package Algorithms.MinimumSpanningTreeAlgoS.AlgoSDesignTechniques;

//Find the maximum and minimum value in an array using divide and conquer technique.
//Implement the logic in getMaxMin() method.
//Return an array containing the maximum value in index position 0 and the minimum value in index position 1 from the getMaxMin() method.


public class divideANDconquer_problem1 {

    public static int[] getMaxMin(int arr[], int low, int high) {

        int[] arr1= new int[2];
        // Base case: If the array contains only one element
        if (low == high) {
            arr1[0] = arr[low]; // Maximum and minimum are the same
            arr1[1] = arr[low];
            return arr1;
        }

        // Divide the array into two halves and recursively find the maximum and minimum.
        int mid = (low + high)/2;
        int[] leftResult= getMaxMin(arr , 0 , mid);
        int[] rightResult= getMaxMin(arr , mid + 1 , high);


        // Compare the maximum and minimum of the two halves
        if(leftResult[0] > rightResult[0]){
            arr1[0]=leftResult[0];
        }
        else {
            arr1[0]=rightResult[0];
        }

        if(leftResult[1] < rightResult[1]){
            arr1[1]=leftResult[1];
        }
        else {
            arr1[1]=rightResult[1];
        }

        return arr1;
    }

    public static void main(String args[]) {
        int arr[] = {1000, 10, 5, 1, 2000};

        int[] maxMin = getMaxMin(arr, 0, arr.length - 1);

        System.out.println("Minimum value is "+ maxMin[1]);
        System.out.println("Maximum value is "+ maxMin[0]);
        System.out.println();

        int arr1[] = {2,3};

        int[] maxMin1 = getMaxMin(arr1, 0, arr1.length - 1);

        System.out.println("Minimum value is "+ maxMin1[1]);
        System.out.println("Maximum value is "+ maxMin1[0]);
    }

}
