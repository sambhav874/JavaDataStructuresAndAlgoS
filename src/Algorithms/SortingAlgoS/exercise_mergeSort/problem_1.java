package Algorithms.SortingAlgoS.exercise_mergeSort;

public class problem_1 {
    public static void merge(int arr[] , int[] left , int right[] ,int leftMerge , int rightMerge ) {

        int firstIndex = 0;
        int secondIndex = 0;
        int thirdIndex = 0;

        while (firstIndex < leftMerge && secondIndex < rightMerge) {
            if (left[firstIndex] <= right[secondIndex]) {
                arr[thirdIndex++] = left[firstIndex++];
            } else {
                arr[thirdIndex++] = right[secondIndex++];
            }
        }
        while (firstIndex < leftMerge) {

            arr[thirdIndex++] = left[firstIndex++];

        }
        while (secondIndex < rightMerge) {

            arr[thirdIndex++] = right[secondIndex++];

        }
    }
    public static void mergeSort(int arr[] ,int size){

        if(size<2){
            return;
        }
        int mid = size / 2;
        int[] left= new int[mid];
        int[] right= new int[size - mid];

        for(int index=0 ; index < mid ; index++){
            left[index] = arr[index];
        }

        for(int index1=mid ; index1 < size ; index1++){
            right[index1- mid] = arr[index1] ;
        }
        mergeSort(left , mid);
        mergeSort(right , size - mid);

        merge(arr , left , right ,mid ,size - mid);
    }

    public static void displayArray(int arr[]){
        for(int iter : arr){
            System.out.print(iter+" ");

        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        int[] elements = { 95, 56, 20, 98, 34, 77, 80 };

        System.out.println("Given Array:");
        displayArray(elements);

        mergeSort(elements, elements.length);

        System.out.println("Sorted Array:");
        displayArray(elements);

    }
}
