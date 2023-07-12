package Algorithms.SortingAlgoS.exercise_mergeSort;
//Given an array of size 'n', sort the array in ascending order using Merge Sort algorithm and find out the median value. The median is the value that is present in the middle of a sorted array containing odd number of values. If the sorted array contains even number of values, median is the average of middle two values.
//
//Implement the functionalities based on the description given below.
//
//Method Description
//
//mergeSort(int[] elements, int size)
//
//Sort the array using the merge sort algorithm
//
//merge(int[] elements, int[] left, int[] right, int leftMerge, int rightMerge)
//
//Merge the left array and right array to produce new sorted arrays
//
//findMedian(int elements[])
//
//Find out and return the median value.



public class problem_2 {

    public static void merge(int elements[] , int[] left , int[] right , int leftMerge , int rightMerge){

        int firstIndex=0;
        int secondIndex=0;
        int thirdIndex=0;

        if(firstIndex<= leftMerge && secondIndex<= rightMerge){
            if(left[firstIndex] <= right[secondIndex]){
                elements[thirdIndex++]=left[firstIndex++];
            }
            else {
                elements[thirdIndex++]=right[secondIndex++];
            }
        }
        while(firstIndex < leftMerge){
            elements[thirdIndex++]=left[firstIndex++];
        }
        while (secondIndex < rightMerge){
            elements[thirdIndex++] = right[secondIndex++];
        }
    }
    public static void mergeSort(int[] elements, int size){

        if(size<2){
            return ;
        }

        int mid= size / 2;

        int left[] = new int[mid];
        int right[] = new int[size - mid];

        for(int index=0; index< mid; index++){
            left[index]=elements[index];
        }
        for(int index1=mid; index1 < size ; index1++){
            right[index1-mid]=elements[index1];
        }

        mergeSort(left,mid);
        mergeSort(right,size-mid);
        merge(elements,left,right,mid , size-mid);

    }

    public static double findMedian(int[] elements){
        int size = elements.length;

        mergeSort(elements,size);


        if(size % 2 == 0){
            int mid= size/2;
            return elements[mid - 1] + elements[ mid ]/2.0;
        }
        else{
            int mid= size/2;
            return elements[mid];
        }
    }

    public static void main(String[] args){

            int elements[] = { 64, 34, 25, 12, 22, 11, 90 };
            mergeSort(elements, elements.length);
            System.out.println("Median: "+findMedian(elements));
    }
}
