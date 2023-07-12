package Algorithms.SearchAlgoS;


//The time complexity of the linear search is O(n). As the number of elements in the array the more the number of iterations it would make.

public class linearSearch {

    //Input elementToBeSearched, arrayOfElements
    //for (int index = 0, index < arrayOfElements.length, index++)
    //     if arrayOfElements[index] == elementToBeSearched then
    //          return index
    //     end-if
    //return -1

    public static int search(int arrOfElem[], int elemToBeSearched) {
        for (int index = 0; index < arrOfElem.length; index++) {
            // this loop will iterate the whole array.
            if (arrOfElem[index] == elemToBeSearched) {
                //this will check and return the element if it is the same element that is to be searched.
                return index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr1[] = new int[5];

        arr1[0] = 14;
        arr1[1] = 1;
        arr1[2] = 51;
        arr1[3] = 71;
        arr1[4] = 32;

        int num = search(arr1, 71);

        // Checking whether the element has been found or not
        if (num == -1)
            System.out.println("Element is not present in the array!");
        else
            System.out.println("Element is found at index position " + num+"!");
    }
}

