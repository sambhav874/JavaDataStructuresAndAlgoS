package Algorithms.MinimumSpanningTreeAlgoS.AlgoSDesignTechniques;

public class example_dynamicProgramming_2 {

    public static int fibonacci(int num){
        //Declare an array to store Fibonacci numbers
        int[] n = new int[num + 1];

        //0th and 1st number of the series are 0 and 1
        n[0] = 1;

        n[1] = 1;

        for(int index = 2 ; index < n.length ; index ++){
//Add the previous 2 numbers in the series and store the sum
            n[index] = n[index - 1] + n[index - 2];
        }
        return n[num];
    }
    public static void main(String[] args) {
        int num = 9;
        System.out.println(num+"th fibonacci number : "+fibonacci(num));
    }
}
