class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int size = m * n;
        int MOD = 12345;

        // Convert 2D → 1D
        int[] arr = new int[size];
        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[k++] = grid[i][j] % MOD;
            }
        }

        // Prefix product
        int[] prefix = new int[size];
        prefix[0] = 1;
        for (int i = 1; i < size; i++) {
            prefix[i] = (prefix[i - 1] * arr[i - 1]) % MOD;
        }

        // Suffix product
        int[] suffix = new int[size];
        suffix[size - 1] = 1;
        for (int i = size - 2; i >= 0; i--) {
            suffix[i] = (suffix[i + 1] * arr[i + 1]) % MOD;
        }

        // Build result matrix
        int[][] result = new int[m][n];
        k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = (prefix[k] * suffix[k]) % MOD;
                k++;
            }
        }

        return result;
    }
}