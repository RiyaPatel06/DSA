class Solution {
    public void gameOfLife(int[][] board) {

        int m = board.length;
        int n = board[0].length;

        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1},  {1, 0},  {1, 1}
        };

        // First pass: determine the next state
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                int liveNeighbors = 0;

                // Check 8 neighbors
                for (int[] dir : directions) {

                    int ni = i + dir[0];
                    int nj = j + dir[1];

                    if (ni >= 0 && ni < m &&
                        nj >= 0 && nj < n) {

                        // 1 and 2 both mean originally alive
                        if (board[ni][nj] == 1 ||
                            board[ni][nj] == 2) {

                            liveNeighbors++;
                        }
                    }
                }

                // Alive cell
                if (board[i][j] == 1) {

                    if (liveNeighbors < 2 ||
                        liveNeighbors > 3) {

                        board[i][j] = 2;
                    }
                }

                // Dead cell
                else if (board[i][j] == 0) {

                    if (liveNeighbors == 3) {

                        board[i][j] = 3;
                    }
                }
            }
        }

        // Second pass: convert temporary states
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (board[i][j] == 2) {
                    board[i][j] = 0;
                }
                else if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }
}