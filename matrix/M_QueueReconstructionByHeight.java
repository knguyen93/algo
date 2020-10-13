package matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Suppose you have a random list of people standing in a queue. Each person is
 * described by a pair of integers (h, k), where h is the height of the person
 * and k is the number of people in front of this person who have a height
 * greater than or equal to h. 
 * 
 * Write an algorithm to reconstruct the queue.
 * 
 * Note: The number of people is less than 1,100.
 * 
 * e.g:
 * 
 * Input: [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * Output: [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class M_QueueReconstructionByHeight {
    public static int[][] reconstructQueue(int[][] people) {

        /**
         * Idea:
         * 1. Sort DESC order of Height (h) & ASC order of No. of people on the left (k) 
         * 2. loop over the sorted Array and put each element at its desired index (x[1])
         * 
         * Output: {{7,0}, {7,1}, {6,1}, {5,0}, {5,2}, {4,4}}
         */
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        printMatrix(people);

        /**
         * We take advantage of the method List.add() => it automatically shifts the occupied element to the right
         * 
         * It means we always put x[1] (index) at its right place.
         * the index always start from 0 => we can asure that there is no >= element on its left handside
         */
        List<int[]> results = new ArrayList<>();
        for (int[] x : people) {//[7,0], [7,1]
            results.add(x[1], x);// [0, [7,0]] => [1,[7,1]] => [1, [6,1]]
        }

        // the parameter just an initial value. give any length doesn't matter
        return results.toArray(new int[people.length][0]);
    }

    static void printMatrix(int[][] matrix) {
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void main(String[] args) {
        int[][] matrix = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        printMatrix(reconstructQueue(matrix));
    }
}
