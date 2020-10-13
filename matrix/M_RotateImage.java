package matrix;

/**
 * You are given an n x n 2D matrix representing an image, rotate the image by
 * 90 degrees (clockwise).
 * 
 * You have to rotate the image in-place, which means you have to modify the
 * input 2D matrix directly. DO NOT allocate another 2D matrix and do the
 * rotation.
 * 
 * e.g:
 * 
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 * 
 * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 * 
 * Constraints:
 * 
 * matrix.length == n
 * matrix[i].length == n
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 */
public class M_RotateImage {
    public void rotate1(int[][] matrix) {
        // transpose matrix
        int n = matrix.length;
        for (int x = 0; x < n; x++) {
            for (int y = x; y < n; y++) {
                int tmp = matrix[x][y];
                matrix[x][y] = matrix[y][x];
                matrix[y][x] = tmp;
            }
        }

        // reverse the rows
        for (int x = 0; x < n; x++) {
            int start = 0, end = n - 1;
            while (start < end) {
                int tmp = matrix[x][start];
                matrix[x][start] = matrix[x][end];
                matrix[x][end] = tmp;
                start++;
                end--;
            }
        }
    }

    /**
     * Idea:
     * 
     * 
     */
    public static void rotate(int[][] matrix) {
        int len = matrix.length - 1;
        for (int x = 0; x < matrix.length / 2; x++) {
            for (int y = 0; y < Math.ceil(matrix.length / 2.0); y++) {
                // rotate
                int temp = matrix[x][y];
                matrix[x][y] = matrix[len - y][x];
                matrix[len - y][x] = matrix[len - x][len - y];
                matrix[len - x][len - y] = matrix[y][len - x];
                matrix[y][len - x] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[][] a1 = { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };
        MatrixUtils.printMatrix(a1);
        rotate(a1);
        MatrixUtils.printMatrix(a1);
    }
}
