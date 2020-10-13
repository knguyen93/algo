package array_prac;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete as many
 * transactions as you like (ie, buy one and sell one share of the stock
 * multiple times) with the following restrictions:
 * 
 * You may not engage in multiple transactions at the same time (ie, you must
 * sell the stock before you buy again). After you sell your stock, you cannot
 * buy stock on next day. (ie, cooldown 1 day)
 * 
 * e.g: 
 * 
 * Input: [1,2,3,0,2]
 * Output: 3 
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 */
public class M_BestTimeToBuyAndSellStockWithCooldown {
    
    /**
     * Idea: solve by using Dynamic Programming
     * 
     * There are 2 possibilities and have approriate actions to decide:
     *
     * 1. I have no stock today
     * - sold it today OR not buying, have no stock since yesterday (might b/c of the cooldown)
     * 
     * 2. I have stock today
     * - carried from yesterday OR bought it today (take care of cooldown gap => i-2)
     * 
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        if (prices.length == 2)
          return Math.max(prices[1] - prices[0], 0);  
        
        int length = prices.length;
        int dp[][] = new int[length][2]; //store profits w/o holding stock (1: has stock, 0: has no stock)
      
        // intialize for the first two days
        dp[0][0] = 0; //has nothing
        dp[0][1] = - prices[0]; // buy stock
        dp[1][0] = Math.max(dp[0][1] + prices[1], dp[0][0]); // selling it OR do nothing
        dp[1][1] = Math.max(dp[0][1], dp[0][0] - prices[1]); // hold yesterday Stock OR buy today Stock
        
        for (int i=2; i<length; i++) {
          dp[i][0] = Math.max(dp[i-1][1] + prices[i], dp[i-1][0]);
          dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0] - prices[i]);
        }      
      
        //return the last day without holding stock
        return dp[length-1][0];
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        System.out.println(maxProfit(prices));
    }
}
