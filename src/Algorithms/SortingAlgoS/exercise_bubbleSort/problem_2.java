package Algorithms.SortingAlgoS.exercise_bubbleSort;
//Given an array of size 'n' and an integer 'm', sort the array in ascending order using Bubble Sort algorithm and find the maximum sum that can be obtained by summing 'm' integers of the array and the minimum sum that can be obtained by summing 'm' integers of the array.
// If the array does not have 'm' number of elements, return 0 as the maximum and minimum sum.
// Implement the logic of sorting the array, finding the maximum sum and finding the minimum sum in sortArray(), findMaxSum() and findMinSum() methods respectively.

public class problem_2 {
    static int noOfSwaps;
    static int noOfPasses;
    public static void swap(int[] arr , int firstIndex , int secondIndex){

        int temp = arr[firstIndex];
        arr[firstIndex]=arr[secondIndex];
        arr[secondIndex]=temp;
        noOfSwaps++;
    }

    public static void sortArray(int[] arr){

        int length = arr.length;

        for(int index = 0 ; index < (length - 1)  ; index ++){

            boolean swapped = false;
            noOfPasses++;

            for(int index2 = 0 ; index2 < (length - index - 1) ; index2++){
                if(arr[index2] > arr[index2 + 1]){
                    swap(arr , index2 , index2 +1);
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
    }
    public static int findMaxSum(int arr[], int m) {

        if (arr.length < m) {
            return 0;
        }
        int sum=0;
        for(int index = arr.length - 1 ; index >= arr.length - m ; index--){
            sum += arr[index];

        }
        return sum;
    }

    public static int findMinSum(int arr[], int m) {

        if (arr.length < m) {
            return 0;
        }
        int sum=0;

        for(int index = 0 ; index <  m ; index++) {
            sum += arr[index];
        }return sum;

    }

    public static void main(String[] args) {
        int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
        sortArray(arr);
        System.out.println("Maximum Sum for m=4: " + findMaxSum(arr, 4));
        System.out.println("Minimum Sum for m=3: " + findMinSum(arr, 3));
        }
    }

