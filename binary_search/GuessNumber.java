package binary_search;

/**
 * LeetCode: We are playing the Guess Game. The game is as follows:
 * 
 * I pick a number from 1 to n. You have to guess which number I picked.
 * 
 * Every time you guess wrong, I'll tell you whether the number is higher or
 * lower.
 * 
 * You call a pre-defined API guess(int num) which returns 3 possible results
 * (-1, 1, or 0):
 * 
 * -1 : My number is lower 
 * 1 : My number is higher 
 * 0 : Congrats! You got it!
 */
public class GuessNumber {
    public int guessNumber(int n) {
        int start = 1, end = n;

        while (start < end) {
            // pick a middle range number
            int pick = start + (end - start) / 2;

            // compare the pick with the given number
            int result = guess(pick);
            if (result == 0)
                return pick;

            // move the range appropriately
            if (result > 0) {
                start = pick + 1;
            } else {
                end = pick - 1;
            }
        }

        return start;
    }

    private int guess(int guess) {
        return -1;
    }
}
