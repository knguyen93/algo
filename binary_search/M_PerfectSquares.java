package binary_search;

import java.util.Arrays;

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * E.g:
 * 
 * Input: n = 12
 * Output: 3 
 * Explanation: 12 = 4 + 4 + 4.
 * 
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */
public class M_PerfectSquares {

    /**
     * This is the dynamic programming problem.
     * 
     * Idea:
     * 
     * 1. Create an array with length of n + 1, fill up by Max Integer values (we're looking for Min value)
     * 2. Loop from i:1 -> n
     * 3. Loop over every possible square from j:1 -> max
     * 4. Get Min count of i & every possible previous perfect square + 1 (this perfect square)
     * 5. return the value of dp[n]
     */
    public static int numSquares(int n) {
        int max = (int) Math.sqrt(n); //3
        int dp[] = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i=1; i <= n; i++) { // 1 2 3 4 5 6 7 8 9 10
            for (int j=1; j <= max; j++) { // 1 -> 3
                if (j * j == i) { //perfect square
                    dp[i] = 1;
                } else if (j * j < i) {
                    dp[i] = Math.min(dp[i], dp[i - j*j] + 1); //4 => & 4-1 = dp[3] + 1
                }
            }

        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12));
        System.out.println(numSquares(13));
    }
}
