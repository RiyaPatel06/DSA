class Solution {

    public static void dfs(int row,int col,int[][] image,int originalColor,int newColor){
        int n = image.length;
        int m = image[0].length;

        // Change current cell's color
        image[row][col] = newColor;

        // Four directions
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        // Check all four neighbours
        for (int i = 0; i < 4; i++) {

            int newRow = row + dRow[i];
            int newCol = col + dCol[i];

            // Check boundaries
            if (newRow >= 0 && newRow < n &&
                newCol >= 0 && newCol < m) {

                // Check same original color
                if (image[newRow][newCol] == originalColor) {

                    dfs(newRow,newCol,image,originalColor,newColor);
                }
            }
        }
    }

    public static int[][] floodFill(int[][] image,int sr,int sc,int color){
        int originalColor = image[sr][sc];

        // Important edge case
        if (originalColor == color) {
            return image;
        }

        dfs(sr,sc,image,originalColor,color);

        return image;
    }

    
}