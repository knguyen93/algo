package matrix;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * e.g:
 * 
 * board = [ 
 * ['A','B','C','E'], 
 * ['S','F','C','S'], 
 * ['A','D','E','E'] 
 * ]
 * 
 * Given word = "ABCCED", return true. 
 * Given word = "SEE", return true. 
 * Given word = "ABCB", return false.
 * 
 * Contraints:
 * 
 * board and word consists only of lowercase and uppercase English letters.
 * 1 <= board.length <= 200
 * 1 <= board{i}.length <= 200
 * 1 <= word.length <= 10^3
 */
public class M_WordSearch {

    /**
     * Idea: 
     * 
     * Loop to every cells in the matrix.
     * Perform DFS on each cell and search with 4 directions: down, up, toward, backward
     * Notes: temporary replaced the found character by ' ' to avoid revisit that again in the recursive
     * 
     * Runtime: O (m * n) ::: m & n is the length and width of the matrix
     * Space: O (m * n) ::: worst case is that we need to save temp of cell in the matrix
     */
    public static boolean exist(char[][] board, String word) {
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (dfs(board, word, x, y, 0))
                    return true;
            }
        }

        return false;
    }

    private static boolean dfs(char[][] board, String word, int x, int y, int index) {
        if (index == word.length()) return true;

        if (x < 0 || y < 0 || x == board.length || y == board[x].length || board[x][y] != word.charAt(index)) return false;
        
        // take the current found item out and put it back after done the search
        char temp = board[x][y];
        board[x][y] = ' ';

        // search with 4 directions
        boolean found = dfs(board, word, x + 1, y, index+1)
        || dfs(board, word, x - 1, y, index+1)
        || dfs(board, word, x, y + 1, index+1)
        || dfs(board, word, x, y - 1, index+1);

        board[x][y] = temp;
        return found;
    }

    public static void main(String[] args) {
        char board[][] = {
            {'A','B','C','E'}, 
            {'S','F','C','S'}, 
            {'A','D','E','E'}
        };

        System.err.println(exist(board, "ABCCED")); //true
        System.err.println(exist(board, "SEE")); // true
        System.err.println(exist(board, "ABCB")); //false
    }
}
