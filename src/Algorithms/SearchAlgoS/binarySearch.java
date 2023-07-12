package Algorithms.SearchAlgoS;

//The time complexity of binary search is log 2 (n).

public class binarySearch {
    public static int search(int arrayOfElem[], int elementToBeSearched) {
        int low = 0;
        int high = arrayOfElem.length - 1;
        int mid;

        while(low<=high){
            mid = (low + high) / 2;

            // Checking if the element to be searched is present in the mid position
            if (arrayOfElem[mid] == elementToBeSearched) {

                return mid;
            }
            // If the element to be searched is greater than the element in the mid position, low is updated
            else if (arrayOfElem[mid] < elementToBeSearched) {

                low = mid + 1;
            }
            // If the element to be searched is lesser than the element in the mid position, high is updated
             else {

                high = mid - 1;
            }

        }
        // -1 is being returned when the element is not present in the array
        return -1;
    }

    public static void main(String[] args){
        int[] arrayOfElements = { 10, 15, 23, 25, 32, 39, 45, 47, 49, 50 };
        int elementToBeSearched = 50;

        int index = search(arrayOfElements, elementToBeSearched);
        if (index == -1)
            System.out.println("Element is not present in the array!");
        else
            System.out.println("Element is found at index position " + index+"!");
    }
}
