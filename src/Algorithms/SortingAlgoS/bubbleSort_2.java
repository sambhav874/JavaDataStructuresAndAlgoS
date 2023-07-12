package Algorithms.SortingAlgoS;

public class bubbleSort_2 {
    public static void sortArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args){
        int[] numbers =  { 48, 40, 35, 49, 33 };
        System.out.println("Given array:");
        for (int number : numbers) {
            System.out.println(number);
        }

        sortArray(numbers);

        System.out.println("Sorted array:");
        for (int number : numbers) {
            System.out.println(number);
        }


    }
}
