class Solution {
    public boolean exist(char[][] board, String word) {
        int rows=board.length;
        int cols=board[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(dfs(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
        
    }
    private boolean dfs(char[][] board,String word,int rows,int cols,int idx){
        if(idx==word.length()) return true;
        //invalid position
        if(rows<0 || cols<0 || rows==board.length || cols==board[0].length || board[rows][cols]!=word.charAt(idx)) return false;
        char temp=board[rows][cols];
        board[rows][cols]='#';//mark visited
        boolean found=dfs(board,word,rows+1,cols,idx+1)||
          dfs(board,word,rows-1,cols,idx+1)||
          dfs(board,word,rows,cols+1,idx+1)||
          dfs(board,word,rows,cols-1,idx+1);
        board[rows][cols]=temp;//backtrack
        return found;


    }
}