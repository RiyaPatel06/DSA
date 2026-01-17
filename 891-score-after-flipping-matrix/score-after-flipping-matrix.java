class Solution {
    int calDeci(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int totalSum = 0;

        for (int i = 0; i < rows; i++) {
            int x = 1;
            for (int j = cols - 1; j >= 0; j--) {
                if (grid[i][j] == 1)
                    totalSum += x;
                x *= 2;
            }
        }
        return totalSum;
    }

    void flipCol(int[][] grid, int col) {
        for (int i = 0; i < grid.length; i++) {
            grid[i][col] ^= 1;
        }
    }

    public int matrixScore(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < cols; j++)
                    grid[i][j] ^= 1;
            }
        }

        for (int i = 0; i < cols; i++) {
            int count0 = 0, count1 = 0;
            for (int j = 0; j < rows; j++) {
                if (grid[j][i] == 0) count0++;
                else count1++;
            }
            if (count0 > count1)
                flipCol(grid, i);
        }

        return calDeci(grid);
    }
}