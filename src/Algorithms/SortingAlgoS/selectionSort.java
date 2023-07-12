package Algorithms.SortingAlgoS;

public class selectionSort {
    public static void sort(int[] a){
        int n=a.length;
        for (int i=0;i<n;i++) {

            int min = i;    // min here will be the first element.

            for (int j = i + 1; j < n; j++) { // this will iterate from the second element of the array to compare it with the first element.
                if (a[j] < a[min]) {
                    swap(a,j,min); // swap function will replace j with min if the element present at j is smaller than the element at min element.
                }
            }
        }
    }
    public static void swap(int [] a , int small , int big){
        int temp = a[small];
        a[small]=a[big];
        a[big]=temp;

    }
    public static void main(String args[]){
        int [] a=new int[5];
        a[0]=15;
        a[1]=13;
        a[2]=5;
        a[3]=4;
        a[4]=10;

        for (int j : a) {
            sort(a);
            System.out.print(j + " ");
        }

    }
}
