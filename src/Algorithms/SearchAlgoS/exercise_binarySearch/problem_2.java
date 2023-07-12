package Algorithms.SearchAlgoS.exercise_binarySearch;
//Given an array of Customer Ids, check whether a Customer Id is present or not using Binary Search algorithm.
// If the Customer Id is present, return the index in which the Customer Id is present, else return -1.
// Implement the logic in searchCustomerId() method.
//
//Assume that the Customer Ids are sorted in ascending order in the array.



public class problem_2 {
    public static int searchCustomerId(int customerIds[], int customerIdToBeSearched) {
        int low=0;
        int high = customerIds.length - 1;
        int mid ;

        while(low<=high){

            mid = (low + high) / 2;

            if( customerIds[mid] == customerIdToBeSearched){
                return mid;}
            else if( customerIds[mid] < customerIdToBeSearched){
                low= mid+1;
            }
            else {

                high = mid - 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] customerIds = { 80451, 80462, 80465, 80479, 80550, 80561, 80665, 80770 };
        int customerIdToBeSearched = 80462;

        int index = searchCustomerId(customerIds, customerIdToBeSearched);

        if (index == -1)
            System.out.println("Customer Id " + customerIdToBeSearched + " is not found!");
        else
            System.out.println("Customer Id " + customerIdToBeSearched + " is found at index position " + index+"!");
    }

}
