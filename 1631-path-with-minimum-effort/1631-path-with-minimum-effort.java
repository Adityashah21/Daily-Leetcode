class Solution {
    public int minimumEffortPath(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        // distance[i][j] = minimum effort needed to reach (i,j)
        int[][] distance = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            java.util.Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        // {effort, row, col}
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> a[0] - b[0]);

        distance[0][0] = 0;

        pq.offer(new int[]{0, 0, 0});

        int[][] directions = {
            {-1, 0},  // up
            {1, 0},   // down
            {0, -1},  // left
            {0, 1}    // right
        };

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int effort = current[0];
            int row = current[1];
            int col = current[2];

            // Destination reached
            if (row == rows - 1 && col == cols - 1) {
                return effort;
            }

            for (int[] dir : directions) {

                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // Check boundaries
                if (newRow >= 0 && newRow < rows &&
                    newCol >= 0 && newCol < cols) {

                    int edgeEffort = Math.abs(
                        heights[row][col] -
                        heights[newRow][newCol]
                    );

                    int newEffort = Math.max(
                        effort,
                        edgeEffort
                    );

                    if (newEffort < distance[newRow][newCol]) {

                        distance[newRow][newCol] = newEffort;

                        pq.offer(new int[]{
                            newEffort,
                            newRow,
                            newCol
                        });
                    }
                }
            }
        }

        return 0;
    }
}