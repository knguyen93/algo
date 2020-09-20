package other;

/**
 * Implement pow(x, n), which calculates x raised to the power n (i.e. x^n).
 * 
 * E.g:
 * 
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 * 
 * Input: x = 2.00000, n = -2
 * Output: 0.25000
 * Explanation: 2^-2 = 1/2^2 = 1/4 = 0.25
 */
public class PowXN {
    public double myPow(double x, int n) {
        if (n == 0) // base case
            return 1;

        double results = myPow(x, n / 2);

        if (n % 2 == 0)
            return results * results; // even case

        if (n > 0)
            return x * results * results; // positive power
        else
            return (results * results) / x; // negative power
    }
}
