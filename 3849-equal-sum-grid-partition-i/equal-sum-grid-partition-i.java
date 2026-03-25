class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long total = 0;  

        //  total sum
        for (int[] row : grid) {
            for (int val : row) {
                total += val;
            }
        }

        // If total is odd 
        if (total % 2 != 0) return false;

        long target = total / 2; 

        // Horizontal cut
        long rowSum = 0;  
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSum += grid[i][j];
            }
            if (rowSum == target) return true;
        }

        // Vertical cut
        long colSum = 0;  
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                colSum += grid[i][j];
            }
            if (colSum == target) return true;
        }

        return false;
    }
}