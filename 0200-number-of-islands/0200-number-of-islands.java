class Solution {

    public int numIslands(char[][] grid) {

        int count = 0;

        int rows = grid.length;
        int cols = grid[0].length;

        // Visit every cell
        for (int r = 0; r < rows; r++) {

            for (int c = 0; c < cols; c++) {

                // If we find land
                if (grid[r][c] == '1') {

                    count++;

                    // Visit the entire island
                    dfs(grid, r, c);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int r, int c) {

        // Boundary check
        if (r < 0 || 
            c < 0 || 
            r >= grid.length || 
            c >= grid[0].length) {
            return;
        }

        // If this is water, stop
        if (grid[r][c] == '0') {
            return;
        }

        // Mark this land as visited
        grid[r][c] = '0';

        // Go down
        dfs(grid, r + 1, c);

        // Go up
        dfs(grid, r - 1, c);

        // Go right
        dfs(grid, r, c + 1);

        // Go left
        dfs(grid, r, c - 1);
    }
}