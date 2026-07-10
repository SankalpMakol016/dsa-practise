import java.util.*;

class Solution {

    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        // Start or destination is blocked
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, 0});

        // Mark start as visited
        grid[0][0] = 1;

        int distance = 1;

        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                int[] curr = q.poll();

                int row = curr[0];
                int col = curr[1];

                // Destination reached
                if (row == n - 1 && col == n - 1) {
                    return distance;
                }

                for (int j = 0; j < 8; j++) {

                    int newRow = row + dr[j];
                    int newCol = col + dc[j];

                    if (newRow >= 0 && newRow < n &&
                        newCol >= 0 && newCol < n &&
                        grid[newRow][newCol] == 0) {

                        grid[newRow][newCol] = 1;

                        q.offer(new int[]{
                            newRow,
                            newCol
                        });
                    }
                }
            }

            distance++;
        }

        return -1;
    }
}