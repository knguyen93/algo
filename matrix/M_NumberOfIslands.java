package matrix;

/**
 * Given an m x n 2d grid map of '1's (land) and '0's (water), return the number
 * of islands.
 * 
 * An island is surrounded by water and is formed by connecting adjacent lands
 * horizontally or vertically. You may assume all four edges of the grid are all
 * surrounded by water.
 * 
 * e.g:
 * 
 * Input: 
 * 
 * grid = [ 
 * ["1","1","1","1","0"], 
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"], 
 * ["0","0","0","0","0"]] 
 * 
 * Output: 1
 * 
 * Input: 
 * grid = [ 
 * ["1","1","0","0","0"], 
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"], 
 * ["0","0","0","1","1"]] 
 * 
 * Output: 3
 * 
 * Constraints:
 * 
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 */
public class M_NumberOfIslands {

    /**
     * Idea:
     * 
     * 1. Start from top left corner
     * 2. If found a cell that has value 1 
     * => Start fill-up value of 1 by x with the following directions: backward, forward, up, down
     * => increase island count
     * 
     * Runtime: O(m * n) ::: m (height), n(width)
     * Space: O(1) ::: we use in-place
     */
    public static int numIslands(char[][] grid) {
        int count = 0;
        // System.out.println(Arrays.deepToString(grid));
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    // System.out.println(Arrays.deepToString(grid));
                    fillup(grid, i, j);
                    count++;
                }
            }
        }

        // System.out.println(Arrays.deepToString(grid));
        return count;
    }

    private static void fillup(char[][] grid, int i, int j) {
        if (j < 0 || i < 0 || i >= grid.length || j >= grid[i].length)
            return;

        if (grid[i][j] == '1') {
            grid[i][j] = 'x';
            fillup(grid, i + 1, j);
            fillup(grid, i - 1, j);
            fillup(grid, i, j + 1);
            fillup(grid, i, j - 1);
        }
    }

    public static void main(String[] args) {
        char grid[][] = { 
            { '1', '1', '1', '1', '0' }, 
            { '1', '1', '0', '1', '0' }, 
            { '1', '1', '0', '0', '0' },
            { '0', '0', '0', '0', '0' }
        };

        char grid2[][] = {
            { '1', '1', '0', '0', '0' }, 
            { '1', '1', '0', '0', '0' }, 
            { '0', '0', '1', '0', '0' },
            { '0', '0', '0', '1', '1' } 
            };

        System.out.println(numIslands(grid)); //1
        System.out.println(numIslands(grid2)); // 3
    }
}
