package other;

/**
 * Given a non negative integer number num. 
 * For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return
 * them as an array.
 * 
 * e.g:
 * 
 * Input: 2 
 * Output: [0,1,1]
 * 
 * Input: 5
 * Output: [0,1,1,2,1,2]
 */
public class M_CountingBits {

    /**
     * This is Dynamic Programming patterns
     * 
     * Idea:
     * 
     * - every power of 2 will has 1 bit count. e.g: 1(1), 2(10), 4(100), 8(1000), 16(10000), ...
     * => we use this as a boundary
     * 
     * - each pointer between nth's power to (n+1)th's power will follow the rules of:
     * power + nth's pointer = nth's pointer bit count  + 1 
     * 
     * e.g: 
     */
    public int[] countBits(int num) {
        int dp[] = new int[num + 1];
        int pointer = 0, power = 1; // 2^0 = 1, 2^1 = 2, 2^2 = 4

        while (power <= num) {
            while (pointer < power && pointer + power <= num) {
                dp[pointer + power] = dp[pointer] + 1;
                pointer++;
            }

            pointer = 0;
            power = power << 1; // 1 => 2 => 4 => 8
        }

        return dp;
    }
}
