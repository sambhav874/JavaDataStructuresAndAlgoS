package Algorithms.MinimumSpanningTreeAlgoS.AlgoSDesignTechniques;

//Given a number 'num' and a power 'p', find and return the exponent of 'num' raised to the power 'p' using brute force technique.
// Implement the logic inside calculatePower() method.


public class bruteForce_problem1 {

    public static int calculatePower(int num , int p){

        int result=1;

        if (p > 0) {
            for (int i = 1; i <= p; i++) {
                result *= num;
            }
        } else if (p < 0) {
            for (int i = 1; i <= -p; i++) {
                result /= num;
            }
        }

        return result;
    }
    public static void main(String[] args){
        System.out.println(calculatePower(2,3));
        System.out.println(calculatePower(0,10));

    }

}
