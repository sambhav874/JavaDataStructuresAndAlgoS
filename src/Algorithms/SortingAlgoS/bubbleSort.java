package Algorithms.SortingAlgoS;

public class bubbleSort {

    static int noOfSwaps=0;
    static int noOfPasses=0;
    public static void swap(int[] numbers , int firstIndex , int secondIndex ){

        int temp=numbers[firstIndex];
        numbers[firstIndex]=numbers[secondIndex];
        numbers[secondIndex]=temp;
        noOfSwaps++;
    }

    public static void BubbleSort(int[] numbers){

        int length=numbers.length;

        for(int index = 0 ; index < (length - 1) ; index ++){

            boolean swapped=false;
            noOfPasses++;

            for(int indexx = 0 ; indexx <(length - index -1) ; indexx++){
                if(numbers[indexx] > numbers[indexx + 1]){
                    swap(numbers , indexx , indexx+1);
                    swapped=true;
                }
            }
            if (!swapped){
                break;
            }
        }
    }

    public static void main(String[] args) {

        int[] numbers =  { 48, 40, 35, 49, 33 };
        System.out.println("Given array:");
        for (int number : numbers) {
            System.out.println(number);
        }

        BubbleSort(numbers);

        System.out.println("Sorted array:");
        for (int number : numbers) {
            System.out.println(number);
        }

        System.out.println("No. of passes: " + noOfPasses);
        System.out.println("No. of swaps: " + noOfSwaps);
    }

}
