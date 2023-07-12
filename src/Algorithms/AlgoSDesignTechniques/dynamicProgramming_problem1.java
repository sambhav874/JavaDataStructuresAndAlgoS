package Algorithms.MinimumSpanningTreeAlgoS.AlgoSDesignTechniques;


// Given a rod of length 'n' and an array containing prices of pieces of each rod size, find the optimal way to cut the rod into smaller pieces to get the maximum price.
// The price of rod of size 'i' is present in index position 'i-1' of the array.
// E.g. - The price of rod of size 2 is present in index position 1 of the array.
// Implement the logic in cutRod() method.

public class  dynamicProgramming_problem1{
    public static int cutRod(int[] prices, int length) {
        int[] dp = new int[length + 1]; // Array to store the maximum prices for each length

        // Initialize the base case (rod of length 0 has price 0)
        dp[0] = 0;

        // Calculate the maximum price for each length from 1 to length
        for (int i = 1; i <= length; i++) {
            int maxPrice = Integer.MIN_VALUE;
            //can also use 0;
            //Integer.MIN_VALUE is the smallest possible value that can be represented by an int data type in Java.
            // By initializing maxPrice with this value,
            // we ensure that any valid price value will be greater than or equal to maxPrice during the calculation of the maximum price.


            // Consider all possible cuts and find the maximum price
            for (int j = 1; j <= i; j++) {
                maxPrice = (prices[j - 1] + dp[i - j] > maxPrice) ? prices[j - 1] + dp[i - j] : maxPrice;
            }
            dp[i] = maxPrice;
        }

        return dp[length]; // Return the maximum price for the given length
    }

    public static void main(String[] args) {
        int[] price  = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int n = 4;
        System.out.println("Maximum price: " + cutRod(price, n));
    }
}
