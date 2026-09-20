class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[] freq=new int[n*n+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                freq[grid[i][j]]++;
            }
            

        }
        int repeat = -1;
        int missing = -1;

        // Check numbers from 1 to n²
        for (int i = 1; i <= n * n; i++) {

            if (freq[i] == 2) {
                repeat = i;
            }

            if (freq[i] == 0) {
                missing = i;
            }
        }

        return new int[]{repeat, missing};
        
    }
}