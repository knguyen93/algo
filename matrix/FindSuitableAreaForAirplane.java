package matrix;

/*
* An aviation company is trying to identify whether a particular area of land
* is suitable for their needs. They need an area of land which can support at
* least 3 airplane runways. A suitable airplane runway requires a cleared area
* that covers at least 0.1 kilometer square meters of land. Given a grid map of
* an area of land, where each cell in the grid represents a 100 meter x 100
* meter section of land and each cell in the grid is marked as either cleared
* or not, write an algorithm to determine whether the area of land is suitable
* for the company's needs.
* 
* e.g:
* area supports >= 3 runways .1 kilometer of land
* 
* 1 1 1 1 0 1 1 1 => 3 
* 1 1 1 0 0 1 1 1 
* 1 1 1 0 1 1 1 1 
* 0 0 0 0 0 0 0 0 
* 1 1 1 0 1 1 1 1 
* 1 1 1 0 1 1 1 1
* 
*/
public class FindSuitableAreaForAirplane {
    static boolean isSuitable(int grid[][]) {
        int count = 0;
        boolean visited[][] = new boolean[grid.length][grid[0].length];

        // go down
        for (int i = 0; i < grid.length; i++) {
            // go to the right
            for (int j = 0; j < grid[i].length; j++) {

                // clear land
                if (grid[i][j] == 1 && !visited[i][j]) {
                    // start scanning all neighbors
                    if(spreadAndCount(grid, visited, i, j) >= 10);
                        count++;
                }
            }
        }

        return count >= 3;
    }

    static int spreadAndCount(int[][] grid, boolean visited[][], int i, int j) {
        if (j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0 || visited[i][j]) return 0;

        visited[i][j] = true;

        int right = spreadAndCount(grid, visited, i + 1, j);
        int diagno = spreadAndCount(grid, visited, i + 1, j + 1);
        int bottom = spreadAndCount(grid, visited, i, j + 1);
        int left = spreadAndCount(grid, visited, i, j - 1);

        // we can also go to all diagno if necessary

        return 1 + left + right + diagno + bottom;
    }

    public static void main(String[] args) {
        int grid[][] = {
            {1, 1, 1, 1, 0, 1, 1, 1 },
            {1, 1, 1, 0, 0, 1, 1, 1 },
            {1, 1, 1, 0, 1, 1, 1, 1 },
            {0, 0, 0, 0, 0, 0, 0, 0 },
            {1, 1, 1, 0, 1, 1, 1, 1 },
            {1, 1, 1, 0, 1, 1, 1, 1 },
            {1, 1, 1, 0, 1, 1, 1, 1 }
        };

        int grid2[][] = {
            {1, 1, 1, 1, 0, 1, 1, 1 },
            {1, 1, 1, 0, 0, 1, 1, 1 },
            {1, 1, 0, 0, 1, 1, 1, 1 },
            {0, 0, 0, 0, 0, 0, 0, 0 },
            {1, 1, 1, 0, 1, 1, 1, 1 },
            {1, 1, 1, 0, 1, 1, 1, 1 },
            {1, 1, 1, 0, 1, 1, 1, 1 }
        };

        System.out.println(isSuitable(grid)); //10, 10, 12 => true
        System.out.println(isSuitable(grid2)); //12, 10 => false
    }
}
