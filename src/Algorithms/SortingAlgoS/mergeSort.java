package Algorithms.SortingAlgoS;

public class mergeSort {
    public static void merge(int arr[], int[] left, int[] right, int leftMerge, int rightMerge){

        int firstIndex=0;//initial index of first sub-array
        int secondIndex=0;//initial index of second sub-array
        int thirdIndex=0;//initial index of third sub-array

        while(firstIndex<leftMerge && secondIndex<rightMerge){
            if(left[firstIndex]<=right[secondIndex]){
                arr[thirdIndex++]=left[firstIndex++];

            }
            else{
                arr[thirdIndex++]=right[secondIndex++];
            }
        }
        while(firstIndex<leftMerge){
            arr[thirdIndex++]=left[firstIndex++];

        }

        while(secondIndex< rightMerge){
            arr[thirdIndex++]=right[secondIndex++];

        }

    }

    public static void MergeSort(int arr[] , int size){

        if(size < 2){
            return;
        }
        int mid = size/2; //Dividing the array into two halves

        int[] left=new int[mid];//Creating temporary array to the left of the mid value
        int[] right=new int[size-mid];//Creating temporary array to the right of the mid value

        //Copying data to temporary arrays
        for(int index=0; index<mid ;index++){
            left[index]=arr[index];
        }

        for(int index1=mid; index1<size ; index1++){
            right[index1 - mid]=arr[index1];
        }

        //Invoking mergeSort() by passing left array
        MergeSort(left, mid);

        //Invoking mergeSort() by passing right array
        MergeSort(right, size - mid);

        //Invoking merge() by passing the arrays returned
        merge(arr, left, right, mid, size - mid);
    }

    public static void main(String[] args) {
        int[] arr = { 19, 8, 16, 26, 45, 76 };
        MergeSort(arr, arr.length);
        for (int number : arr)
            System.out.println(number);
    }
}
