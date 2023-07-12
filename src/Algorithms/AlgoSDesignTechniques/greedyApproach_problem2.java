package Algorithms.MinimumSpanningTreeAlgoS.AlgoSDesignTechniques;




public class greedyApproach_problem2 {

    public static int findSwapCount(String s){
        int count = 0; // Total number of swaps
        int openCount = 0; // Count of open parentheses encountered

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                openCount++;
            } else if (ch == ')') {
                // If an open parentheses exists, we can pair the current closing parentheses with an open parentheses
                if (openCount > 0) {
                    openCount--;
                } else {
                    // No open parentheses available, so we need to swap the current closing parentheses with a later open parentheses
                    count++;
                }
            }
        }
        count += openCount;// If there are any remaining open parentheses, we need to swap them with later closing parentheses.
        return count;
    }

    public static void main(String[] args){
        String inputString = "())()(";
        System.out.println("Number of swaps: "+findSwapCount(inputString));
    }
}
