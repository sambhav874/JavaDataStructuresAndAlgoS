package Algorithms.MinimumSpanningTreeAlgoS.AlgoSDesignTechniques;

//Given an array of integers, find and return the maximum sum that can be obtained using contiguous subarrays of the array using Divide and Conquer technique.
// Implement the logic in findMaxSum() method.
// To implement the logic, you need to also calculate the maximum sum of the subarray containing the middle element.
// You need to implement the logic of calculating the maximum sum of the subarray containing the middle element findMaxCrossingSubarraySum() method.


public class divideANDconquer_problem2 {

    public static int findSubArraySum(int[] arr , int low , int high){

        if (low == high) {
            return arr[low];
        }

        int size = arr.length;

        int mid= (low + high) / 2;

        int m1 = findSubArraySum(arr , low , mid);
        int m2 = findSubArraySum(arr , mid + 1 , high);
        int m3 = findCrossingMaxSubArraySum(arr , low , mid ,high);

        if(m1 >= m2 && m1 >= m3){
            return m1;
        }
        else if (m2 >= m1 && m2 >= m3) {
            return m2;
        }
        else{
            return m3;
        }

    }

    public static int findCrossingMaxSubArraySum(int[] arr , int low , int mid , int high){

        int leftSum = 0;
        int sum = 0;

        for (int i = mid; i >= low; i--) {
            sum += arr[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }

        int rightSum = 0;
        sum = 0;

        for (int i = mid + 1; i <= high; i++) {
            sum += arr[i];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }
        return leftSum + rightSum;
    }

    public static void main(String[] args){

        int arr[] = { -2, -5, 6, -2, -3, 1, 5, -6 };
        System.out.println("Maximum sum: " + findSubArraySum(arr, 0, arr.length - 1));

        int arr1[] = { -2, 1, -3, 4, -1, 2, 1, -5 , 4};
        System.out.println("Maximum sum: " + findSubArraySum(arr1, 0, arr1.length - 1));

    }
}
