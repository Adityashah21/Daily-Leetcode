class Solution {

    public int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        int fresh = 0;

        // Find all rotten oranges
        // and count fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }

                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int minutes = 0;

        // Directions:
        // up, down, left, right
        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while (!queue.isEmpty() && fresh > 0) {

            // Number of oranges currently rotten
            int size = queue.size();

            // Process one complete level
            for (int i = 0; i < size; i++) {

                int[] current = queue.poll();

                int r = current[0];
                int c = current[1];

                // Check all 4 directions
                for (int[] dir : directions) {

                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    // Check boundary
                    if (nr >= 0 && nr < rows &&
                        nc >= 0 && nc < cols &&
                        grid[nr][nc] == 1) {

                        // Make fresh orange rotten
                        grid[nr][nc] = 2;

                        fresh--;

                        // Add newly rotten orange
                        // to queue
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }

            // One minute has passed
            minutes++;
        }

        // If fresh oranges are still left,
        // they can never become rotten
        if (fresh > 0) {
            return -1;
        }

        return minutes;
    }
}