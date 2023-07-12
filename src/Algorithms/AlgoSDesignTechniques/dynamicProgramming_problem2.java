package Algorithms.MinimumSpanningTreeAlgoS.AlgoSDesignTechniques;

//Given a string and a list of words, find out the number of possible word segments that can be used to form the given string using the words present in wordsList.
// Count the number of possible word segments with the help of 'count' static variable.
// Implement the logic in findWordSegments() method.

import java.util.ArrayList;
import java.util.List;

public class dynamicProgramming_problem2 {


        public static int countWordSegments(String inputString, List<String> wordsList) {
            int n = inputString.length();
            int[] dp = new int[n + 1]; // Create an array to store the count of word segments for each position in the input string
            dp[0] = 1; // Initialize the count for position 0 to 1 (base case)

            // Iterate through each position in the input string
            for (int i = 1; i <= n; i++) {
                // Iterate through each word in the word list
                for (String word : wordsList) {
                    int len = word.length(); // Get the length of the current word
                    // Check if the current position is greater than or equal to the length of the word
                    // and if the substring starting from i-len to i matches the current word
                    if (i >= len && inputString.substring(i - len, i).equals(word)) {
                        dp[i] += dp[i - len]; // Add the count of word segments for the previous position to the current position
                    }
                }
            }

            return dp[n]; // Return the count of word segments for the last position in the input string
    }

    public static void main(String[] args) {
        List<String> wordList = new ArrayList<String>();
        wordList.add("i");
        wordList.add("like");
        wordList.add("pizza");
        wordList.add("li");
        wordList.add("ke");
        wordList.add("pi");
        wordList.add("zza");

        String inputString = "ilikepizza";
        int result = countWordSegments(inputString, wordList);
        System.out.println("Number of possible word segments: " + result);

    }

}
