package Algorithms.SortingAlgoS.exercise_bubbleSort;

public class problem_1 {
    static int noOfSwaps = 0;
    static int noOfPasses = 0;

    public static void swap(int[] elements, int firstIndex, int secondIndex) {
        int temp=elements[firstIndex];
        elements[firstIndex]=elements[secondIndex];
        elements[secondIndex]=temp;
        noOfSwaps++;
    }

    public static int bubbleSort(int[] elements) {

        int len=elements.length;

        for(int index1=0 ; index1 < (len - 1) ; index1++){

            boolean swapped=false;
            noOfPasses++;

            for(int index2=0; index2 < (len - index1 - 1);index2++){

                if(elements[index2]>elements[index2+1]){

                    swap(elements , index2 , index2 +1);
                    swapped=true;
                }
            }
            if(!swapped){
                break;
            }
        }

        return noOfPasses;
    }

    public static void displayArray(int[] elements) {
        for (int element : elements)
            System.out.print(element + " ");
        System.out.println();
    }


    public static void main(String[] args) {

        int[] elements = { 23, 67, 45, 76, 34, 68, 90 };

        System.out.println("Given array:");
        displayArray(elements);

        int noOfPasses = bubbleSort(elements);

        System.out.println("==========================");
        System.out.println("Total number of passes needed to sort the array: " + noOfPasses);
        System.out.println("==========================");

        System.out.println("Array after sorting:");
        displayArray(elements);

    }
}
