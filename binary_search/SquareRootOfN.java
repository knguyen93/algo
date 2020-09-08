package binary_search;

/**
 * Leetcode: Implement int sqrt(int x).
 * 
 * Compute and return the square root of x, where x is guaranteed to be a
 * non-negative integer.
 * 
 * Since the return type is an integer, the decimal digits are truncated and
 * only the integer part of the result is returned.
 * 
 * e.g: 
 * 
 * Input: 8 
 * Output: 2 
 * Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
 * 
 * Binary Search template I:
 * -    Initial Condition: left = 0, right = length-1
 * -    Termination: left > right
 * -    Searching Left: right = mid-1
 * -    Searching Right: left = mid+1
 */
public class SquareRootOfN {

    /***
     * Solution similar to Binary Search Template I instruction. 
     * But found online solution that parsed int to long which passed the '2147395599' test case
     */
    public int mySqrt(int x) {
        if (x == 0 || x == 1)
            return x;

        long left = 0, x1 = (long) x, right = x1;

        while (left <= right) {
            // Prevent (left + right) overflow
            long mid = left + (right - left) / 2;
            if (mid * mid == x1) {
                return (int) mid;
            } else if (mid * mid < x1) {
                left = mid + 1;
                if (left * left > x1)
                    return (int) mid;
            } else {
                right = mid - 1;
            }
        }

        return (int) left;
    }
}