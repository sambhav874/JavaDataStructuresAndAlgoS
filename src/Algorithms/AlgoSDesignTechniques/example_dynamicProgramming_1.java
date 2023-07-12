package Algorithms.MinimumSpanningTreeAlgoS.AlgoSDesignTechniques;

//Here is a recursive program to compute the nth Fibonacci number.
//
//Execute and find the 5th, 10th, 30th, 35th , 40th and 50th Fibonacci numbers.

public class example_dynamicProgramming_1 {

    public static int fibonacci(int num) {
        //If passed input is 0, return 0
        if (num == 0)
            return 0;
            //If passed input is 1, return 1
        else if(num == 1)
            return 1;
        else
            return fibonacci(num - 1) + fibonacci(num - 2);
    }

    public static void main(String[] args) {
        int num = 15;
        System.out.println(num+"th fibaonacci number: "+fibonacci(num));
    }

}
